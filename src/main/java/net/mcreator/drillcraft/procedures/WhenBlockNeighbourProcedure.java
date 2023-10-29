package net.mcreator.drillcraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class WhenBlockNeighbourProcedure {
	public static boolean execute(Level world, BlockPos pos, Direction dir, ItemStack item) {
		BlockPos targetPos = withDirOffset(pos,dir);
		BlockState state = world.getBlockState(targetPos);
		double breakTime = state.getBlock().defaultDestroyTime();
		double level = item.getOrCreateTag().getDouble("level");
		return breakTime <= level*2 && IsHot.execute(world,pos) && breakTime >= 0;
	}
	public static BlockPos withDirOffset(BlockPos pos,Direction dir){
		int x = pos.getX() + dir.getStepX();
		int y = pos.getY() + dir.getStepY();
		int z = pos.getZ() + dir.getStepZ();
		return BlockPos.containing(x,y,z);
	}
}
