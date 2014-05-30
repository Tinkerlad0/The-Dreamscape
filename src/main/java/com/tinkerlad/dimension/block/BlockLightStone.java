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

import com.tinkerlad.dimension.reference.BlockInfo;
import net.minecraft.block.material.Material;

public class BlockLightStone extends BlockGeneric {

	public BlockLightStone() {
		super(Material.rock);
		setHardness(1F);
		setResistance(1F);
		setStepSound(soundTypeStone);
		setBlockName(BlockInfo.LIGHTSTONE_ULOCALIZED_NAME);
		setBlockTextureName(BlockInfo.TEXTURE_LOCATION + BlockInfo.LIGHTSTONE_TEXTURE);
	}
}
