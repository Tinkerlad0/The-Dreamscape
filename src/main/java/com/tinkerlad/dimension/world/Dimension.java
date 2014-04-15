package com.tinkerlad.dimension.world;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;

import com.tinkerlad.dimension.world.dream.BiomeGenDream;
import com.tinkerlad.dimension.world.dream.WorldProviderDream;
import com.tinkerlad.dimension.world.nightmare.BiomeGenNightmare;
import com.tinkerlad.dimension.world.nightmare.StructureMineshaftPiecesNightmare;
import com.tinkerlad.dimension.world.nightmare.StructureMineshaftStartNightmare;
import com.tinkerlad.dimension.world.nightmare.WorldProviderNightmare;

import cpw.mods.fml.common.registry.GameRegistry;

public class Dimension {

	public static BiomeGenBase	nightmare	= new BiomeGenNightmare(52).setBiomeName("NightMare");
	public static BiomeGenBase	dreamscape	= new BiomeGenDream(53).setBiomeName("The DreamScape");
	public static int			nightmareID	= 36;
	public static int			dreamID		= 37;

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
