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

package com.tinkerlad.dimension.block.ore;

import com.tinkerlad.dimension.block.BlockGeneric;
import com.tinkerlad.dimension.item.DimItem;
import com.tinkerlad.dimension.reference.BlockInfo;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockRubyOre extends BlockGeneric {

	public BlockRubyOre() {
		super(Material.rock);
		setHardness(3F);
		setResistance(6F);
		setStepSound(soundTypeStone);
		setBlockName(BlockInfo.RUBY_ULOCALIZED_NAME);
		setBlockTextureName(BlockInfo.TEXTURE_LOCATION + BlockInfo.RUBY_TEXTURE);
	}

	@Override
	public int quantityDropped(Random random) {
		return 1 + random.nextInt(4);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {

		return DimItem.rubyGem;
	}
}
