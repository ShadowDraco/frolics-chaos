package com.shadowdraco.tutorial.lib;


import com.shadowdraco.tutorial.registry.ModBlocks;


import com.shadowdraco.tutorial.registry.ModStats;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

import net.minecraft.world.World;

import java.util.ArrayList;


public class DoubleJumper extends Thread {

    private final World world;
    private Boolean running = true;
    private final PlayerEntity player;

    private final ArrayList<BlockPos> BlocksPlaced = new ArrayList<>();
    private final ArrayList<BlockState> BlocksReplaced = new ArrayList<>();

    public DoubleJumper(World world, PlayerEntity player) {
        this.world = world;
        this.player = player;

    }

    @Override
    public void run() {

            while (running) {
                try {
                    int yPos = player.getSteppingPos().getY();
                    // wait to see if the player is in the air
                    if (!player.isOnGround()) {

                        //noinspection BusyWait
                        sleep(200);

                        if (Math.abs(player.getSteppingPos().getY() - yPos) > 1) {

                            BlockPos playerPos =  new BlockPos(player.getPos().getX(),player.getPos().getY() - 1, player.getPos().getZ());
                            BlockPos middlePos = playerPos.offset(player.getMovementDirection(), 1);
                            BlockPos frontPos = playerPos.offset(player.getMovementDirection(), 2);

                            // get the block before replacing
                            BlocksReplaced.add(world.getBlockState(playerPos));
                            BlocksReplaced.add(world.getBlockState(middlePos));
                            BlocksReplaced.add(world.getBlockState(frontPos));

                            world.setBlockState(playerPos, ModBlocks.HOLLOW_RUBY_BLOCK.getDefaultState());
                            world.setBlockState(middlePos, ModBlocks.HOLLOW_RUBY_BLOCK.getDefaultState());
                            world.setBlockState(frontPos, ModBlocks.HOLLOW_RUBY_BLOCK.getDefaultState());

                            BlocksPlaced.add(playerPos);
                            BlocksPlaced.add(middlePos);
                            BlocksPlaced.add(frontPos);

                            player.incrementStat(ModStats.DOUBLE_JUMPS);

                        }
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException("interrupted");
                }
            }

    }


    public void deleteBlocks() {
        System.out.println("\n\nDeleting blocks\n\n");
        running = false;
        for (BlockPos block : BlocksPlaced) {
            world.removeBlock(block, false);
        }
        System.out.println("Blocks removed");

        this.restoreBlocks();
    }

    public void restoreBlocks() {
        System.out.println("Restoring blocks");

        try {
            int i = 0;
            for (BlockPos blockPos : BlocksPlaced) {
                world.setBlockState(blockPos, BlocksReplaced.get(i));
                i++;
            }
        } catch (Error error) {
            System.out.println("Could not finish restoring blocks");
        }
        System.out.println("Blocks restored");
    }
}