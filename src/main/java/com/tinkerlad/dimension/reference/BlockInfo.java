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

package com.tinkerlad.dimension.reference;

import com.tinkerlad.dimension.block.DimBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class BlockInfo {

	public static final String TEXTURE_LOCATION = ModInfo.ID.toLowerCase() + ":";
	public static final String DEFAULT = "default";

	// BlockLightStone
	public static final String LIGHTSTONE_ULOCALIZED_NAME = "lightStone";
	public static final String LIGHTSTONE_TEXTURE = "lightstone";

	// BlockPlatinumOre
	public static final String PLATINUM_ULOCALIZED_NAME = "orePlatinum";
	public static final String PLATINUM_TEXTURE = "platinum";

	// BlockRubyOre
	public static final String RUBY_ULOCALIZED_NAME = "oreRuby";
	public static final String RUBY_TEXTURE = "ruby";

	// BlockDebug
	public static final String DEBUG_ULOCALIZED_NAME = "debugDim";
	public static final String DEBUG_TEXTURE = "default";

	// BlockDiamondLeaves
	public static final String DIA_LEAVES_ULOCALIZED_NAME = "leavesDiamond";
	public static final String DIA_LEAVES_TEXTURE[] = {"leaves_diamond", "leaves_diamond_opaque"};

	// BlockDiamondWood
	public static final String DIA_WOOD_ULOCALIZED_NAME = "logDiamond";
	public static final String DIA_WOOD_TEXTURE[] = {"log_diamond", "log_diamond_top"};

	// BlockHardenedOre
	public static final String HARDENED_ORE_ULOCALIZED_NAME = "oreHardened";
	public static final String HARDENED_ORE_TEXTURE = "hardenedOre";
	public static final Block HARDENED_ORE[] = {Blocks.redstone_ore, Blocks.coal_ore, Blocks.diamond_ore,
			                                           Blocks.emerald_ore, Blocks.gold_ore, Blocks.iron_ore,
			                                           Blocks.lapis_ore, Blocks.quartz_ore, DimBlocks.BlockLightStone,
			                                           DimBlocks.BlockRubyOre};

	// BlockFreakSand
	public static final String FSAND_ULOCALIZED_NAME = "sandFreak";
	public static final String FSAND_TEXTURE = "sand";

	// BlockBedrockBreakable
	public static final String BEDROCK_ULOCALIZED_NAME = "bedrockBreakable";
	public static final String BEDROCK_TEXTURE = "Bedrock";

	//BlockTopSoil
	public static final String TOPSOIL_ULOCALIZED_NAME = "topSoil";
	public static final String TOPSOIL_TEXTURE[] = {"soil_grass", "soil"};

	//BlockFluidDreamWater
	public static final String DREAMWATER_ULOCALIZED_NAME = "dreamWater";
	public static final String DREAMWATER_TEXTURE[] = {""};

	//BlockGlobalStorage
	public static final String GLOBAL_ULOCALIZED_NAME = "globalStorage";
	public static final String GLOBAL_TEXTURE = "bedrock";

	//BlockBedMaster
	public static final String MASTER_ULOCALIZED_NAME = "masterBed";
	public static final String MASTER_TEXTURE[] = {"stone", "pensive"};

	//BlockBed Bases
	public static final String BASE_ULOCALIZED_NAME[] = {"bedTier1", "bedTier2", "bedTier3"};
	public static final String BASE_TEXTURE[] = {"tier1", "tier2", "tier3"};
}
