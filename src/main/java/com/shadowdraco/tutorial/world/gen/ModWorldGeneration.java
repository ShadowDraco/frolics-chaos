package com.shadowdraco.tutorial.world.gen;

public class ModWorldGeneration {

    // call the modded world gen
    public static void generateModWorldGen() {
        System.out.println("--DTM Registering and creating ore generation!---");
        ModOreGeneration.generateOres();

        // ModTreeGeneration.generateTrees();
    }
}
