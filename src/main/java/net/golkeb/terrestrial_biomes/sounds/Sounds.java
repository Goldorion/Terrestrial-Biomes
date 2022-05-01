package net.golkeb.terrestrial_biomes.sounds;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Sounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TerrestrialBiomes.MODID);

    public static final RegistryObject<SoundEvent> DEER_AMBIENT = register("entity.deer.ambient");
    public static final RegistryObject<SoundEvent> GRASS_DINOSAUR_AMBIENT = register("entity.grass_dinosaur.ambient");
    public static final RegistryObject<SoundEvent> WHALE_AMBIENT = register("entity.whale.ambient");
    public static final RegistryObject<SoundEvent> YETI_AMBIENT = register("entity.yeti.ambient");

    private static RegistryObject<SoundEvent> register(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(TerrestrialBiomes.RL(name)));
    }
}
