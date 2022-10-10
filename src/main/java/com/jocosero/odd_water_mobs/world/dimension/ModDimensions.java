package com.jocosero.odd_water_mobs.world.dimension;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.registries.RegistryObject;

public class ModDimensions {
    public static final ResourceKey<Level> DEEP_OCEAN_DUNES_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(OddWaterMobs.MOD_ID, "deep_ocean_dunes"));
    public static final ResourceKey<DimensionType> DEEP_OCEAN_DUNES_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, DEEP_OCEAN_DUNES_KEY.getRegistryName());

    public static void register() {
        System.out.println("Registering ModDimensions for " + OddWaterMobs.MOD_ID);
    }
}
