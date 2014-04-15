package com.tinkerlad.dimension.modules;

import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ForgeEventReciever {
	@SubscribeEvent
	public void onPlayerSleep(PlayerSleepInBedEvent event) {
		if (!event.isCanceled()) {

			SleepTimer timer = new SleepTimer(60, event.entityPlayer);
			timer.enable();

			// Timer timer = new Timer();
			// teleportToDream dream = new teleportToDream();
			// dream.player = event.entityPlayer;
			// timer.schedule(dream, 3000);
		}
	}

}
