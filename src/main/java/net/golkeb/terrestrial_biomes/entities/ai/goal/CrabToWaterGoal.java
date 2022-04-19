package net.golkeb.terrestrial_biomes.entities.ai.goal;

import net.golkeb.terrestrial_biomes.entities.Crab;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Random;

public class CrabToWaterGoal extends Goal {

    private final Crab crab;
    private double wantedX;
    private double wantedY;
    private double wantedZ;
    private final double speedModifier;
    private final Level level;

    public CrabToWaterGoal(Crab crab, double speed) {
        this.crab = crab;
        this.speedModifier = speed;
        this.level = crab.level;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean canUse() {
        if (!this.level.isDay()) {
            return false;
        } else if (this.crab.isInWater()) {
            return false;
        } else {
            Vec3 vec3 = this.getWaterPos();
            if (vec3 == null) {
                return false;
            } else {
                this.wantedX = vec3.x;
                this.wantedY = vec3.y;
                this.wantedZ = vec3.z;
                return true;
            }
        }
    }

    public boolean canContinueToUse() {
        return !this.crab.getNavigation().isDone();
    }

    public void start() {
        this.crab.getNavigation().moveTo(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
    }

    @Nullable
    private Vec3 getWaterPos() {
        Random random = this.crab.getRandom();
        BlockPos blockPos = this.crab.blockPosition();

        for (int i = 0; i < 10; ++i) {
            BlockPos offset = blockPos.offset(random.nextInt(20) - 10, 2 - random.nextInt(8), random.nextInt(20) - 10);
            if (this.level.getBlockState(offset).is(Blocks.WATER)) {
                return Vec3.atBottomCenterOf(offset);
            }
        }
        return null;
    }
}
