package com.sweetrpg.ironhells.client.event;

import com.sweetrpg.ironhells.IronHells;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientEventHandler {

    public static void onKeyInput(final InputEvent.Key event) {
        IronHells.LOGGER.trace("#onKeyInput: {}", event);

    }

    @SubscribeEvent
    public void onInputEvent(final MovementInputUpdateEvent event) {
        IronHells.LOGGER.trace("#onInputEvent: {}", event);

    }

    @SubscribeEvent
    public static void onScreenInit(final ScreenEvent.Init.Post event) {
        IronHells.LOGGER.trace("#onScreenInit: {}", event);

    }

    @SubscribeEvent
    public void onScreenDrawForeground(final ScreenEvent.Render event) {
        IronHells.LOGGER.trace("#onScreenDrawForeground: {}", event);

        Screen screen = event.getScreen();
        if(screen instanceof InventoryScreen || screen instanceof CreativeModeInventoryScreen) {
//            boolean creative = screen instanceof CreativeModeInventoryScreen;

            // TODO
        }
    }

}
