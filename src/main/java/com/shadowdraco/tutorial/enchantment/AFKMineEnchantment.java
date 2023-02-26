package com.shadowdraco.tutorial.enchantment;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

import net.minecraft.item.ItemStack;


public class AFKMineEnchantment extends Enchantment {
    public AFKMineEnchantment() {

        // very rare enchantment for main hand tools
        super(Rarity.VERY_RARE, EnchantmentTarget.DIGGER, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return super.isAcceptableItem(stack);
    }


}
