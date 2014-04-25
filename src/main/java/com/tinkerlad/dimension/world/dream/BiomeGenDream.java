package com.tinkerlad.dimension.world.dream;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.tinkerlad.dimension.block.DimBlocks;

public class BiomeGenDream extends BiomeGenBase {
	public BiomeGenDream(int par1) {
		super(par1);
		this.spawnableCreatureList.clear();
		this.topBlock = Blocks.grass;
		this.fillerBlock = DimBlocks.BlockLightStone;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.setColor(0xFFFFFF);
		this.theBiomeDecorator.cactiPerChunk = 0;
		this.theBiomeDecorator.deadBushPerChunk = 0;
		this.theBiomeDecorator.clayPerChunk = 5;
		this.theBiomeDecorator.treesPerChunk = 2;
		this.setHeight(new BiomeGenBase.Height(-0.5F, 2F));


	}

	public void genTerrainBlocks(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
		Block block = this.topBlock;
		byte b0 = (byte) (this.field_150604_aj & 255);
		Block block1 = this.fillerBlock;
		int k = -1;
		int l = (int) (p_150573_7_ / 3.0D + 3.0D + p_150573_2_.nextDouble() * 0.25D);
		int i1 = p_150573_5_ & 15;
		int j1 = p_150573_6_ & 15;
		int k1 = p_150573_3_.length / 256;

		for (int l1 = 255; l1 >= 0; --l1) {
			int i2 = (j1 * 16 + i1) * k1 + l1;

			if (l1 <= 0 + p_150573_2_.nextInt(5)) {
				p_150573_3_[i2] = Blocks.bedrock;
			} else {
				Block block2 = p_150573_3_[i2];

				if (block2 != null && block2.getMaterial() != Material.air) {
					if (block2 == DimBlocks.BlockLightStone) {
						if (k == -1) {
							if (l <= 0) {
								block = null;
								b0 = 0;
								block1 = Blocks.stone;
							} else if (l1 >= 59 && l1 <= 64) {
								block = this.topBlock;
								b0 = (byte) (this.field_150604_aj & 255);
								block1 = this.fillerBlock;
							}

							if (l1 < 63 && (block == null || block.getMaterial() == Material.air)) {
								if (this.getFloatTemperature(p_150573_5_, l1, p_150573_6_) < 0.15F) {
									block = Blocks.ice;
									b0 = 0;
								} else {
									block = Blocks.water;
									b0 = 0;
								}
							}

							k = l;

							if (l1 >= 62) {
								p_150573_3_[i2] = block;
								p_150573_4_[i2] = b0;
							} else if (l1 < 56 - l) {
								block = null;
								block1 = DimBlocks.BlockLightStone;
								p_150573_3_[i2] = Blocks.gravel;
							} else {
								p_150573_3_[i2] = block1;
							}
						} else if (k > 0) {
							--k;
							p_150573_3_[i2] = block1;

							if (k == 0 && block1 == Blocks.sand) {
								k = p_150573_2_.nextInt(4) + Math.max(0, l1 - 63);
								block1 = DimBlocks.BlockLightStone;
							}
						}
					}
				} else {
					k = -1;
				}
			}
		}
	}
}