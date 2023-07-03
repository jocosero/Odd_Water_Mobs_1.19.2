package com.jocosero.odd_water_mobs.entity.client;

import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.entity.custom.CoelacanthEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public class CoelacanthRenderer extends GeoEntityRenderer<CoelacanthEntity> {
        public CoelacanthRenderer(EntityRendererProvider.Context renderManager) {
            super(renderManager, new CoelacanthModel());
            this.shadowRadius = 0.5f;
        }

    @Override
    public ResourceLocation getTextureLocation(CoelacanthEntity instance) {
        return new ResourceLocation (OddWaterMobs.MOD_ID, "textures/entity/coelacanth.png");
    }

    @Override
    public RenderType getRenderType(CoelacanthEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1F, 1F, 1F);
        return RenderType.entityCutoutNoCull(getTextureLocation(animatable));
    }
}
