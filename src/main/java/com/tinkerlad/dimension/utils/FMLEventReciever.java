package com.tinkerlad.dimension.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.WorldServer;

import com.tinkerlad.dimension.world.Dimension;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;

public class FMLEventReciever {

	int	cooldown	= 0;

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onServerTick(ServerTickEvent event) {

		WorldServer worldserver = MinecraftServer.getServer().worldServerForDimension(0);
		long time = worldserver.getWorldTime();
		System.out.println(time);
		if (cooldown == 0) {
			System.out.println(time);
			if ((time % 24000L) > 0 && time % 24000 < 1000) {
				wakeUpDreamers(Dimension.dreamID);
				wakeUpDreamers(Dimension.nightmareID);
				System.out.println("WAKE UP GEOFF");
				cooldown = 2200;
			}
		} else {
			cooldown--;
		}
	}

	public void wakeUpDreamers(int dimID) {

		WorldServer world = MinecraftServer.getServer().worldServerForDimension(dimID);
		int size = world.playerEntities.size();
		for (int i = 0; i < size; i++) {
			EntityPlayer player = (EntityPlayer) world.playerEntities.get(i);
			if (player.dimension == dimID) {
				InventoryPlayer inventoryDreaming = player.inventory;

				GlobalStorage.PLAYER_INVENTORY_DREAMING.put(player, inventoryDreaming);
				player.inventory.clearInventory(null, -1);

				if (GlobalStorage.PLAYER_INVENTORY_STANDARD.containsKey(player)) {
					InventoryPlayer standardInv = GlobalStorage.PLAYER_INVENTORY_STANDARD.get(player);
					player.inventory.copyInventory(standardInv);
				} else {
					player.addChatMessage(new ChatComponentText("You have no saved inventory"));
				}
				Utils.teleport(player, 0);

			}
		}
	}

}
