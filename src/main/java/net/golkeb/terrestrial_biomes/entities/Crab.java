package net.golkeb.terrestrial_biomes.entities;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.init.ItemInit;
import net.golkeb.terrestrial_biomes.misc.Keys;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

public class Crab extends PathfinderMob implements Bucketable {

    public static final EntityDataAccessor<String> CRAB_TEXTURE = SynchedEntityData.defineId(Crab.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(Crab.class, EntityDataSerializers.BOOLEAN);

    public Crab(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        setNoAi(false);
        this.moveControl = new MoveControl(this) {
            @Override
            public void tick() {
                if (this.mob.isEyeInFluid(FluidTags.WATER))
                    Crab.this.setDeltaMovement(Crab.this.getDeltaMovement().add(0, 0.005, 0));
                if (this.operation == Operation.MOVE_TO && !Crab.this.getNavigation().isStuck()) {
                    double dx = this.wantedX - Crab.this.getX();
                    double dy = this.wantedY - Crab.this.getY();
                    double dz = this.wantedZ - Crab.this.getZ();
                    dy = dy / Math.sqrt(dx * dx + dy * dy + dz * dz);
                    Crab.this.yRot = this.rotlerp(Crab.this.yRot,
                            (float) (Math.atan2(dz, dx) * (double) (180 / (float) Math.PI)) - 90, 90);
                    Crab.this.yBodyRot = Crab.this.yRot;
                    Crab.this.setSpeed(Math.fma(0.125f, Crab.this.getSpeed(),
                            (float) (this.getSpeedModifier() * Crab.this.getAttributeValue(Attributes.MOVEMENT_SPEED))));
                    Crab.this.setDeltaMovement(Crab.this.getDeltaMovement().add(0, Crab.this.getSpeed() * dy * 0.1, 0));
                } else {
                    Crab.this.setSpeed(0);
                }
            }
        };
        this.navigation = new WaterBoundPathNavigation(this, this.level);
    }

    public MobType getMobType() {
        return MobType.WATER;
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
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1, 40));
        this.goalSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.MAX_HEALTH, 5)
                .add(Attributes.ARMOR, 8)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(ForgeMod.SWIM_SPEED.get(), 0.3);
    }

    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {
        super.dropCustomDeathLoot(source, looting, recentlyHit);
        this.spawnAtLocation(new ItemStack(ItemInit.RAW_CRAB_MEAT.get(), 1));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.TROPICAL_FISH_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.TROPICAL_FISH_DEATH;
    }

    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_FILL_FISH;
    }

    @Override
    public int getExperienceReward(Player player) {
        return 1;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public boolean canBeLeashed(Player player) {
        return false;
    }

    public ResourceLocation getTexture() {
        return TerrestrialBiomes.RL(this.entityData.get(CRAB_TEXTURE));
    }

    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    public void setFromBucket(boolean fromBucket) {
        this.entityData.set(FROM_BUCKET, fromBucket);
    }

    public void saveToBucketTag(ItemStack bucket) {
        Bucketable.saveDefaultDataToBucketTag(this, bucket);
    }

    public void loadFromBucketTag(CompoundTag tag) {
        Bucketable.loadDefaultDataFromBucketTag(this, tag);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CRAB_TEXTURE, this.random.nextDouble() < 0.5 ? Keys.RED_CRAB.getPath() : Keys.BROWN_CRAB.getPath());
        this.entityData.define(FROM_BUCKET, false);
    }
}
