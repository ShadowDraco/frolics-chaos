package com.shadowdraco.tutorial.lib;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseItemCallback;

public class ModCustomHandlers {
    public static CustomBlockBreakHandler customBlockBreakHandler = new CustomBlockBreakHandler();
    public static CustomItemUseHandler customItemUseHandler = new CustomItemUseHandler();

    public static void startHandlers() {
        // PlayerBlockBreakEvents callback registers a function to do when a player breaks a block
        PlayerBlockBreakEvents.AFTER.register(((world, player, pos, state, blockEntity) -> customBlockBreakHandler.handleCustomBlockBreak(world, player, pos, state, blockEntity)));

        // UseItemCallback registers a function for when a player uses an Item
        UseItemCallback.EVENT.register((world, player, hand) -> customItemUseHandler.customUse(player, world, hand));

    }
}
