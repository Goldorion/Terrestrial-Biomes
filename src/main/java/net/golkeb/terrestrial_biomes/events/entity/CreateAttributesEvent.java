package net.golkeb.terrestrial_biomes.events.entity;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.entities.Crab;
import net.golkeb.terrestrial_biomes.entities.ExplorerDwarf;
import net.golkeb.terrestrial_biomes.entities.FarmerDwarf;
import net.golkeb.terrestrial_biomes.entities.WarriorDwarf;
import net.golkeb.terrestrial_biomes.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TerrestrialBiomes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreateAttributesEvent {

    @SubscribeEvent
    public static void createAttributes(EntityAttributeCreationEvent event) {
        ExplorerDwarf.createAttributes();
        event.put(EntityInit.CRAB.get(), Crab.createAttributes().build());
        event.put(EntityInit.EXPLORER_DWARF.get(), ExplorerDwarf.createAttributes().build());
        event.put(EntityInit.FARMER_DWARF.get(), FarmerDwarf.createAttributes().build());
        event.put(EntityInit.WARRIOR_DWARF.get(), WarriorDwarf.createAttributes().build());
    }
}
