/******************************************************************************
 * Copyright (c) 2014 Tinkerlad                                               *
 * All rights reserved. This program and the accompanying materials           *
 * are made available under the terms of the GNU Public License v2.0          *
 * which accompanies this distribution, and is available at                   *
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html                      *
 *                                                                            *
 * Contributors:                                                              *
 * 	Tinkerlad - initial concept and implementation                            *
 ******************************************************************************/

package com.tinkerlad.dimension.block;

import com.tinkerlad.dimension.block.bed.BlockBed1;
import com.tinkerlad.dimension.block.bed.BlockBed2;
import com.tinkerlad.dimension.block.bed.BlockBed3;
import com.tinkerlad.dimension.block.bed.BlockBedMaster;
import com.tinkerlad.dimension.block.dream.BlockDiamondLeaves;
import com.tinkerlad.dimension.block.dream.BlockDiamondWood;
import com.tinkerlad.dimension.block.dream.BlockTopSoil;
import com.tinkerlad.dimension.block.fluids.DimFluids;
import com.tinkerlad.dimension.block.nightmare.BlockBedrockBreakable;
import com.tinkerlad.dimension.block.nightmare.BlockFreakSand;
import com.tinkerlad.dimension.block.nightmare.BlockHardenedOre;
import com.tinkerlad.dimension.block.ore.BlockRubyOre;
import com.tinkerlad.dimension.logging.LogHelper;
import com.tinkerlad.dimension.reference.BlockInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import org.apache.logging.log4j.Level;

public class DimBlocks {

	public static Block BlockLightStone;
	public static Block BlockRubyOre;

	// DreamBlocks
	public static Block BlockDiamondLeaves;
	public static Block BlockDiamondWood;
	public static Block BlockTopSoil;

	// NightmareBlocks
	public static Block BlockHardenedOre;
	public static Block BlockFreakySand;
	public static Block BlockBedrockBreakable;

	//BedBlocks
	public static Block BlockBedMaster;
	public static Block BlockTier1;
	public static Block BlockTier2;
	public static Block BlockTier3;

	public static Block BlockDebug;
	public static Block BlockGlobalStorage;

	public static void init() {

		LogHelper.log(Level.INFO, "Preparing DimBlocks");

		BlockLightStone = new BlockLightStone();
		GameRegistry.registerBlock(BlockLightStone, BlockInfo.LIGHTSTONE_ULOCALIZED_NAME);

		BlockDiamondLeaves = new BlockDiamondLeaves();
		GameRegistry.registerBlock(BlockDiamondLeaves, "diamondLeaves");

		BlockDiamondWood = new BlockDiamondWood();
		GameRegistry.registerBlock(BlockDiamondWood, BlockInfo.DIA_WOOD_ULOCALIZED_NAME);

		BlockHardenedOre = new BlockHardenedOre();
		GameRegistry.registerBlock(BlockHardenedOre, BlockInfo.HARDENED_ORE_ULOCALIZED_NAME);

		BlockRubyOre = new BlockRubyOre();
		GameRegistry.registerBlock(BlockRubyOre, BlockInfo.RUBY_ULOCALIZED_NAME);

		BlockFreakySand = new BlockFreakSand();
		GameRegistry.registerBlock(BlockFreakySand, BlockInfo.FSAND_ULOCALIZED_NAME);

		BlockBedrockBreakable = new BlockBedrockBreakable();
		GameRegistry.registerBlock(BlockBedrockBreakable, BlockInfo.BEDROCK_ULOCALIZED_NAME);

		BlockTopSoil = new BlockTopSoil();
		GameRegistry.registerBlock(BlockTopSoil, BlockInfo.TOPSOIL_ULOCALIZED_NAME);

		BlockBedMaster = new BlockBedMaster();
		GameRegistry.registerBlock(BlockBedMaster, BlockInfo.MASTER_ULOCALIZED_NAME);

		BlockDebug = new BlockDebug();
		GameRegistry.registerBlock(BlockDebug, BlockInfo.DEBUG_ULOCALIZED_NAME);

		BlockGlobalStorage = new BlockGlobalStorage();
		GameRegistry.registerBlock(BlockGlobalStorage, BlockInfo.GLOBAL_ULOCALIZED_NAME);

		BlockTier1 = new BlockBed1();
		BlockTier2 = new BlockBed2();
		BlockTier3 = new BlockBed3();

		GameRegistry.registerBlock(BlockTier1, BlockInfo.BASE_ULOCALIZED_NAME[0]);
		GameRegistry.registerBlock(BlockTier2, BlockInfo.BASE_ULOCALIZED_NAME[1]);
		GameRegistry.registerBlock(BlockTier3, BlockInfo.BASE_ULOCALIZED_NAME[2]);


		DimFluids.init();

		LogHelper.log(Level.INFO, "Loaded DimBlocks");
	}
}
