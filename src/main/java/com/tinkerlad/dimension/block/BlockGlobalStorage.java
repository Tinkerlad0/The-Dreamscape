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
import com.tinkerlad.dimension.tileEntities.TileGlobalStorage;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Michael on 5/27/2014.
 */
public class BlockGlobalStorage extends BlockGeneric {

	public BlockGlobalStorage() {
		super(Material.rock);
		this.setBlockUnbreakable();
		this.setBlockName(BlockInfo.GLOBAL_ULOCALIZED_NAME);
		this.setBlockTextureName(BlockInfo.GLOBAL_TEXTURE);
		this.setCreativeTab(TabItems.tabPossession);
	}

	public TileEntity createTileEntity(World world, int metadata) {
		return new TileGlobalStorage();
	}
}
