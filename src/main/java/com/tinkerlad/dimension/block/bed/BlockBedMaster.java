package com.tinkerlad.dimension.block.bed;

import com.tinkerlad.dimension.block.BlockGeneric;
import com.tinkerlad.dimension.reference.BlockInfo;
import com.tinkerlad.dimension.tileEntities.TileBedMaster;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Michael on 6/10/2014.
 */
public class BlockBedMaster extends BlockGeneric implements ITileEntityProvider {

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon side;

	public BlockBedMaster() {
		super(Material.cloth);
		setHardness(1F);
		setResistance(1F);
		setStepSound(soundTypeStone);
		setBlockName(BlockInfo.MASTER_ULOCALIZED_NAME);
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

	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer player) {
		System.out.println(par2 + " " + par3 + " " + par4);
		TileEntity tile = par1World.getTileEntity(par2, par3, par4);
		if (tile instanceof TileBedMaster) {
			TileBedMaster BedTile = (TileBedMaster) tile;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		this.top = register.registerIcon(BlockInfo.TEXTURE_LOCATION + BlockInfo.MASTER_TEXTURE[1]);
		this.side = register.registerIcon(BlockInfo.TEXTURE_LOCATION + BlockInfo.MASTER_TEXTURE[0]);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileBedMaster();
	}
}
