/*
 *** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
 */

package com.tinkerlad.dimension.world.dream.diamondTree;

import java.util.Random;

import net.minecraft.world.World;

import com.tinkerlad.dimension.block.DimBlocks;

public class DiamondTree {

	public DiamondTree() {

	}

	public static boolean generate(World world, Random rand, int i, int j, int k) {

		if (!world.isAirBlock(i + 3, j - 1, k + 3)) {

			world.setBlock(i + 0, j + 4, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 0, j + 5, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 1, j + 3, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 1, j + 4, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 1, j + 4, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 1, j + 4, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 1, j + 5, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 1, j + 5, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 1, j + 5, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 1, j + 6, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 2, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 3, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 3, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 3, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 4, k + 1, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 4, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 4, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 4, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 4, k + 5, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 5, k + 1, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 5, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 5, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 5, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 5, k + 5, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 6, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 6, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 6, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 2, j + 7, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 0, k + 3, DimBlocks.BlockDiamondWood);
			world.setBlock(i + 3, j + 1, k + 3, DimBlocks.BlockDiamondWood);
			world.setBlock(i + 3, j + 2, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 2, k + 3, DimBlocks.BlockDiamondWood);
			world.setBlock(i + 3, j + 2, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 3, k + 1, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 3, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 3, k + 3, DimBlocks.BlockDiamondWood);
			world.setBlock(i + 3, j + 3, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 3, k + 5, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 4, k + 0, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 4, k + 1, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 4, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 4, k + 3, DimBlocks.BlockDiamondWood);
			world.setBlock(i + 3, j + 4, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 4, k + 5, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 4, k + 6, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 5, k + 0, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 5, k + 1, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 5, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 5, k + 3, DimBlocks.BlockDiamondWood);
			world.setBlock(i + 3, j + 5, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 5, k + 5, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 5, k + 6, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 6, k + 1, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 6, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 6, k + 3, DimBlocks.BlockDiamondWood);
			world.setBlock(i + 3, j + 6, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 6, k + 5, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 7, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 7, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 7, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 3, j + 8, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 2, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 3, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 3, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 3, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 4, k + 1, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 4, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 4, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 4, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 4, k + 5, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 5, k + 1, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 5, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 5, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 5, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 5, k + 5, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 6, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 6, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 6, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 4, j + 7, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 5, j + 3, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 5, j + 4, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 5, j + 4, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 5, j + 4, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 5, j + 5, k + 2, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 5, j + 5, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 5, j + 5, k + 4, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 5, j + 6, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 6, j + 4, k + 3, DimBlocks.BlockDiamondLeaves);
			world.setBlock(i + 6, j + 5, k + 3, DimBlocks.BlockDiamondLeaves);

			return true;
		}
		return false;
	}
}