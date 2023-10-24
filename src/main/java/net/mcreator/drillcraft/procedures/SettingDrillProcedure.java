package net.mcreator.drillcraft.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.mcreator.drillcraft.init.DrillCraftModItems;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.ItemHandlerHelper;

public class SettingDrillProcedure {
	public static void execute(Entity entity, Level world) {
		if (entity == null){
			return;
		}
		ItemStack itemStackR = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		ItemStack itemStackL = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
		if (itemStackL.getItem().equals(DrillCraftModItems.DRILL.get())){
			double type = getType(itemStackL);
			double level = getLevel(itemStackL);
			double energy = itemStackL.getOrCreateTag().getDouble("energy");

			double burnT = ForgeHooks.getBurnTime(itemStackR,null);
			if (type == 0 && level == 0){
				double levelR = itemStackR.getOrCreateTag().getDouble("level");
				if (itemStackR.getItem().equals(DrillCraftModItems.PICK_DRILL.get())) {
					putType(1, levelR, itemStackL);
					itemStackR.setCount(0);
				}
				else if (burnT > 0 && energy < 1024){
					itemStackR.shrink(1);
					itemStackL.getOrCreateTag().putDouble("energy",energy +burnT / 200);
					if (entity instanceof Player player){
						player.displayClientMessage(Component.literal("your energy: " + (int) energy ),true);
					}
				}
			}
			else {

				ItemStack instrument = ItemStack.EMPTY;
				if (type > 0 && level > 0){
					instrument =  DrillCraftModItems.PICK_DRILL.get().getDefaultInstance();
				}
				if (type == 1){
					putType(0,0,itemStackL);
					instrument.getOrCreateTag().putDouble("level",level);
				}
				if (entity instanceof Player player){
					ItemHandlerHelper.giveItemToPlayer(player, instrument);
				}
				}
			}

		}
	static double getType(ItemStack item){
		return item.getOrCreateTag().getDouble("type");
	}
	static double getLevel(ItemStack item){
		return item.getOrCreateTag().getDouble("level");
	}
	static void putType(double type,double level, ItemStack item){
		item.getOrCreateTag().putDouble("type", type);
		item.getOrCreateTag().putDouble("level",level);
	}
}
