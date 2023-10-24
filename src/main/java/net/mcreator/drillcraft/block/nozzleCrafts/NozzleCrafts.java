package net.mcreator.drillcraft.block.nozzleCrafts;

import com.google.gson.Gson;
import net.mcreator.drillcraft.init.DrillCraftModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.lang.reflect.Array;

public class NozzleCrafts {
    static ItemStack[] ingredientOne = {
            Items.IRON_INGOT.getDefaultInstance(),
            Items.COPPER_INGOT.getDefaultInstance(),
            DrillCraftModItems.COPPER_PLATE.get().getDefaultInstance(),
            DrillCraftModItems.IRON_PLATE.get().getDefaultInstance(),
            DrillCraftModItems.IRON_PLATE.get().getDefaultInstance(),
            DrillCraftModItems.COPPER_PLATE.get().getDefaultInstance(),
            Items.NETHERITE_INGOT.getDefaultInstance(),
            Items.WARPED_PLANKS.getDefaultInstance(),
            drill(1),
            drill(2),
            drill(3)
    };
    static ItemStack[] ingredientTwo = {
            ItemStack.EMPTY,
            ItemStack.EMPTY,
            DrillCraftModItems.RUBBER_PIECE.get().getDefaultInstance(),
            Items.GLOWSTONE_DUST.getDefaultInstance(),
            Items.REDSTONE.getDefaultInstance(),
            Items.AMETHYST_SHARD.getDefaultInstance(),
            ItemStack.EMPTY,
            DrillCraftModItems.COPPER_PLATE.get().getDefaultInstance(),
            Items.IRON_PICKAXE.getDefaultInstance(),
            Items.DIAMOND_PICKAXE.getDefaultInstance(),
            DrillCraftModItems.NETHERITE_PLATE.get().getDefaultInstance()
    };
   static ItemStack[] result = {
            DrillCraftModItems.IRON_PLATE.get().getDefaultInstance(),
           DrillCraftModItems.COPPER_PLATE.get().getDefaultInstance(),
           DrillCraftModItems.COPPER_COIL.get().getDefaultInstance(),
           DrillCraftModItems.LIGHT_EMITTING_DIODE.get().getDefaultInstance(),
           DrillCraftModItems.BATTERY.get().getDefaultInstance(),
           DrillCraftModItems.ACCUMULATOR.get().getDefaultInstance(),
           DrillCraftModItems.NETHERITE_PLATE.get().getDefaultInstance(),
           DrillCraftModItems.CHIP.get().getDefaultInstance(),
           drill(2),
           drill(3),
           drill(4)
    };
    static ItemStack drill(int level){
        ItemStack r = DrillCraftModItems.PICK_DRILL.get().getDefaultInstance();
        r.getOrCreateTag().putDouble("level",level);
        return r.copy();
    }
    public static ItemStack getResult(ItemStack first, ItemStack second) {
        for(int i = 0;i<result.length;i++){
            if (ItemStack.isSameItemSameTags(first,ingredientOne[i])) {
                if (ItemStack.isSameItemSameTags(second,ingredientTwo[i])){
                return result[i].copy();
                }
            }
        }
        return ItemStack.EMPTY;
    }

    public static int getIndex(ItemStack[] array, ItemStack object) {
        for (int i = 0; i < array.length; i++) {
            if (ItemStack.isSameItemSameTags(array[i], (object))) {
                return i;
            }
        }
        return -1;
    }

}
