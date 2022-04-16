package net.golkeb.terrestrial_biomes.client.renderers;

import net.golkeb.terrestrial_biomes.client.models.CrabModel;
import net.golkeb.terrestrial_biomes.entities.Crab;
import net.golkeb.terrestrial_biomes.misc.ModelLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrabRenderer extends MobRenderer<Crab, CrabModel<Crab>> {

    public CrabRenderer(EntityRendererProvider.Context context) {
        super(context, new CrabModel<>(context.bakeLayer(ModelLayer.CRAB)), 0.3F);
    }

    public ResourceLocation getTextureLocation(Crab crab) {
        return crab.getTexture();
    }
}
