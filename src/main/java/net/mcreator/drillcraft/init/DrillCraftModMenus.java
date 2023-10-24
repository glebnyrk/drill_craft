
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.drillcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.drillcraft.world.inventory.NozzleCrafterGUIMenu;
import net.mcreator.drillcraft.DrillCraftMod;

public class DrillCraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DrillCraftMod.MODID);
	public static final RegistryObject<MenuType<NozzleCrafterGUIMenu>> NOZZLE_CRAFTER_GUI = REGISTRY.register("nozzle_crafter_gui", () -> IForgeMenuType.create(NozzleCrafterGUIMenu::new));
}
