package com.tinkerlad.dimension.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.tinkerlad.dimension.reference.BlockInfo;

public class BlockDebug extends BlockGeneric {

	public BlockDebug() {
		super(Material.iron);
		setHardness(4F);
		setResistance(2F);
		setStepSound(soundTypeMetal);
		setBlockName(BlockInfo.DEBUG_ULOCALIZED_NAME);
		setBlockTextureName(BlockInfo.TEXTURE_LOCATION + BlockInfo.DEBUG_TEXTURE);
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {

    	
        return false;
    }

}
