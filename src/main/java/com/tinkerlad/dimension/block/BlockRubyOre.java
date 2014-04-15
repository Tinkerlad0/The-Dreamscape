package com.tinkerlad.dimension.block;

import java.util.Random;

import net.minecraft.block.material.Material;

import com.tinkerlad.dimension.reference.BlockInfo;

public class BlockRubyOre extends BlockGeneric {

	public BlockRubyOre() {
		super(Material.rock);
		setHardness(3F);
		setResistance(6F);
		setStepSound(soundTypeStone);
		setBlockName(BlockInfo.RUBY_ULOCALIZED_NAME);
		setBlockTextureName(BlockInfo.TEXTURE_LOCATION + BlockInfo.RUBY_TEXTURE);
		
	}


	@Override
	public int quantityDropped(Random random) {
		return 1 + random.nextInt(4);
	}

}
