package com.sweetrpg.ironhells.common.registry;

import com.sweetrpg.ironhells.common.advancement.CriterionTriggerBase;
import com.sweetrpg.ironhells.common.advancement.SimpleTrigger;
import net.minecraft.advancements.CriteriaTriggers;

import java.util.HashMap;
import java.util.Map;

public class ModTriggers {

    public static final Map<String, CriterionTriggerBase<?>> ENTRIES = new HashMap<>();

    public ModTriggers() {
    }

    public static SimpleTrigger addSimple(String id) {
        return (SimpleTrigger) add(id, new SimpleTrigger(id));
    }

    private static <T extends CriterionTriggerBase<?>> T add(String name, T instance) {
        ENTRIES.put(name, instance);
        return instance;
    }

    public static void register() {
//        ENTRIES.values().forEach(CriteriaTriggers::register);
    }
}
