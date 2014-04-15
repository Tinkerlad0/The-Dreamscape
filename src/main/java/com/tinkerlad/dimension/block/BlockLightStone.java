package com.tinkerlad.dimension.block;



import net.minecraft.block.material.Material;

import com.tinkerlad.dimension.reference.BlockInfo;

public class BlockLightStone extends BlockGeneric {

	public BlockLightStone() {
		super(Material.rock);
		setHardness(1F);
		setResistance(1F);
		setStepSound(soundTypeStone);
		setBlockName(BlockInfo.LIGHTSTONE_ULOCALIZED_NAME);
		setBlockTextureName(BlockInfo.TEXTURE_LOCATION + BlockInfo.LIGHTSTONE_TEXTURE);
	}
}
