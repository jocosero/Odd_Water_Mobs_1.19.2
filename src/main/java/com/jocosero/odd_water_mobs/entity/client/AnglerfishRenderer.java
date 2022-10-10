package com.jocosero.odd_water_mobs.entity.client;

import com.google.common.collect.Maps;
import com.jocosero.odd_water_mobs.OddWaterMobs;
import com.jocosero.odd_water_mobs.entity.client.layer.AnglerfishLayer;
import com.jocosero.odd_water_mobs.entity.custom.AnglerfishEntity;
import com.jocosero.odd_water_mobs.entity.variant.AnglerfishVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class AnglerfishRenderer extends GeoEntityRenderer<AnglerfishEntity> {
    private static final ResourceLocation PUFFED = new ResourceLocation("odd_water_mobs:textures/entity/anglerfish/anglerfish_puffed.png");
        public static final Map<AnglerfishVariant, ResourceLocation> LOCATION_BY_VARIANT =
                Util.make(Maps.newEnumMap(AnglerfishVariant.class), (anglerfishVariantResourceLocationEnumMap) -> {
                    anglerfishVariantResourceLocationEnumMap.put(AnglerfishVariant.DEFAULT,
                            new ResourceLocation(OddWaterMobs.MOD_ID, "textures/entity/anglerfish/anglerfish.png"));
                    anglerfishVariantResourceLocationEnumMap.put(AnglerfishVariant.DEEP,
                            new ResourceLocation(OddWaterMobs.MOD_ID, "textures/entity/anglerfish/anglerfish_deep.png"));
                });

        public AnglerfishRenderer(EntityRendererProvider.Context renderManager) {
            super(renderManager, new AnglerfishModel());
            this.addLayer(new AnglerfishLayer(this));
            this.shadowRadius = 0.3f;
        }

    @Override
    public ResourceLocation getTextureLocation(AnglerfishEntity instance) {
        return instance.isPuffed() ? PUFFED : LOCATION_BY_VARIANT.get(instance.getVariant());
    }
    @Override
    public RenderType getRenderType(AnglerfishEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1F, 1F, 1F);
        return RenderType.entityCutoutNoCull(getTextureLocation(animatable));
    }
}
