package com.tinkerlad.dimension.item;

import com.tinkerlad.dimension.reference.ItemInfo;

/**
 * Created by Michael on 6/14/2014.
 */
public class ItemPlatinum extends ItemGeneric {

	public ItemPlatinum() {
		super();
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.PLATINUM_UNLOCALIZED_NAME);
		setTextureName(ItemInfo.TEXTURE_LOCATION + ItemInfo.PLATINUM_ICON);
	}
}
