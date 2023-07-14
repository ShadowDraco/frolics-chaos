// Package naming convention com.<dev name>.<mod name>
package com.frolic.chaos;

// import custom registry classes for the mod
import com.frolic.chaos.registry.ModBlocks;
import com.frolic.chaos.registry.ModItems;
import com.frolic.chaos.registry.ModStats;
import com.frolic.chaos.lib.ModCustomHandlers;
import com.frolic.chaos.registry.ModEnchantments;

import com.frolic.chaos.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer; // imported as an implement


/*
    // The gradlew.properties maven_group mus match the project structure after ./java
	maven_group = com.shadowdraco.tutorial
	archives_base_name = technovision-tutorial-mod
 */

// Before continuing make sure to edit
// resources/fabric.mod.json id and name etc...
// here
    /*

      "schemaVersion": 1,
      "id": "draco-tutorial-mod",    // This modid (mod id) cannot have caps!!
      "version": "${version}",

      "name": "Techno Tutorial Mod",
      "description": "This is a tutorial by TechnoVision!",
      "authors": [
        "Ethan Storm"
      ],
      "contact": {
        "homepage": "",
        "sources": ""
      },

      "license": "CC0-1.0",
      "icon": "assets/dracoTutorialMod/icon.png",

      "environment": "*",
      "entrypoints": {
        "main": [
          "com.shadowdraco.tutorial.TutorialMod"
        ]
      },
      "mixins": [],

      ...
*/


// Then open terminal and run the command "./gradlew genSources"

// If build is successful run at top right minecraft client configuration run button
// look for
// [main/INFO] (FabricLoader) Loading 46 mods:
// and find your modid (mod/id) and version number in the list
//	- draco-tutorial-mod 1.0.0  <---- it will be at the top or bottom



/*

  ********      MAIN MOD CLASS

*/
public class FrolicsChaosMod implements ModInitializer{

    // Easily get the exact mod id in the future!
    public static final String MOD_ID = "frolics-chaos";

    @Override
    // imported from ModInitializer class
    //Runs when mod is initialized
    public void onInitialize() {
        System.out.println("--\n\nFrolic's Chaos is running!---\n\n");

        // On initialization register items
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModWorldGeneration.generateModWorldGen();

        ModEnchantments.registerEnchantments();

        ModCustomHandlers.startHandlers();

        ModStats.registerStats();
    }

}
