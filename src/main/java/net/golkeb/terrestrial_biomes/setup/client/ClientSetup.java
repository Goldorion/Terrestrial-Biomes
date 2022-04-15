package net.golkeb.terrestrial_biomes.setup.client;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.client.guis.BackpackWindow;
import net.golkeb.terrestrial_biomes.client.models.DwarfModel;
import net.golkeb.terrestrial_biomes.client.renderers.ExplorerDwarfRenderer;
import net.golkeb.terrestrial_biomes.init.ContainerInit;
import net.golkeb.terrestrial_biomes.init.EntityInit;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TerrestrialBiomes.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) {
        // Make this deferred for unsafe threads
        event.enqueueWork(() -> {
            // Connect Containers and Windows
            MenuScreens.register(ContainerInit.BACKPACK_CONTAINER.get(), BackpackWindow::new);
        });
    }

    @SubscribeEvent
    public static void registerModels(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.EXPLORER_DWARF_TYPE, renderManager ->
                new ExplorerDwarfRenderer<>(renderManager, new DwarfModel<>(renderManager.bakeLayer(ExplorerDwarfRenderer.LAYER_LOCATION))));
    }
}
