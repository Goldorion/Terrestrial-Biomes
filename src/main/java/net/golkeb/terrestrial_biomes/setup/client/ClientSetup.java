package net.golkeb.terrestrial_biomes.setup.client;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.client.guis.BackpackWindow;
import net.golkeb.terrestrial_biomes.client.models.CrabModel;
import net.golkeb.terrestrial_biomes.client.models.DwarfModel;
import net.golkeb.terrestrial_biomes.client.renderers.CrabRenderer;
import net.golkeb.terrestrial_biomes.client.renderers.ExplorerDwarfRenderer;
import net.golkeb.terrestrial_biomes.client.renderers.FarmerDwarfRenderer;
import net.golkeb.terrestrial_biomes.client.renderers.WarriorDwarfRenderer;
import net.golkeb.terrestrial_biomes.init.BlockInit;
import net.golkeb.terrestrial_biomes.init.ContainerInit;
import net.golkeb.terrestrial_biomes.init.EntityInit;
import net.golkeb.terrestrial_biomes.misc.ModelLayer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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

            // Cutout
            ItemBlockRenderTypes.setRenderLayer(BlockInit.BLUEBERRIES.get(), RenderType.cutout());
        });
    }

    @SubscribeEvent
    public static void registerModels(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.CRAB.get(), CrabRenderer::new);
        event.registerEntityRenderer(EntityInit.EXPLORER_DWARF.get(), ExplorerDwarfRenderer::new);
        event.registerEntityRenderer(EntityInit.FARMER_DWARF.get(), FarmerDwarfRenderer::new);
        event.registerEntityRenderer(EntityInit.WARRIOR_DWARF.get(), WarriorDwarfRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelLayer.CRAB, CrabModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayer.EXPLORER_DWARF, DwarfModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayer.FARMER_DWARF, DwarfModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayer.WARRIOR_DWARF, DwarfModel::createBodyLayer);
    }
}
