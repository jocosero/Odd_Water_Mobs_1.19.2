package com.jocosero.odd_water_mobs.entity.client;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.entity.custom.IsopodEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IsopodModel extends AnimatedGeoModel<IsopodEntity> {
    @Override
    public ResourceLocation getModelLocation(IsopodEntity object) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "geo/isopod.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(IsopodEntity object) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "textures/entity/isopod.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(IsopodEntity animatable) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "animations/isopod.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(IsopodEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
    }
}
