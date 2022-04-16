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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

public class Crab extends AbstractFish {

    public static final EntityDataAccessor<String> CRAB_TEXTURE = SynchedEntityData.defineId(Crab.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Crab.class, EntityDataSerializers.INT);

    public Crab(EntityType<? extends AbstractFish> entityType, Level level) {
        super(entityType, level);
        setNoAi(false);
        this.navigation = new WaterBoundPathNavigation(this, this.level);
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

    protected void handleAirSupply(int air) {
        this.setAirSupply(300);
    }

    @Override
    public SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.TROPICAL_FISH_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.TROPICAL_FISH_DEATH;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;
    }

    @Override
    public int getExperienceReward(Player player) {
        return 1;
    }

    public ResourceLocation getTexture() {
        return TerrestrialBiomes.RL(this.entityData.get(CRAB_TEXTURE));
    }

    public int getVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        double randomDouble = this.random.nextDouble();
        this.entityData.define(CRAB_TEXTURE, randomDouble < 0.5 ? Keys.RED_CRAB.getPath() : Keys.BROWN_CRAB.getPath());
        this.entityData.define(DATA_ID_TYPE_VARIANT, randomDouble < 0.5 ? 0 : 1);
    }

    public void saveToBucketTag(ItemStack itemStack) {
        super.saveToBucketTag(itemStack);
        CompoundTag compoundtag = itemStack.getOrCreateTag();
        compoundtag.putInt("BucketVariantTag", this.getVariant());
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
