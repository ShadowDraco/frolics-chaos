package com.shadowdraco.tutorial.registry;


import com.shadowdraco.tutorial.TutorialMod;

// give the block a unique identifier
import com.shadowdraco.tutorial.blocks.custom.RubyBlock;
import net.minecraft.util.Identifier;
// allow the mod to register the new block
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {

    // register the blocks
    public static void registerBlocks() {
        System.out.println("\n--DTM Registering blocks !---");
        registerRubyBlock();
    }

    // create a ruby block that can be registered
    public static final RubyBlock RUBY_BLOCK = new RubyBlock();
    // register the ruby block
    static void registerRubyBlock() {
        // Add block to the registry
        Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, "ruby_block"), RUBY_BLOCK);
    }

    
}
