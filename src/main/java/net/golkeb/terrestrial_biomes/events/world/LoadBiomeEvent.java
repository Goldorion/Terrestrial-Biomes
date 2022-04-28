package net.golkeb.terrestrial_biomes.events.world;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.init.EntityInit;
import net.golkeb.terrestrial_biomes.misc.Keys;
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
        if (event.getCategory() == Biome.BiomeCategory.UNDERGROUND) {
            event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings
                    .SpawnerData(EntityInit.EXPLORER_DWARF.get(), 20, 1, 1));
            event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings
                    .SpawnerData(EntityInit.FARMER_DWARF.get(), 15, 1, 3));
            event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings
                    .SpawnerData(EntityInit.WARRIOR_DWARF.get(), 15, 1, 5));
        }
        if (Keys.DEEP_LUKEWARM_OCEAN.equals(event.getName()) || Keys.DEEP_WARM_OCEAN.equals(event.getName())
                || Keys.GREAT_LAKES.equals(event.getName()) || Keys.LUKEWARM_OCEAN.equals(event.getName())
                || Keys.WARM_OCEAN.equals(event.getName())) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings
                    .SpawnerData(EntityInit.CRAB.get(), 14, 2, 4));
        }
    }
}
