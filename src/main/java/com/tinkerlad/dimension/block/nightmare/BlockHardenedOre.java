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
import com.tinkerlad.dimension.block.DimBlocks;
import com.tinkerlad.dimension.reference.BlockInfo;
import net.minecraft.block.material.Material;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class BlockHardenedOre extends BlockGeneric {

	public BlockHardenedOre() {

		super(Material.iron);
		this.lightValue = 8;
		setBlockName(BlockInfo.HARDENED_ORE_ULOCALIZED_NAME);
		setBlockTextureName(BlockInfo.TEXTURE_LOCATION + BlockInfo.HARDENED_ORE_TEXTURE);
	}

	@Override
	public int quantityDropped(Random random) {

		return 0;
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, int xPos, int yPos, int zPos, Explosion explosion) {

		world.setBlock(xPos, yPos, zPos, DimBlocks.BlockRubyOre);
	}
}
