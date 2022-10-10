package com.jocosero.odd_water_mobs.item;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.entity.ModEntityTypes;
import com.jocosero.odd_water_mobs.item.custom.OddBucketItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OddWaterMobs.MOD_ID);

    public static final RegistryObject<Item> RAW_ANGLERFISH = ITEMS.register("raw_anglerfish",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB).food(ModFoods.RAW_ANGLERFISH)));

    public static final RegistryObject<Item> RAW_ISOPOD = ITEMS.register("raw_isopod",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB)));

    public static final RegistryObject<Item> COOKED_ISOPOD = ITEMS.register("cooked_isopod",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB).food(ModFoods.COOKED_ISOPOD)));

    public static final RegistryObject<Item> HORSESHOE_CRAB_THORAX = ITEMS.register("horseshoe_crab_thorax",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB)));

    public static final RegistryObject<Item> COELACANTH = ITEMS.register("coelacanth",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB).food(ModFoods.COELACANTH)));

    public static final RegistryObject<Item> RAW_SPIDER_CRAB_LEG = ITEMS.register("raw_spider_crab_leg",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB).food(ModFoods.RAW_SPIDER_CRAB_LEG)));

    public static final RegistryObject<Item> COOKED_SPIDER_CRAB_LEG = ITEMS.register("cooked_spider_crab_leg",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB).food(ModFoods.COOKED_SPIDER_CRAB_LEG)));

    public static final RegistryObject<Item> RAW_GHOST_SHARK = ITEMS.register("raw_ghost_shark",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB).food(ModFoods.RAW_GHOST_SHARK)));

    public static final RegistryObject<Item> GHOST_SHARK_STING = ITEMS.register("ghost_shark_sting",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB)));

    public static final RegistryObject<Item> RAW_MUDSKIPPER = ITEMS.register("raw_mudskipper",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB).food(ModFoods.RAW_MUDSKIPPER)));

    public static final RegistryObject<Item> COOKED_MUDSKIPPER = ITEMS.register("cooked_mudskipper",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB).food(ModFoods.COOKED_MUDSKIPPER)));

    public static final RegistryObject<Item> MUDSKIPPER_FIN = ITEMS.register("mudskipper_fin",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB)));

    public static final RegistryObject<Item> DEEP_SEA_FISH = ITEMS.register("deep_sea_fish",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB).food(ModFoods.DEEP_SEA_FISH)));

    public static final RegistryObject<Item> RAW_SQUAT_LOBSTER_TAIL = ITEMS.register("raw_squat_lobster_tail",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB).food(ModFoods.RAW_SQUAT_LOBSTER_TAIL)));

    public static final RegistryObject<Item> COOKED_SQUAT_LOBSTER_TAIL = ITEMS.register("cooked_squat_lobster_tail",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB).food(ModFoods.COOKED_SQUAT_LOBSTER_TAIL)));

    public static final RegistryObject<Item> SEA_PIG = ITEMS.register("sea_pig",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB).food(ModFoods.SEA_PIG)));

    //ANGLERFISH//
    public static final RegistryObject<Item> ANGLERFISH_BUCKET = ITEMS.register("anglerfish_bucket",
            () -> new OddBucketItem(ModEntityTypes.ANGLERFISH, (new Item.Properties()
            .stacksTo(1)
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB))));

    public static final RegistryObject<Item> ANGLERFISH_SPAWN_EGG = ITEMS.register("anglerfish_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ANGLERFISH,-11781057, -14082015,
                    new Item.Properties().tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB)));

    //ISOPOD//
    public static final RegistryObject<Item> ISOPOD_BUCKET = ITEMS.register("isopod_bucket",
            () -> new OddBucketItem(ModEntityTypes.ISOPOD, (new Item.Properties()
                    .stacksTo(1)
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB))));

    public static final RegistryObject<Item> ISOPOD_SPAWN_EGG = ITEMS.register("isopod_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ISOPOD,-4813707, -1259349,
                    new Item.Properties().tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB)));

    //HORSESHOE CRAB//
    public static final RegistryObject<Item> HORSESHOE_CRAB_BUCKET = ITEMS.register("horseshoe_crab_bucket",
            () -> new OddBucketItem(ModEntityTypes.HORSESHOE_CRAB, (new Item.Properties()
                    .stacksTo(1)
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB))));

    public static final RegistryObject<Item> HORSESHOE_CRAB_SPAWN_EGG = ITEMS.register("horseshoe_crab_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.HORSESHOE_CRAB,-8359583, -12569299,
                    new Item.Properties().tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB)));

    //COELACANTH//

    public static final RegistryObject<Item> COELACANTH_BUCKET = ITEMS.register("coelacanth_bucket",
            () -> new OddBucketItem(ModEntityTypes.COELACANTH, (new Item.Properties()
                    .stacksTo(1)
                    .tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB))));

    public static final RegistryObject<Item> COELACANTH_SPAWN_EGG = ITEMS.register("coelacanth_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.COELACANTH,-15461851, -13618085,
                    new Item.Properties().tab(ModCreativeModeTab.ODD_WATER_MOBS_TAB)));
    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
