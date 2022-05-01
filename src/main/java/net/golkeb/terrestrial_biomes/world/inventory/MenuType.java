package net.golkeb.terrestrial_biomes.world.inventory;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuType {

    public static final DeferredRegister<net.minecraft.world.inventory.MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS, TerrestrialBiomes.MODID);

    public static final RegistryObject<net.minecraft.world.inventory.MenuType<BackpackMenu>> BACKPACK = register("backpack", (id, inv, data) -> new BackpackMenu(id, inv, data.readItem()));

    private static <T extends AbstractContainerMenu> RegistryObject<net.minecraft.world.inventory.MenuType<T>> register(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }
}
