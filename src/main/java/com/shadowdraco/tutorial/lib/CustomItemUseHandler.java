package com.shadowdraco.tutorial.lib;

import com.shadowdraco.tutorial.registry.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CustomItemUseHandler {

    public static Boolean AfkBlocking = false;
    AFKBlocker afkBlocker;
    public CustomItemUseHandler() {
        System.out.println("\n--DTM created custom item use handler !---");
    }

    public TypedActionResult<ItemStack> customUse(World world, PlayerEntity player, Hand ignoredHand) {
        // get the item that is equipped in the player's hand
        ItemStack usedStack = player.getEquippedStack(EquipmentSlot.MAINHAND);

        if (!world.isClient) {
            // if the item used has the afk mine enchant
            checkAfkBlocker(world, player, usedStack);


        }
        return TypedActionResult.success(usedStack);
    }

    public void checkAfkBlocker(World world, PlayerEntity player, ItemStack usedStack) {
        if (EnchantmentHelper.getLevel(ModEnchantments.AFK_MINE_ENCHANTMENT, usedStack) > 0) {

            if (AfkBlocking) {
                if (player.getY() < 30) {

                    System.out.println("AfkBlocking Started");
                    afkBlocker = new AFKBlocker(world, player);
                    afkBlocker.start();

                    player.sendMessage(Text.literal("Afk Mining"));
                    player.setInvisible(true);

                } else {
                    player.sendMessage(Text.literal("Head further into the caves first!"));
                }
            } else {

                System.out.println("Thread interrupted");
                afkBlocker.deleteBlocks();
                afkBlocker.interrupt();

                player.setInvisible(false);
                player.sendMessage(Text.literal("Welcome back!"));
            }
        }
    }

}
