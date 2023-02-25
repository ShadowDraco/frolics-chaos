package com.shadowdraco.tutorial.items.custom;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class RubyBootsItem extends ArmorItem {

    public RubyBootsItem(ArmorMaterial material) {
        super(material, EquipmentSlot.FEET, new FabricItemSettings().fireproof());
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {

        if (!world.isClient) {
            stack.addEnchantment(Enchantments.FEATHER_FALLING, 2);
        }
    }
}
