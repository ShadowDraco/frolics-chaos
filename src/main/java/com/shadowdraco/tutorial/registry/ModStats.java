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


    // a custom statistic for the sapphire item
    public static final Identifier CONSUME_SAPPHIRE = new Identifier(TutorialMod.MOD_ID, "consume_sapphire");
    public static final Identifier CONSUME_RUBY = new Identifier(TutorialMod.MOD_ID, "consume_ruby");

    // register all the stats
    public static void registerStats() {

        System.out.println("\n--DTM Registering Statistics!---");
        registerStat("consume_sapphire", CONSUME_SAPPHIRE, StatFormatter.DEFAULT);
        registerStat("consume_sapphire", CONSUME_RUBY, StatFormatter.DEFAULT);
    }

    public static void registerStat(String name, Identifier ID, StatFormatter type) {
        // register a new statistic for the sapphire
        Registry.register(Registries.CUSTOM_STAT, name, ID);
        // Display the statistic with a default counter
        Stats.CUSTOM.getOrCreateStat(ID, type);
    }


}
