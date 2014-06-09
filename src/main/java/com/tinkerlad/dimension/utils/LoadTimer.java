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

import com.tinkerlad.dimension.block.DimBlocks;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import net.minecraft.client.Minecraft;

public class LoadTimer {

	public int ticksRequired;
	public boolean enabled = false;
	private int ticked = 0;

	public LoadTimer(int ticks) {
		this.ticksRequired = ticks;
	}

	@SubscribeEvent
	public void onServerTick(ServerTickEvent event) {
		this.ticked++;
		if (this.ticked == this.ticksRequired) {
			if (Minecraft.getMinecraft().theWorld.getTileEntity(0, 0, 0) == null) {
				Minecraft.getMinecraft().theWorld.setBlock(0, 0, 0, DimBlocks.BlockGlobalStorage);
			}
			FMLCommonHandler.instance().bus().unregister(this);
		}
	}
}
