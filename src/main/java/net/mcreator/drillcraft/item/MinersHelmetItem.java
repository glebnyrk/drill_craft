
package net.mcreator.drillcraft.item;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

public class MinersHelmetItem extends Item {
	public MinersHelmetItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
		return armorType == EquipmentSlot.HEAD;
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int p_41407_, boolean p_41408_) {
		if (entity instanceof LivingEntity livingEntity){
			if (livingEntity.getItemBySlot(EquipmentSlot.HEAD) == stack){
				BlockPos pos = BlockPos.containing(livingEntity.getX(),livingEntity.getY(),livingEntity.getZ());
				LevelAccessor levelAccessor = level;
				if (levelAccessor.getMaxLocalRawBrightness(pos) < 8){
					if (Blocks.TORCH.defaultBlockState().canSurvive(level,pos)){
						if (level.getBlockState(pos).getBlock() == Blocks.AIR){
							ItemStack leftHand = livingEntity.getOffhandItem();
							if (leftHand.sameItem(Items.TORCH.getDefaultInstance())){
								level.setBlock(pos, Blocks.TORCH.defaultBlockState(),3);
								leftHand.shrink(1);
							}
						}
					}
				}
			}
		}
	}
}
