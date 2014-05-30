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

import com.tinkerlad.dimension.block.DimBlocks;
import com.tinkerlad.dimension.item.DimItem;
import com.tinkerlad.dimension.logging.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import org.apache.logging.log4j.Level;

public class Recipes {

	public static void addRecipes() {

		LogHelper.log(Level.INFO, "Adding Recipes");

		Object[] legRecipe = new Object[]{" X ", " / ", " Z ", 'X', "plankWood", '/', "stickWood", 'Z', "logWood"};
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(DimItem.leg), legRecipe));

		Object[] plankRecipe = {"X", 'X', DimBlocks.BlockDiamondWood};
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 16), plankRecipe);

		Object[] hardenedWoodRecipe = {"XXX", "XYX", "XXX", 'X', DimBlocks.BlockDiamondWood, 'Y', Blocks.planks};
		GameRegistry.addRecipe(new ItemStack(Items.iron_ingot, 2), hardenedWoodRecipe);

		LogHelper.log(Level.INFO, "Added Recipes");
	}
}
