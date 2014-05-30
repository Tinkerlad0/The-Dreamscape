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

package com.tinkerlad.dimension.block.fluids;

import com.tinkerlad.dimension.creativeTab.TabItems;
import com.tinkerlad.dimension.reference.BlockInfo;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityDropParticleFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import java.util.Random;

/**
 * Created by Michael on 5/18/2014.
 */
public class FluidGeneric extends BlockFluidClassic {

	@SideOnly(Side.CLIENT)
	protected IIcon[] theIcon;
	protected boolean flammable;
	protected int flammability = 0;

	public FluidGeneric(Fluid fluid, Material material) {
		super(fluid, material);
		setCreativeTab(TabItems.tabPossession);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return side != 0 && side != 1 ? this.theIcon[1] : this.theIcon[0];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		super.randomDisplayTick(world, x, y, z, rand);

		if (rand.nextInt(10) == 0
				    && World.doesBlockHaveSolidTopSurface(world, x, y - 1, z)
				    && !world.getBlock(x, y - 2, z).getMaterial().blocksMovement()) {

			double px = x + rand.nextFloat();
			double py = y - 1.05D;
			double pz = z + rand.nextFloat();

			EntityFX fx = new EntityDropParticleFX(world, px, py, pz, this.blockMaterial);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(fx);
		}
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (true){//!world.isRemote) {
			if (fluidName == "dream_water") {
				if (entity instanceof EntityPlayer) {
					EntityPlayer player = ((EntityPlayer) entity);
					player.addPotionEffect(new PotionEffect(1, 600, 3));
					player.addPotionEffect(new PotionEffect(6, 20,1));
					player.addPotionEffect(new PotionEffect(8,600, 4));
				}
			} else {
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.theIcon = new IIcon[]{iconRegister.registerIcon(BlockInfo.TEXTURE_LOCATION + fluidName + "_still"),
				                          iconRegister.registerIcon(BlockInfo.TEXTURE_LOCATION + fluidName + "_flow")};
	}

	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return flammability;
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return flammable;
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return flammable ? 300 : 0;
	}

	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
		return flammable && flammability == 0;
	}

	public FluidGeneric setFlammable(boolean flammable) {
		this.flammable = flammable;
		return this;
	}

	public FluidGeneric setFlammability(int flammability) {
		this.flammability = flammability;
		return this;
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
			return false;
		}
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
			return false;
		}
		return super.displaceIfPossible(world, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		super.onNeighborBlockChange(world, x, y, z, block);
		if (flammable && world.provider.dimensionId == -1) {
			world.newExplosion(null, x, y, z, 4F, true, true);
			world.setBlockToAir(x, y, z);
		}
	}
}
