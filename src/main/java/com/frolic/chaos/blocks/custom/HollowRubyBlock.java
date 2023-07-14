package com.frolic.chaos.blocks.custom;

// Everything the mod needs to create a new block

import com.frolic.chaos.registry.ModEnchantments;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HollowRubyBlock extends Block {

    // constructor
    public HollowRubyBlock() {

        // initialize a Block with new settings
        super(FabricBlockSettings
                .of(Material.METAL, MapColor.RED)
                .requiresTool()
                .strength(3.0F, 10.0F)
                .sounds(BlockSoundGroup.METAL)
        );

        // set the default state of the block
        setDefaultState(getDefaultState());
    }

    // override block properties
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        // add custom property to the block
        // builder.add(property)
        super.appendProperties(builder);
    }



    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {


            if (!world.isClient) {
                if (!(EnchantmentHelper.getLevel(ModEnchantments.LOVELY_ENCHANTMENT, player.getMainHandStack()) > 0)) {
                    player.sendMessage(Text.literal("You cannot harness this power that deeply..."));
                    player.setHealth(2);
                    player.setFireTicks(20);
                    player.setAbsorptionAmount(2);
                    player.setStuckArrowCount(100);

                    player.setNoGravity(!player.hasNoGravity());
                } else {
                    player.sendMessage(Text.literal("I've spared you for your loveliness..."));
                }
        }
        super.onBreak(world, pos, state, player);
    }
}
