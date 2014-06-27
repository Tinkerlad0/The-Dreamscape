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

package com.tinkerlad.dimension.world;

import com.tinkerlad.dimension.world.dream.diamondTree.DiamondTree;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class DimensionGenerator implements IWorldGenerator {

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		switch (world.provider.dimensionId) {
			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16);
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
			case 1:
				generateEnd(world, random, chunkX * 16, chunkZ * 16);
			case 36:
				generateNightmare(world, random, chunkX * 16, chunkZ * 16);
			case 37:
				generateDream(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateNightmare(World world, Random random, int i, int j) {

	}

	private void generateDream(World world, Random random, int x, int z) {
		if (random.nextInt(15) == 0) {
			DiamondTree.tryGenerate(world, random, x, world.getTopSolidOrLiquidBlock(x, z), z);
		}
	}

	private void generateEnd(World world, Random random, int i, int j) {


	}

	public void generateSurface(World world, Random random, int blockX, int blockZ) {

	}

	public void generateNether(World world, Random random, int blockX, int blockZ) {

	}
}