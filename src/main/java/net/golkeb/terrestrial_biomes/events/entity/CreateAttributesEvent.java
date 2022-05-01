package net.golkeb.terrestrial_biomes.events.entity;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.world.entity.Entity;
import net.golkeb.terrestrial_biomes.world.entity.animal.*;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TerrestrialBiomes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreateAttributesEvent {

    @SubscribeEvent
    public static void createAttributes(EntityAttributeCreationEvent event) {
        ExplorerDwarf.createAttributes();
        event.put(Entity.CRAB.get(), Crab.createAttributes().build());
        event.put(Entity.EXPLORER_DWARF.get(), ExplorerDwarf.createAttributes().build());
        event.put(Entity.FARMER_DWARF.get(), FarmerDwarf.createAttributes().build());
        event.put(Entity.STARFISH.get(), Starfish.createAttributes().build());
        event.put(Entity.WARRIOR_DWARF.get(), WarriorDwarf.createAttributes().build());
        event.put(Entity.WHALE.get(), Whale.createAttributes().build());
    }
}
