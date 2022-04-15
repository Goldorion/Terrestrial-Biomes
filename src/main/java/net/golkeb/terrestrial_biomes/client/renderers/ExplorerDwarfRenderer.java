package net.golkeb.terrestrial_biomes.client.renderers;

import net.golkeb.terrestrial_biomes.client.models.DwarfModel;
import net.golkeb.terrestrial_biomes.entities.ExplorerDwarf;
import net.golkeb.terrestrial_biomes.misc.Keys;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExplorerDwarfRenderer<T extends ExplorerDwarf> extends MobRenderer<T, DwarfModel<T>> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Keys.DWARF_MODEL, "main");

    public ExplorerDwarfRenderer(EntityRendererProvider.Context context, DwarfModel<T> model) {
        super(context, model, 1.75F);
    }

    public ResourceLocation getTextureLocation(T texture) {
        return (Math.random() < 0.5 ? Keys.EXPLORER_DWARF : Keys.EXPLORER_DWARF_BLONDE);
    }
}
