package com.sweetrpg.ironhells.common;

import com.sweetrpg.ironhells.common.network.PacketHandler;
import com.sweetrpg.ironhells.common.registry.ModAdvancements;
import com.sweetrpg.ironhells.common.registry.ModTriggers;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PacketHandler.init();
            ModAdvancements.register();
            ModTriggers.register();
        });
    }

}
