package com.tinkerlad.dimension.packetHandling.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;

import com.tinkerlad.dimension.packetHandling.AbstractPacket;
import com.tinkerlad.dimension.utils.GlobalStorage;
import com.tinkerlad.dimension.utils.Utils;
import com.tinkerlad.dimension.world.Dimension;

public class SleptInBedPacket extends AbstractPacket {

	int	xLoc;
	int	yLoc;
	int	zLoc;

	public SleptInBedPacket() {

	}

	public SleptInBedPacket(int posX, int posY, int posZ) {

		xLoc = posX;
		yLoc = posY;
		zLoc = posZ;
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

		// TODO Auto-generated method stub

	}

	@Override
	public void handleServerSide(EntityPlayer player) {

		if (player.isPlayerSleeping()) {
			player.wakeUpPlayer(true, false, true);
			player.worldObj.updateAllPlayersSleepingFlag();
			System.out.println(player.toString() + " is now dreaming");
			dream(player);
			GlobalStorage.PLAYER_INVENTORY_STANDARD.put(player, player.inventory);
			player.inventory.clearInventory(null, -1);
			if (GlobalStorage.PLAYER_INVENTORY_DREAMING.containsKey(player)) {
				player.inventory.copyInventory(GlobalStorage.PLAYER_INVENTORY_DREAMING.get(player));
			}
		}

	}

	private void dream(EntityPlayer player) {

		Random rand = new Random(player.ticksExisted);
		int dimID = Dimension.dreamID + rand.nextInt(1);
		Utils.teleport(player, dimID);
	}

}
