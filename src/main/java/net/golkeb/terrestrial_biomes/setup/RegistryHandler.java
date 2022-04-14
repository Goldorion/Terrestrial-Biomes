package net.golkeb.terrestrial_biomes.setup;

import net.golkeb.terrestrial_biomes.init.BlockInit;
import net.golkeb.terrestrial_biomes.init.ContainerInit;
import net.golkeb.terrestrial_biomes.init.ItemInit;
import net.golkeb.terrestrial_biomes.init.SoundsInit;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RegistryHandler {

    public static void init() {
        ContainerInit.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockInit.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemInit.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SoundsInit.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
