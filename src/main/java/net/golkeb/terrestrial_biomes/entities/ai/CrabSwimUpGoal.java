package net.golkeb.terrestrial_biomes.entities.ai;

import net.golkeb.terrestrial_biomes.entities.Crab;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.phys.Vec3;

public class CrabSwimUpGoal extends Goal {

    private final Crab crab;
    private final double speedModifier;
    private final int seaLevel;
    private boolean stuck;

    public CrabSwimUpGoal(Crab crab, double speed, int seaLevel) {
        this.crab = crab;
        this.speedModifier = speed;
        this.seaLevel = seaLevel;
    }

    public boolean canUse() {
        return !this.crab.level.isDay() && this.crab.isInWater() && this.crab.getY() < (double) (this.seaLevel - 2) && this.crab.isOnGround();
    }

    public boolean canContinueToUse() {
        return this.canUse() && !this.stuck;
    }

    public void tick() {
        if (this.crab.getY() < (double) (this.seaLevel - 1) && (this.crab.getNavigation().isDone() || this.crab.closeToNextPos())) {
            Vec3 vec3 = DefaultRandomPos.getPosTowards(this.crab, 4, 8, new Vec3(this.crab.getX(), this.seaLevel - 1, this.crab.getZ()), (float) Math.PI / 2F);
            if (vec3 == null) {
                this.stuck = true;
                return;
            }
            this.crab.getNavigation().moveTo(vec3.x, vec3.y, vec3.z, this.speedModifier);
        }
    }

    public void start() {
        this.crab.setSearchingForLand(true);
        this.stuck = false;
    }

    public void stop() {
        this.crab.setSearchingForLand(false);
    }
}
