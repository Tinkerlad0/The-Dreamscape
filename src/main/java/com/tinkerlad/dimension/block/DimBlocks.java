/*******************************************************************************
 * Copyright (c) 2013 Tinkerlad
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Tinkerlad - initial concept and implementation
 ******************************************************************************/
package com.tinkerlad.dimension.block;

import net.minecraft.block.Block;

import org.apache.logging.log4j.Level;

import com.tinkerlad.dimension.block.dream.BlockDiamondLeaves;
import com.tinkerlad.dimension.block.dream.BlockDiamondWood;
import com.tinkerlad.dimension.block.nightmare.BlockHardenedOre;
import com.tinkerlad.dimension.block.ore.BlockRubyOre;
import com.tinkerlad.dimension.logging.LogHelper;
import com.tinkerlad.dimension.reference.BlockInfo;

import cpw.mods.fml.common.registry.GameRegistry;

public class DimBlocks {

	public static Block BedTimer;
	public static Block BlockLightStone;
	public static Block	BlockRubyOre;
	
	// DreamBlocks
	public static Block	BlockDiamondLeaves;
	public static Block	BlockDiamondWood;

	// NightmareBlocks
	public static Block	BlockHardenedOre;

	public static Block	BlockDebug;

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

		BlockDebug = new BlockDebug();
		GameRegistry.registerBlock(BlockDebug, BlockInfo.DEBUG_ULOCALIZED_NAME);

		LogHelper.log(Level.INFO, "Loaded DimBlocks");
	}



}
