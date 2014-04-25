/*******************************************************************************
 * Copyright (c) 2013 Tinkerlad
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Tinkerlad - initial concept and implementation
 ******************************************************************************/
package com.tinkerlad.dimension.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import com.tinkerlad.dimension.reference.ModInfo;
import com.tinkerlad.dimension.utils.Utils;
import com.tinkerlad.dimension.world.Dimension;

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

		if (arguments.length <= 0)
			throw new WrongUsageException("Type '" + this.getCommandUsage(sender) + " help" + "' for help.");

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
		}

		throw new WrongUsageException(this.getCommandUsage(sender));
	}

	private void commandVersion(ICommandSender sender, String[] arguments) {

		sender.addChatMessage(new ChatComponentText("Version" + " " + ModInfo.VERSION + " " + ModInfo.RELEASE));

	}


}
