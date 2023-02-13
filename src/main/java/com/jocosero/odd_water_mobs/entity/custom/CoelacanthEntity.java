package com.jocosero.odd_water_mobs.entity.custom;

import com.jocosero.odd_water_mobs.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import static software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes.LOOP;


public class CoelacanthEntity extends OddWaterMob implements IAnimatable {

    private static final EntityDataAccessor<Boolean> STRANDED = SynchedEntityData.defineId(CoelacanthEntity.class, EntityDataSerializers.BOOLEAN);

    public AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public CoelacanthEntity(EntityType<? extends OddWaterMob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes() {
        return OddWaterMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0f)
                .add(Attributes.ARMOR, 1.5f)
                .add(Attributes.MOVEMENT_SPEED, 0.4f).build();
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setStranded(tag.getBoolean("isStranded"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("isStranded", this.isStranded());
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 10.0F, 1.8D, 1.6D, EntitySelector.NO_SPECTATORS::test));
        this.goalSelector.addGoal(4, new OddWaterMob.FishSwimGoal(this));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STRANDED, false);
    }

    public boolean isStranded() {
        return this.entityData.get(STRANDED);
    }

    public void setStranded(boolean stranded) {
        this.entityData.set(STRANDED, stranded);
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
            if (this.isStranded() && !this.isUnderWater()) {
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
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.COELACANTH_BUCKET.get());
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving() && !this.isStranded()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.coelacanth.swim", LOOP));
            return PlayState.CONTINUE;
        }
        if (this.isStranded()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.coelacanth.stranded", LOOP));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.coelacanth.idle", LOOP));
        return PlayState.CONTINUE;
    }

    public void tick() {
        super.tick();
        if (!isUnderWater()) {
            if (!isStranded()) {
                this.setStranded(true);
            }
        }
        if (isUnderWater()) {
            this.setStranded(false);
        }
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                1, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.SALMON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.SALMON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SALMON_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }
}