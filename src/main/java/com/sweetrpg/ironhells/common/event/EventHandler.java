package com.sweetrpg.ironhells.common.event;

import com.sweetrpg.ironhells.IronHells;
import com.sweetrpg.ironhells.client.event.CraftingEvents;
import com.sweetrpg.ironhells.common.Constants;
import com.sweetrpg.ironhells.common.network.PacketHandler;
import com.sweetrpg.ironhells.common.network.packet.data.QueueCommandData;
import com.sweetrpg.ironhells.common.registry.ModAdvancements;
import com.sweetrpg.ironhells.common.util.AdvancementUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemSmeltedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sweetrpg.ironhells.common.network.packet.data.QueueCommandData.QueueCommand.RECALCULATE;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class EventHandler {

    @SubscribeEvent
    public void onItemCrafted(final ItemCraftedEvent event) {
        IronHells.LOGGER.debug("EventHandler#onItemCrafted: {}", event);

        if(event.getEntity().level().isClientSide) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                var itemId = ForgeRegistries.ITEMS.getKey(event.getCrafting().getItem());
                var quantity = event.getCrafting().getCount();
                CraftingEvents.removeProduct(itemId, quantity);
            });
        }
        else {
            // send packet
            PacketHandler.sendToPlayer((ServerPlayer) event.getEntity(), new QueueCommandData(RECALCULATE));
            AdvancementUtil.trigger(ModAdvancements.Key.CRAFT_ITEM, (ServerPlayer) event.getEntity());
        }
    }

    @SubscribeEvent
    public void onItemSmelted(final ItemSmeltedEvent event) {
        IronHells.LOGGER.debug("EventHandler#onItemSmelted: {}", event);

        if(event.getEntity().level().isClientSide) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                var itemId = ForgeRegistries.ITEMS.getKey(event.getSmelting().getItem());
                var quantity = event.getSmelting().getCount();
                CraftingEvents.removeProduct(itemId, quantity);
            });
        }
        else {
            // send packet
            PacketHandler.sendToPlayer((ServerPlayer) event.getEntity(), new QueueCommandData(RECALCULATE));
            AdvancementUtil.trigger(ModAdvancements.Key.CRAFT_ITEM, (ServerPlayer) event.getEntity());
        }
    }

    @SubscribeEvent
    public void onItemPickedUp(final ItemPickupEvent event) {
        IronHells.LOGGER.debug("EventHandler#onItemPickedUp: {}", event);

        if(event.getEntity().level().isClientSide) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                var itemId = ForgeRegistries.ITEMS.getKey(event.getStack().getItem());
                var quantity = event.getStack().getCount();
                CraftingEvents.pickupItem(itemId, quantity);
            });
        }
        else {
            // send packet
            PacketHandler.sendToPlayer((ServerPlayer) event.getEntity(), new QueueCommandData(RECALCULATE));
            AdvancementUtil.trigger(ModAdvancements.Key.ACQUIRE_ITEM, (ServerPlayer) event.getEntity());
        }
    }

}
