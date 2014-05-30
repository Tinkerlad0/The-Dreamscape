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
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public class BreakBlockPacket extends AbstractPacket {

	int x, y, z;

	public BreakBlockPacket() {

	}

	public BreakBlockPacket(int xPos, int yPos, int zPos) {

		x = xPos;
		y = yPos;
		z = zPos;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {

	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {

	}

	@Override
	public void handleClientSide(EntityPlayer player) {

		player.worldObj.setBlockToAir(x, y, z);
	}

	@Override
	public void handleServerSide(EntityPlayer player) {

		player.worldObj.setBlockToAir(x, y, z);
	}
}
