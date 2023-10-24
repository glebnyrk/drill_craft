
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.drillcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.drillcraft.block.RubberBlockBlock;
import net.mcreator.drillcraft.block.NozzleCrafterBlock;
import net.mcreator.drillcraft.block.FrameBlock;
import net.mcreator.drillcraft.DrillCraftMod;

public class DrillCraftModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DrillCraftMod.MODID);
	public static final RegistryObject<Block> NOZZLE_CRAFTER = REGISTRY.register("nozzle_crafter", () -> new NozzleCrafterBlock());
	public static final RegistryObject<Block> RUBBER_BLOCK = REGISTRY.register("rubber_block", () -> new RubberBlockBlock());
	public static final RegistryObject<Block> FRAME = REGISTRY.register("frame", () -> new FrameBlock());
}
