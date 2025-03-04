package com.sweetrpg.ironhells.common;

import com.sweetrpg.ironhells.common.util.Util;
import net.minecraft.resources.ResourceLocation;

public class Constants {

    public static final String MOD_ID = "ironhells";
    public static final String MOD_NAME = "The Iron Hells";

    public static final String VANILLA_ID = "minecraft";
    public static final String VANILLA_NAME = "Minecraft";

    public static final String JEI_PLUGIN_ID = "jei_plugin";

    // GUIs
    public static final int BACKGROUND_COLOR = 0x015f5f5f;
    public static final int BORDER_COLOR = 0x011f1f1f;

    // Network
    public static final ResourceLocation CHANNEL_NAME = Util.getResource("channel");
    public static final String PROTOCOL_VERSION = Integer.toString(1);

    // Language
    public static final String LOCALE_EN_US = "en_us";
    public static final String LOCALE_EN_GB = "en_gb";
    public static final String LOCALE_DE_DE = "de_de";

    // Translation keys

    // Key bindings
    public static final String KEY_BINDINGS_CATEGORY_TITLE = "key.categories.ironhells";
    public static final String TRANSLATION_KEY_BINDINGS_XXX_TITLE = "key.ironhells.xxx";

    // Config
    public static final String TRANSLATION_KEY_CONFIG_CLIENT_XXX = "ironhells.config.client.calculation_depth";

    // Advancements
    public static final String TRANSLATION_KEY_ADVANCEMENT_ROOT_TITLE = "advancements.ironhells.main.root.title";
    public static final String TRANSLATION_KEY_ADVANCEMENT_ROOT_DESCRIPTION = "advancements.ironhells.main.root.description";

}
