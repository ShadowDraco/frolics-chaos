package com.frolic.chaos.items.custom.ruby.armor;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
public class RubyChestplateItem extends ArmorItem {

    public RubyChestplateItem(ArmorMaterial material) {
        super(material, EquipmentSlot.CHEST, new FabricItemSettings().fireproof());
    }


}
