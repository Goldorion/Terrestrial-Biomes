package net.golkeb.terrestrial_biomes.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class SuppCropBlock extends CropBlock {

    private final Supplier<ItemLike> baseSeed;

    public SuppCropBlock(Supplier<ItemLike> baseSeed, BlockBehaviour.Properties properties) {
        super(properties);
        this.baseSeed = baseSeed;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return this.baseSeed.get();
    }

    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState blockState) {
        return new ItemStack(this.baseSeed.get());
    }
}
