package com.tinkerlad.dimension.block.nightmare;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.tinkerlad.dimension.block.BlockGeneric;
import com.tinkerlad.dimension.block.DimBlocks;
import com.tinkerlad.dimension.reference.BlockInfo;

public class BlockHardenedOre extends BlockGeneric {

	public BlockHardenedOre() {

		super(Material.iron);
		this.lightValue = 8;
		setBlockName(BlockInfo.HARDENED_ORE_ULOCALIZED_NAME);
		setBlockTextureName(BlockInfo.TEXTURE_LOCATION + BlockInfo.HARDENED_ORE_TEXTURE);
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, int xPos, int yPos, int zPos, Explosion explosion) {

		world.setBlock(xPos, yPos, zPos, DimBlocks.BlockRubyOre);

	}

	@Override
	public int quantityDropped(Random random) {

		return 0;
	}

}
