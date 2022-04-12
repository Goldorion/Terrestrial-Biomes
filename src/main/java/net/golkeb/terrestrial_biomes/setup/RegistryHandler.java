package net.golkeb.terrestrial_biomes.setup;

import net.golkeb.terrestrial_biomes.init.SoundsInit;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RegistryHandler {

    public static void init() {
        SoundsInit.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
