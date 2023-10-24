
package net.mcreator.drillcraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CopperCoilItem extends Item {
	public CopperCoilItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
