package com.tinkerlad.dimension.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.tinkerlad.dimension.block.BlockDimBed;
import com.tinkerlad.dimension.block.DimBlocks;
import com.tinkerlad.dimension.reference.ItemInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBed extends ItemPossession {

	public ItemBed() {

		super();
		setMaxStackSize(4);
		setUnlocalizedName(ItemInfo.LEG_UNLOCALIZED_NAME);
		setTextureName(ItemInfo.TEXTURE_LOCATION + ItemInfo.BED_ICON);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {

		this.itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ItemInfo.BED_ICON);
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int posX, int posY, int posZ, int side, float floatX, float floatY, float floatZ) {
		System.out.println(side);
		if (world.isRemote) {
			return true;
		} else if (side != 1) {
			return false;
		} else {
			++posY;
			BlockDimBed blockbed = (BlockDimBed) DimBlocks.BlockDimBed;
			int i1 = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			byte b0 = 0;
			byte b1 = 0;

			if (i1 == 0) {
				b1 = 1;
			}

			if (i1 == 1) {
				b0 = -1;
			}

			if (i1 == 2) {
				b1 = -1;
			}

			if (i1 == 3) {
				b0 = 1;
			}

			if (player.canPlayerEdit(posX, posY, posZ, side, stack) && player.canPlayerEdit(posX + b0, posY, posZ + b1, side, stack)) {
				if (world.isAirBlock(posX, posY, posZ) && world.isAirBlock(posX + b0, posY, posZ + b1) && World.doesBlockHaveSolidTopSurface(world, posX, posY - 1, posZ)
						&& World.doesBlockHaveSolidTopSurface(world, posX + b0, posY - 1, posZ + b1)) {
					world.setBlock(posX, posY, posZ, blockbed, i1, 3);

					if (world.getBlock(posX, posY, posZ) == blockbed) {
						world.setBlock(posX + b0, posY, posZ + b1, blockbed, i1 + 8, 3);
					}

					--stack.stackSize;
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}

}
