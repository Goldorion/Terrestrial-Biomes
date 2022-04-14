package net.golkeb.terrestrial_biomes.setup;

import net.golkeb.terrestrial_biomes.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemGroups {

    public static final CreativeModeTab TERRESTRIAL_BIOMES_ITEMS = new CreativeModeTab("terrestrial_biomes_items") {
        @OnlyIn(Dist.CLIENT)
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.BLUEBERRY.get());
        }

        @OnlyIn(Dist.CLIENT)
        public boolean hasSearchBar() {
            return false;
        }
    };

    /*
    public static final CreativeModTab TERRESTRIAL_BIOMES_BLOCKS = new CreativeModTab("terrestrial_biomes_blocks") {
        @OnlyIn(Dist.CLIENT)
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlockInit.TIN_ORE.get());
        }

        @OnlyIn(Dist.CLIENT)
        public boolean hasSearchBar() {
            return false;
        }
    };
    */
}