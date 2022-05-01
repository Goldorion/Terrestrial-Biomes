package net.golkeb.terrestrial_biomes.init;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.world.inventory.BackpackMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ContainerInit {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, TerrestrialBiomes.MODID);

    public static final RegistryObject<MenuType<BackpackMenu>> BACKPACK_CONTAINER = CONTAINERS.register("backpack",
            () -> IForgeMenuType.create((id, inv, data) -> new BackpackMenu(id, inv, data.readItem())));
}
