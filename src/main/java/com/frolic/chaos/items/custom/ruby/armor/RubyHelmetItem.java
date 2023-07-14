package com.frolic.chaos.items.custom.ruby.armor;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;



public class RubyHelmetItem extends ArmorItem {

    public RubyHelmetItem(ArmorMaterial material) {
        super(material, EquipmentSlot.HEAD, new FabricItemSettings().fireproof());
    }


}
