package net.golkeb.terrestrial_biomes.client.renderer.entity;

import net.golkeb.terrestrial_biomes.client.model.WhaleModel;
import net.golkeb.terrestrial_biomes.client.model.geom.ModelLayer;
import net.golkeb.terrestrial_biomes.world.entity.animal.Whale;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WhaleRenderer extends MobRenderer<Whale, WhaleModel<Whale>> {

    public WhaleRenderer(EntityRendererProvider.Context context) {
        super(context, new WhaleModel<>(context.bakeLayer(ModelLayer.WHALE)), 2F);
    }

    public ResourceLocation getTextureLocation(Whale whale) {
        return whale.getTexture();
    }
}
