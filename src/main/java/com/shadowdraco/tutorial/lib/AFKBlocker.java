package com.shadowdraco.tutorial.lib;


import com.shadowdraco.tutorial.registry.ModStats;
import net.minecraft.block.Block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
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
    private final ArrayList<BlockState> BlocksReplaced = new ArrayList<>();

    public AFKBlocker(World world, PlayerEntity player) {
        this.world = world;
        this.player = player;
    }

    public void run() {

            while (player.getMovementSpeed() > 0) {
                try {

                    if (player.getPos().getY() > 30) {
                        // if the player goes above the height limit force cancel the thread
                        player.sendMessage(Text.literal("You're leaving the caves... "));
                        this.deleteBlocks();
                        this.restoreBlocks();
                        this.interrupt();
                    }

                    // get block below player
                    BlockPos playerPos = new BlockPos(player.getPos().getX(), player.getPos().getY() - 1, player.getPos().getZ());
                    // block in front of player and right below
                    BlockPos FrontAndBelow = playerPos.offset(player.getMovementDirection(), 1);


                    if (BadBlocks.contains(world.getBlockState(FrontAndBelow).getBlock())) {
                        // get the block before replacing
                        BlocksReplaced.add(world.getBlockState(FrontAndBelow));
                        // set the block to cobblestone
                        world.setBlockState(FrontAndBelow, Blocks.COBBLESTONE.getDefaultState());
                        // add tje block position to the list
                        BlocksPlaced.add(FrontAndBelow);
                    }
                    //noinspection BusyWait
                    sleep(100);

                } catch (InterruptedException e) {
                    throw new RuntimeException("Stopped Afk Mining");
                }
            }

    }

    public void deleteBlocks() {
        System.out.println("\nDeleting blocks");

        // increase the blocks placed stat before deleting all blocks
        player.increaseStat(ModStats.AFK_BLOCKS_PLACED, BlocksPlaced.size());
        try {
            for (BlockPos blockPos : BlocksPlaced) {
                world.removeBlock(blockPos, false);
                sleep(5);
            }
        } catch (InterruptedException exception) {
            System.out.println("Could not finish deleting blocks");
        }
        System.out.println("Blocks removed");
    }

     public void restoreBlocks() {
        System.out.println("\nRestoring blocks");

        try {
            int i = 0;
            for (BlockPos blockPos : BlocksPlaced) {
                world.setBlockState(blockPos, BlocksReplaced.get(i));
                i++;
                sleep(5);
            }
        } catch (InterruptedException exception) {
            System.out.println("Could not finish restoring blocks");
        }
        System.out.println("Blocks restored");
    }
}
