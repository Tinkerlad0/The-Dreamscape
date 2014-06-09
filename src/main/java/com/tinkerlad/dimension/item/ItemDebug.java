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

package com.tinkerlad.dimension.item;

import com.tinkerlad.dimension.reference.ItemInfo;
import com.tinkerlad.dimension.tileEntities.TileGlobalStorage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.List;

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

		if (Minecraft.getMinecraft().theWorld.getTileEntity(0, 0, 0) == null) {
			System.out.println("Does not exist");
		} else {
			TileEntity tile = Minecraft.getMinecraft().theWorld.getTileEntity(0, 0, 0);
			if (tile instanceof TileGlobalStorage) {
				TileGlobalStorage storage = (TileGlobalStorage) tile;
				storage.writeToNBT(new NBTTagCompound());
			}
		}

		return stack;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean useExtraInformation) {

		info.add("This item is for DEBUGGING only");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {

		this.itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ItemInfo.DEBUG_ICON);
	}

	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

		return true;
	}
}