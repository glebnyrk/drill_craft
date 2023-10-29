package net.mcreator.drillcraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class IsHot {
    public static boolean execute(Level world, BlockPos pos){
        BlockPos targetPos = WhenBlockNeighbourProcedure.withDirOffset(pos, Direction.DOWN);
        BlockState state = world.getBlockState(targetPos);
        boolean isLit = state.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _getbp1 && state.getValue(_getbp1);
        return IsFurnace(state) && isLit;
    }
    public static Boolean IsFurnace(BlockState state){
        Block block = state.getBlock();
        return block.equals(Blocks.FURNACE) ||
                block.equals(Blocks.SMOKER) ||
                block.equals(Blocks.BLAST_FURNACE);

    }
}
