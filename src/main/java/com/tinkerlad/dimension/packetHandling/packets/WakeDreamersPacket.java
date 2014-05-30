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

import com.tinkerlad.dimension.packetHandling.AbstractPacket;
import com.tinkerlad.dimension.utils.GlobalStorage;
import com.tinkerlad.dimension.utils.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

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
		InventoryPlayer inventoryPlayer = new InventoryPlayer(player);
		inventoryPlayer.copyInventory(player.inventory);
		GlobalStorage.PLAYER_INVENTORY_DREAMING.put(player, inventoryPlayer);
		player.inventory.clearInventory(null, -1);
		if (GlobalStorage.PLAYER_INVENTORY_STANDARD.containsKey(player)) {
			player.inventory.copyInventory(GlobalStorage.PLAYER_INVENTORY_STANDARD.get(player));
		}
		Utils.teleport(player, 0);
	}
}
