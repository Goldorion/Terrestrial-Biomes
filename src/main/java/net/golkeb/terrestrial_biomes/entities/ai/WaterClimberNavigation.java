package net.golkeb.terrestrial_biomes.entities.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;

import javax.annotation.Nullable;

public class WaterClimberNavigation extends WaterBoundPathNavigation {

    @Nullable
    private BlockPos pathToPosition;

    public WaterClimberNavigation(Mob mob, Level level) {
        super(mob, level);
    }

    public Path createPath(BlockPos blockPos, int path) {
        this.pathToPosition = blockPos;
        return super.createPath(blockPos, path);
    }

    public Path createPath(Entity entity, int path) {
        this.pathToPosition = entity.blockPosition();
        return super.createPath(entity, path);
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
