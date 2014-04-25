package com.tinkerlad.dimension.utils;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;

public class FMLEventReciever {

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onServerTick(ServerTickEvent event) {
		if (event.phase == Phase.START) {
			// start of tick
		} else {
			// end of tick
		}

	}



}
