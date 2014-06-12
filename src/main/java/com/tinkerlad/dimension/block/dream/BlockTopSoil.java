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

package com.tinkerlad.dimension.block.dream;

import com.tinkerlad.dimension.block.BlockGeneric;
import com.tinkerlad.dimension.reference.BlockInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockTopSoil extends BlockGeneric {

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon side;
	@SideOnly(Side.CLIENT)
	private IIcon bottom;

	public BlockTopSoil() {
		super(Material.grass);
		this.setBlockName(BlockInfo.TOPSOIL_ULOCALIZED_NAME);
		this.setHardness(1.5F);
		this.setLightLevel(3F);
		this.setStepSound(soundTypeGrass);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (side == 1) {
			return this.top;
		} else {
			return this.side;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {

		this.top = register.registerIcon(BlockInfo.TEXTURE_LOCATION + BlockInfo.TOPSOIL_TEXTURE[0]);
		this.side = register.registerIcon(BlockInfo.TEXTURE_LOCATION + BlockInfo.TOPSOIL_TEXTURE[1]);
	}
}
