package net.golkeb.terrestrial_biomes.events.world;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.init.EntityInit;
import net.golkeb.terrestrial_biomes.misc.Keys;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TerrestrialBiomes.MODID)
public class LoadBiomeEvent {

    @SubscribeEvent
    public static void addFeatureToBiomes(BiomeLoadingEvent event) {
        if (Keys.DACITE_MOUNTAINS.equals(event.getName()) || Keys.BASALT_MOUNTAINS.equals(event.getName())
                || Keys.LIMESTONE_COLLINS.equals(event.getName())) {
            event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings
                    .SpawnerData(EntityInit.BEETLE_ENTITY_TYPE, 20, 1, 1));
        }
    }
}
