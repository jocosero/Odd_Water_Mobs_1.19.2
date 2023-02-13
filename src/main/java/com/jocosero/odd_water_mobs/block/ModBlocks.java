package com.jocosero.odd_water_mobs.block;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.block.custom.DeepSand;
import com.jocosero.odd_water_mobs.block.custom.GiantTubeWorm;
import com.jocosero.odd_water_mobs.block.custom.GlowingAnemone;
import com.jocosero.odd_water_mobs.block.custom.HydrothermalVent;
import com.jocosero.odd_water_mobs.item.ModCreativeModeTab;
import com.jocosero.odd_water_mobs.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, OddWaterMobs.MOD_ID);

    public static final RegistryObject<Block> DEEP_SAND = registerBlock("deep_sand",
            () -> new DeepSand(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND)
                    .strength(0.5f)
                    .sound(SoundType.SAND)), ModCreativeModeTab.ODD_WATER_MOBS_TAB);

    public static final RegistryObject<Block> DEEP_SANDSTONE = registerBlock("deep_sandstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND)
                    .strength(0.8f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ODD_WATER_MOBS_TAB);
    public static final RegistryObject<Block> DEEP_SANDSTONE_STAIRS = registerBlock("deep_sandstone_stairs",
            () -> new StairBlock(() -> DEEP_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND)
                            .strength(0.8f)
                            .sound(SoundType.STONE)
                            .requiresCorrectToolForDrops()), ModCreativeModeTab.ODD_WATER_MOBS_TAB);
    public static final RegistryObject<Block> DEEP_SANDSTONE_SLAB = registerBlock("deep_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND)
                    .strength(0.8f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ODD_WATER_MOBS_TAB);
    public static final RegistryObject<Block> DEEP_SANDSTONE_WALL = registerBlock("deep_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND)
                    .strength(0.8f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ODD_WATER_MOBS_TAB);

    public static final RegistryObject<Block> CHISELED_DEEP_SANDSTONE = registerBlock("chiseled_deep_sandstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND)
                    .strength(0.8f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ODD_WATER_MOBS_TAB);

    public static final RegistryObject<Block> CUT_DEEP_SANDSTONE = registerBlock("cut_deep_sandstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND)
                    .strength(0.8f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ODD_WATER_MOBS_TAB);

    public static final RegistryObject<Block> CUT_DEEP_SANDSTONE_SLAB = registerBlock("cut_deep_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND)
                    .strength(0.8f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ODD_WATER_MOBS_TAB);

    public static final RegistryObject<Block> SMOOTH_DEEP_SANDSTONE = registerBlock("smooth_deep_sandstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND)
                    .strength(2f, 6f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ODD_WATER_MOBS_TAB);

    public static final RegistryObject<Block> SMOOTH_DEEP_SANDSTONE_STAIRS = registerBlock("smooth_deep_sandstone_stairs",
            () -> new StairBlock(() -> SMOOTH_DEEP_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND)
                            .strength(2f, 6f)
                            .sound(SoundType.STONE)
                            .requiresCorrectToolForDrops()), ModCreativeModeTab.ODD_WATER_MOBS_TAB);

    public static final RegistryObject<Block> SMOOTH_DEEP_SANDSTONE_SLAB = registerBlock("smooth_deep_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SAND)
                    .strength(2f, 6f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ODD_WATER_MOBS_TAB);

    public static final RegistryObject<Block> BIOLUMINESCENT_SCALES = registerBlock("bioluminescent_scales",
            () -> new GlowLichenBlock(BlockBehaviour.Properties.copy(Blocks.GLOW_LICHEN)
                    .lightLevel((state) -> {
                        return 6;
                    })
                    .sound(SoundType.NETHER_WART)
                    .noCollission()
                    .noOcclusion()
                    .hasPostProcess((bs, br, bp) -> true)
                    .emissiveRendering((bs, br, bp) -> true)
                    .instabreak()), ModCreativeModeTab.ODD_WATER_MOBS_TAB);

    public static final RegistryObject<Block> BIOLUMINESCENT_BLOCK = registerBlock("bioluminescent_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLAY, MaterialColor.SAND)
                    .lightLevel((state) -> {
                        return 6;
                    })
                    .strength(0.5f, 0.3f)
                    .sound(SoundType.NETHER_WART)
                    .hasPostProcess((bs, br, bp) -> true)
                    .emissiveRendering((bs, br, bp) -> true)), ModCreativeModeTab.ODD_WATER_MOBS_TAB);

    public static final RegistryObject<Block> GIANT_TUBE_WORM = registerBlock("giant_tube_worm",
            () -> new GiantTubeWorm(BlockBehaviour.Properties.of(Material.WATER_PLANT, MaterialColor.TERRACOTTA_LIGHT_GRAY)
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .instabreak()), ModCreativeModeTab.ODD_WATER_MOBS_TAB);

    public static final RegistryObject<Block> GLOWING_ANEMONE = registerBlock("glowing_anemone",
            () -> new GlowingAnemone(BlockBehaviour.Properties.of(Material.WATER_PLANT, MaterialColor.COLOR_CYAN)
                    .lightLevel((state) -> {
                        return 2;
                    })
                    .sound(SoundType.NETHER_WART)
                    .noOcclusion()
                    .hasPostProcess((bs, br, bp) -> true)
                    .emissiveRendering((bs, br, bp) -> true)), ModCreativeModeTab.ODD_WATER_MOBS_TAB);

    public static final RegistryObject<Block> HYDROTHERMAL_VENT = registerBlock("hydrothermal_vent",
            () -> new HydrothermalVent(true, 1, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GREEN)
                    .strength(1.3f)
                    .sound(SoundType.BASALT)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.ODD_WATER_MOBS_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
