package net.golkeb.terrestrial_biomes.init;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.entities.ExplorerDwarf;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            TerrestrialBiomes.MODID);

    public static final RegistryObject<EntityType<ExplorerDwarf>> EXPLORER_DWARF = ENTITIES.register("explorer_dwarf", () ->
            EntityType.Builder.of(ExplorerDwarf::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
                    .setUpdateInterval(3).sized(1f, 1.75f).build("explorer_dwarf"));
}
