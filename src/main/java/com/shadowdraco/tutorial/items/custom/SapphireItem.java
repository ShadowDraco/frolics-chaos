package com.shadowdraco.tutorial.items.custom;



import com.shadowdraco.tutorial.registry.ModStats; // import ModStats to use the custom statistic
import net.minecraft.entity.player.PlayerEntity; // to get the player using an item

// import new Fabric item things
import net.fabricmc.fabric.api.item.v1.FabricItemSettings; // to pass item settings to custom item
import net.minecraft.item.Item; // minecraft item class
import net.minecraft.sound.SoundEvents; // play sounds

import net.minecraft.text.Text; // Send messages to the player with text.literal
import net.minecraft.util.Hand; // the player's hand

import net.minecraft.world.World; // the current world

// Custom extends Minecraft item
public class SapphireItem extends Item {

    // Constructor
    public SapphireItem() {
        // call super to init and include the new Item Settings here
        super(new FabricItemSettings().fireproof().maxCount(32));
    }

    // Override the Item method to give it MY custom function
    public static void useSapphire(World world, PlayerEntity player, Hand hand) {
        // Volume is based on the amount of items held
        float volume = (player.getStackInHand(hand).getCount() / 5.0F) + 1.0F;
        float pitch =  (player.getStackInHand(hand).getCount()) + 1.0F;

        // If this is being called on server side
        if (!world.isClient) {

            //item is not in off-hand
            if (hand == Hand.MAIN_HAND) {
                // Send the player a message and increase their level
                player.sendMessage(Text.literal("The sapphire empowers you"));

                // Play sound At the user of the item calling SoundEvents and giving volume
                player.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, volume, pitch);
                // give the player one level
                player.experienceLevel++;
                // increment the sapphire stat when used
                player.incrementStat(ModStats.CONSUME_SAPPHIRE);

                // if player is in survival decrement the stack
                if (!player.isCreative()) {
                    player.getStackInHand(hand).decrement(1);
                }
            }

        }
    }
}
