package com.jocosero.odd_water_mobs.effect;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, OddWaterMobs.MOD_ID);

    public static final RegistryObject<MobEffect> SINKING = MOB_EFFECTS.register("sinking",
            () -> new SinkingEffect(MobEffectCategory.HARMFUL, -11713734));

    public static final RegistryObject<MobEffect> HEALING_VIGOR = MOB_EFFECTS.register("healing_vigor",
            () -> new HealingVigorEffect(MobEffectCategory.BENEFICIAL, -16750849));

    public static void  register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
