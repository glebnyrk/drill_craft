package net.mcreator.drillcraft.procedures;

import net.minecraft.world.item.ItemStack;

public class CraftingProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("level", 1);
	}
}
