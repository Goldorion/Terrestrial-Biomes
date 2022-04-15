package net.golkeb.terrestrial_biomes.client.renderers;

import net.golkeb.terrestrial_biomes.client.models.DwarfModel;
import net.golkeb.terrestrial_biomes.entities.ExplorerDwarf;
import net.golkeb.terrestrial_biomes.misc.ModelLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExplorerDwarfRenderer extends MobRenderer<ExplorerDwarf, DwarfModel<ExplorerDwarf>> {

    public ExplorerDwarfRenderer(EntityRendererProvider.Context context) {
        super(context, new DwarfModel<>(context.bakeLayer(ModelLayer.EXPLORER_DWARF)), 1.75F);
    }

    public ResourceLocation getTextureLocation(ExplorerDwarf explorerDwarf) {
        return explorerDwarf.getTexture();
    }
}
