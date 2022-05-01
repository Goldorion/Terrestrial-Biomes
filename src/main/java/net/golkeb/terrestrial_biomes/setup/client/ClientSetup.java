package net.golkeb.terrestrial_biomes.setup.client;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.client.guis.BackpackScreen;
import net.golkeb.terrestrial_biomes.client.model.CrabModel;
import net.golkeb.terrestrial_biomes.client.model.DwarfModel;
import net.golkeb.terrestrial_biomes.client.model.StarfishModel;
import net.golkeb.terrestrial_biomes.client.model.WhaleModel;
import net.golkeb.terrestrial_biomes.client.model.geom.ModelLayer;
import net.golkeb.terrestrial_biomes.client.renderer.entity.*;
import net.golkeb.terrestrial_biomes.misc.Keys;
import net.golkeb.terrestrial_biomes.world.entity.Entity;
import net.golkeb.terrestrial_biomes.world.entity.animal.Crab;
import net.golkeb.terrestrial_biomes.world.inventory.MenuType;
import net.golkeb.terrestrial_biomes.world.item.Items;
import net.golkeb.terrestrial_biomes.world.level.block.Blocks;
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
            MenuScreens.register(MenuType.BACKPACK.get(), BackpackScreen::new);

            // Cutout
            ItemBlockRenderTypes.setRenderLayer(Blocks.BLUEBERRIES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.BEANS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.BLACK_BEANS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.RED_BEANS.get(), RenderType.cutout());

            // Item Properties
            ItemProperties.register(Items.CRAB_BUCKET.get(), Keys.VARIANT_PROPERTY, (stack, level, entity, i) -> {
                if (entity == null) return 0.0F;
                if (stack.getTag() != null) return stack.getTag().getInt(Crab.BUCKET_VARIANT_TAG);
                return 0.0F;
            });
        });
    }

    @SubscribeEvent
    public static void registerModels(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Entity.CRAB.get(), CrabRenderer::new);
        event.registerEntityRenderer(Entity.EXPLORER_DWARF.get(), ExplorerDwarfRenderer::new);
        event.registerEntityRenderer(Entity.FARMER_DWARF.get(), FarmerDwarfRenderer::new);
        event.registerEntityRenderer(Entity.STARFISH.get(), StarfishRenderer::new);
        event.registerEntityRenderer(Entity.WARRIOR_DWARF.get(), WarriorDwarfRenderer::new);
        event.registerEntityRenderer(Entity.WHALE.get(), WhaleRenderer::new);
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
