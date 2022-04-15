package net.golkeb.terrestrial_biomes.init;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.items.AbstractEgg;
import net.golkeb.terrestrial_biomes.items.Backpack;
import net.golkeb.terrestrial_biomes.setup.ItemGroups;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            TerrestrialBiomes.MODID);

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberries", () -> new ItemNameBlockItem(BlockInit.BLUEBERRIES.get(),
            new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).tab(ItemGroups.TERRESTRIAL_BIOMES_ITEMS).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).build())));

    public static final RegistryObject<Item> BACKPACK = ITEMS.register("backpack", Backpack::new);

    public static final RegistryObject<SpawnEggItem> EXPLORER_DWARF_SPAWN_EGG = ITEMS.register("explorer_dwarf_spawn_egg", () ->
            new AbstractEgg(EntityInit.EXPLORER_DWARF, -9880025, -14342875));
}
