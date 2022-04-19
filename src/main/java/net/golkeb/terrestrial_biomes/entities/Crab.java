package net.golkeb.terrestrial_biomes.entities;

import net.golkeb.terrestrial_biomes.entities.ai.control.CrabMoveControl;
import net.golkeb.terrestrial_biomes.entities.ai.goal.CrabSwimUpGoal;
import net.golkeb.terrestrial_biomes.entities.ai.goal.CrabToBeachGoal;
import net.golkeb.terrestrial_biomes.entities.ai.goal.CrabToWaterGoal;
import net.golkeb.terrestrial_biomes.entities.ai.navigation.WaterClimberNavigation;
import net.golkeb.terrestrial_biomes.init.ItemInit;
import net.golkeb.terrestrial_biomes.misc.Keys;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraftforge.common.ForgeMod;

import javax.annotation.Nullable;

public class Crab extends AbstractShellfish {

    public static final String BUCKET_VARIANT_TAG = "BucketVariantTag";
    boolean searchingForLand;
    public static final ResourceLocation[] CRAB_TEXTURE_LOCATIONS = new ResourceLocation[]{Keys.RED_CRAB, Keys.BROWN_CRAB};
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Crab.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Crab.class, EntityDataSerializers.BYTE);

    public Crab(EntityType<? extends AbstractShellfish> entityType, Level level) {
        super(entityType, level);
        setNoAi(false);
        this.moveControl = new CrabMoveControl(this);
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new WaterClimberNavigation(this, level);
    }

    public ItemStack getBucketItemStack() {
        return new ItemStack(ItemInit.CRAB_BUCKET.get());
    }

    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.1D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 8.0F, 1.6D, 1.4D, EntitySelector.NO_SPECTATORS::test));
        this.goalSelector.addGoal(2, new CrabToWaterGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new CrabToBeachGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new CrabSwimUpGoal(this, 1.0D, this.level.getSeaLevel()));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.5)
                .add(Attributes.MAX_HEALTH, 5)
                .add(Attributes.ARMOR, 8)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(ForgeMod.SWIM_SPEED.get(), 0.5);
    }

    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }
    }

    public boolean onClimbable() {
        return this.isClimbing();
    }

    public boolean isClimbing() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setClimbing(boolean climbing) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        b0 = (climbing ? (byte) (b0 | 1) : (byte) (b0 & -2));
        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {
        super.dropCustomDeathLoot(source, looting, recentlyHit);
        this.spawnAtLocation(new ItemStack(ItemInit.RAW_CRAB_MEAT.get(), 1));
    }

    @Override
    protected void handleAirSupply(int air) {
        this.setAirSupply(300);
    }

    public void setSearchingForLand(boolean searchingForLand) {
        this.searchingForLand = searchingForLand;
    }

    public boolean isSearchingForLand() {
        return this.searchingForLand;
    }

    public boolean closeToNextPos() {
        Path path = this.getNavigation().getPath();
        if (path != null) {
            BlockPos blockPos = path.getTarget();
            double d0 = this.distanceToSqr(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            return d0 < 4.0D;
        }
        return false;
    }

    @Override
    public int getExperienceReward(Player player) {
        return 1;
    }

    public ResourceLocation getTexture() {
        return CRAB_TEXTURE_LOCATIONS[getVariant()];
    }

    public int getVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficulty, MobSpawnType mobSpawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
        groupData = super.finalizeSpawn(levelAccessor, difficulty, mobSpawnType, groupData, tag);
        if (mobSpawnType == MobSpawnType.BUCKET && tag != null && tag.contains(BUCKET_VARIANT_TAG)) {
            this.setVariant(tag.getInt(BUCKET_VARIANT_TAG));
            return groupData;
        }
        this.setVariant(this.random.nextDouble() < 0.5 ? 0 : 1);
        return groupData;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
        this.entityData.define(DATA_FLAGS_ID, (byte) 0);
    }

    public void saveToBucketTag(ItemStack itemStack) {
        super.saveToBucketTag(itemStack);
        CompoundTag compoundtag = itemStack.getOrCreateTag();
        compoundtag.putInt(BUCKET_VARIANT_TAG, this.getVariant());
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getVariant());
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setVariant(tag.getInt("Variant"));
    }
}
