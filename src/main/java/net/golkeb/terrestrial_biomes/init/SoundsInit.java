package net.golkeb.terrestrial_biomes.init;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;

import net.minecraft.sounds.SoundEvent;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundsInit {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
            TerrestrialBiomes.MODID);

    public static final RegistryObject<SoundEvent> DEER_AMBIENT = SOUNDS
            .register("entity.deer.ambient", () -> setupSound("entity.deer.ambient"));

    public static final RegistryObject<SoundEvent> GRASS_DINOSAUR_AMBIENT = SOUNDS
            .register("entity.grass_dinosaur.ambient", () -> setupSound("entity.grass_dinosaur.ambient"));

    public static final RegistryObject<SoundEvent> WHALE_AMBIENT = SOUNDS
            .register("entity.whale.ambient", () -> setupSound("entity.whale.ambient"));

    public static final RegistryObject<SoundEvent> YETI_AMBIENT = SOUNDS
            .register("entity.yeti.ambient", () -> setupSound("entity.yeti.ambient"));

    private static SoundEvent setupSound(String soundName) {
        return new SoundEvent(TerrestrialBiomes.RL(soundName));
    }
}
