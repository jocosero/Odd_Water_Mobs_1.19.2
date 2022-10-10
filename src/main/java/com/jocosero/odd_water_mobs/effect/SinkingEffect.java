package com.jocosero.odd_water_mobs.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class SinkingEffect extends MobEffect {
    public SinkingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level.isClientSide()) {
            Double x = pLivingEntity.getX();
            Double y = pLivingEntity.getY();
            Double z = pLivingEntity.getZ();
            if (!pLivingEntity.isInWater() && (!pLivingEntity.isInvulnerable())) {
                pLivingEntity.setSwimming(false);
                pLivingEntity.setDeltaMovement(pLivingEntity.getDeltaMovement().add(0D, -1.5D, 0D));;
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
