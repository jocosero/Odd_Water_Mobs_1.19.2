package com.jocosero.odd_water_mobs.event;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.entity.ModEntityTypes;
import com.jocosero.odd_water_mobs.entity.custom.AnglerfishEntity;
import com.jocosero.odd_water_mobs.entity.custom.CoelacanthEntity;
import com.jocosero.odd_water_mobs.entity.custom.HorseshoeCrabEntity;
import com.jocosero.odd_water_mobs.entity.custom.IsopodEntity;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = OddWaterMobs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll();
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.ANGLERFISH.get(), AnglerfishEntity.setAttributes());
        event.put(ModEntityTypes.ISOPOD.get(), IsopodEntity.setAttributes());
        event.put(ModEntityTypes.HORSESHOE_CRAB.get(), HorseshoeCrabEntity.setAttributes());
        event.put(ModEntityTypes.COELACANTH.get(), CoelacanthEntity.setAttributes());
    }
}
