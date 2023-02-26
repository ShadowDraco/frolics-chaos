package com.shadowdraco.tutorial.lib;

import com.shadowdraco.tutorial.items.custom.SapphireItem;
import com.shadowdraco.tutorial.registry.ModEnchantments;
import com.shadowdraco.tutorial.registry.ModItems;
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
    public static Boolean charged = false;
    AFKBlocker afkBlocker;
    DoubleJumper doubleJumper;
    public CustomItemUseHandler() {
        System.out.println("\n--DTM created custom item use handler !---");
    }

    public TypedActionResult<ItemStack> customUse(World world, PlayerEntity player, Hand hand) {
        // get the item that is equipped in the player's hand
        ItemStack usedStack = player.getEquippedStack(EquipmentSlot.MAINHAND);

        if (!world.isClient) {
            // check specific items and skip the rest then check variable items

            // check if a ruby is used
            if (usedStack.getItem() == ModItems.RUBY) {
                checkDoubleJumper(world, player, hand);
                return TypedActionResult.success(usedStack);
            }
            // check if a sapphire is used
            if (usedStack.getItem() == ModItems.SAPPHIRE) {
                SapphireItem.useSapphire(world, player, hand);
                return TypedActionResult.success(usedStack);
            }
            // check if an item with afk mine is used
            checkAfkBlocker(world, player, usedStack);

        }
        return TypedActionResult.success(usedStack);
    }

    public void checkAfkBlocker(World world, PlayerEntity player, ItemStack usedStack) {
        if (EnchantmentHelper.getLevel(ModEnchantments.AFK_MINE_ENCHANTMENT, usedStack) > 0) {

            AfkBlocking = ! AfkBlocking;

            if (player.getY() < 30) {

                if (AfkBlocking) {
                    player.sendMessage(Text.literal("Afk Mining"));
                    player.setInvisible(true);

                } else {
                    player.setInvisible(false);
                    player.sendMessage(Text.literal("Welcome back!"));

                }

                toggleAfkBlocking(world, player);

            } else {
                player.sendMessage(Text.literal("Head further into the caves first!"));
            }

        }
    }

    public void toggleAfkBlocking(World world, PlayerEntity player) {
        if (AfkBlocking) {
            System.out.println("AfkBlocking Started");
            afkBlocker = new AFKBlocker(world, player);
            afkBlocker.start();
        } else {
            System.out.println("Thread interrupted");
            afkBlocker.deleteBlocks();
            afkBlocker.interrupt();
        }
    }

    public void checkDoubleJumper(World world, PlayerEntity player, Hand hand) {
            // change the charge
            charged = !charged;
            // alert the user
            if (charged) {
                player.sendMessage(Text.literal("Charged!"));
                player.setGlowing(true);
            } else {
                player.sendMessage(Text.literal("UnCharged!"));
                player.setGlowing(false);

                // if user is in survival decrement the stack
                if (!player.isCreative()) {
                    player.getStackInHand(hand).decrement(1);
                }
            }
            // toggle the double jumper thread
            toggleDoubleJump(world, player);

    }

    public void toggleDoubleJump(World world, PlayerEntity player) {
        if (charged) {
            System.out.println("Thread started");
            doubleJumper = new DoubleJumper(world, player);
            doubleJumper.start();
        } else {
            System.out.println("Thread interrupted");
            doubleJumper.deleteBlocks();
            doubleJumper.interrupt();
        }
    }

}
