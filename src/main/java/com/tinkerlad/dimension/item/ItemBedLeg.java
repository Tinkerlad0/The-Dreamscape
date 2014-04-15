/*******************************************************************************
 * Copyright (c) 2013 Tinkerlad
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Tinkerlad - initial concept and implementation
 ******************************************************************************/
package com.tinkerlad.dimension.item;

import net.minecraft.client.renderer.texture.IIconRegister;

import com.tinkerlad.dimension.reference.ItemInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBedLeg extends ItemPossession {

	public ItemBedLeg() {

		super();
		setMaxStackSize(4);
		setUnlocalizedName(ItemInfo.LEG_UNLOCALIZED_NAME);
		setTextureName(ItemInfo.TEXTURE_LOCATION + ItemInfo.LEG_ICON);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {

		this.itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION
				+ ItemInfo.LEG_ICON);
	}

}
