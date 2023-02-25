package com.shadowdraco.tutorial.registry;

import com.shadowdraco.tutorial.TutorialMod;
import com.shadowdraco.tutorial.enchantment.LovelyEnchantment;
import com.shadowdraco.tutorial.enchantment.LuckEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static LovelyEnchantment LOVELY_ENCHANTMENT = new LovelyEnchantment();
    public static LuckEnchantment LUCK_ENCHANTMENT = new LuckEnchantment();
    public static void registerEnchantments() {
        System.out.println("\n--DTM Registering enchantments !---");

        registerEnchantment("lovely", LOVELY_ENCHANTMENT);
        registerEnchantment("luck", LUCK_ENCHANTMENT);
    }

    public static void registerEnchantment(String name, Enchantment enchantment) {
        Registry.register(Registries.ENCHANTMENT, new Identifier(TutorialMod.MOD_ID, name), enchantment);
    }
}
