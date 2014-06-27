package com.tinkerlad.dimension.GUI;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Michael on 6/16/2014.
 */
public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			default:
				return null;

			case GuiManual.GUI_ID:
				return new GuiManual();

			case GUIEmpty.GUI_ID:
				return new GUIEmpty();
		}
	}
}
