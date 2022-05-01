package net.golkeb.terrestrial_biomes.world.entity;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.world.entity.animal.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Entity {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, TerrestrialBiomes.MODID);

    public static final RegistryObject<EntityType<Crab>> CRAB = register("crab", () -> EntityType.Builder.of(Crab::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).sized(0.6875f, 0.1875f));
    public static final RegistryObject<EntityType<ExplorerDwarf>> EXPLORER_DWARF = register("explorer_dwarf", () -> EntityType.Builder.of(ExplorerDwarf::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).sized(1f, 1.75f));
    public static final RegistryObject<EntityType<FarmerDwarf>> FARMER_DWARF = register("farmer_dwarf", () -> EntityType.Builder.of(FarmerDwarf::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).sized(1f, 1.75f));
    public static final RegistryObject<EntityType<Starfish>> STARFISH = register("starfish", () -> EntityType.Builder.of(Starfish::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).sized(0.5f, 0.094f));
    public static final RegistryObject<EntityType<WarriorDwarf>> WARRIOR_DWARF = register("warrior_dwarf", () -> EntityType.Builder.of(WarriorDwarf::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).sized(1f, 1.75f));
    public static final RegistryObject<EntityType<Whale>> WHALE = register("whale", () -> EntityType.Builder.of(Whale::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).sized(10f, 3f));

    private static <T extends net.minecraft.world.entity.Entity> RegistryObject<EntityType<T>> register(String name, Supplier<EntityType.Builder<T>> builder) {
        return ENTITIES.register(name, () -> builder.get().build(name));
    }
}
