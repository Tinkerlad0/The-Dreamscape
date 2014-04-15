package com.tinkerlad.dimension.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

import com.tinkerlad.dimension.reference.BlockInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPlatinumOre extends BlockGeneric {

	@SideOnly(Side.CLIENT)
	protected IIcon	blockIcon;

	public BlockPlatinumOre() {
		super(Material.rock);
		setHardness(4F);
		setResistance(2F);
		setStepSound(soundTypeStone);
		setBlockName(BlockInfo.PLATINUM_ULOCALIZED_NAME);
		setBlockTextureName(BlockInfo.TEXTURE_LOCATION + BlockInfo.PLATINUM_TEXTURE);
	}

}
