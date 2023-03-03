package com.shadowdraco.tutorial.items.custom.ruby.tools;

import com.shadowdraco.tutorial.registry.ModEnchantments;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.world.World;

public class RubyPickaxeItem extends PickaxeItem {
    public RubyPickaxeItem() {

        super(RubyToolMaterial.INSTANCE, 5, 1.7F, new FabricItemSettings().fireproof());
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {

        if(!world.isClient) {
            stack.addEnchantment(ModEnchantments.LOVELY_ENCHANTMENT, 2);
        }

        super.onCraft(stack, world, player);
    }
}
