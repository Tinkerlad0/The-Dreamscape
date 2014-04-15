package com.tinkerlad.dimension.item;

import net.minecraft.client.renderer.texture.IIconRegister;

import com.tinkerlad.dimension.reference.ItemInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRuby extends ItemPossession {

	public ItemRuby() {
		super();
		setMaxStackSize(4);
		setUnlocalizedName(ItemInfo.RUBY_UNLOCALIZED_NAME);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {

		this.itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION
				+ ItemInfo.RUBY_ICON);
	}
}
