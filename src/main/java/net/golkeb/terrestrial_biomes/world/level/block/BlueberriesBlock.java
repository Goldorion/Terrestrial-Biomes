package net.golkeb.terrestrial_biomes.world.level.block;

import net.golkeb.terrestrial_biomes.world.item.Items;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public class BlueberriesBlock extends Bush3Block {

    public BlueberriesBlock(Properties properties) {
        super(properties, Items.BLUEBERRY);
    }

    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState blockState) {
        return new ItemStack(Items.BLUEBERRY.get());
    }
}
