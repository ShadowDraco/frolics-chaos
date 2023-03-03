package com.shadowdraco.tutorial.lib;

import com.shadowdraco.tutorial.enchantment.AFKMineEnchantment;
import com.shadowdraco.tutorial.items.custom.ruby.RubyItem;
import com.shadowdraco.tutorial.items.custom.SapphireItem;
import com.shadowdraco.tutorial.registry.ModEnchantments;
import com.shadowdraco.tutorial.registry.ModItems;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.ArrayList;

public class CustomItemUseHandler {

    public static ArrayList<ItemStack> ModdedItems = new ArrayList<>() {
        {
            add(ModItems.SAPPHIRE.getDefaultStack());
            add(ModItems.RUBY.getDefaultStack());
        }
    };

    public CustomItemUseHandler() {
        System.out.println("\n--DTM created custom item use handler !---");
    }

    public TypedActionResult<ItemStack> customUse(World world, PlayerEntity player, Hand hand) {
        // get the item that is equipped in the player's hand
        ItemStack usedStack = player.getEquippedStack(EquipmentSlot.MAINHAND);

        // if the item is not one that I WANT to use the custom item handler then pass to the normal minecraft handler
        if (ModdedItems.contains(usedStack) || EnchantmentHelper.getLevel(ModEnchantments.AFK_MINE_ENCHANTMENT, usedStack) > 0) {
            if (!world.isClient) {
                // check specific items and skip the rest then check variable items

                // check if a ruby is used
                if (usedStack.getItem() == ModItems.RUBY) {
                    // keep functions related to items and enchantments in their own places but handle USING items here
                    RubyItem.useRuby(world, player, hand);

                    return TypedActionResult.success(usedStack);
                }
                // check if a sapphire is used
                if (usedStack.getItem() == ModItems.SAPPHIRE) {
                    SapphireItem.useSapphire(world, player, hand);
                    return TypedActionResult.success(usedStack);
                }

                if (EnchantmentHelper.getLevel(ModEnchantments.AFK_MINE_ENCHANTMENT, usedStack) > 0) {
                    // check if an item with afk mine is used
                    AFKMineEnchantment.checkAfkBlocker(world, player);
                    return TypedActionResult.success(usedStack);
                }

            }
            return TypedActionResult.success(usedStack);
        }

        // if the item is not one that I WANT to use the custom item handler then pass to the normal minecraft handler
        return TypedActionResult.pass(usedStack);
    }

}
