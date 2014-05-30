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

package com.tinkerlad.dimension.tileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Michael on 5/27/2014.
 */
public class TileGlobalStorage extends TileEntity {

	public static Map<String, InventoryPlayer> PLAYER_INVENTORY_STANDARD;
	public static Map<String, InventoryPlayer> PLAYER_INVENTORY_DREAMING;

	public boolean putInventory(int map, EntityPlayer player) {

		switch (map) {
			case 0://Storing Standard Inventory
				InventoryPlayer inventoryPlayer = new InventoryPlayer(player);
				inventoryPlayer.copyInventory(player.inventory);
				PLAYER_INVENTORY_STANDARD.put(player.getDisplayName(), inventoryPlayer);
				return true;
			case 1://Storing Dreamers Inventory
				InventoryPlayer inventoryPlayerDreaming = new InventoryPlayer(player);
				inventoryPlayerDreaming.copyInventory(player.inventory);
				PLAYER_INVENTORY_DREAMING.put(player.getDisplayName(), inventoryPlayerDreaming);
				return true;
			default:
				return false;
		}
	}

	public InventoryPlayer getInventory(int map, EntityPlayer player) {
		switch (map) {
			case 0://Get Standard Inventory
				if (PLAYER_INVENTORY_STANDARD.containsKey(player)) {
					return PLAYER_INVENTORY_STANDARD.get(player);
				} else {
					return null;
				}
			case 1:
				if (PLAYER_INVENTORY_DREAMING.containsKey(player)) {
					return PLAYER_INVENTORY_DREAMING.get(player);
				} else {
					return null;
				}
			default:
				return null;
		}
	}

	public void saveToFile(NBTTagCompound nbt) throws IOException {
		File file = new File("E:/test.dat");

		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream output = new FileOutputStream(file);
		CompressedStreamTools.writeCompressed(nbt, output);
		output.close();
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);


		for (Map.Entry<String, InventoryPlayer> entry : PLAYER_INVENTORY_STANDARD.entrySet()) {
			String entityPlayer = entry.getKey();
			InventoryPlayer inventoryPlayer = entry.getValue();
			NBTTagList list = new NBTTagList();

			for (int i = 0; i < inventoryPlayer.getSizeInventory(); i++) {
				if (inventoryPlayer.getStackInSlot(i) != null) {
					NBTTagCompound tag = new NBTTagCompound();
					tag.setByte("Slot", (byte) i);
					inventoryPlayer.getStackInSlot(i).writeToNBT(tag);
					list.appendTag(tag);
				}
			}

			nbt.setTag(entityPlayer, list);
		}

		for (Map.Entry<String, InventoryPlayer> entry : PLAYER_INVENTORY_DREAMING.entrySet()) {
			String entityPlayer = entry.getKey();
			InventoryPlayer inventoryPlayer = entry.getValue();
			NBTTagList list = new NBTTagList();

			for (int i = 0; i < inventoryPlayer.getSizeInventory(); i++) {
				if (inventoryPlayer.getStackInSlot(i) != null) {
					NBTTagCompound tag = new NBTTagCompound();
					tag.setByte("Slot", (byte) i);
					inventoryPlayer.getStackInSlot(i).writeToNBT(tag);
					list.appendTag(tag);
				}
			}

			nbt.setTag(entityPlayer + "_dream", list);
		}
		try {
			saveToFile(nbt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
