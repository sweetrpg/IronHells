package com.sweetrpg.ironhells.common.network;

import com.sweetrpg.ironhells.IronHells;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.PacketDistributor;

public final class PacketHandler {

    private static int disc = 0;

    public static void init() {
//        registerPacket(new QueueCommandPacket(), QueueCommandData.class);
//        registerPacket(new AdvancementPacket(), AdvancementData.class);
    }

    public static <MSG> void send(PacketDistributor.PacketTarget target, MSG message) {
        IronHells.HANDLER.send(target, message);
    }

//    public static <MSG> void sendToServer(MSG message) {
//        IronHells.HANDLER.send(PacketDistributor.PLAYER.noArg(), message);
//    }

    public static <MSG> void sendToPlayer(ServerPlayer player, MSG message) {
        IronHells.HANDLER.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    public static <D> void registerPacket(IPacket<D> packet, Class<D> dataClass) {
        IronHells.HANDLER.messageBuilder(dataClass, PacketHandler.disc++)
                .encoder(packet::encode)
                .decoder(packet::decode)
                .consumerNetworkThread(packet::handle)
                .add();
    }
}
