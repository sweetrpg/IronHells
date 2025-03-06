package com.sweetrpg.ironhells.common.event;

import com.sweetrpg.ironhells.IronHells;
import com.sweetrpg.ironhells.common.Constants;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemSmeltedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class EventHandler {

    @SubscribeEvent
    public void onItemCrafted(final ItemCraftedEvent event) {
        IronHells.LOGGER.debug("EventHandler#onItemCrafted: {}", event);

    }

    @SubscribeEvent
    public void onItemSmelted(final ItemSmeltedEvent event) {
        IronHells.LOGGER.debug("EventHandler#onItemSmelted: {}", event);


    }

    @SubscribeEvent
    public void onItemPickedUp(final ItemPickupEvent event) {
        IronHells.LOGGER.debug("EventHandler#onItemPickedUp: {}", event);

    }

}
