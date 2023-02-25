package com.shadowdraco.tutorial.enchantment;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.decoration.EndCrystalEntity;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.item.Items;


public class LovelyEnchantment extends Enchantment {

    public LovelyEnchantment() {
        // very rare enchantment for tools that dig and only usable with main hand tool
        super(Rarity.VERY_RARE, EnchantmentTarget.DIGGER, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {

        // if the user breaks an end crystal it will drop itself.
        if (target instanceof EndCrystalEntity) {
            target.dropItem(Items.END_CRYSTAL, 5);
        }
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        // add regeneration for (1 second of game ticks) * (2 seconds) * level of enchantment with (level) potency
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 2 * level, level));
        attacker.damage(DamageSource.player((PlayerEntity) user), level);
    }
}
