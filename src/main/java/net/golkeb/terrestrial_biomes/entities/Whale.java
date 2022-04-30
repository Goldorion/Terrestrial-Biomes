package net.golkeb.terrestrial_biomes.entities;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.entities.ai.control.AbstractMoveControl;
import net.golkeb.terrestrial_biomes.init.SoundsInit;
import net.golkeb.terrestrial_biomes.misc.Keys;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeMod;

import java.util.Random;

public class Whale extends WaterAnimal {

    public static final EntityDataAccessor<String> WHALE_TEXTURE = SynchedEntityData.defineId(Whale.class, EntityDataSerializers.STRING);

    public Whale(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        setNoAi(false);
        this.moveControl = new AbstractMoveControl(this);
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new WaterBoundPathNavigation(this, level);
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
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.ARMOR, 0)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(ForgeMod.SWIM_SPEED.get(), 0.3);
    }

    public static boolean checkMobSpawn(EntityType<? extends WaterAnimal> mob, LevelAccessor levelAccessor, MobSpawnType type, BlockPos pos, Random random) {
        return levelAccessor.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY).get(levelAccessor.getBiome(pos).unwrapKey().get().getRegistryName()) != null
                && levelAccessor.getBiome(pos).unwrapKey().isPresent() && BiomeDictionary.hasType(levelAccessor.getBiome(pos).unwrapKey().get(), BiomeDictionary.Type.OCEAN);
    }

    @Override
    public int getExperienceReward(Player player) {
        return 5;
    }

    public ResourceLocation getTexture() {
        return TerrestrialBiomes.RL(this.entityData.get(WHALE_TEXTURE));
    }

    public SoundEvent getAmbientSound() {
        return SoundsInit.WHALE_AMBIENT.get();
    }

    public SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.GENERIC_HURT;
    }

    public SoundEvent getDeathSound() {
        return SoundEvents.GENERIC_DEATH;
    }

    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide && Math.random() < 0.25) {
            for (int i = 0; i < 7; i++) {
                double d0 = (this.getX() + 0.5) + (this.random.nextFloat() - 0.5) * 1.9D;
                double d1 = ((this.getY() + 0.7) + (this.random.nextFloat() - 0.5) * 1.9D * 100) + 0.5;
                double d2 = (this.getZ() + 0.5) + (this.random.nextFloat() - 0.5) * 1.9D;
                this.level.addParticle(ParticleTypes.BUBBLE, d0, d1, d2, 0, 0, 0);
            }
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(WHALE_TEXTURE, Keys.WHALE.getPath());
    }
}
