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

import com.tinkerlad.dimension.creativeTab.TabItems;
import com.tinkerlad.dimension.reference.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGeneric extends Block {

	public BlockGeneric(Material material) {

		super(material);
		setCreativeTab(TabItems.tabPossession);
		setBlockTextureName(BlockInfo.TEXTURE_LOCATION + BlockInfo.DEFAULT);
	}
}
