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

package com.tinkerlad.dimension.modules;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import net.minecraft.entity.player.EntityPlayer;
import scala.util.Random;

public class SleepTimer {

	public EntityPlayer player;
	public int ticksRequired;
	public boolean enabled = false;
	private int ticked = 0;

	public SleepTimer(int ticks, EntityPlayer target) {
		this.player = target;
		this.ticksRequired = ticks;
	}

	public void enable() {
		this.enabled = true;
	}

	@SubscribeEvent
	public void onServerTick(ServerTickEvent event) {
		if (enabled) {
			this.ticked++;
			if (this.ticked == this.ticksRequired) {
				this.player.wakeUpPlayer(false, false, false);
				Random rand = new Random(player.ticksExisted);
				int dim = 36 + rand.nextInt(1);
				player.travelToDimension(dim);
				FMLCommonHandler.instance().bus().unregister(this);
			}
		}
	}
}
