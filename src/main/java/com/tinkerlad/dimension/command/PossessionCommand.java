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

import com.tinkerlad.dimension.reference.ModInfo;

public class PossessionCommand extends CommandBase {

	private void commandVersion(ICommandSender sender, String[] arguments) {

		// sender.sendChatToPlayer(ChatMessageComponent.createFromText(String
		// .format(colour + "Possession Verion " + ModInfo.VERSION)));

	}

	@Override
	public String getCommandName() {

		return ModInfo.NAME;
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {

		return "/" + getCommandName();
	}

	@Override
	public void processCommand(ICommandSender sender, String[] arguments) {

		commandVersion(sender, arguments);
		return;

	}

}
