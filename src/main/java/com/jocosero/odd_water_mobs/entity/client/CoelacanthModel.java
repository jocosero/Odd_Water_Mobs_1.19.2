package com.jocosero.odd_water_mobs.entity.client;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.entity.custom.CoelacanthEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CoelacanthModel extends AnimatedGeoModel<CoelacanthEntity> {
    @Override
    public ResourceLocation getModelResource(CoelacanthEntity object) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "geo/coelacanth.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CoelacanthEntity object) {
        return new ResourceLocation (OddWaterMobs.MOD_ID, "textures/entity/coelacanth.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CoelacanthEntity animatable) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "animations/coelacanth.animation.json");
    }

    @Override
    public void setCustomAnimations(CoelacanthEntity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
    }
}
