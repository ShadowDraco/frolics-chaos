package com.shadowdraco.tutorial.blocks.custom;

// Everything the mod needs to create a new block
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

import net.minecraft.sound.BlockSoundGroup;

// get the block's position
import net.minecraft.state.StateManager;
import net.minecraft.text.Text;
import net.minecraft.util.Arm;
import net.minecraft.util.math.BlockPos;
// do things in the world with actions
import net.minecraft.world.World;
// use or change the player for things
import net.minecraft.entity.player.PlayerEntity;

public class RubyBlock extends Block {

    // constructor
    public RubyBlock() {

        // initialize a Block with new settings
        super(FabricBlockSettings
                .of(Material.METAL, MapColor.RED)
                .requiresTool()
                .strength(6.0F, 6.0F)
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
            player.sendMessage(Text.literal("You'll unleash chaos doing that..."));
            player.setHealth(2);
            player.setMainArm(Arm.LEFT);
            player.setGlowing(true);
            player.setFireTicks(20);
            player.setAbsorptionAmount(2);
            player.setStuckArrowCount(100);

            player.setNoGravity(!player.hasNoGravity());
        }
        super.onBreak(world, pos, state, player);
    }
}
