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

package com.tinkerlad.dimension.world.nightmare;

import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenMineshaftNightmare extends MapGenStructure {

	public String func_143025_a() {
		return "Mineshaft";
	}

	protected boolean canSpawnStructureAtCoords(int par1, int par2) {
		return this.rand.nextInt(100) == 0 && this.rand.nextInt(80) < Math.max(Math.abs(par1), Math.abs(par2));
	}

	protected StructureStart getStructureStart(int par1, int par2) {
		return new StructureMineshaftStartNightmare(this.worldObj, this.rand, par1, par2);
	}
}
