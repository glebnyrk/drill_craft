
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.drillcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.drillcraft.block.entity.NozzleCrafterBlockEntity;
import net.mcreator.drillcraft.DrillCraftMod;

public class DrillCraftModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DrillCraftMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> NOZZLE_CRAFTER = register("nozzle_crafter", DrillCraftModBlocks.NOZZLE_CRAFTER, NozzleCrafterBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
