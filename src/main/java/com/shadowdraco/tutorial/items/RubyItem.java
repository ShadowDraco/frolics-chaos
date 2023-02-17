package com.shadowdraco.tutorial.items;

import com.shadowdraco.tutorial.DoubleJumper; // import my custom thread

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RubyItem extends Item{

    public static Boolean charged = false;
    DoubleJumper t;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!world.isClient) {

            charged = !charged;
            if (charged) {
                user.sendMessage(Text.literal("Charged!"));
                user.setGlowing(true);
            } else {
                user.sendMessage(Text.literal("UnCharged!"));
                user.setGlowing(false);
            }

            toggleDoubleJump(world, user);

        }

        return super.use(world, user, hand);
    }

    public void toggleDoubleJump(World world, PlayerEntity user) {
        if (charged) {
            System.out.println("Thread started");
           t = new DoubleJumper(world, user);
           t.start();
        } else {
            System.out.println("Thread interrupted");
            t.deleteBlocks();
            t.interrupt();
        }
    }

    public RubyItem() {
        super(new FabricItemSettings().rarity(Rarity.RARE).maxCount(32));
    }
}
