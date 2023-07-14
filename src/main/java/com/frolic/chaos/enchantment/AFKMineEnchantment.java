package com.frolic.chaos.enchantment;


import com.frolic.chaos.lib.AFKBlocker;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;


public class AFKMineEnchantment extends Enchantment {

    private static Boolean AfkBlocking = false;
    private static AFKBlocker afkBlocker;
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

    // see if an item with this enchantment has enabled an afk blocker thread
    public static void checkAfkBlocker(World world, PlayerEntity player) {

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

    static void toggleAfkBlocking(World world, PlayerEntity player) {
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


}
