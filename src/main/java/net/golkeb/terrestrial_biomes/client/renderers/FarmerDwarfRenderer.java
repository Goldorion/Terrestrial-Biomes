package net.golkeb.terrestrial_biomes.client.renderers;

import net.golkeb.terrestrial_biomes.client.models.DwarfModel;
import net.golkeb.terrestrial_biomes.entities.FarmerDwarf;
import net.golkeb.terrestrial_biomes.misc.ModelLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FarmerDwarfRenderer extends MobRenderer<FarmerDwarf, DwarfModel<FarmerDwarf>> {

    public FarmerDwarfRenderer(EntityRendererProvider.Context context) {
        super(context, new DwarfModel<>(context.bakeLayer(ModelLayer.FARMER_DWARF)), 0.5F);
    }

    public ResourceLocation getTextureLocation(FarmerDwarf farmerDwarf) {
        return farmerDwarf.getTexture();
    }
}
