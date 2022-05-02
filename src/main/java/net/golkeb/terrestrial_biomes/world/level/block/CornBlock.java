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

public class CornBlock extends SuppCropBlock {

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(3.0D, 0.0D, 3.0D, 15.0D, 3.0D, 15.0D),
            Block.box(2.0D, 0.0D, 2.0D, 16.0D, 3.0D, 15.0D),
            Block.box(1.0D, 0.0D, 1.0D, 16.0D, 6.0D, 16.0D),
            Block.box(1.0D, 0.0D, 1.0D, 16.0D, 6.0D, 16.0D),
            Block.box(1.0D, 0.0D, 1.0D, 16.0D, 14.0D, 16.0D),
            Block.box(1.0D, 0.0D, 1.0D, 16.0D, 14.0D, 16.0D),
            Block.box(1.0D, 0.0D, 1.0D, 16.0D, 14.0D, 16.0D),
            Block.box(1.0D, 0.0D, 1.0D, 16.0D, 14.0D, 16.0D)};

    public CornBlock(Supplier<ItemLike> corn, BlockBehaviour.Properties properties) {
        super(corn, properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }
}
