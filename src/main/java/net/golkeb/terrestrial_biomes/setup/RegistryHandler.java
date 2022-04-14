package net.golkeb.terrestrial_biomes.setup;

import net.golkeb.terrestrial_biomes.init.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RegistryHandler {

    public static void init() {
        BlockInit.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ContainerInit.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        EntityInit.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemInit.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SoundsInit.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
