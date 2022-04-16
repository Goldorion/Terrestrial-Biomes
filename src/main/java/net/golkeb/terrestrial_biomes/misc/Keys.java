package net.golkeb.terrestrial_biomes.misc;

import net.golkeb.terrestrial_biomes.TerrestrialBiomes;
import net.minecraft.resources.ResourceLocation;

public class Keys {

    public static final ResourceLocation DEFAULT_NULL = new ResourceLocation("");

    // Biomes
    public static final ResourceLocation DEEP_LUKEWARM_OCEAN = new ResourceLocation("deep_lukewarm_ocean");
    public static final ResourceLocation DEEP_WARM_OCEAN = new ResourceLocation("deep_warm_ocean");
    public static final ResourceLocation GREAT_LAKES = TerrestrialBiomes.RL("great_lakes");
    public static final ResourceLocation LUKEWARM_OCEAN = new ResourceLocation("lukewarm_ocean");
    public static final ResourceLocation WARM_OCEAN = new ResourceLocation("warm_ocean");

    // Entities
    public static final ResourceLocation BROWN_CRAB = new ResourceLocation("textures/entities/crab/brown_crab.png");
    public static final ResourceLocation EXPLORER_DWARF = new ResourceLocation("textures/entities/dwarf/explorer_dwarf.png");
    public static final ResourceLocation EXPLORER_DWARF_BLONDE = new ResourceLocation("textures/entities/dwarf/explorer_dwarf_blonde.png");
    public static final ResourceLocation FARMER_DWARF = new ResourceLocation("textures/entities/dwarf/farmer_dwarf.png");
    public static final ResourceLocation RED_CRAB = new ResourceLocation("textures/entities/crab/red_crab.png");
    public static final ResourceLocation WARRIOR_DWARF = new ResourceLocation("textures/entities/dwarf/warrior_dwarf.png");

    // GUIs
    public static final ResourceLocation BACKPACK_GUI = TerrestrialBiomes.RL("textures/guis/backpack_gui.png");
}
