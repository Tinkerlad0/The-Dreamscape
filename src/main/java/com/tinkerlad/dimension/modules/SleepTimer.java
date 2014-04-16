package com.tinkerlad.dimension.modules;

import net.minecraft.entity.player.EntityPlayer;
import scala.util.Random;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;

public class SleepTimer {

	public EntityPlayer	player;
	public int			ticksRequired;
	private int			ticked	= 0;
	public boolean		enabled	= false;

	public SleepTimer(int ticks, EntityPlayer target) {
		this.player = target;
		this.ticksRequired = ticks;

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

				this.player.wakeUpPlayer(false, false, false);
				Random rand = new Random(player.ticksExisted);
				int dim = 36 + rand.nextInt(1);
				player.travelToDimension(dim);
				FMLCommonHandler.instance().bus().unregister(this);
			}
		}
	}
}
