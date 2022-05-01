package net.golkeb.terrestrial_biomes.init;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.world.entity.animal.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            TerrestrialBiomes.MODID);

    public static final RegistryObject<EntityType<Crab>> CRAB = ENTITIES.register("crab", () ->
            EntityType.Builder.of(Crab::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).sized(0.6875f, 0.1875f).build("crab"));

    public static final RegistryObject<EntityType<ExplorerDwarf>> EXPLORER_DWARF = ENTITIES.register("explorer_dwarf", () ->
            EntityType.Builder.of(ExplorerDwarf::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).sized(1f, 1.75f).build("explorer_dwarf"));

    public static final RegistryObject<EntityType<FarmerDwarf>> FARMER_DWARF = ENTITIES.register("farmer_dwarf", () ->
            EntityType.Builder.of(FarmerDwarf::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).sized(1f, 1.75f).build("farmer_dwarf"));

    public static final RegistryObject<EntityType<Starfish>> STARFISH = ENTITIES.register("starfish", () ->
            EntityType.Builder.of(Starfish::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).sized(0.5f, 0.094f).build("starfish"));

    public static final RegistryObject<EntityType<WarriorDwarf>> WARRIOR_DWARF = ENTITIES.register("warrior_dwarf", () ->
            EntityType.Builder.of(WarriorDwarf::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).sized(1f, 1.75f).build("warrior_dwarf"));

    public static final RegistryObject<EntityType<Whale>> WHALE = ENTITIES.register("whale", () ->
            EntityType.Builder.of(Whale::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).sized(10f, 3f).build("whale"));
}
