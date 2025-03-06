package com.sweetrpg.ironhells.common.registry;

import com.mojang.blaze3d.platform.InputConstants;
import com.sweetrpg.ironhells.common.Constants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID,
        value = {Dist.CLIENT},
        bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModKeyBindings {

//    public static final KeyMapping ADD_TO_QUEUE_MAPPING = new KeyMapping(Constants.TRANSLATION_KEY_BINDINGS_ADDTOQUEUE_TITLE, KeyConflictContext.GUI, InputConstants.Type.KEYSYM, InputConstants.KEY_Q, Constants.KEY_BINDINGS_CATEGORY_TITLE);

    @SubscribeEvent
    public static void registerKeyBindings(RegisterKeyMappingsEvent event) {
//        event.register(ADD_TO_QUEUE_MAPPING);
    }

    public static void init() {}
}
