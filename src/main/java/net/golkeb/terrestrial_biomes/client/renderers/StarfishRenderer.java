package net.golkeb.terrestrial_biomes.client.renderers;

import net.golkeb.terrestrial_biomes.client.models.StarfishModel;
import net.golkeb.terrestrial_biomes.entities.Starfish;
import net.golkeb.terrestrial_biomes.misc.ModelLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StarfishRenderer extends MobRenderer<Starfish, StarfishModel<Starfish>> {

    public StarfishRenderer(EntityRendererProvider.Context context) {
        super(context, new StarfishModel<>(context.bakeLayer(ModelLayer.STARFISH)), 0.3F);
    }

    public ResourceLocation getTextureLocation(Starfish starfish) {
        return starfish.getTexture();
    }
}
