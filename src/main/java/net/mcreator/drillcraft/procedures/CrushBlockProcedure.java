package net.mcreator.drillcraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CrushBlockProcedure {
	public static void execute(Level world, BlockPos pos, Direction dir, ItemStack item) {
		BlockPos targetPos	= WhenBlockNeighbourProcedure.withDirOffset(pos,dir);
		world.destroyBlock(targetPos,true);
	}
}
