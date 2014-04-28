package com.tinkerlad.dimension.packetHandling.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

import com.tinkerlad.dimension.packetHandling.AbstractPacket;

public class BreakBlockPacket extends AbstractPacket {

	int	x, y, z;

	public BreakBlockPacket() {

	}

	public BreakBlockPacket(int xPos, int yPos, int zPos) {

		x = xPos;
		y = yPos;
		z = zPos;

	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {

		// TODO Auto-generated method stub

	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {

		// TODO Auto-generated method stub

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
