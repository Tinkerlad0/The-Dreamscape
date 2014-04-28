package com.tinkerlad.dimension.block.ore;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.tinkerlad.dimension.block.BlockGeneric;
import com.tinkerlad.dimension.item.DimItem;
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

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {

		return DimItem.rubyGem;
	}

}
