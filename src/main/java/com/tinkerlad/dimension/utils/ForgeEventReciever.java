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

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

public class ForgeEventReciever {

	@SubscribeEvent
	public void onPlayerSleep(PlayerSleepInBedEvent event) {

		if (GlobalStorage.DREAM) {
			if (!event.isCanceled()) {
				if (event.entityPlayer.worldObj.isRemote) {
					System.out.println(event.entityPlayer.worldObj.isRemote);
					SleepTimer timer = new SleepTimer(60, event.entityPlayer, event);
					FMLCommonHandler.instance().bus().register(timer);
					timer.enable();
				}
			}
		}
	}
}
