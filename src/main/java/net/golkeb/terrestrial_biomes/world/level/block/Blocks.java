package net.golkeb.terrestrial_biomes.world.level.block;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Blocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TerrestrialBiomes.MODID);

    public static final RegistryObject<Block> BEANS = register("beans", () -> new BeanBlock(Items.BEAN::get, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP)));
    public static final RegistryObject<Block> BLACK_BEANS = register("black_beans", () -> new BeanBlock(Items.BLACK_BEAN::get, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP)));
    public static final RegistryObject<Block> BLACKBERRIES = register("blackberries", () -> new BlackberriesBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> BLUEBERRIES = register("blueberries", () -> new BlueberriesBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> CORNS = register("corns", () -> new CornBlock(Items.CORN::get, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP)));
    public static final RegistryObject<Block> RED_BEANS = register("red_beans", () -> new BeanBlock(Items.RED_BEAN::get, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP)));
    public static final RegistryObject<Block> TOMATOES = register("tomatoes", () -> new TomatoBlock(Items.TOMATO::get, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP)));

    private static RegistryObject<Block> register(String name, Supplier<Block> block) {
        return BLOCKS.register(name, block);
    }
}
