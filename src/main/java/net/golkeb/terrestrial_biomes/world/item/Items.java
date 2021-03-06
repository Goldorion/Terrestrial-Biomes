package net.golkeb.terrestrial_biomes.world.item;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.setup.ItemGroups;
import net.golkeb.terrestrial_biomes.world.entity.Entity;
import net.golkeb.terrestrial_biomes.world.food.Food;
import net.golkeb.terrestrial_biomes.world.level.block.Blocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TerrestrialBiomes.MODID);

    public static final RegistryObject<Item> BEAN = ITEMS.register("bean", () -> registerNameBlockItem(Blocks.BEANS.get(), ItemGroups.TERRESTRIAL_BIOMES_ITEMS, Food.BEAN));
    public static final RegistryObject<Item> BLACK_BEAN = ITEMS.register("black_bean", () -> registerNameBlockItem(Blocks.BLACK_BEANS.get(), ItemGroups.TERRESTRIAL_BIOMES_ITEMS, Food.BEAN));
    public static final RegistryObject<Item> RED_BEAN = ITEMS.register("red_bean", () -> registerNameBlockItem(Blocks.RED_BEANS.get(), ItemGroups.TERRESTRIAL_BIOMES_ITEMS, Food.BEAN));
    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry", () -> registerNameBlockItem(Blocks.BLUEBERRIES.get(), ItemGroups.TERRESTRIAL_BIOMES_ITEMS, Food.BLUEBERRY));
    public static final RegistryObject<Item> BLACKBERRY = ITEMS.register("blackberry", () -> registerNameBlockItem(Blocks.BLACKBERRIES.get(), ItemGroups.TERRESTRIAL_BIOMES_ITEMS, Food.BLACKBERRY));
    public static final RegistryObject<Item> CORN = ITEMS.register("corn", () -> registerNameBlockItem(Blocks.CORNS.get(), ItemGroups.TERRESTRIAL_BIOMES_ITEMS, Food.CORN));
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato", () -> registerNameBlockItem(Blocks.TOMATOES.get(), ItemGroups.TERRESTRIAL_BIOMES_ITEMS, Food.TOMATO));
    public static final RegistryObject<Item> BACKPACK = registerItem("backpack", () -> new BackpackItem(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).tab(ItemGroups.TERRESTRIAL_BIOMES_ITEMS)));
    public static final RegistryObject<Item> RAW_CRAB_MEAT = registerItem("raw_crab_meat", ItemGroups.TERRESTRIAL_BIOMES_ITEMS, Food.RAW_CRAB);
    public static final RegistryObject<Item> COOKED_CRAB_MEAT = registerItem("cooked_crab_meat", ItemGroups.TERRESTRIAL_BIOMES_ITEMS, Food.COOKED_CRAB);
    public static final RegistryObject<Item> STARFISH = registerItem("starfish", ItemGroups.TERRESTRIAL_BIOMES_ITEMS);
    public static final RegistryObject<Item> CRAB_BUCKET = registerItem("crab_bucket", () -> new MobBucketItem(Entity.CRAB, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> STARFISH_BUCKET = registerItem("starfish_bucket", () -> new MobBucketItem(Entity.STARFISH, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<SpawnEggItem> CRAB_SPAWN_EGG = registerSpawnEgg("crab_spawn_egg", Entity.CRAB, -511739, -12412);
    public static final RegistryObject<SpawnEggItem> EXPLORER_DWARF_SPAWN_EGG = registerSpawnEgg("explorer_dwarf_spawn_egg", Entity.EXPLORER_DWARF, -9880025, -14342875);
    public static final RegistryObject<SpawnEggItem> FARMER_DWARF_SPAWN_EGG = registerSpawnEgg("farmer_dwarf_spawn_egg", Entity.FARMER_DWARF, -9880025, -2245076);
    public static final RegistryObject<SpawnEggItem> STARFISH_SPAWN_EGG = registerSpawnEgg("starfish_spawn_egg", Entity.STARFISH, -511739, -12412);
    public static final RegistryObject<SpawnEggItem> WARRIOR_DWARF_SPAWN_EGG = registerSpawnEgg("warrior_dwarf_spawn_egg", Entity.WARRIOR_DWARF, -9880025, -3026479);
    public static final RegistryObject<SpawnEggItem> WHALE_SPAWN_EGG = registerSpawnEgg("whale_spawn_egg", Entity.WHALE, -9271601, -13158280);

    private static ItemNameBlockItem registerNameBlockItem(Block block, CreativeModeTab creativeModeTab, FoodProperties food) {
        return new ItemNameBlockItem(block, (new Item.Properties().tab(creativeModeTab).food(food)));
    }

    private static BlockItem registerBlockItem(Block block, CreativeModeTab creativeModeTab) {
        return new BlockItem(block, (new Item.Properties().tab(creativeModeTab)));
    }

    private static RegistryObject<Item> registerItem(String name, CreativeModeTab creativeModeTab, FoodProperties foodProperties) {
        return registerItem(name, () -> (new Item(new Item.Properties().tab(creativeModeTab).food(foodProperties))));
    }

    private static RegistryObject<Item> registerItem(String name, CreativeModeTab creativeModeTab) {
        return registerItem(name, () -> (new Item(new Item.Properties().tab(creativeModeTab))));
    }

    private static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }

    private static RegistryObject<SpawnEggItem> registerSpawnEgg(String name, Supplier<? extends EntityType<? extends Mob>> entityType, int color1, int color2) {
        return ITEMS.register(name, () -> new AbstractEggItem(entityType, color1, color2));
    }
}
