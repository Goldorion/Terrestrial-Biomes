package net.golkeb.terrestrial_biomes.client.renderers;

import net.golkeb.terrestrial_biomes.client.models.DwarfModel;
import net.golkeb.terrestrial_biomes.entities.WarriorDwarf;
import net.golkeb.terrestrial_biomes.misc.ModelLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WarriorDwarfRenderer extends MobRenderer<WarriorDwarf, DwarfModel<WarriorDwarf>> {

    public WarriorDwarfRenderer(EntityRendererProvider.Context context) {
        super(context, new DwarfModel<>(context.bakeLayer(ModelLayer.WARRIOR_DWARF)), 0.5F);
    }

    public ResourceLocation getTextureLocation(WarriorDwarf warriorDwarf) {
        return warriorDwarf.getTexture();
    }
}
