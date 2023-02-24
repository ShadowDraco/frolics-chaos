package com.shadowdraco.tutorial.items.custom;



import com.shadowdraco.tutorial.registry.ModStats; // import ModStats to use the custom statistic
import net.minecraft.entity.player.PlayerEntity; // to get the player using an item

// import new Fabric item things
import net.fabricmc.fabric.api.item.v1.FabricItemSettings; // to pass item settings to custom item
import net.minecraft.item.Item; // minecraft item class
import net.minecraft.item.ItemStack; // item stack in a players hand or inventory
import net.minecraft.sound.SoundEvents; // play sounds

import net.minecraft.text.Text; // Send messages to the user with text.literal
import net.minecraft.util.Hand; // the player's hand
import net.minecraft.util.TypedActionResult; // method to do actions in the game world
import net.minecraft.world.World; // the current world

// Custom extends Minecraft item
public class SapphireItem extends Item {

    // Constructor
    public SapphireItem() {
        // call super to init and include the new Item Settings here
        super(new FabricItemSettings().fireproof().maxCount(32));
    }

    // Override the Item method to give it MY custom function
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        // Volume is based on the amount of items held
        float volume = (user.getStackInHand(hand).getCount() / 5.0F) + 1.0F;
        float pitch =  (user.getStackInHand(hand).getCount()) + 1.0F;

        // If this is being called on server side
        if (!world.isClient) {

            //item is not in off-hand
            if (hand == Hand.MAIN_HAND) {
                // Send the user a message and increase their level
                user.sendMessage(Text.literal("The sapphire empowers you"));

                // if user is in survival decrement the stack
                if (!user.isCreative()) {
                    user.getStackInHand(hand).decrement(1);
                }
            }
        } else {
            // Play sound At the user of the item calling SoundEvents and giving volume
            user.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, volume, pitch);
            if (hand == Hand.MAIN_HAND) {
                // give the user one level
                user.experienceLevel++;
                // increment the sapphire stat when used
                user.incrementStat(ModStats.INTERACT_WITH_SAPPHIRE);
            }
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
