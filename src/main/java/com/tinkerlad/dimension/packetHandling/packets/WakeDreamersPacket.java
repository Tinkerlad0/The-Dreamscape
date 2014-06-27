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

package com.tinkerlad.dimension.packetHandling.packets;

import com.tinkerlad.dimension.block.DimBlocks;
import com.tinkerlad.dimension.item.DimItem;
import com.tinkerlad.dimension.packetHandling.AbstractPacket;
import com.tinkerlad.dimension.utils.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WakeDreamersPacket extends AbstractPacket {

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {

	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {

	}

	@Override
	public void handleClientSide(EntityPlayer player) {

	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		for (int slot = 0; slot < player.inventory.getSizeInventory(); slot++) {
			Item item = player.inventory.getStackInSlot(slot).getItem();
			if (item == DimItem.rubyGem || item == DimItem.platinumIngot || item == (new ItemStack(DimBlocks
					                                                                                       .BlockPlatinumOre, 1)).getItem()) {

				player.inventory.clearInventory(DimItem.rubyGem, -1);
			}
		}
		Utils.teleport(player, 0);
	}
}
