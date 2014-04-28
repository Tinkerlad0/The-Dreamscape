package com.tinkerlad.dimension.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class DimensionGenerator implements IWorldGenerator {

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		switch (world.provider.dimensionId) {
			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16);
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
			case 1:
				generateEnd(world, random, chunkX * 16, chunkZ * 16);
			case 36:
				generateDream(world, random, chunkX * 16, chunkZ * 16);
			case 37:
				generateNightmare(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateNightmare(World world, Random random, int i, int j) {


	}

	private void generateDream(World world, Random random, int x, int z) {

	}

	private void generateEnd(World world, Random random, int i, int j) {


	}

	public void generateSurface(World world, Random random, int blockX, int blockZ) {

	}

	public void generateNether(World world, Random random, int blockX, int blockZ) {

	}

}