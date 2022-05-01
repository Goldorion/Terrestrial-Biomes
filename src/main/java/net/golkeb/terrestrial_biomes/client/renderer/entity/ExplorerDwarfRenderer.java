package net.golkeb.terrestrial_biomes.client.renderer.entity;

import net.golkeb.terrestrial_biomes.client.model.DwarfModel;
import net.golkeb.terrestrial_biomes.client.model.geom.ModelLayer;
import net.golkeb.terrestrial_biomes.world.entity.animal.ExplorerDwarf;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExplorerDwarfRenderer extends MobRenderer<ExplorerDwarf, DwarfModel<ExplorerDwarf>> {

    public ExplorerDwarfRenderer(EntityRendererProvider.Context context) {
        super(context, new DwarfModel<>(context.bakeLayer(ModelLayer.EXPLORER_DWARF)), 0.5F);
    }

    public ResourceLocation getTextureLocation(ExplorerDwarf explorerDwarf) {
        return explorerDwarf.getTexture();
    }
}
