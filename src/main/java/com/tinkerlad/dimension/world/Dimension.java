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

package com.tinkerlad.dimension.world;

import com.tinkerlad.dimension.world.dream.BiomeGenDream;
import com.tinkerlad.dimension.world.dream.WorldProviderDream;
import com.tinkerlad.dimension.world.nightmare.BiomeGenNightmare;
import com.tinkerlad.dimension.world.nightmare.StructureMineshaftPiecesNightmare;
import com.tinkerlad.dimension.world.nightmare.StructureMineshaftStartNightmare;
import com.tinkerlad.dimension.world.nightmare.WorldProviderNightmare;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;

public class Dimension {

	public static BiomeGenBase nightmare = new BiomeGenNightmare(52).setBiomeName("NightMare");
	public static BiomeGenBase dreamscape = new BiomeGenDream(53).setBiomeName("The DreamScape");
	public static int nightmareID = 36;
	public static int dreamID = 37;

	public static void init() {

		// Nightmare
		MapGenStructureIO.registerStructure(StructureMineshaftStartNightmare.class, "NightMare-Mineshaft");
		StructureMineshaftPiecesNightmare.registerStructurePieces();

		GameRegistry.registerWorldGenerator(new DimensionGenerator(), 0);

		DimensionManager.registerProviderType(Dimension.nightmareID, WorldProviderNightmare.class, false);
		DimensionManager.registerDimension(Dimension.nightmareID, Dimension.nightmareID);

		// Dream
		DimensionManager.registerProviderType(Dimension.dreamID, WorldProviderDream.class, false);
		DimensionManager.registerDimension(Dimension.dreamID, Dimension.dreamID);
	}
}
