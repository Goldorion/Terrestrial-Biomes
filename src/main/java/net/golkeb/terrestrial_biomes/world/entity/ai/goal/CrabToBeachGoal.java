package net.golkeb.terrestrial_biomes.world.entity.ai.goal;

import net.golkeb.terrestrial_biomes.world.entity.animal.Crab;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.LevelReader;

public class CrabToBeachGoal extends MoveToBlockGoal {

    private final Crab crab;

    public CrabToBeachGoal(Crab crab, double speed) {
        super(crab, speed, 8, 2);
        this.crab = crab;
    }

    public boolean canUse() {
        return super.canUse() && !this.crab.level.isDay() && this.crab.isInWater() && this.crab.getY() >= (double) (this.crab.level.getSeaLevel() - 3);
    }

    public boolean canContinueToUse() {
        return super.canContinueToUse();
    }

    protected boolean isValidTarget(LevelReader levelReader, BlockPos blockPos) {
        BlockPos above = blockPos.above();
        return levelReader.isEmptyBlock(above) && levelReader.isEmptyBlock(above.above()) && levelReader.getBlockState(blockPos).entityCanStandOn(levelReader, blockPos, this.crab);
    }

    public void start() {
        this.crab.setSearchingForLand(false);
        super.start();
    }

    public void stop() {
        super.stop();
    }
}
