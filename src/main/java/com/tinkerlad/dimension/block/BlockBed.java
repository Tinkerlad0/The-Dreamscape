package com.tinkerlad.dimension.block;

import com.tinkerlad.dimension.reference.BlockInfo;
import com.tinkerlad.dimension.tileEntities.TileBed;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockBed extends BlockGeneric {

	@SideOnly(Side.CLIENT)
	private IIcon bottom;
	@SideOnly(Side.CLIENT)
	private IIcon top;
	public BlockBed() {
		super(Material.cloth);
		setHardness(1F);
		setResistance(1F);
		setStepSound(soundTypeStone);
		setBlockName(BlockInfo.BED_ULOCALIZED_NAME);
	}

	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 0 ? this.bottom : (side == 1 ? this.top : this.blockIcon);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		this.blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + BlockInfo.BED_TEXTURE[2]);
		this.top = register.registerIcon(BlockInfo.TEXTURE_LOCATION + BlockInfo.BED_TEXTURE[1]);
		this.bottom = register.registerIcon(BlockInfo.TEXTURE_LOCATION + BlockInfo.BED_TEXTURE[0]);
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		return new TileBed(world);
	}
}
