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
            return new ItemStack(ItemInit.AQUAMARINE.get());
        }

        @OnlyIn(Dist.CLIENT)
        public boolean hasSearchBar() {
            return false;
        }
    };
}