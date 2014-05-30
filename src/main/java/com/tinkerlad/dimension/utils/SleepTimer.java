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

package com.tinkerlad.dimension.utils;

import com.tinkerlad.dimension.Possession;
import com.tinkerlad.dimension.packetHandling.packets.SleptInBedPacket;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class SleepTimer {

	public EntityPlayer player;
	public EntityPlayerMP mpPlayer;
	public int ticksRequired;
	public Event sleepEvent;
	public boolean enabled = false;
	private int ticked = 0;

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
