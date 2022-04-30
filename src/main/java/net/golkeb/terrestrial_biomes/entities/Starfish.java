package net.golkeb.terrestrial_biomes.entities;

import net.golkeb.terrestrial_biomes.entities.ai.control.AbstractMoveControl;
import net.golkeb.terrestrial_biomes.init.ItemInit;
import net.golkeb.terrestrial_biomes.misc.Keys;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.common.ForgeMod;

import javax.annotation.Nullable;

public class Starfish extends AbstractShellfish {

    public static final String BUCKET_VARIANT_TAG = "BucketVariantTag";
    public static final ResourceLocation[] STARFISH_TEXTURE_LOCATIONS = new ResourceLocation[]{Keys.STARFISH_1, Keys.STARFISH_2, Keys.STARFISH_3, Keys.STARFISH_4, Keys.STARFISH_5, Keys.STARFISH_6, Keys.STARFISH_7};
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Starfish.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Starfish.class, EntityDataSerializers.BYTE);

    public Starfish(EntityType<? extends AbstractShellfish> entityType, Level level) {
        super(entityType, level);
        setNoAi(false);
        this.moveControl = new AbstractMoveControl(this);
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new WaterBoundPathNavigation(this, level);
    }

    public ItemStack getBucketItemStack() {
        return new ItemStack(ItemInit.STARFISH_BUCKET.get());
    }

    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new RandomSwimmingGoal(this, 1, 40));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2D));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.MAX_HEALTH, 6)
                .add(Attributes.ARMOR, 2)
                .add(Attributes.ATTACK_DAMAGE, 0)
                .add(ForgeMod.SWIM_SPEED.get(), 0.2);
    }

    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {
        super.dropCustomDeathLoot(source, looting, recentlyHit);
        this.spawnAtLocation(new ItemStack(ItemInit.STARFISH.get(), 1));
    }

    @Override
    protected void handleAirSupply(int air) {
        this.setAirSupply(300);
    }

    @Override
    public int getExperienceReward(Player player) {
        return 1;
    }

    public ResourceLocation getTexture() {
        return STARFISH_TEXTURE_LOCATIONS[getVariant()];
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
