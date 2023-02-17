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
    public static final Identifier INTERACT_WITH_SAPPHIRE = new Identifier(TutorialMod.MOD_ID, "interact_with_sapphire");

    // register all the stats
    public static void registerStats() {

        System.out.println("\n--DTM Registering Statistics!---");
        registerSapphireStat();
    }

    // register sapphire stat
    static void registerSapphireStat() {
        // register a new statistic for the sapphire
        Registry.register(Registries.CUSTOM_STAT, "interact_with_sapphire", INTERACT_WITH_SAPPHIRE);
        // Display the statistic with a default counter
        Stats.CUSTOM.getOrCreateStat(INTERACT_WITH_SAPPHIRE, StatFormatter.DEFAULT);
    }
}
