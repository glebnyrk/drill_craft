
package net.mcreator.drillcraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CopperPlateItem extends Item {
	public CopperPlateItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
