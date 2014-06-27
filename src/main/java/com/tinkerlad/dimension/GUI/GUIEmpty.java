package com.tinkerlad.dimension.GUI;

import net.minecraft.client.gui.GuiScreen;

public class GUIEmpty extends GuiScreen {

	public static final int GUI_ID = 2;

	public GUIEmpty() {

	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
