package com.jocosero.odd_water_mobs.entity.client;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.entity.custom.IsopodEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IsopodModel extends AnimatedGeoModel<IsopodEntity> {
    @Override
    public ResourceLocation getModelResource(IsopodEntity object) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "geo/isopod.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IsopodEntity object) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "textures/entity/isopod.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IsopodEntity animatable) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "animations/isopod.animation.json");
    }

    @Override
    public void setCustomAnimations(IsopodEntity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
    }
}
