package net.golkeb.terrestrial_biomes.client.renderers;

import net.golkeb.terrestrial_biomes.client.models.DwarfModel;
import net.golkeb.terrestrial_biomes.entities.ExplorerDwarf;
import net.golkeb.terrestrial_biomes.misc.Keys;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Locale;

public class ExplorerDwarfRenderer extends MobRenderer<ExplorerDwarf, DwarfModel<ExplorerDwarf>> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Keys.DWARF_MODEL, "main");

    public ExplorerDwarfRenderer(EntityRendererProvider.Context context) {
        super(context, new DwarfModel<>(context.bakeLayer(LAYER_LOCATION)), 1.75F);
    }

    public ResourceLocation getTextureLocation(ExplorerDwarf explorerDwarf) {
        return new ResourceLocation(explorerDwarf.getEntityData().get(ExplorerDwarf.EXPLORER_DWARF).toLowerCase(Locale.ROOT));
    }
}
