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

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.tinkerlad.dimension.reference.ItemInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDebug extends ItemPossession {

	public ItemDebug() {

		super();
		setFull3D();
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.DEBUG_UNLOCALIZED_NAME);
		setTextureName(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.DEBUG_ICON);

	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer par5Entity) {

		return stack;
	}

	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

		for (int i = -5; i <= 5; i++) {
			for (int j = -5; j <= 5; j++) {
				for (int k = -5; k <= 5; k++) {
					if (player.worldObj.getBlock(x - i, y - j, z - k) == player.worldObj.getBlock(x, y, z)) {

						// Possession.packetPipeline.sendToAll(new
						// SleptInBedPacket(x - i, y - j, z - k));
						world.setBlockToAir(x - i, y - j, z - k);
					}
				}
			}
		}

		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {

		this.itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ItemInfo.DEBUG_ICON);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean useExtraInformation) {

		info.add("This item is for DEBUGGING only");
	}
}