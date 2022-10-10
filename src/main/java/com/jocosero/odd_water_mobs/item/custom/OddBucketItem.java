package com.jocosero.odd_water_mobs.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluids;
import java.util.function.Supplier;

public class OddBucketItem extends MobBucketItem {
    private final Supplier<? extends EntityType<?>> fishType;

    public OddBucketItem(Supplier<? extends EntityType<?>> entityType, Properties properties) {
        super(entityType, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, properties);
        this.fishType = entityType;
    }
}
