package com.shadowdraco.tutorial.items.custom;

import com.shadowdraco.tutorial.lib.DoubleJumper;
import com.shadowdraco.tutorial.registry.ModStats;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;


public class RubyItem extends Item{

    public RubyItem() {

        super(new FabricItemSettings().rarity(Rarity.RARE).maxCount(32));
    }

    public static void useRuby(World world, PlayerEntity player, Hand hand, DoubleJumper doubleJumper, Boolean charged) {
        checkDoubleJumper(player, hand, charged);
        // toggle the double jumper thread
        toggleDoubleJumper(world, player, doubleJumper, charged);

    }

    // see if a player has used a ruby and toggle the double jumper
    static void checkDoubleJumper( PlayerEntity player, Hand hand, Boolean charged) {
        // change the charge
        charged = !charged;
        // alert the user
        if (charged) {
            player.sendMessage(Text.literal("Charged!"));
            player.setGlowing(true);
        } else {
            player.sendMessage(Text.literal("UnCharged!"));
            player.setGlowing(false);

            // if user is in survival decrement the stack on UNCharge
            if (!player.isCreative()) {
                player.getStackInHand(hand).decrement(1);
                // increment the sapphire stat when used
                player.incrementStat(ModStats.CONSUME_SAPPHIRE);
            }

        }

    }

    static void toggleDoubleJumper(World world, PlayerEntity player, DoubleJumper doubleJumper, Boolean charged) {
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
