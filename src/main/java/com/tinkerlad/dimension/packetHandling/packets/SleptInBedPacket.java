package com.tinkerlad.dimension.packetHandling.packets;

import com.tinkerlad.dimension.packetHandling.AbstractPacket;
import com.tinkerlad.dimension.tileEntities.TileGlobalStorage;
import com.tinkerlad.dimension.utils.Utils;
import com.tinkerlad.dimension.world.Dimension;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

public class SleptInBedPacket extends AbstractPacket {

	int xLoc;
	int yLoc;
	int zLoc;

	public SleptInBedPacket() {

	}

	public SleptInBedPacket(int posX, int posY, int posZ) {

		xLoc = posX;
		yLoc = posY;
		zLoc = posZ;
	}

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

		if (player.isPlayerSleeping()) {
			player.wakeUpPlayer(true, false, true);
			player.worldObj.updateAllPlayersSleepingFlag();
			System.out.println(player.toString() + " is now dreaming");
			//storeInv(player);
			//getInv(player);
			dream(player);
		}
	}

	private void dream(EntityPlayer player) {

		Random rand = new Random(player.ticksExisted);
		int dimID = Dimension.dreamID + rand.nextInt(1);
		Utils.teleport(player, dimID);
	}

	private void storeInv(EntityPlayer player) {
		TileEntity tile = Minecraft.getMinecraft().theWorld.getTileEntity(0, 0, 0);
		if (tile instanceof TileGlobalStorage) {
			TileGlobalStorage storage = (TileGlobalStorage) tile;
			storage.putInventory(0, player);
		}
	}

	private void getInv(EntityPlayer player) {
		TileEntity tile = Minecraft.getMinecraft().theWorld.getTileEntity(0, 0, 0);
		if (tile instanceof TileGlobalStorage) {
			TileGlobalStorage storage = (TileGlobalStorage) tile;
			storage.getInventory(1, player);
		}
	}
}