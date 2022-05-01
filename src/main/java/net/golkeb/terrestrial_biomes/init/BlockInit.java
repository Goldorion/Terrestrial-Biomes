package net.golkeb.terrestrial_biomes.init;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.golkeb.terrestrial_biomes.world.level.blocks.BeanBlock;
import net.golkeb.terrestrial_biomes.world.level.blocks.BlueberriesBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            TerrestrialBiomes.MODID);

    public static final RegistryObject<Block> BLUEBERRIES = BLOCKS.register("blueberries", () ->
            new BlueberriesBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.CROP)));

    public static final RegistryObject<Block> BEANS = BLOCKS.register("beans", () ->
            new BeanBlock(ItemInit.BEAN::get, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP)));

    public static final RegistryObject<Block> BLACK_BEANS = BLOCKS.register("black_beans", () ->
            new BeanBlock(ItemInit.BLACK_BEAN::get, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP)));

    public static final RegistryObject<Block> RED_BEANS = BLOCKS.register("red_beans", () ->
            new BeanBlock(ItemInit.RED_BEAN::get, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP)));
}
