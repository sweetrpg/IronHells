package com.sweetrpg.ironhells.common.config;

import com.sweetrpg.ironhells.IronHells;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

public class ConfigHandler {

    public static ClientConfig CLIENT;
    public static CommonConfig COMMON;
    public static ServerConfig SERVER;

    public static void init(IEventBus modEventBus) {
        Pair<ClientConfig, ForgeConfigSpec> clientPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        ForgeConfigSpec configClientSpec = clientPair.getRight();
        CLIENT = clientPair.getLeft();
        Pair<CommonConfig, ForgeConfigSpec> commonPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        ForgeConfigSpec configCommonSpec = commonPair.getRight();
        COMMON = commonPair.getLeft();
        Pair<ServerConfig, ForgeConfigSpec> serverPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        ForgeConfigSpec configServerSpec = serverPair.getRight();
        SERVER = serverPair.getLeft();

        IronHells.LOGGER.debug("register configs");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, configClientSpec);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, configCommonSpec);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, configServerSpec);

        modEventBus.addListener(ConfigHandler::configEventHandler);
    }

    public static void configEventHandler(ModConfigEvent event) {
        IronHells.LOGGER.debug("#configEventHandler: {}", event);

        if(event instanceof ModConfigEvent.Reloading &&
                ((event.getConfig().getType() == ModConfig.Type.CLIENT) ||
                        (event.getConfig().getType() == ModConfig.Type.COMMON)) &&
                Minecraft.getInstance().level != null) {
            IronHells.LOGGER.debug("config is reloading");

        }
    }

    public static class ClientConfig {

        // General
//        public ForgeConfigSpec.IntValue calculationDepth;


        public ClientConfig(ForgeConfigSpec.Builder builder) {
            {
                builder.push("General");

//                calculationDepth = builder.comment("Determines how far down the tree the queue calculation will go before it stops").translation(Constants.TRANSLATION_KEY_CONFIG_CLIENT_CALC_DEPTH).defineInRange("calculation_depth", 3, 1, 5);

                builder.pop();
            }

        }
    }

    public static class CommonConfig {

//        public Map<String, ForgeConfigSpec.IntValue> tagEntries = new HashMap<>();
//        public Map<String, ForgeConfigSpec.IntValue> overrideEntries = new HashMap<>();
//        public List<String> rawMaterials = new ArrayList<>();
//        public Map<String, ForgeConfigSpec.DoubleValue> namespaceEntries = new HashMap<>();
//        public Map<String, ForgeConfigSpec.DoubleValue> recipeTypeEntries = new HashMap<>();

        public CommonConfig(ForgeConfigSpec.Builder builder) {
            {
                builder.push("General");

                builder.pop();
            }
        }
    }

    public static class ServerConfig {

        public ServerConfig(ForgeConfigSpec.Builder builder) {
            {
                builder.push("General");

                builder.pop();
            }
        }
    }

}
