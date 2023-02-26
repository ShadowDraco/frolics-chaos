package com.shadowdraco.tutorial.items.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.item.Item;

import net.minecraft.util.Rarity;


public class RubyItem extends Item{

    public RubyItem() {

        super(new FabricItemSettings().rarity(Rarity.RARE).maxCount(32));
    }

}
