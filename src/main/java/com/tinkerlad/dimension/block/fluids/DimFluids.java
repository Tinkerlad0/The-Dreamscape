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

package com.tinkerlad.dimension.block.fluids;

import com.tinkerlad.dimension.reference.BlockInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by Michael on 5/18/2014.
 */
public class DimFluids {

	public static Fluid FluidDreamWater;
	public static Block BlockFluidDreamWater;

	private static Fluid dreamWater;


	public static void init(){

		//DreamWater
		dreamWater = new Fluid("dream_water").setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(dreamWater);
		FluidDreamWater = FluidRegistry.getFluid("dream_water");

		if (FluidDreamWater.getBlock() == null) {
			BlockFluidDreamWater = new FluidGeneric(FluidDreamWater, Material.water).setFlammable(false).setFlammability(0);
			BlockFluidDreamWater.setBlockName(BlockInfo.DREAMWATER_ULOCALIZED_NAME);
			GameRegistry.registerBlock(BlockFluidDreamWater, BlockInfo.DREAMWATER_ULOCALIZED_NAME);
			FluidDreamWater.setBlock(BlockFluidDreamWater);
		} else {
			BlockFluidDreamWater = FluidDreamWater.getBlock();
		}




	}

}
