package com.tinkerlad.dimension.block.bed;

import com.tinkerlad.dimension.block.BlockGeneric;
import com.tinkerlad.dimension.reference.BlockInfo;
import net.minecraft.block.material.Material;

/**
 * Created by Michael on 6/10/2014.
 */
public class BlockBed1 extends BlockGeneric {

	public BlockBed1() {
		super(Material.cloth);
		setHardness(1F);
		setResistance(1F);
		setStepSound(soundTypeStone);
		setBlockName(BlockInfo.BASE_ULOCALIZED_NAME[0]);
		setBlockTextureName(BlockInfo.BASE_TEXTURE[0]);
	}
}
