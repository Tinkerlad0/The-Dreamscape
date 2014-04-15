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
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

import com.tinkerlad.dimension.reference.ItemInfo;
import com.tinkerlad.dimension.world.Dimension;
import com.tinkerlad.dimension.world.nightmare.TeleporterNightmare;

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
	public ItemStack onItemRightClick(ItemStack stack, World world,
 EntityPlayer par5Entity) {

		if (par5Entity.isSneaking()) {
			teleport(par5Entity, Dimension.nightmareID);
		} else {
			teleport(par5Entity, Dimension.dreamID);
		}

		return stack;
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {

		this.itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION
				+ ItemInfo.DEBUG_ICON);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List info,
			boolean useExtraInformation) {

		info.add("This item is for DEBUGGING only.... atm");
	}

	private void teleport(EntityPlayer par5Entity, int dimID) {

		if ((par5Entity.ridingEntity == null) && (par5Entity.riddenByEntity == null) && ((par5Entity instanceof EntityPlayerMP))) {
			EntityPlayerMP player = (EntityPlayerMP) par5Entity;

			MinecraftServer mServer = MinecraftServer.getServer();

			if (player.timeUntilPortal > 0) {
				player.timeUntilPortal = 10;
			} else if (player.dimension != dimID) {
				player.timeUntilPortal = 10;

				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, dimID, new TeleporterNightmare(mServer.worldServerForDimension(Dimension.nightmareID)));
			} else {
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0);
			}
		}

}
}