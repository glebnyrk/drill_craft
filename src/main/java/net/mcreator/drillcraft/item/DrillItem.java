package net.mcreator.drillcraft.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.drillcraft.procedures.SettingDrillProcedure;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DrillItem extends Item {
    public DrillItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        SettingDrillProcedure.execute(entity, world);
        return ar;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        double energy = stack.getOrCreateTag().getDouble("energy");
        if (entity instanceof Player player){
            player.displayClientMessage(Component.literal("your energy: " + (int) energy ),true);
        }
        if (energy > 0){
            if (stack.getOrCreateTag().getDouble("type") == 1) {
                breakAsHummer(pos, entity.getDirection(), world);
                stack.getOrCreateTag().putDouble("energy",energy - 1);
            }
        }
        return true;
    }

    void breakBlock(BlockPos pos, BlockPos pos2, Level level) {
        float powerOne = level.getBlockState(pos).getDestroySpeed(level, pos);
        float powerTwo = level.getBlockState(pos2).getDestroySpeed(level, pos2);
        if (powerTwo >= 0 && powerOne >= powerTwo) {
            Block.dropResources(level.getBlockState(pos2), level, pos2);
            level.destroyBlock(pos2, false);
        }
    }

    BlockPos posSum(BlockPos a, BlockPos b) {
        int x = a.getX() + b.getX();
        int y = a.getY() + b.getY();
        int z = a.getZ() + b.getZ();
        return BlockPos.containing(x, y, z);
    }

    void breakAsHummer(BlockPos pos, Direction dir, Level level) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (!(x == 1 && y == 1)) {
                    BlockPos cpos;
                    if (dir.getAxis().equals(Direction.Axis.Z)) {
                        cpos = posSum(pos, BlockPos.containing(x - 1, y - 1, 0));
                        breakBlock(pos, cpos, level);
                    } else if (dir.getAxis().equals(Direction.Axis.X)) {
                        cpos = posSum(pos, BlockPos.containing(0, y - 1, x - 1));
                        breakBlock(pos, cpos, level);
                    }
                }
            }
        }
    }

    @Override
    public float getDestroySpeed(ItemStack itemStack, BlockState p_41426_) {
        return (float) itemStack.getOrCreateTag().getDouble("level") * 2;
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState p_41450_) {
        return true;
    }
}
