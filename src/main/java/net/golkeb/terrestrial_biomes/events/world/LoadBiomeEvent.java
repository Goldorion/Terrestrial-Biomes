package net.golkeb.terrestrial_biomes.events.world;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.misc.Keys;
import net.golkeb.terrestrial_biomes.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TerrestrialBiomes.MODID)
public class LoadBiomeEvent {

    @SubscribeEvent
    public static void addFeatureToBiomes(BiomeLoadingEvent event) {
        event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings
                .SpawnerData(Entity.WHALE.get(), 5, 1, 2));
        if (event.getCategory() == Biome.BiomeCategory.UNDERGROUND) {
            event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings
                    .SpawnerData(Entity.EXPLORER_DWARF.get(), 20, 1, 1));
            event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings
                    .SpawnerData(Entity.FARMER_DWARF.get(), 15, 1, 3));
            event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings
                    .SpawnerData(Entity.WARRIOR_DWARF.get(), 15, 1, 5));
        }
        if (Keys.DEEP_LUKEWARM_OCEAN.equals(event.getName()) || Keys.DEEP_WARM_OCEAN.equals(event.getName())
                || Keys.GREAT_LAKES.equals(event.getName()) || Keys.LUKEWARM_OCEAN.equals(event.getName())
                || Keys.WARM_OCEAN.equals(event.getName())) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings
                    .SpawnerData(Entity.CRAB.get(), 14, 2, 4));
        }
        if (Keys.DEEP_LUKEWARM_OCEAN.equals(event.getName()) || Keys.DEEP_WARM_OCEAN.equals(event.getName())
                || Keys.LUKEWARM_OCEAN.equals(event.getName())
                || Keys.WARM_OCEAN.equals(event.getName())) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings
                    .SpawnerData(Entity.STARFISH.get(), 14, 2, 4));
        }
    }
}
