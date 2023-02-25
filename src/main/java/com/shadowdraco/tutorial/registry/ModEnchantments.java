package com.shadowdraco.tutorial.registry;

import com.shadowdraco.tutorial.TutorialMod;
import com.shadowdraco.tutorial.enchantment.LovelyEnchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static LovelyEnchantment LOVELY_ENCHANTMENT = new LovelyEnchantment();
    public static void registerEnchantments() {
        System.out.println("\n--DTM Registering enchantments !---");

        registerEnchantment("lovely");
    }

    public static void registerEnchantment(String name) {
        Registry.register(Registries.ENCHANTMENT, new Identifier(TutorialMod.MOD_ID, name), LOVELY_ENCHANTMENT);
    }
}
