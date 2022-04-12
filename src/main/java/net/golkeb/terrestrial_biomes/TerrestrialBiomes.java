package net.golkeb.terrestrial_biomes;

import net.golkeb.terrestrial_biomes.setup.RegistryHandler;

import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TerrestrialBiomes.MODID)
public class TerrestrialBiomes {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    // Register the modid
    public static final String MODID = "terrestrial_biomes";

    public TerrestrialBiomes() {

        // Init Advancements and Registries
        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation RL(String path) {
        return new ResourceLocation(MODID, path);
    }
}