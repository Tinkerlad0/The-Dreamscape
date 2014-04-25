package com.tinkerlad.dimension.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import com.tinkerlad.dimension.Possession;
import com.tinkerlad.dimension.packetHandling.SleptInBedPacket;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;

public class SleepTimer {

	public EntityPlayer		player;
	public EntityPlayerMP	mpPlayer;
	public int				ticksRequired;
	public Event			sleepEvent;
	private int				ticked	= 0;
	public boolean			enabled	= false;

	public SleepTimer(int ticks, EntityPlayer target, Event event) {

		this.player = target;
		this.ticksRequired = ticks;
		this.sleepEvent = event;
		this.mpPlayer = (EntityPlayerMP) player.worldObj.getClosestPlayer(player.posX, player.posY, player.posY, 0);
	}

	public void enable() {

		this.enabled = true;
	}

	@SubscribeEvent
	public void onServerTick(ServerTickEvent event) {

		System.out.println("ticking");
		if (enabled) {
			this.ticked++;
			if (this.ticked == this.ticksRequired) {
				Possession.packetPipeline.sendToServer(new SleptInBedPacket());
				FMLCommonHandler.instance().bus().unregister(this);

			}
		}
	}
}
