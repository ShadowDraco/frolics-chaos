package com.frolic.chaos.registry;


import com.frolic.chaos.FrolicsChaosMod;

// give the block a unique identifier
import com.frolic.chaos.blocks.custom.HollowRubyBlock;
import com.frolic.chaos.blocks.custom.RubyBlock;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
// allow the mod to register the new block
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;


public class ModBlocks {

    // create a ruby block that can be registered
    public static final RubyBlock RUBY_BLOCK = new RubyBlock();
    public static final HollowRubyBlock HOLLOW_RUBY_BLOCK = new HollowRubyBlock();
    // register the blocks
    public static void registerBlocks() {
        System.out.println("\n--Frolic's Chaos Registering blocks !---");
        registerBlock("ruby_block", RUBY_BLOCK);
        registerBlock("hollow_ruby_block", HOLLOW_RUBY_BLOCK);
    }

    // register the ruby block
    static void registerBlock(String name, Block block) {
        // Add block to the registry
        Registry.register(Registries.BLOCK, new Identifier(FrolicsChaosMod.MOD_ID, name), block);

    }
}
