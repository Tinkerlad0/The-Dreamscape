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

import com.tinkerlad.dimension.world.Dimension;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Random;
import java.util.TimerTask;

class teleportToDream extends TimerTask {

	public EntityPlayer player;

	public void run() {
		if (player != null) {
			player.wakeUpPlayer(true, true, true);

			Random randGen = new Random();
			randGen.setSeed((long) player.experience);
			int random = randGen.nextInt(1);
			if (random == 0) {
				player.travelToDimension(Dimension.dreamID);
			} else {
				player.travelToDimension(Dimension.nightmareID);
			}
		}
	}
}
