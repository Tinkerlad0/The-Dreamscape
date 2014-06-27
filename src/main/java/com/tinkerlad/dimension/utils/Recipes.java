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

		Object[] plankRecipe = new Object[]{"X", 'X', DimBlocks.BlockDiamondWood};
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 16), plankRecipe);

		Object[] hardenedWoodRecipe = new Object[]{"XXX", "XYX", "XXX", 'X', DimBlocks.BlockDiamondWood, 'Y', Blocks.planks};
		GameRegistry.addRecipe(new ItemStack(Items.iron_ingot, 2), hardenedWoodRecipe);

		Object[] platinumPickRecipe = new Object[]{"XXX", " S ", " S ", 'X', DimItem.platinumIngot, 'S', Items.stick};
		GameRegistry.addShapedRecipe(new ItemStack(DimItem.pickPlatinum), platinumPickRecipe);

		Object[] platinumSpadeRecipe = new Object[]{" X ", " S ", " S ", 'X', DimItem.platinumIngot, 'S', Items.stick};
		GameRegistry.addShapedRecipe(new ItemStack(DimItem.spadePlatinum), platinumSpadeRecipe);

		Object[] platinumHoeRecipeI = new Object[]{"XX ", " S ", " S ", 'X', DimItem.platinumIngot, 'S', Items.stick};
		GameRegistry.addShapedRecipe(new ItemStack(DimItem.hoePlatinum), platinumHoeRecipeI);

		Object[] platinumHoeRecipeII = new Object[]{" XX", " S ", " S ", 'X', DimItem.platinumIngot, 'S', Items.stick};
		GameRegistry.addShapedRecipe(new ItemStack(DimItem.hoePlatinum), platinumHoeRecipeII);

		Object[] platinumAxeRecipeI = new Object[]{" XX", " SX", " S ", 'X', DimItem.platinumIngot, 'S', Items.stick};
		GameRegistry.addShapedRecipe(new ItemStack(DimItem.axePlatinum), platinumAxeRecipeI);

		Object[] platinumAxeRecipeII = new Object[]{"XX ", "XS ", " S ", 'X', DimItem.platinumIngot, 'S', Items.stick};
		GameRegistry.addShapedRecipe(new ItemStack(DimItem.axePlatinum), platinumAxeRecipeII);

		Object[] platinumSwordRecipe = new Object[]{"X", "X", "S", 'X', DimItem.platinumIngot, 'S', Items.stick};
		GameRegistry.addShapedRecipe(new ItemStack(DimItem.swordPlatinum, 1), platinumSwordRecipe);

		addFurnace();

		LogHelper.log(Level.INFO, "Added Recipes");
	}

	public static void addFurnace() {
		GameRegistry.addSmelting(DimBlocks.BlockPlatinumOre, new ItemStack(DimItem.platinumIngot, 1), 1F);
	}
}
