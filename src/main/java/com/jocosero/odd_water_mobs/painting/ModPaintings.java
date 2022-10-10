package com.jocosero.odd_water_mobs.painting;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<Motive> PAINTING_MOTIVES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, OddWaterMobs.MOD_ID);

    public static final RegistryObject<Motive> COLOSSAL =
            PAINTING_MOTIVES.register("colossal", () -> new Motive(64,32));

    public static void register(IEventBus eventBus) {
        PAINTING_MOTIVES.register(eventBus);
    }
}
