package com.jocosero.odd_water_mobs.entity.client;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.entity.custom.HorseshoeCrabEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HorseshoeCrabModel extends AnimatedGeoModel<HorseshoeCrabEntity> {
    @Override
    public ResourceLocation getModelLocation(HorseshoeCrabEntity object) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "geo/horseshoe_crab.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(HorseshoeCrabEntity object) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "textures/entity/horseshoe_crab.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(HorseshoeCrabEntity animatable) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "animations/horseshoe_crab.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(HorseshoeCrabEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
    }
}
