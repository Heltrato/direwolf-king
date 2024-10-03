package com.example.examplemod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class EventHandlers {

    @SubscribeEvent
    public static void onPlayerHoldTick(TickEvent.PlayerTickEvent playerTickEvent) {
        Player getPlayer = playerTickEvent.player;
        ItemStack stack = getPlayer.getMainHandItem();
        ItemStack marty = new ItemStack(ExampleMod.WOLF_AMULET_JOHNNY.get());
        if (stack != null) {
            if (stack == marty) {
                System.out.println("Test");
            }
        }
    }

}
