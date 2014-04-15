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

import com.tinkerlad.dimension.logging.LogHelper;
import com.tinkerlad.dimension.reference.BlockInfo;

import cpw.mods.fml.common.registry.GameRegistry;

public class DimBlocks {

	public static Block BedTimer;
	public static Block BlockLightStone;
	public static Block BlockPlatinumOre;
	public static Block	BlockBed;
	public static Block	BlockDimBed;
	
	public static Block	BlockDebug;

	public static void init() {

		LogHelper.log(Level.INFO, "Preparing DimBlocks");

		BlockLightStone = new BlockLightStone();
		GameRegistry.registerBlock(BlockLightStone, BlockInfo.LIGHTSTONE_ULOCALIZED_NAME);
		
		BlockPlatinumOre = new BlockPlatinumOre();
		GameRegistry.registerBlock(BlockPlatinumOre, BlockInfo.PLATINUM_ULOCALIZED_NAME);
		
		BlockDebug = new BlockDebug();
		GameRegistry.registerBlock(BlockDebug, BlockInfo.DEBUG_ULOCALIZED_NAME);

		BlockBed = new BlockBed();
		GameRegistry.registerBlock(BlockBed, BlockInfo.BED_ULOCALIZED_NAME);

		BlockDimBed = new BlockDimBed();
		GameRegistry.registerBlock(BlockDimBed, BlockInfo.BED_ULOCALIZED_NAME + "dim");
		LogHelper.log(Level.INFO, "Loaded DimBlocks");
	}



}
