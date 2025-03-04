package com.sweetrpg.ironhells.integration.jei;

import com.sweetrpg.ironhells.IronHells;
import com.sweetrpg.ironhells.common.Constants;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

@JeiPlugin
public class IHPlugin implements IModPlugin {

    public static IJeiRuntime jeiRuntime;

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Constants.MOD_ID, Constants.JEI_PLUGIN_ID);
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        IronHells.LOGGER.debug("CTPlugin#onRuntimeAvailable: {}", jeiRuntime);

        IHPlugin.jeiRuntime = jeiRuntime;

        // TODO: move this elsewhere to remove hard dependency on JEI
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            Player player = Minecraft.getInstance().player;
        });
    }
}
