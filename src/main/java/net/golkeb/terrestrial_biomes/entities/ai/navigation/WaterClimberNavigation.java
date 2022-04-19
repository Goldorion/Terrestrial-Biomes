package net.golkeb.terrestrial_biomes.entities.ai.navigation;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class WaterClimberNavigation extends PathNavigation {

    @Nullable
    private BlockPos pathToPosition;

    public WaterClimberNavigation(Mob mob, Level level) {
        super(mob, level);
    }

    protected PathFinder createPathFinder(int pathFinder) {
        this.nodeEvaluator = new WalkNodeEvaluator();
        this.nodeEvaluator.setCanPassDoors(true);
        return new PathFinder(this.nodeEvaluator, pathFinder);
    }

    public Path createPath(BlockPos blockPos, int speed) {
        this.pathToPosition = blockPos;
        return super.createPath(blockPos, speed);
    }

    public Path createPath(Entity entity, int speed) {
        this.pathToPosition = entity.blockPosition();
        return super.createPath(entity, speed);
    }

    public boolean moveTo(Entity entity, double speed) {
        Path path = this.createPath(entity, 0);
        if (path != null) {
            return this.moveTo(path, speed);
        } else {
            this.pathToPosition = entity.blockPosition();
            this.speedModifier = speed;
            return true;
        }
    }

    protected boolean canUpdatePath() {
        return this.mob.isOnGround() || this.isInLiquid() || this.mob.isPassenger();
    }

    protected Vec3 getTempMobPos() {
        return new Vec3(this.mob.getX(), this.mob.getY(0.5D), this.mob.getZ());
    }

    protected double getGroundY(Vec3 vec3) {
        return vec3.y;
    }

    protected boolean canMoveDirectly(Vec3 vec3, Vec3 vec31) {
        Vec3 vec = new Vec3(vec31.x, vec31.y + (double) this.mob.getBbHeight() * 0.5D, vec31.z);
        return this.level.clip(new ClipContext(vec3, vec, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this.mob)).getType() == HitResult.Type.MISS;
    }

    public boolean isStableDestination(BlockPos blockPos) {
        return !this.level.getBlockState(blockPos).isSolidRender(this.level, blockPos);
    }

    public void setCanFloat(boolean canFloat) {
    }

    protected void trimPath() {
        super.trimPath();
    }

    public void tick() {
        if (!this.isDone()) {
            super.tick();
        } else {
            if (this.pathToPosition != null) {
                if (!this.pathToPosition.closerToCenterThan(this.mob.position(), Math.max(this.mob.getBbWidth(), 1.0D)) && (!(this.mob.getY() > (double) this.pathToPosition.getY()) || !(new BlockPos(this.pathToPosition.getX(), this.mob.getY(), this.pathToPosition.getZ())).closerToCenterThan(this.mob.position(), Math.max(this.mob.getBbWidth(), 1.0D)))) {
                    this.mob.getMoveControl().setWantedPosition(this.pathToPosition.getX(), this.pathToPosition.getY(), this.pathToPosition.getZ(), this.speedModifier);
                } else {
                    this.pathToPosition = null;
                }
            }
        }
    }
}
