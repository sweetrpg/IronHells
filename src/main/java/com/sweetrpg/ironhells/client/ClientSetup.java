package com.sweetrpg.ironhells.client;

import com.sweetrpg.ironhells.client.event.ClientEventHandler;
import com.sweetrpg.ironhells.common.registry.ModKeyBindings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


public class ClientSetup {

    public static void addKeyBindings(final FMLClientSetupEvent event) {

        MinecraftForge.EVENT_BUS.addListener(ClientEventHandler::onScreenInit);
        MinecraftForge.EVENT_BUS.addListener(ClientEventHandler::onKeyInput);

//        CraftQueueOverlay.init();
//        ShoppingListOverlay.init();

        MinecraftForge.EVENT_BUS.addListener(ModKeyBindings::registerKeyBindings);
    }
}
