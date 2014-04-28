package com.tinkerlad.dimension.block.nightmare;

import net.minecraft.block.material.Material;

import com.tinkerlad.dimension.block.BlockGeneric;
import com.tinkerlad.dimension.reference.BlockInfo;

public class BlockBedrockBreakable extends BlockGeneric {

	public BlockBedrockBreakable() {

		super(Material.rock);
		setBlockUnbreakable();
		setBlockName(BlockInfo.BEDROCK_ULOCALIZED_NAME);
		setBlockTextureName(BlockInfo.TEXTURE_LOCATION + BlockInfo.BEDROCK_TEXTURE);
	}

}
