package net.golkeb.terrestrial_biomes.init;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.entities.BeetleEntity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            TerrestrialBiomes.MODID);

    public static final EntityType<BeetleEntity> BEETLE_ENTITY_TYPE = EntityType.Builder
            .of(BeetleEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64).setUpdateInterval(3).sized(0.5f, 0.5f).build("beetle");

    public static final RegistryObject<EntityType<BeetleEntity>> BEETLE = ENTITIES.register("beetle", () -> BEETLE_ENTITY_TYPE);
}
