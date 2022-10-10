package com.jocosero.odd_water_mobs.entity;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.entity.custom.AnglerfishEntity;
import com.jocosero.odd_water_mobs.entity.custom.CoelacanthEntity;
import com.jocosero.odd_water_mobs.entity.custom.HorseshoeCrabEntity;
import com.jocosero.odd_water_mobs.entity.custom.IsopodEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, OddWaterMobs.MOD_ID);

    public static final RegistryObject<EntityType<AnglerfishEntity>> ANGLERFISH =
            ENTITY_TYPES.register("anglerfish",
                    () -> EntityType.Builder.of(AnglerfishEntity::new, MobCategory.WATER_CREATURE)
                            .sized(0.65f, 0.3f)
                            .build(new ResourceLocation(OddWaterMobs.MOD_ID, "anglerfish").toString()));

    public static final RegistryObject<EntityType<IsopodEntity>> ISOPOD =
            ENTITY_TYPES.register("isopod",
                    () -> EntityType.Builder.of(IsopodEntity::new, MobCategory.WATER_CREATURE)
                            .sized(0.4f, 0.3f)
                            .build(new ResourceLocation(OddWaterMobs.MOD_ID, "isopod").toString()));

    public static final RegistryObject<EntityType<HorseshoeCrabEntity>> HORSESHOE_CRAB =
            ENTITY_TYPES.register("horseshoe_crab",
                    () -> EntityType.Builder.of(HorseshoeCrabEntity::new, MobCategory.WATER_CREATURE)
                            .sized(0.6f, 0.25f)
                            .build(new ResourceLocation(OddWaterMobs.MOD_ID, "horseshoe_crab").toString()));

    public static final RegistryObject<EntityType<CoelacanthEntity>> COELACANTH =
            ENTITY_TYPES.register("coelacanth",
                    () -> EntityType.Builder.of(CoelacanthEntity::new, MobCategory.WATER_CREATURE)
                            .sized(1.0f, 0.6f)
                            .build(new ResourceLocation(OddWaterMobs.MOD_ID, "coelacanth").toString()));

    public static void register (IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
