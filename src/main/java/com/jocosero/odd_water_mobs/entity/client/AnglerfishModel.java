package com.jocosero.odd_water_mobs.entity.client;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.entity.custom.AnglerfishEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class AnglerfishModel extends AnimatedGeoModel<AnglerfishEntity> {
    @Override
    public ResourceLocation getModelLocation(AnglerfishEntity object) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "geo/anglerfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AnglerfishEntity object) {
        return AnglerfishRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
    }
    @Override
    public ResourceLocation getAnimationFileLocation(AnglerfishEntity animatable) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "animations/anglerfish.animation.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(AnglerfishEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone body = this.getAnimationProcessor().getBone("body");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (body != null) {
            body.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
        if (body != null) {
            body.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
