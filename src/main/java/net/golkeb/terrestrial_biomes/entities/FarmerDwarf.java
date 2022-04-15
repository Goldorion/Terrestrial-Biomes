package net.golkeb.terrestrial_biomes.entities;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.misc.Keys;
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
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class FarmerDwarf extends PathfinderMob {

    public static final EntityDataAccessor<String> FARMER_DWARF_TEXTURE = SynchedEntityData.defineId(FarmerDwarf.class, EntityDataSerializers.STRING);

    public FarmerDwarf(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        setNoAi(false);
    }

    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 1.0D, 10));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.8));
        this.goalSelector.addGoal(5, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(6, new MoveBackToVillageGoal(this, 0.6, false));
        this.goalSelector.addGoal(7, new OpenDoorGoal(this, false));
        this.goalSelector.addGoal(8, new PanicGoal(this, 1));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.MAX_HEALTH, 15)
                .add(Attributes.ARMOR, 0.5)
                .add(Attributes.ATTACK_DAMAGE, 0);
    }

    @Override
    public SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.GENERIC_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.GENERIC_DEATH;
    }

    @Override
    public int getExperienceReward(Player player) {
        return 5;
    }

    public ResourceLocation getTexture() {
        return TerrestrialBiomes.RL(this.entityData.get(FARMER_DWARF_TEXTURE));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FARMER_DWARF_TEXTURE, Keys.FARMER_DWARF.getPath());
    }
}
