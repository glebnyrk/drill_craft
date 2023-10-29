
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.drillcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.drillcraft.procedures.CheckTypeProcedure;
import net.mcreator.drillcraft.procedures.CheckLevelProcedure;
import net.mcreator.drillcraft.item.RubberPieceItem;
import net.mcreator.drillcraft.item.PickDrillItem;
import net.mcreator.drillcraft.item.NetheritePlateItem;
import net.mcreator.drillcraft.item.MinersHelmetItem;
import net.mcreator.drillcraft.item.MetalCoinItem;
import net.mcreator.drillcraft.item.LightEmittingDiodeItem;
import net.mcreator.drillcraft.item.IronPlateItem;
import net.mcreator.drillcraft.item.DrillItem;
import net.mcreator.drillcraft.item.CopperPlateItem;
import net.mcreator.drillcraft.item.CopperPickaxeItem;
import net.mcreator.drillcraft.item.CopperCoilItem;
import net.mcreator.drillcraft.item.ChipItem;
import net.mcreator.drillcraft.item.BatteryItem;
import net.mcreator.drillcraft.item.AccumulatorItem;
import net.mcreator.drillcraft.DrillCraftMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DrillCraftModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DrillCraftMod.MODID);
	public static final RegistryObject<Item> DRILL = REGISTRY.register("drill", () -> new DrillItem());
	public static final RegistryObject<Item> PICK_DRILL = REGISTRY.register("pick_drill", () -> new PickDrillItem());
	public static final RegistryObject<Item> NOZZLE_CRAFTER = block(DrillCraftModBlocks.NOZZLE_CRAFTER);
	public static final RegistryObject<Item> METAL_COIN = REGISTRY.register("metal_coin", () -> new MetalCoinItem());
	public static final RegistryObject<Item> COPPER_COIL = REGISTRY.register("copper_coil", () -> new CopperCoilItem());
	public static final RegistryObject<Item> IRON_PLATE = REGISTRY.register("iron_plate", () -> new IronPlateItem());
	public static final RegistryObject<Item> COPPER_PLATE = REGISTRY.register("copper_plate", () -> new CopperPlateItem());
	public static final RegistryObject<Item> NETHERITE_PLATE = REGISTRY.register("netherite_plate", () -> new NetheritePlateItem());
	public static final RegistryObject<Item> RUBBER_PIECE = REGISTRY.register("rubber_piece", () -> new RubberPieceItem());
	public static final RegistryObject<Item> RUBBER_BLOCK = block(DrillCraftModBlocks.RUBBER_BLOCK);
	public static final RegistryObject<Item> CHIP = REGISTRY.register("chip", () -> new ChipItem());
	public static final RegistryObject<Item> BATTERY = REGISTRY.register("battery", () -> new BatteryItem());
	public static final RegistryObject<Item> ACCUMULATOR = REGISTRY.register("accumulator", () -> new AccumulatorItem());
	public static final RegistryObject<Item> LIGHT_EMITTING_DIODE = REGISTRY.register("light_emitting_diode", () -> new LightEmittingDiodeItem());
	public static final RegistryObject<Item> COPPER_PICKAXE = REGISTRY.register("copper_pickaxe", () -> new CopperPickaxeItem());
	public static final RegistryObject<Item> MINERS_HELMET = REGISTRY.register("miners_helmet", () -> new MinersHelmetItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(DRILL.get(), new ResourceLocation("drill_craft:drill_type"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) CheckTypeProcedure.execute(itemStackToRender));
			ItemProperties.register(DRILL.get(), new ResourceLocation("drill_craft:drill_level"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) CheckLevelProcedure.execute(itemStackToRender));
			ItemProperties.register(PICK_DRILL.get(), new ResourceLocation("drill_craft:pick_drill_level"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) CheckLevelProcedure.execute(itemStackToRender));
		});
	}
}
