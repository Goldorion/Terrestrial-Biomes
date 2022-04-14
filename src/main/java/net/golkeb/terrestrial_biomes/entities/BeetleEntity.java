package net.golkeb.terrestrial_biomes.entities;

import net.golkeb.terrestrial_biomes.init.EntityInit;
import net.golkeb.terrestrial_biomes.misc.Keys;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class BeetleEntity extends Animal {

    public BeetleEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        setNoAi(false);
        this.moveControl = new FlyingMoveControl(this, 10, true);
        this.navigation = new FlyingPathNavigation(this, this.level);
    }

    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.8, 20) {
            @Override
            protected Vec3 getPosition() {
                Random random = this.mob.getRandom();
                double x = this.getPosition().x + ((random.nextFloat() * 2 - 1) * 16);
                double y = this.getPosition().y + ((random.nextFloat() * 2 - 1) * 16);
                double z = this.getPosition().z + ((random.nextFloat() * 2 - 1) * 16);
                return new Vec3(x, y, z);
            }
        });
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 10));
        this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, (float) 0.8));
        this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.MAX_HEALTH, 10)
                .add(Attributes.ARMOR, 2)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.FLYING_SPEED, 0.3);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.SPIDER_AMBIENT;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource damageSource) {
        return ForgeRegistries.SOUND_EVENTS.getValue(Keys.DEFAULT_NULL);
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(Keys.DEFAULT_NULL);
    }

    public boolean causeFallDamage(float distance, float damage, DamageSource damageSource) {
        return false;
    }

    protected void checkFallDamage(double vecY, boolean isOnGround, BlockState state, BlockPos pos) {
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        BeetleEntity beetle = new BeetleEntity(EntityInit.BEETLE_ENTITY_TYPE, serverWorld);
        beetle.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(beetle.blockPosition()), MobSpawnType.BREEDING, null, null);
        return beetle;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        /*
        if (new ItemStack(BlueberryItem.block, (int) (1)).getItem() == stack.getItem())
            return true;
        if (new ItemStack(OrangeItem.block, (int) (1)).getItem() == stack.getItem())
            return true;
        if (new ItemStack(LemonItem.block, (int) (1)).getItem() == stack.getItem())
            return true;
        if (new ItemStack(LimeItem.block, (int) (1)).getItem() == stack.getItem())
            return true;
        if (new ItemStack(BlackberryItem.block, (int) (1)).getItem() == stack.getItem())
            return true;
        if (new ItemStack(StrawberryItem.block, (int) (1)).getItem() == stack.getItem())
            return true;
         */
        if (new ItemStack(Items.APPLE, 1).getItem() == stack.getItem())
            return true;
        if (new ItemStack(Items.MELON_SLICE, 1).getItem() == stack.getItem())
            return true;
        return new ItemStack(Items.SWEET_BERRIES, 1).getItem() == stack.getItem();
    }

    @Override
    public int getExperienceReward(Player player) {
        return 5;
    }

    @Override
    public void setNoGravity(boolean ignored) {
        super.setNoGravity(true);
    }

    public void tick() {
        super.tick();
        this.setNoGravity(true);
    }
}
