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

package com.tinkerlad.dimension.block.nightmare;

import com.tinkerlad.dimension.block.BlockGeneric;
import com.tinkerlad.dimension.reference.BlockInfo;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFreakSand extends BlockGeneric {

	public BlockFreakSand() {

		super(Material.sand);
		setBlockName(BlockInfo.FSAND_ULOCALIZED_NAME);
		setBlockTextureName(BlockInfo.TEXTURE_LOCATION + BlockInfo.FSAND_TEXTURE);
		setTickRandomly(true);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {

		if (!world.isRemote) {

			if (world.isAirBlock(x, y - 1, z)) {
				world.setBlock(x, y - 1, z, this);
				world.setBlockToAir(x, y, z);
			} else if (y == 0) {
				world.setBlockToAir(x, y, z);
			}
		}
	}

	@Override
	public int tickRate(World world) {

		return 5;
	}
}
