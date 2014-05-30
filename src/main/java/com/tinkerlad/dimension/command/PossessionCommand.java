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

package com.tinkerlad.dimension.command;

import com.tinkerlad.dimension.reference.ModInfo;
import com.tinkerlad.dimension.utils.Utils;
import com.tinkerlad.dimension.world.Dimension;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

import java.util.Hashtable;

public class PossessionCommand extends CommandBase {

	@Override
	public String getCommandName() {

		return ModInfo.ID;
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {

		return "/" + getCommandName();
	}

	@Override
	public void processCommand(ICommandSender sender, String[] arguments) {

		if (arguments.length <= 0) {
			throw new WrongUsageException("Type '" + this.getCommandUsage(sender) + " help" + "' for help.");
		}

		if (arguments[0].matches("version")) {
			commandVersion(sender, arguments);
			return;
		} else if (arguments[0].matches("help")) {
			sender.addChatMessage(new ChatComponentText("Format: '" + this.getCommandName() + " <command> <arguments>'"));
			sender.addChatMessage(new ChatComponentText("Available commands:"));
			sender.addChatMessage(new ChatComponentText("- version : Version information."));
			sender.addChatMessage(new ChatComponentText("- dream : travel to Dreamscape."));
			sender.addChatMessage(new ChatComponentText("- nightmare : Travel to Nightmare Realm."));
			return;
		} else if (arguments[0].matches("dream")) {
			if (sender instanceof EntityPlayer) {
				Utils.teleport((EntityPlayer) sender, Dimension.dreamID);
				return;
			}
		} else if (arguments[0].matches("nightmare")) {
			if (sender instanceof EntityPlayer) {
				Utils.teleport((EntityPlayer) sender, Dimension.nightmareID);
				return;
			}
		} else if (arguments[0].matches("tps")) {
			MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();

			Hashtable<Integer, long[]> worldTickTimes = server.worldTickTimes;
			for (Integer i : worldTickTimes.keySet()) {
				String dimName = i.toString();
				try {
					dimName = server.worldServerForDimension(i).provider.getDimensionName();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

				double tickMS = Math.round(avgTick(worldTickTimes.get(i)) * 1.0E-5D) / 10d;
				double tickPct = (tickMS < 50) ? 100d : Math.round(50d / tickMS * 1000) / 10d;
				double tps = (tickMS < 50) ? 20d : Math.round((1000d / tickMS) * 10d) / 10d;
				sender.addChatMessage(new ChatComponentText(textColor(tps) + dimName + " tick: " + tps + " tps (" + tickMS + "ms, " + tickPct + "%)"));

				return;
			}
		}

		throw new WrongUsageException(this.getCommandUsage(sender));
	}

	private double avgTick(long[] serverTickArray) {

		long sum = 0L;
		long[] svTicks = serverTickArray;
		int size = serverTickArray.length;

		for (int i = 0; i < size; i++) { sum += svTicks[i]; }

		return (double) sum / (double) size;
	}

	private String textColor(double tps) {

		if (tps >= 15) { return "\u00a72"; } else if (tps >= 10 && tps < 15) { return "\u00a7e"; } else {
			return "\u00a74";
		}
	}

	private void commandVersion(ICommandSender sender, String[] arguments) {

		sender.addChatMessage(new ChatComponentText("Version" + " " + ModInfo.VERSION + " " + ModInfo.RELEASE));
	}
}
