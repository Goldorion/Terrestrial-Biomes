package net.golkeb.terrestrial_biomes.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class TomatoBlock extends SuppCropBlock {

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(2.0D, 0.0D, 2.0D, 13.0D, 3.0D, 13.0D),
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 5.0D, 15.0D),
            Block.box(0.0D, 0.0D, 0.0D, 15.0D, 7.0D, 15.0D),
            Block.box(0.0D, 0.0D, 0.0D, 15.0D, 9.0D, 15.0D),
            Block.box(0.0D, 0.0D, 0.0D, 15.0D, 12.0D, 15.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D)};

    public TomatoBlock(Supplier<ItemLike> tomato, BlockBehaviour.Properties properties) {
        super(tomato, properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }
}
