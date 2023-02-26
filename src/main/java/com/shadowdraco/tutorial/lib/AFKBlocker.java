package com.shadowdraco.tutorial.lib;


import net.minecraft.block.Block;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class AFKBlocker extends Thread {

    private final World world;
    private final PlayerEntity player;

    // list of blocks to check for
    private final ArrayList<Block> BadBlocks = new ArrayList<>() {
        {
            add(Blocks.CAVE_AIR);
            add(Blocks.AIR);
            add(Blocks.VOID_AIR);
            add(Blocks.WATER);
            add(Blocks.LAVA);
        }
    };
    // blocks placed to save the player from falling
    private final ArrayList<BlockPos> BlocksPlaced = new ArrayList<>();

    public AFKBlocker(World world, PlayerEntity player) {
        this.world = world;
        this.player = player;

    }

    public void run() {

            while (player.getMovementSpeed() > 0) {
                try {

                    // get block below player
                    BlockPos playerPos = new BlockPos(player.getPos().getX(), player.getPos().getY() - 1, player.getPos().getZ());
                    // block in front of player and right below
                    BlockPos FrontAndBelow = playerPos.offset(player.getMovementDirection(), 1);


                    if (BadBlocks.contains(world.getBlockState(FrontAndBelow).getBlock())) {
                        world.setBlockState(FrontAndBelow, Blocks.COBBLESTONE.getDefaultState());
                        BlocksPlaced.add(FrontAndBelow);
                    }
                    //noinspection BusyWait
                    sleep(100);

                } catch (InterruptedException e) {
                    throw new RuntimeException("interruppted");
                }
            }

    }

    public void deleteBlocks() {
        System.out.println("\n\nDeleting blocks\n\n");
        for (BlockPos block : BlocksPlaced) {
            world.removeBlock(block, false);
        }
        System.out.println("Blocks removed");
    }
}
