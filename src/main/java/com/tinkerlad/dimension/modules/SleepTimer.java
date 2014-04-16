package com.tinkerlad.dimension.modules;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import scala.util.Random;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;

public class SleepTimer {

	public EntityPlayer	player;
	public int			ticksRequired;
	public Event		sleepEvent;
	private int			ticked	= 0;
	public boolean		enabled	= false;

	public SleepTimer(int ticks, EntityPlayer target, Event event) {
		this.player = target;
		this.ticksRequired = ticks;
		this.sleepEvent = event;
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
				this.player.wakeUpPlayer(true, false, true);
				this.player.worldObj.updateAllPlayersSleepingFlag();
				Random rand = new Random(player.ticksExisted);
				int dim = 36; // + rand.nextInt(1);
				player.travelToDimension(dim);
				player.setPositionAndUpdate(0, player.worldObj.getHeightValue(0, 0) + 3, 0);
				FMLCommonHandler.instance().bus().unregister(this);

			}
		}
	}

	public void dream(int dimID) {
		World world = this.player.worldObj;
		// obviously make sure you are server side, then get the world server's
		// default teleporter:
		((EntityPlayerMP) player).mcServer.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, dimID, ((WorldServer) world).getDefaultTeleporter());
		// get the height value so you don't get stuck in solid blocks or worse,
		// in the void
		double dy = player.worldObj.getHeightValue(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posZ));

		// still seem to need to set the position, +1 so you don't get in the
		// void
		player.setPositionAndUpdate(player.posX, dy + 1, player.posZ);

	}
}
