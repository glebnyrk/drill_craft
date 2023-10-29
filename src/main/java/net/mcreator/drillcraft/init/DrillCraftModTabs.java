
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.drillcraft.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.item.CreativeModeTabs;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DrillCraftModTabs {
	@SubscribeEvent
	public static void buildTabContentsVanilla(CreativeModeTabEvent.BuildContents tabData) {

		if (tabData.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(DrillCraftModBlocks.NOZZLE_CRAFTER.get().asItem());
			tabData.accept(DrillCraftModBlocks.RUBBER_BLOCK.get().asItem());
		}

		if (tabData.getTab() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(DrillCraftModItems.METAL_COIN.get());
		}

		if (tabData.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(DrillCraftModItems.DRILL.get());
			tabData.accept(DrillCraftModItems.PICK_DRILL.get());
			tabData.accept(DrillCraftModItems.COPPER_PICKAXE.get());
			tabData.accept(DrillCraftModItems.MINERS_HELMET.get());
		}
	}
}
