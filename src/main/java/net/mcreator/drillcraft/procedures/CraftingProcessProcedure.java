package net.mcreator.drillcraft.procedures;

import net.mcreator.drillcraft.block.nozzleCrafts.NozzleCrafts;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.apache.commons.logging.Log;

import java.util.concurrent.atomic.AtomicReference;

public class CraftingProcessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack result = ItemStack.EMPTY;
		ItemStack item1 = ItemStack.EMPTY;
		ItemStack item2 = ItemStack.EMPTY;
		BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
		item1 = getItemStack(world,BlockPos.containing(x,y,z),0);
		item2 = getItemStack(world, BlockPos.containing(x, y, z), 1);
		result = NozzleCrafts.getResult(item1,item2);
		if (!(result.getItem() == ItemStack.EMPTY.getItem())) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 1), z, result.copy());
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
				if (item1.getCount() > 0){
					item1.shrink(1);
				}
				if (item2.getCount() > 0){
				item2.shrink(1);
				}
			}
		}
		}
	public static ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
		AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
		BlockEntity _ent = world.getBlockEntity(pos);
		if (_ent != null)
			_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid)));
		return _retval.get();
	}
}
