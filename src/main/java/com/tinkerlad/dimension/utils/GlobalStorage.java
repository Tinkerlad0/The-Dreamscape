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

package com.tinkerlad.dimension.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.nbt.NBTTagCompound;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GlobalStorage {

	public static boolean DREAM = true;

	public static String SAVE_DIR;

	public static Map<EntityPlayer, InventoryPlayer> PLAYER_INVENTORY_STANDARD;
	public static Map<EntityPlayer, Integer> PLAYER_STANDARD_TIME;
	public static Map<EntityPlayer, InventoryPlayer> PLAYER_INVENTORY_DREAMING;

	public GlobalStorage(File cfg) throws ClassNotFoundException, IOException {

		SAVE_DIR = cfg.getParent() + "/tnkpos_inv";

		// INIT PLAYER INVENTORY STORAGES
		PLAYER_INVENTORY_STANDARD = new HashMap<EntityPlayer, InventoryPlayer>();
		PLAYER_STANDARD_TIME = new HashMap<EntityPlayer, Integer>();
		PLAYER_INVENTORY_DREAMING = new HashMap<EntityPlayer, InventoryPlayer>();
		readFromFile();
	}

	public static boolean saveToFile() throws IOException {

		NBTTagCompound nbt = new NBTTagCompound();


		return true;
	}

	public static boolean readFromFile() throws IOException {

		return true;
	}
}
