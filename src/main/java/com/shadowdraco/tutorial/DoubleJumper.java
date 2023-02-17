package com.shadowdraco.tutorial;

import net.minecraft.block.Blocks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayList;


public class DoubleJumper extends Thread {

    private final World world;
    private Boolean running = true;
    private final PlayerEntity player;

    private final ArrayList BlocksPlaced = new ArrayList<BlockPos>();

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

                        sleep(200);

                        if (Math.abs(player.getSteppingPos().getY() - yPos) > 1) {

                            BlockPos playerPos =  new BlockPos(player.getPos().getX(),player.getPos().getY() - 1, player.getPos().getZ());
                            BlockPos middlePos = playerPos.offset(player.getMovementDirection(), 1);
                            BlockPos frontPos = playerPos.offset(player.getMovementDirection(), 2);

                            world.setBlockState(playerPos, Blocks.RED_NETHER_BRICKS.getDefaultState());
                            world.setBlockState(middlePos, Blocks.RED_NETHER_BRICKS.getDefaultState());
                            world.setBlockState(frontPos, Blocks.RED_NETHER_BRICKS.getDefaultState());

                            BlocksPlaced.add(playerPos);
                            BlocksPlaced.add(middlePos);
                            BlocksPlaced.add(frontPos);

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
        for (Object block : BlocksPlaced) {
            world.removeBlock((BlockPos) block, false);
        }
        System.out.println("Blocks removed");
    }
}