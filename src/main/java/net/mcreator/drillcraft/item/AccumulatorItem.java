
package net.mcreator.drillcraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AccumulatorItem extends Item {
	public AccumulatorItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
