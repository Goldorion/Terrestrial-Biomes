package net.golkeb.terrestrial_biomes.init;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.setup.ItemGroups;
import net.golkeb.terrestrial_biomes.world.food.Food;
import net.golkeb.terrestrial_biomes.world.item.AbstractEggItem;
import net.golkeb.terrestrial_biomes.world.item.BackpackItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            TerrestrialBiomes.MODID);

    public static final RegistryObject<Item> BEAN = ITEMS.register("bean", () ->
            new ItemNameBlockItem(BlockInit.BEANS.get(), (new Item.Properties()).tab(ItemGroups.TERRESTRIAL_BIOMES_ITEMS).food(Food.BEAN)));

    public static final RegistryObject<Item> BLACK_BEAN = ITEMS.register("black_bean", () ->
            new ItemNameBlockItem(BlockInit.BLACK_BEANS.get(), (new Item.Properties()).tab(ItemGroups.TERRESTRIAL_BIOMES_ITEMS).food(Food.BEAN)));

    public static final RegistryObject<Item> RED_BEAN = ITEMS.register("red_bean", () ->
            new ItemNameBlockItem(BlockInit.RED_BEANS.get(), (new Item.Properties()).tab(ItemGroups.TERRESTRIAL_BIOMES_ITEMS).food(Food.BEAN)));

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberries", () ->
            new ItemNameBlockItem(BlockInit.BLUEBERRIES.get(), (new Item.Properties()).stacksTo(64).rarity(Rarity.COMMON).tab(ItemGroups.TERRESTRIAL_BIOMES_ITEMS).food(Food.BLUEBERRY)));

    public static final RegistryObject<Item> BACKPACK = ITEMS.register("backpack", BackpackItem::new);

    public static final RegistryObject<Item> RAW_CRAB_MEAT = ITEMS.register("raw_crab_meat", () ->
            new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).tab(ItemGroups.TERRESTRIAL_BIOMES_ITEMS).food(Food.RAW_CRAB)));

    public static final RegistryObject<Item> COOKED_CRAB_MEAT = ITEMS.register("cooked_crab_meat", () ->
            new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).tab(ItemGroups.TERRESTRIAL_BIOMES_ITEMS).food(Food.COOKED_CRAB)));

    public static final RegistryObject<Item> STARFISH = ITEMS.register("starfish", () ->
            new Item(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).tab(ItemGroups.TERRESTRIAL_BIOMES_ITEMS)));

    public static final RegistryObject<Item> CRAB_BUCKET = ITEMS.register("crab_bucket", () ->
            new MobBucketItem(EntityInit.CRAB, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> STARFISH_BUCKET = ITEMS.register("starfish_bucket", () ->
            new MobBucketItem(EntityInit.STARFISH, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<SpawnEggItem> CRAB_SPAWN_EGG = ITEMS.register("crab_spawn_egg", () ->
            new ForgeSpawnEggItem(EntityInit.CRAB, -511739, -12412, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<SpawnEggItem> EXPLORER_DWARF_SPAWN_EGG = ITEMS.register("explorer_dwarf_spawn_egg", () ->
            new AbstractEggItem(EntityInit.EXPLORER_DWARF, -9880025, -14342875));

    public static final RegistryObject<SpawnEggItem> FARMER_DWARF_SPAWN_EGG = ITEMS.register("farmer_dwarf_spawn_egg", () ->
            new AbstractEggItem(EntityInit.FARMER_DWARF, -9880025, -2245076));

    public static final RegistryObject<SpawnEggItem> STARFISH_SPAWN_EGG = ITEMS.register("starfish_spawn_egg", () ->
            new AbstractEggItem(EntityInit.STARFISH, -511739, -12412));

    public static final RegistryObject<SpawnEggItem> WARRIOR_DWARF_SPAWN_EGG = ITEMS.register("warrior_dwarf_spawn_egg", () ->
            new AbstractEggItem(EntityInit.WARRIOR_DWARF, -9880025, -3026479));

    public static final RegistryObject<SpawnEggItem> WHALE_SPAWN_EGG = ITEMS.register("whale_spawn_egg", () ->
            new AbstractEggItem(EntityInit.WHALE, -9271601, -13158280));
}
