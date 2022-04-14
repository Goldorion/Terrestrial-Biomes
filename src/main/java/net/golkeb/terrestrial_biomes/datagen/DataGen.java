package net.golkeb.terrestrial_biomes.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;

import net.minecraft.data.DataGenerator;

import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = TerrestrialBiomes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @SubscribeEvent
    public static void onDataGen(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        generator.addProvider(new SoundFiles(generator));
    }
}
