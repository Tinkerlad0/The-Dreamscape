package com.tinkerlad.dimension.reference;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by Michael on 6/15/2014.
 */
public class ToolInfo {

	public static final String TEXTURE_LOCATION = "tnkpos:";

	public static final Item.ToolMaterial PLATINUM = EnumHelper.addToolMaterial("PLATINUM", 4, 500, 8.0F, 5.5F, 50);

	public static final String PLATINUM_AXE_NAME = "platinumAxe";
	public static final String PLATINUM_PICK_NAME = "platinumPick";
	public static final String PLATINUM_SPADE_NAME = "platinumSpade";
	public static final String PLATINUM_HOE_NAME = "platinumHoe";
	public static final String PLATINUM_SWORD_NAME = "platinumSword";
}
