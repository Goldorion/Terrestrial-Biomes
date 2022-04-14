package net.golkeb.terrestrial_biomes.events.entity;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.entities.BeetleEntity;
import net.golkeb.terrestrial_biomes.init.EntityInit;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TerrestrialBiomes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreateAttributesEvent {

    @SubscribeEvent
    public static void createAttributes(EntityAttributeCreationEvent event) {
        BeetleEntity.createAttributes();
        event.put(EntityInit.BEETLE.get(), BeetleEntity.createAttributes().build());
    }
}
