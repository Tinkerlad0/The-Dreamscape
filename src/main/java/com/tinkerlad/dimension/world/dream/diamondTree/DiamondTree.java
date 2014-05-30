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

package com.tinkerlad.dimension.world.dream.diamondTree;

import com.tinkerlad.dimension.block.DimBlocks;
import com.tinkerlad.dimension.block.fluids.DimFluids;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Random;

public class DiamondTree {

	public DiamondTree() {

	}

	public static boolean tryGenerate(World world, Random random, int x, int y, int z) {
		boolean flag = true;

		for (int i = -2; i <= 2; i++) {
			for (int j = 0; j <= 7; j++) {
				for (int k = -2; k <= 2; k++) {
					flag = world.isAirBlock(x + i, y + j, z + k) ? flag : false;
				}
			}
		}
		flag = !world.isAirBlock(x, y - 1, z) ? flag : false;

		if (flag) {
			generate(world, random, x, y, z);
			System.out.println("Genning Tree at " + x + " " + y + " " + z);
		}

		return flag;
	}

	public static boolean generate(World world, Random rand, int i, int j, int k) {

		setBlock(world, i - 3, j + 4, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 3, j + 5, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 2, j + 3, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 2, j + 4, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 2, j + 4, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 2, j + 4, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 2, j + 5, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 2, j + 5, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 2, j + 5, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 2, j + 6, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 2, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 3, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 3, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 3, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 4, k - 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 4, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 4, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 4, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 4, k + 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 5, k - 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 5, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 5, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 5, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 5, k + 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 6, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 6, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 6, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i - 1, j + 7, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 0, k, DimBlocks.BlockDiamondWood);
		setBlock(world, i, j + 1, k, DimBlocks.BlockDiamondWood);
		setBlock(world, i, j + 2, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 2, k, DimBlocks.BlockDiamondWood);
		setBlock(world, i, j + 2, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 3, k - 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 3, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 3, k, DimBlocks.BlockDiamondWood);
		setBlock(world, i, j + 3, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 3, k + 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 4, k - 3, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 4, k - 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 4, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 4, k, DimBlocks.BlockDiamondWood);
		setBlock(world, i, j + 4, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 4, k + 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 4, k + 3, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 5, k - 3, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 5, k - 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 5, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 5, k, DimBlocks.BlockDiamondWood);
		setBlock(world, i, j + 5, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 5, k + 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 5, k + 3, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 6, k - 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 6, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 6, k, DimFluids.BlockFluidDreamWater);
		setBlock(world, i, j + 6, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 6, k + 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 7, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 7, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 7, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i, j + 8, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 2, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 3, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 3, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 3, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 4, k - 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 4, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 4, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 4, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 4, k + 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 5, k - 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 5, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 5, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 5, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 5, k + 2, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 6, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 6, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 6, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 1, j + 7, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 2, j + 3, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 2, j + 4, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 2, j + 4, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 2, j + 4, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 2, j + 5, k - 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 2, j + 5, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 2, j + 5, k + 1, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 2, j + 6, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 3, j + 4, k, DimBlocks.BlockDiamondLeaves);
		setBlock(world, i + 3, j + 5, k, DimBlocks.BlockDiamondLeaves);

		return true;
	}

	private static void setBlock(World world, int x, int y, int z, Block block) {
		if (!world.isAirBlock(x, y, z)) {
			world.setBlock(x, y, z, block);
		}
	}
}