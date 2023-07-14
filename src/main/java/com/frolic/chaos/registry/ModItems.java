package com.frolic.chaos.registry;

import com.frolic.chaos.FrolicsChaosMod; // import Main


import com.frolic.chaos.items.custom.SapphireItem;
import com.frolic.chaos.items.custom.ruby.armor.RubyArmorMaterial;
import com.frolic.chaos.items.custom.ruby.RubyItem;
import com.frolic.chaos.items.custom.ruby.armor.RubyBootsItem;
import com.frolic.chaos.items.custom.ruby.armor.RubyChestplateItem;
import com.frolic.chaos.items.custom.ruby.armor.RubyHelmetItem;
import com.frolic.chaos.items.custom.ruby.armor.RubyLeggingsItem;
import com.frolic.chaos.items.custom.ruby.tools.RubyPickaxeItem;
import net.minecraft.item.*;
// Import ItemGroupEvents to change item properties and instance a new item
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
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

    // create an armor material
    public static final RubyArmorMaterial RUBY_ARMOR_MATERIAL = new RubyArmorMaterial();
    // create armor from the material
    public static final RubyHelmetItem RUBY_HELMET = new RubyHelmetItem(RUBY_ARMOR_MATERIAL);
    public static final RubyChestplateItem RUBY_CHESTPLATE = new RubyChestplateItem(RUBY_ARMOR_MATERIAL);
    public static final RubyLeggingsItem RUBY_LEGGINGS = new RubyLeggingsItem(RUBY_ARMOR_MATERIAL);
    public static final RubyBootsItem RUBY_BOOTS = new RubyBootsItem(RUBY_ARMOR_MATERIAL);

    // the Tool Material is an instance in its own class, referenced in the pickaxe item's constructor
    public static final RubyPickaxeItem RUBY_PICKAXE_ITEM = new RubyPickaxeItem();

    // Register all items
    public static void registerItems() {
        System.out.println("\n--Frolic's Chaos Registering Items!---");

        registerItem("sapphire", SAPPHIRE, ItemGroups.INGREDIENTS);
        registerRubyItems();
    }

    // ---------- Item register functions

    // For all general item registry
    static void registerItem(String name, Item item, ItemGroup group) {
        // import Registry and call .register, passing the .ITEM registry, and a new identifier for the item
        // every item has a special             identifier ( modid:itemName )
        Registry.register(Registries.ITEM, new Identifier(FrolicsChaosMod.MOD_ID, name), item); // last parameter is the RUBY item.
        // then modify the item group entries to include this item in the Ingredients item group
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    static void registerRubyItems() {

        registerItem("ruby", RUBY, ItemGroups.INGREDIENTS);
        FuelRegistry.INSTANCE.add(RUBY, 5000); // add ruby as furnace fuel

        registerItem("ruby_block", RUBY_BLOCK_ITEM, ItemGroups.BUILDING_BLOCKS); // register with same name as associated block

        registerItem("ruby_helmet", RUBY_HELMET, ItemGroups.COMBAT);
        registerItem("ruby_chestplate", RUBY_CHESTPLATE, ItemGroups.COMBAT);
        registerItem("ruby_leggings", RUBY_LEGGINGS, ItemGroups.COMBAT);
        registerItem("ruby_boots", RUBY_BOOTS, ItemGroups.COMBAT);

        registerItem("ruby_pickaxe", RUBY_PICKAXE_ITEM, ItemGroups.TOOLS);

    }
}
