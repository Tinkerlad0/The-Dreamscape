/******************************************************************************
 * Copyright (c) 2014 Tinkerlad                                               *
 * All rights reserved. This program and the accompanying materials           *
 * are made available under the terms of the GNU Public License v2.0          *
 * which accompanies this distribution, and is available at                   *
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html                      *
 *                                                                            *
 * Contributors:                                                              *
 * 	Tinkerlad - initial concept and implementation                            *
 ******************************************************************************/

package com.tinkerlad.dimension.block.dream;

import com.tinkerlad.dimension.block.BlockGeneric;
import com.tinkerlad.dimension.creativeTab.TabItems;
import com.tinkerlad.dimension.reference.BlockInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import java.util.ArrayList;
import java.util.Random;

public class BlockDiamondLeaves extends BlockGeneric implements IShearable {

	@SideOnly(Side.CLIENT)
	protected int field_150127_b;
	int[] field_150128_a;
	@SideOnly(Side.CLIENT)
	private IIcon opaque;
	@SideOnly(Side.CLIENT)
	private IIcon fancy;

	@SideOnly(Side.CLIENT)

	public BlockDiamondLeaves() {

		super(Material.leaves);
		this.setTickRandomly(true);
		this.setCreativeTab(TabItems.tabPossession);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setStepSound(soundTypeGrass);
		this.setBlockName(BlockInfo.DIA_LEAVES_ULOCALIZED_NAME);
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {

		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {

		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
		return ret;
	}

	@Override
	public boolean renderAsNormalBlock() {

		return false;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {

		return Minecraft.getMinecraft().gameSettings.fancyGraphics ? fancy : opaque;
	}

	public boolean isOpaqueCube() {

		return false;
	}

	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {

	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int xPos, int yPos, int zPos, Random random) {

		int frequency = Minecraft.getMinecraft().gameSettings.fancyGraphics ? 30 : 300;
		if (random.nextInt(frequency) == 0) {
			world.spawnParticle("fireworksSpark", xPos + random.nextDouble(), yPos, zPos + random.nextDouble(), 0, 0 - (random.nextDouble() / 5), 0);
		}
	}

	public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {

	}

	public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_,
	                                      int p_149690_7_) {

	}

	@Override
	protected boolean canSilkHarvest() {

		return true;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {

		this.opaque = register.registerIcon(BlockInfo.TEXTURE_LOCATION + BlockInfo.DIA_LEAVES_TEXTURE[1]);
		this.fancy = register.registerIcon(BlockInfo.TEXTURE_LOCATION + BlockInfo.DIA_LEAVES_TEXTURE[0]);
	}
}