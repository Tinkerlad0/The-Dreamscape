package com.tinkerlad.dimension.GUI;

import net.minecraft.client.gui.GuiScreen;

import java.util.HashMap;
import java.util.Map;

public class GuiManual extends GuiScreen {

	public static final int GUI_ID = 1;
	public static Map<Integer, String> page1 = new HashMap<Integer, String>();
	public static Map<Integer, String> page2 = new HashMap<Integer, String>();
	public static Map<Integer, String> page3 = new HashMap<Integer, String>();

	public GuiManual() {
		page1.put(0, "The Dreamscape");
		page1.put(2, "No longer are any of you dreams safe...");
		page1.put(3, "You cannot hope to rest in peace any longer");
		page1.put(4, "Each night when you sleep nightmares will haunt you");
		page1.put(5, "No matter how many times you die in your nightmare");
		page1.put(6, "...you will not wake up; until sunrise..");
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		textSplit(page1);
	}

	public void textSplit(Map<Integer, String> para) {
		int spacing = ((int) (this.height * 0.8) / 15);
		int x = this.width / 8;

		//Page Header

		fontRendererObj.drawStringWithShadow(para.get(0), x, spacing, 0xff0000);

		for (int line = 1; line < 16; line++) {
			if (para.get(line) != null) {
				fontRendererObj.drawStringWithShadow(para.get(line), x, ((line + 1) * spacing), 0xffffff);
			}
		}
	}
}
