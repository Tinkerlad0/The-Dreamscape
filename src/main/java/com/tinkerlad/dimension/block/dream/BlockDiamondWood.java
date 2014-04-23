package com.tinkerlad.dimension.block.dream;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import com.tinkerlad.dimension.block.BlockGeneric;
import com.tinkerlad.dimension.reference.BlockInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDiamondWood extends BlockGeneric {

	@SideOnly(Side.CLIENT)
	private IIcon	top;
	@SideOnly(Side.CLIENT)
	private IIcon	side;

	public BlockDiamondWood() {

		super(Material.wood);
		this.setHardness(5.0F);
		this.setStepSound(soundTypeWood);
		this.setBlockName(BlockInfo.DIA_WOOD_ULOCALIZED_NAME);

	}

	public int quantityDropped(Random p_149745_1_) {

		return 1;
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {

		return Item.getItemFromBlock(this);
	}

	@Override
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {

		return true;
	}

	@Override
	public boolean isWood(IBlockAccess world, int x, int y, int z) {

		return true;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {

		this.top = register.registerIcon(BlockInfo.TEXTURE_LOCATION + BlockInfo.DIA_WOOD_TEXTURE[1]);
		this.side = register.registerIcon(BlockInfo.TEXTURE_LOCATION + BlockInfo.DIA_WOOD_TEXTURE[0]);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {

		if (side == 0 || side == 1) {
			// top or bottom
			return this.top;
		} else {
			return this.side;
		}
	}

}
