package com.jocosero.odd_water_mobs.entity.custom;


import com.jocosero.odd_water_mobs.entity.variant.AnglerfishVariant;
import com.jocosero.odd_water_mobs.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;

public class AnglerfishEntity  extends OddWaterMob implements IAnimatable {

    private static final EntityDataAccessor<Boolean> PUFFED = SynchedEntityData.defineId(AnglerfishEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(AnglerfishEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public AnglerfishEntity(EntityType<? extends OddWaterMob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes() {return OddWaterMob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 4.0D)
            .add(Attributes.ATTACK_DAMAGE, 2.0f)
            .add(Attributes.ATTACK_SPEED, 2.0f)
            .add(Attributes.MOVEMENT_SPEED, 0.35f).build();
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setPuffed(tag.getBoolean("isPuffed"));
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("isPuffed", this.isPuffed());
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(PUFFED, false);
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    public boolean isPuffed() {
        return this.entityData.get(PUFFED);
    }

    public void setPuffed(boolean puffed) {
        this.entityData.set(PUFFED, puffed);
    }


    @Override
    protected void handleAirSupply(int p_209207_1_) {
        if (this.isAlive() && !this.isInWaterOrBubble()) {
            this.setAirSupply(p_209207_1_ - 1);
            if (this.getAirSupply() == -20) {
                this.setAirSupply(0);
                this.hurt(DamageSource.DROWN, random.nextInt(2) == 0 ? 1F : 0F);
            }
        } else {
            this.setAirSupply(100);
        }
    }

    public void travel(Vec3 pTravelVector) {
        if (this.isEffectiveAi() && this.isUnderWater()) {
            this.moveRelative(0.01F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0D, 0.0D));
            }
            if (this.isPuffed() && !this.isUnderWater()) {
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.5D, 1D, 0.5D));
            }
        } else {
            super.travel(pTravelVector);
        }

    }
    public void aiStep() {
        if (!this.isUnderWater()) {
            this.setDeltaMovement(this.getDeltaMovement());
        }

        super.aiStep();
    }
    @Override
    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return pSize.height * 0.45F;
    }
    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.FISH_SWIM;
    }
    @Override
    public ItemStack getBucketItemStack()  {
        return new ItemStack(ModItems.ANGLERFISH_BUCKET.get());
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving() && !this.isPuffed()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.anglerfish.swim", true));
            return PlayState.CONTINUE;
        }
        if (this.isPuffed()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.anglerfish.puffed", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.anglerfish.idle", true));
        return PlayState.CONTINUE;
    }
    public void tick() {
        super.tick();
        if (!isUnderWater()) {
            if (!isPuffed()) {
                this.setPuffed(true);
            }
        }
        if (isUnderWater()) {
            this.setPuffed(false);
        }
    }
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                2, this::predicate));
    }
    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.COD_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.COD_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }

    /* VARIANTS */
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty,
                                        MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData,
                                        @Nullable CompoundTag pDataTag) {
        if (pDifficulty.isHard()) {
            AnglerfishVariant variant = AnglerfishVariant.DEEP;
        } else {
            AnglerfishVariant variant = AnglerfishVariant.DEFAULT;
        }
        return super.finalizeSpawn(pLevel,pDifficulty,pReason,pSpawnData,pDataTag);
    }

    public AnglerfishVariant getVariant() {
        return AnglerfishVariant.byId(this.getTypeVariant() & 255);
    }

    private void setVariant(AnglerfishVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }
}
