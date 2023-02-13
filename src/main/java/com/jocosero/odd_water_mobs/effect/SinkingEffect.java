package com.jocosero.odd_water_mobs.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class SinkingEffect extends MobEffect {
    public SinkingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        Vec3 vec3 = pLivingEntity.getDeltaMovement();
        if (pLivingEntity.isInFluidType() && vec3.y < 0.0D) {
            pLivingEntity.setDeltaMovement(vec3.multiply(1.2D, 1.7D, 1.2D));
            pLivingEntity.maxUpStep = 1.0F;
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
