package net.golkeb.terrestrial_biomes.entities.ai;

import net.golkeb.terrestrial_biomes.entities.Crab;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;

public class CrabMoveControl extends MoveControl {

    private final Crab crab;

    public CrabMoveControl(Crab crab) {
        super(crab);
        this.crab = crab;
    }

    public void tick() {
        LivingEntity livingEntity = this.crab.getTarget();
        if (this.crab.wantsToSwim() && this.crab.isInWater()) {
            if (livingEntity != null && livingEntity.getY() > this.crab.getY() || this.crab.isSearchingForLand()) {
                this.crab.setDeltaMovement(this.crab.getDeltaMovement().add(0.0D, 0.002D, 0.0D));
            }

            if (this.operation != MoveControl.Operation.MOVE_TO || this.crab.getNavigation().isDone()) {
                this.crab.setSpeed(0.0F);
                return;
            }

            double d0 = this.wantedX - this.crab.getX();
            double d2 = this.wantedZ - this.crab.getZ();
            float f = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
            this.crab.setYRot(this.rotlerp(this.crab.getYRot(), f, 90.0F));
            this.crab.yBodyRot = this.crab.getYRot();
            float f1 = (float) (this.speedModifier * this.crab.getAttributeValue(Attributes.MOVEMENT_SPEED));
            float f2 = Mth.lerp(0.125F, this.crab.getSpeed(), f1);
            this.crab.setSpeed(f2);
            this.crab.setDeltaMovement(this.crab.getDeltaMovement().add((double) f2 * d0 * 0.005D, 0D, (double) f2 * d2 * 0.005D));
        } else {
            if (!this.crab.isOnGround()) {
                this.crab.setDeltaMovement(this.crab.getDeltaMovement().add(0.0D, -0.008D, 0.0D));
            }
            super.tick();
        }
    }
}
