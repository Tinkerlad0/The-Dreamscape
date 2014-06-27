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

package com.tinkerlad.dimension.item;

import com.tinkerlad.dimension.item.tools.*;
import com.tinkerlad.dimension.logging.LogHelper;
import com.tinkerlad.dimension.reference.ItemInfo;
import com.tinkerlad.dimension.reference.ToolInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Level;

public class DimItem {

	public static Item debug;
	public static Item leg;
	public static Item rubyGem;
	public static Item platinumIngot;

	public static Item axePlatinum;
	public static Item pickPlatinum;
	public static Item spadePlatinum;
	public static Item hoePlatinum;
	public static Item swordPlatinum;

	public static void init() {

		LogHelper.log(Level.INFO, "Preparing items");

		debug = new ItemDebug().setUnlocalizedName(ItemInfo.DEBUG_UNLOCALIZED_NAME);
		leg = new ItemBedLeg().setUnlocalizedName(ItemInfo.LEG_UNLOCALIZED_NAME);
		rubyGem = new ItemRuby().setUnlocalizedName(ItemInfo.RUBY_UNLOCALIZED_NAME);
		platinumIngot = new ItemPlatinum().setUnlocalizedName(ItemInfo.PLATINUM_UNLOCALIZED_NAME);

		GameRegistry.registerItem(debug, ItemInfo.DEBUG_UNLOCALIZED_NAME);
		GameRegistry.registerItem(leg, ItemInfo.LEG_UNLOCALIZED_NAME);
		GameRegistry.registerItem(rubyGem, ItemInfo.RUBY_UNLOCALIZED_NAME);
		GameRegistry.registerItem(platinumIngot, ItemInfo.PLATINUM_UNLOCALIZED_NAME);

		OreDictionary.registerOre("legBed", leg);
		OreDictionary.registerOre("gemRuby", rubyGem);
		OreDictionary.registerOre("ingotPlatinum", platinumIngot);

		initTools();

		LogHelper.log(Level.INFO, "Items Loaded");
	}

	public static void initTools() {

		axePlatinum = new DimensionAxe(ToolInfo.PLATINUM).setUnlocalizedName(ToolInfo.PLATINUM_AXE_NAME)
				              .setTextureName(ToolInfo.TEXTURE_LOCATION + ToolInfo.PLATINUM_AXE_NAME);
		GameRegistry.registerItem(axePlatinum, ToolInfo.PLATINUM_AXE_NAME);

		pickPlatinum = new DimensionPick(ToolInfo.PLATINUM).setUnlocalizedName(ToolInfo.PLATINUM_PICK_NAME)
				               .setTextureName(ToolInfo.TEXTURE_LOCATION + ToolInfo.PLATINUM_PICK_NAME);
		GameRegistry.registerItem(pickPlatinum, ToolInfo.PLATINUM_PICK_NAME);

		hoePlatinum = new DimensionHoe(ToolInfo.PLATINUM).setUnlocalizedName(ToolInfo.PLATINUM_HOE_NAME)
				              .setTextureName(ToolInfo.TEXTURE_LOCATION + ToolInfo.PLATINUM_HOE_NAME);
		GameRegistry.registerItem(hoePlatinum, ToolInfo.PLATINUM_HOE_NAME);

		spadePlatinum = new DimensionShovel(ToolInfo.PLATINUM).setUnlocalizedName(ToolInfo.PLATINUM_SPADE_NAME)
				                .setTextureName(ToolInfo.TEXTURE_LOCATION + ToolInfo.PLATINUM_SPADE_NAME);
		GameRegistry.registerItem(spadePlatinum, ToolInfo.PLATINUM_SPADE_NAME);

		swordPlatinum = new DimensionSword(ToolInfo.PLATINUM).setUnlocalizedName(ToolInfo.PLATINUM_SWORD_NAME)
				                .setTextureName(ToolInfo.TEXTURE_LOCATION + ToolInfo.PLATINUM_SWORD_NAME);
		GameRegistry.registerItem(swordPlatinum, ToolInfo.PLATINUM_SWORD_NAME);
	}
}