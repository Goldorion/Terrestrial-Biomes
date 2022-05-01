package net.golkeb.terrestrial_biomes.world.level.block;

import net.golkeb.terrestrial_biomes.world.item.Items;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public class BlackberriesBlock extends Bush3Block {

    public BlackberriesBlock(Properties properties) {
        super(properties, Items.BLACKBERRY);
    }

    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState blockState) {
        return new ItemStack(Items.BLACKBERRY.get());
    }
}
