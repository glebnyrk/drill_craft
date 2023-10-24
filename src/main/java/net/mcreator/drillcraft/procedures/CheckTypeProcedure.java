package net.mcreator.drillcraft.procedures;

import net.minecraft.world.item.ItemStack;

public class CheckTypeProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("type");
	}
}
