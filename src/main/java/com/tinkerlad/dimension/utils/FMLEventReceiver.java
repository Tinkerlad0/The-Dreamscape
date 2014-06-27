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

import com.tinkerlad.dimension.world.Dimension;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class FMLEventReceiver {

	int cooldown = 0;

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onServerTick(ServerTickEvent event) {

		WorldServer worldserver = MinecraftServer.getServer().worldServerForDimension(0);
		long time = worldserver.getWorldTime();
		if (cooldown == 0) {
			if ((time % 24000L) > 0 && time % 24000 < 1000) {
				wakeUpDreamers(Dimension.dreamID);
				wakeUpDreamers(Dimension.nightmareID);
				System.out.println("WAKE UP GEOFF");
				cooldown = 2200;
			}
		} else {
			cooldown--;
		}
	}

	public void wakeUpDreamers(int dimID) {

		WorldServer world = MinecraftServer.getServer().worldServerForDimension(dimID);
		int size = world.playerEntities.size();
		for (int i = 0; i < size; i++) {
			EntityPlayer player = (EntityPlayer) world.playerEntities.get(i);
			if (player.dimension == dimID) {
				Utils.teleport(player, 0);
			}
		}
	}
}
