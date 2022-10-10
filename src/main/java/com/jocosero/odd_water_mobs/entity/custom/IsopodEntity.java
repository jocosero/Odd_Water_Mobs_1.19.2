package com.jocosero.odd_water_mobs.entity.custom;


import com.jocosero.odd_water_mobs.entity.SeafloorAnimal;
import com.jocosero.odd_water_mobs.entity.ai.FindWater;
import com.jocosero.odd_water_mobs.entity.ai.LeaveWater;
import com.jocosero.odd_water_mobs.entity.ai.SeafloorWander;
import com.jocosero.odd_water_mobs.entity.ai.SemiAquaticPathNavigator;
import com.jocosero.odd_water_mobs.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class IsopodEntity extends OddWaterMob implements SeafloorAnimal, IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    public static AttributeSupplier setAttributes() {return OddWaterMob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 6.0f)
            .add(Attributes.ARMOR, 2.2f)
            .add(Attributes.ATTACK_DAMAGE, 2.0f)
            .add(Attributes.ATTACK_SPEED, 2.0f)
            .add(Attributes.MOVEMENT_SPEED, 0.15f).build();
    }

    public IsopodEntity(EntityType type, Level level) {
        super(type, level);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 0.0F);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(0, new TemptGoal(this, 1.2f, Ingredient.of(Items.COD), false));
        this.goalSelector.addGoal(1, new FindWater(this));
        this.goalSelector.addGoal(1, new LeaveWater(this));
        this.goalSelector.addGoal(3, new SeafloorWander(this, 1.0D, 10, 50));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
    }

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }
    protected void handleAirSupply(int air) {
    }

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            if(this.jumping){
                this.setDeltaMovement(this.getDeltaMovement().scale(1.4D));
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.9D, 0.0D));
            }else{
                this.setDeltaMovement(this.getDeltaMovement().scale(0.4D));
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.01D, 0.0D));
            }

        } else {
            super.travel(travelVector);
        }
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader worldIn) {
        return worldIn.getFluidState(pos.below()).isEmpty() && worldIn.getFluidState(pos).is(FluidTags.WATER) ? 10.0F : super.getWalkTargetValue(pos, worldIn);
    }
    @Override
    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return pSize.height * 0.3F;
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
        return new ItemStack(ModItems.ISOPOD_BUCKET.get());
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if ((!this.isOnGround() && this.isUnderWater()) && event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.isopod.swim", true));
            return PlayState.CONTINUE;
        }
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.isopod.walk", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.isopod.idle", true));
        return PlayState.CONTINUE;
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


    protected PathNavigation createNavigation(Level worldIn) {
        SemiAquaticPathNavigator flyingpathnavigator = new SemiAquaticPathNavigator(this, worldIn) {
            public boolean isStableDestination(BlockPos pos) {
                return this.level.getBlockState(pos).getFluidState().isEmpty();
            }
        };
        return flyingpathnavigator;
    }

    @Override
    public boolean shouldEnterWater() {
        return true;
    }

    @Override
    public boolean shouldLeaveWater() {
        return false;
    }

    @Override
    public boolean shouldStopMoving() {
        return false;
    }

    @Override
    public int getWaterSearchRange() {
        return 5;
    }

}