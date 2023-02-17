package com.shadowdraco.tutorial.registry;

import com.shadowdraco.tutorial.TutorialMod; // import Main


import com.shadowdraco.tutorial.items.RubyItem;
import com.shadowdraco.tutorial.items.SapphireItem; // import the custom sapphire item

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item; // the item class to create a new item
// Import ItemGroupEvents to change item properties and instance a new item
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups; // creative tabs
// create an identifier for a new item
import net.minecraft.util.Identifier;
// util to add rarity setting to an item
import net.minecraft.util.Rarity;
// registry allows you to register new items
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries; // registries stores the types of things to register
import net.fabricmc.fabric.api.registry.FuelRegistry; // add an item as furnace fuel


/*

  ********      Store custom items that will be added and registered to the game!

*/

public class ModItems {

    // Items

    // create a new public item named RUBY that is an instance of the minecraft.item
    // and pass in new Item Settings including what creative tab the item will appear in
    // as well as a rarity... you can continue to append more settings
    public static final RubyItem RUBY = new RubyItem(); // create item without its own class
    // create a BlockItem that is associated with the Ruby Block
    public static final BlockItem RUBY_BLOCK_ITEM = new BlockItem(ModBlocks.RUBY_BLOCK, new Item.Settings().maxCount(64).fireproof().rarity(Rarity.RARE));

    // create a custom item
    public static final SapphireItem SAPPHIRE = new SapphireItem();


    // Register all items
    public static void registerItems() {
        System.out.println("\n--DTM Registering Items!---");
        registerRubyItem();
        registerRubyBlockItem();
        registerSapphireItem();
    }

    // ---------- Item register functions

    // register ruby item
    static void registerRubyItem() {
        // import Registry and call .register, passing the .ITEM registry, and a new identifier for the item
        // every item has a special             identifier ( modid:itemName )
        Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, "ruby"), RUBY); // last parameter is the RUBY item.
        FuelRegistry.INSTANCE.add(RUBY, 300); // add ruby as furnace fuel
        // then modify the item group entries to include this item in the Ingredients item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(RUBY));
    }
    //register sapphire item
    static void registerSapphireItem() {
        // register the item and add it to an item group
        Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, "sapphire"), SAPPHIRE);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(SAPPHIRE));
    }

    // register ruby BlockItem and give it to a creative tab
    static void registerRubyBlockItem() {
        //                                                          the item path is same as it's associated block
        Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, "ruby_block"), RUBY_BLOCK_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(RUBY_BLOCK_ITEM));
    }
}
