package com.jocosero.odd_water_mobs.effect;

import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;

public class HealingVigorEffect extends MobEffect {
    public HealingVigorEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.getCommandSenderWorld().isClientSide && entity instanceof Player player) {
            FoodData foodData = player.getFoodData();
                float food = foodData.getFoodLevel();
                float saturation = foodData.getSaturationLevel();
                int stop = player.getUseItemRemainingTicks();
                if (entity.getItemInHand(entity.getUsedItemHand()).isEdible() && (stop <= 0)){
                    player.getFoodData().setSaturation(
                            (float) (player.getFoodData().getSaturationLevel() + Math.ceil(saturation / 2)));
                    player.getFoodData().setFoodLevel(
                            (int) (player.getFoodData().getFoodLevel() + Math.ceil(food / 2)));
                }
            }
        }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
