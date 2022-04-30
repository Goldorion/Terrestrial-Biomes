package net.golkeb.terrestrial_biomes.entities.ai.control;

import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.animal.WaterAnimal;

public class AbstractMoveControl extends MoveControl {

    private final WaterAnimal animal;

    public AbstractMoveControl(WaterAnimal animal) {
        super(animal);
        this.animal = animal;
    }

    public void tick() {
        if (this.animal.isEyeInFluid(FluidTags.WATER)) {
            this.animal.setDeltaMovement(this.animal.getDeltaMovement().add(0, 0.005, 0));
        }
        if (this.operation != Operation.MOVE_TO && !this.animal.getNavigation().isDone()) {
            double dx = this.wantedX - this.animal.getX();
            double dy = this.wantedY - this.animal.getY();
            double dz = this.wantedZ - this.animal.getZ();
            dy = dy / Math.sqrt(dx * dx + dy * dy + dz * dz);
            this.animal.setYRot(this.rotlerp(this.animal.getYRot(), (float) (Math.atan2(dz, dx) * (double) (180 / (float) Math.PI)) - 90, 90));
            this.animal.setYBodyRot(this.animal.getYRot());
            this.animal.setSpeed(Mth.lerp(0.125f, this.animal.getSpeed(), (float) (this.speedModifier * this.animal.getAttributeValue(Attributes.MOVEMENT_SPEED))));
            this.animal.setDeltaMovement(this.animal.getDeltaMovement().add(0, this.animal.getSpeed() * dy * 0.1, 0));
        } else {
            this.animal.setSpeed(0);
        }
    }
}
