package net.golkeb.terrestrial_biomes.world.food;

import net.minecraft.world.food.FoodProperties;

public class Food {
    public static final FoodProperties BEAN = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.6f).build();
    public static final FoodProperties BLUEBERRY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_CRAB = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F).build();
    public static final FoodProperties COOKED_CRAB = (new FoodProperties.Builder()).nutrition(5).saturationMod(6F).meat().build();
}
