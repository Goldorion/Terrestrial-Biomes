package net.golkeb.terrestrial_biomes.init;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.items.Backpack;
import net.golkeb.terrestrial_biomes.setup.ItemGroups;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            TerrestrialBiomes.MODID);

    public static final RegistryObject<Item> AQUAMARINE = ITEMS.register("aquamarine", () ->
            new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).tab(ItemGroups.TERRESTRIAL_BIOMES_ITEMS)));

    public static final RegistryObject<Item> BACKPACK = ITEMS.register("backpack", Backpack::new);
}
