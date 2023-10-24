
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.drillcraft.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.drillcraft.client.gui.NozzleCrafterGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DrillCraftModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(DrillCraftModMenus.NOZZLE_CRAFTER_GUI.get(), NozzleCrafterGUIScreen::new);
		});
	}
}
