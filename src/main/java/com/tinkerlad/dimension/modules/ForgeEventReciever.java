package com.tinkerlad.dimension.modules;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

public class ForgeEventReciever {

	@SubscribeEvent
	public void onPlayerSleep(PlayerSleepInBedEvent event) {
		if (!event.isCanceled()) {
			if (event.entityPlayer.worldObj.isRemote) {
				System.out.println(event.entityPlayer.worldObj.isRemote);
				SleepTimer timer = new SleepTimer(60, event.entityPlayer);
				FMLCommonHandler.instance().bus().register(timer);
				timer.enable();
			}
		}
	}
}
