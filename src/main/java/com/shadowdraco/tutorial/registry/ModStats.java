package com.shadowdraco.tutorial.registry;

import com.shadowdraco.tutorial.TutorialMod;
// registry allows you to register new items
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries; // registries stores the types of things to register
// Stat formatter allows you to create and change stats
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
// create an identifier for a new item
import net.minecraft.util.Identifier;

public class ModStats {


    // a custom statistic for the sapphire item - etc
    public static final Identifier CONSUME_SAPPHIRE = new Identifier(TutorialMod.MOD_ID, "consume_sapphire");
    public static final Identifier CONSUME_RUBY = new Identifier(TutorialMod.MOD_ID, "consume_ruby");
    public static final Identifier DOUBLE_JUMPS = new Identifier(TutorialMod.MOD_ID, "double_jumps");
    public static final Identifier AFK_BLOCKS_PLACED = new Identifier(TutorialMod.MOD_ID, "afk_blocks_placed");
    public static final Identifier SPAWNERS_SILK_TOUCHED = new Identifier(TutorialMod.MOD_ID, "spawners_silk_touched");
    public static final Identifier SCULK_SILK_TOUCHED = new Identifier(TutorialMod.MOD_ID, "sculk_silk_touched");

    // register all the stats
    public static void registerStats() {

        System.out.println("\n--DTM Registering Statistics!---");
        registerStat("consume_sapphire", CONSUME_SAPPHIRE, StatFormatter.DEFAULT);
        registerStat("consume_ruby", CONSUME_RUBY, StatFormatter.DEFAULT);
        registerStat("double_jumps", DOUBLE_JUMPS, StatFormatter.DEFAULT);
        registerStat("afk_blocks_placed", AFK_BLOCKS_PLACED, StatFormatter.DEFAULT);
        registerStat("spawners_silk_touched", SPAWNERS_SILK_TOUCHED, StatFormatter.DEFAULT);
        registerStat("sculk_silk_touched", SCULK_SILK_TOUCHED, StatFormatter.DEFAULT);
    }

    public static void registerStat(String name, Identifier ID, StatFormatter type) {
        // register a new statistic for the sapphire
        Registry.register(Registries.CUSTOM_STAT, name, ID);
        // Display the statistic with a default counter
        Stats.CUSTOM.getOrCreateStat(ID, type);
    }


}
