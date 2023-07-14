package com.frolic.chaos.registry;

import com.frolic.chaos.FrolicsChaosMod;
import com.frolic.chaos.enchantment.AFKMineEnchantment;
import com.frolic.chaos.enchantment.LovelyEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static LovelyEnchantment LOVELY_ENCHANTMENT = new LovelyEnchantment();
    public static AFKMineEnchantment AFK_MINE_ENCHANTMENT = new AFKMineEnchantment();
    public static void registerEnchantments() {
        System.out.println("\n--Frolic's Chaos Registering enchantments !---");

        registerEnchantment("lovely", LOVELY_ENCHANTMENT);
        registerEnchantment("afk_mine", AFK_MINE_ENCHANTMENT);
    }

    public static void registerEnchantment(String name, Enchantment enchantment) {
        Registry.register(Registries.ENCHANTMENT, new Identifier(FrolicsChaosMod.MOD_ID, name), enchantment);
    }
}
