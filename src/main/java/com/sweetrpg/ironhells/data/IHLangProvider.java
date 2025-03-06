package com.sweetrpg.ironhells.data;

import com.sweetrpg.ironhells.IronHells;
import com.sweetrpg.ironhells.common.Constants;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class IHLangProvider extends LanguageProvider {
    private final String locale;

    public IHLangProvider(PackOutput packOutput, String locale) {
        super(packOutput, Constants.MOD_ID, locale);
        this.locale = locale;
    }

    @Override
    public String getName() {
        return "Craft Tracker Language Provider: " + this.locale;
    }

    @Override
    protected void addTranslations() {
        switch(this.locale) {
            case Constants.LOCALE_EN_US -> processENUS();
            case Constants.LOCALE_EN_GB -> processENGB();
            case Constants.LOCALE_DE_DE -> processDEDE();
        }
    }

    private void processENUS() {
        IronHells.LOGGER.info("Adding translations for EN_US...");

        add(Constants.KEY_BINDINGS_CATEGORY_TITLE, "Iron Hells");

        add(Constants.TRANSLATION_KEY_ADVANCEMENT_ROOT_TITLE, "Spelunking");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_ROOT_DESCRIPTION, "Descend into the depths of the dungeon");
    }

    private void processENGB() {
        IronHells.LOGGER.info("Adding translations for EN_GB...");

        add(Constants.KEY_BINDINGS_CATEGORY_TITLE, "Iron Hells");

        add(Constants.TRANSLATION_KEY_ADVANCEMENT_ROOT_TITLE, "Spelunking");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_ROOT_DESCRIPTION, "Descend into the depths of the dungeon");
    }

    private void processDEDE() {
        IronHells.LOGGER.info("Adding translations for DE_DE...");

        add(Constants.KEY_BINDINGS_CATEGORY_TITLE, "Iron Hells");

        add(Constants.TRANSLATION_KEY_ADVANCEMENT_ROOT_TITLE, "Spelunking");
        add(Constants.TRANSLATION_KEY_ADVANCEMENT_ROOT_DESCRIPTION, "Descend into the depths of the dungeon");
    }
}
