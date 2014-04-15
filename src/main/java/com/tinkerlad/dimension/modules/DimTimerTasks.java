package com.tinkerlad.dimension.modules;

import java.util.Random;
import java.util.TimerTask;

import net.minecraft.entity.player.EntityPlayer;

import com.tinkerlad.dimension.world.Dimension;

class teleportToDream extends TimerTask {

	public EntityPlayer	player;

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
