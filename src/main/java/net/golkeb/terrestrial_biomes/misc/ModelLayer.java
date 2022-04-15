package net.golkeb.terrestrial_biomes.misc;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.minecraft.client.model.geom.ModelLayerLocation;

public class ModelLayer {

    public static final ModelLayerLocation EXPLORER_DWARF = register("explorer_dwarf");

    private static ModelLayerLocation register(String name) {
        return new ModelLayerLocation(TerrestrialBiomes.RL(name), "main");
    }
}
