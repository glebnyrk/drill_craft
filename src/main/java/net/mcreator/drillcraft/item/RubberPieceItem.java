
package net.mcreator.drillcraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RubberPieceItem extends Item {
	public RubberPieceItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
