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

import com.tinkerlad.dimension.logging.LogHelper;
import com.tinkerlad.dimension.reference.ItemInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Level;

public class DimItem {

	public static Item debug;
	public static Item leg;
	public static Item rubyGem;

	public static void init() {

		LogHelper.log(Level.INFO, "Preparing items");

		debug = new ItemDebug().setUnlocalizedName(ItemInfo.DEBUG_UNLOCALIZED_NAME);
		leg = new ItemBedLeg().setUnlocalizedName(ItemInfo.LEG_UNLOCALIZED_NAME);
		rubyGem = new ItemRuby().setUnlocalizedName(ItemInfo.RUBY_UNLOCALIZED_NAME);

		GameRegistry.registerItem(debug, ItemInfo.DEBUG_UNLOCALIZED_NAME);
		GameRegistry.registerItem(leg, ItemInfo.LEG_UNLOCALIZED_NAME);
		GameRegistry.registerItem(rubyGem, ItemInfo.RUBY_UNLOCALIZED_NAME);

		OreDictionary.registerOre("legBed", leg);
		OreDictionary.registerOre("gemRuby", rubyGem);


		LogHelper.log(Level.INFO, "Items Loaded");
	}
}
