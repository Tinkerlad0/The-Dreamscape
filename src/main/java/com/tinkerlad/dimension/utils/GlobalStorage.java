package com.tinkerlad.dimension.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class GlobalStorage {

	public static boolean								DREAM	= true;

	public static String								SAVE_DIR;

	public static Map<EntityPlayer, InventoryPlayer>	PLAYER_INVENTORY_STANDARD;
	public static Map<EntityPlayer, InventoryPlayer>	PLAYER_INVENTORY_DREAMING;

	public static void init(File cfg) throws ClassNotFoundException, IOException {

		SAVE_DIR = cfg.getParent() + "/tnkpos_inv";

		// INIT PLAYER INVENTORY STORAGES
		PLAYER_INVENTORY_STANDARD = new HashMap<EntityPlayer, InventoryPlayer>();
		PLAYER_INVENTORY_DREAMING = new HashMap<EntityPlayer, InventoryPlayer>();
		readFromFile();

	}

	public static boolean saveToFile() throws IOException {

		SerializeToFile.serialize(PLAYER_INVENTORY_STANDARD, SAVE_DIR);
		return true;
	}

	@SuppressWarnings("unchecked")
	public static boolean readFromFile() throws IOException {

		return true;

	}

}
