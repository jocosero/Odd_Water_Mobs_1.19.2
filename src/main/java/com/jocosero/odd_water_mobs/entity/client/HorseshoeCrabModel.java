package com.jocosero.odd_water_mobs.entity.client;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.entity.custom.HorseshoeCrabEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HorseshoeCrabModel extends AnimatedGeoModel<HorseshoeCrabEntity> {
    @Override
    public ResourceLocation getModelResource(HorseshoeCrabEntity object) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "geo/horseshoe_crab.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HorseshoeCrabEntity object) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "textures/entity/horseshoe_crab.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HorseshoeCrabEntity animatable) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "animations/horseshoe_crab.animation.json");
    }

    @Override
    public void setCustomAnimations(HorseshoeCrabEntity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
    }
}
