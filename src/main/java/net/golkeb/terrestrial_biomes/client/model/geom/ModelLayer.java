package net.golkeb.terrestrial_biomes.client.model.geom;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.minecraft.client.model.geom.ModelLayerLocation;

public class ModelLayer {

    public static final ModelLayerLocation CRAB = register("crab");
    public static final ModelLayerLocation EXPLORER_DWARF = register("explorer_dwarf");
    public static final ModelLayerLocation FARMER_DWARF = register("farmer_dwarf");
    public static final ModelLayerLocation STARFISH = register("starfish");
    public static final ModelLayerLocation WARRIOR_DWARF = register("warrior_dwarf");
    public static final ModelLayerLocation WHALE = register("whale");

    private static ModelLayerLocation register(String name) {
        return new ModelLayerLocation(TerrestrialBiomes.RL(name), "main");
    }
}
