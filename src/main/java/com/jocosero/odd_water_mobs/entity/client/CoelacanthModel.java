package com.jocosero.odd_water_mobs.entity.client;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.entity.custom.CoelacanthEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.shadowed.eliotlash.mclib.utils.MathHelper;

public class CoelacanthModel extends AnimatedGeoModel<CoelacanthEntity> {
    @Override
    public ResourceLocation getModelResource(CoelacanthEntity object) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "geo/coelacanth.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CoelacanthEntity object) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "textures/entity/coelacanth.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CoelacanthEntity animatable) {
        return new ResourceLocation(OddWaterMobs.MOD_ID, "animations/coelacanth.animation.json");
    }

    @Override
    public void setCustomAnimations(CoelacanthEntity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);

        if (animationEvent != null) {
            IBone leftfin = getAnimationProcessor().getBone("leftfin");
            IBone rightfin = getAnimationProcessor().getBone("rightfin");
            IBone tailfin = getAnimationProcessor().getBone("rightfin");
            IBone coelacanth = getAnimationProcessor().getBone("coelacanth");
            IBone body = getAnimationProcessor().getBone("body");
            IBone bodysegment2 = getAnimationProcessor().getBone("bodysegment2");
            IBone uppermiddlefin = getAnimationProcessor().getBone("uppermiddlefin");
            IBone lowermiddlefin = getAnimationProcessor().getBone("lowermiddlefin");
            float limbSwingAmount = animationEvent.getLimbSwingAmount();
            float f2 = 0.6F * -limbSwingAmount;
            float f3 = 0.2F * limbSwingAmount;
            coelacanth.setRotationY(f3);
            leftfin.setRotationY(f2);
            rightfin.setRotationY(-f2);
            bodysegment2.setRotationY(-f2);
            tailfin.setRotationY(-f2);
        }
    }
}