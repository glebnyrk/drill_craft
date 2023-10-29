
package net.mcreator.drillcraft.item.extension;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockSource;

import net.mcreator.drillcraft.procedures.WhenBlockNeighbourProcedure;
import net.mcreator.drillcraft.procedures.CrushBlockProcedure;
import net.mcreator.drillcraft.init.DrillCraftModItems;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DrillWorkingItemExtension {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> DispenserBlock.registerBehavior(DrillCraftModItems.PICK_DRILL.get(), new OptionalDispenseItemBehavior() {
			public ItemStack execute(BlockSource blockSource, ItemStack stack) {
				ItemStack itemstack = stack.copy();
				Level world = blockSource.getLevel();
				Direction direction = blockSource.getBlockState().getValue(DispenserBlock.FACING);
				int x = blockSource.getPos().getX();
				int y = blockSource.getPos().getY();
				int z = blockSource.getPos().getZ();
				this.setSuccess(WhenBlockNeighbourProcedure.execute(world,blockSource.getPos(),direction,itemstack));
				boolean success = this.isSuccess();
				if (success)
					CrushBlockProcedure.execute(world,blockSource.getPos(),direction,itemstack);
				return itemstack;
			}
		}));
	}
}
