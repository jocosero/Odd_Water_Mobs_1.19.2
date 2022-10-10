package com.jocosero.odd_water_mobs.entity.client;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.entity.custom.CoelacanthEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CoelacanthModel extends AnimatedGeoModel<CoelacanthEntity> {
    @Override
    public ResourceLocation getModelLocation(CoelacanthEntity object) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "geo/coelacanth.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CoelacanthEntity object) {
        return new ResourceLocation (OddWaterMobs.MOD_ID, "textures/entity/coelacanth.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CoelacanthEntity animatable) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "animations/coelacanth.animation.json");
    }

    @Override
    public void setLivingAnimations(CoelacanthEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
    }
}
