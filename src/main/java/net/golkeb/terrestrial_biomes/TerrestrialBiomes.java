package net.golkeb.terrestrial_biomes;

import net.golkeb.terrestrial_biomes.init.ContainerInit;
import net.golkeb.terrestrial_biomes.sounds.Sounds;
import net.golkeb.terrestrial_biomes.world.entity.Entity;
import net.golkeb.terrestrial_biomes.world.entity.animal.Whale;
import net.golkeb.terrestrial_biomes.world.item.Items;
import net.golkeb.terrestrial_biomes.world.level.block.Blocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TerrestrialBiomes.MODID)
public class TerrestrialBiomes {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    // Register the modid
    public static final String MODID = "terrestrial_biomes";

    public TerrestrialBiomes() {

        // Init Registries
        Blocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ContainerInit.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Entity.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        Items.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Sounds.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Registers an event with the mod specific event bus. This is needed to register new stuff.
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation RL(String path) {
        return new ResourceLocation(MODID, path);
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(Entity.CRAB.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Squid::checkMobSpawnRules);
            SpawnPlacements.register(Entity.EXPLORER_DWARF.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
            SpawnPlacements.register(Entity.FARMER_DWARF.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
            SpawnPlacements.register(Entity.STARFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Squid::checkMobSpawnRules);
            SpawnPlacements.register(Entity.WARRIOR_DWARF.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
            SpawnPlacements.register(Entity.WHALE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Whale::checkMobSpawn);
        });
    }
}