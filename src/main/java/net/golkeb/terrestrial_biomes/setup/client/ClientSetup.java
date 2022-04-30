package net.golkeb.terrestrial_biomes.setup.client;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.client.guis.BackpackWindow;
import net.golkeb.terrestrial_biomes.client.models.CrabModel;
import net.golkeb.terrestrial_biomes.client.models.DwarfModel;
import net.golkeb.terrestrial_biomes.client.models.StarfishModel;
import net.golkeb.terrestrial_biomes.client.models.WhaleModel;
import net.golkeb.terrestrial_biomes.client.renderers.*;
import net.golkeb.terrestrial_biomes.entities.Crab;
import net.golkeb.terrestrial_biomes.init.BlockInit;
import net.golkeb.terrestrial_biomes.init.ContainerInit;
import net.golkeb.terrestrial_biomes.init.EntityInit;
import net.golkeb.terrestrial_biomes.init.ItemInit;
import net.golkeb.terrestrial_biomes.misc.Keys;
import net.golkeb.terrestrial_biomes.misc.ModelLayer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
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

            // Item Properties
            ItemProperties.register(ItemInit.CRAB_BUCKET.get(), Keys.VARIANT_PROPERTY, (stack, level, entity, i) -> {
                if (entity == null) return 0.0F;
                if (stack.getTag() != null) return stack.getTag().getInt(Crab.BUCKET_VARIANT_TAG);
                return 0.0F;
            });
        });
    }

    @SubscribeEvent
    public static void registerModels(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.CRAB.get(), CrabRenderer::new);
        event.registerEntityRenderer(EntityInit.EXPLORER_DWARF.get(), ExplorerDwarfRenderer::new);
        event.registerEntityRenderer(EntityInit.FARMER_DWARF.get(), FarmerDwarfRenderer::new);
        event.registerEntityRenderer(EntityInit.STARFISH.get(), StarfishRenderer::new);
        event.registerEntityRenderer(EntityInit.WARRIOR_DWARF.get(), WarriorDwarfRenderer::new);
        event.registerEntityRenderer(EntityInit.WHALE.get(), WhaleRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelLayer.CRAB, CrabModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayer.EXPLORER_DWARF, DwarfModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayer.FARMER_DWARF, DwarfModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayer.STARFISH, StarfishModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayer.WARRIOR_DWARF, DwarfModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayer.WHALE, WhaleModel::createBodyLayer);
    }
}
