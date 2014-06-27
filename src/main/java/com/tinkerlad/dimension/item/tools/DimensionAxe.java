package com.tinkerlad.dimension.item.tools;

import com.tinkerlad.dimension.creativeTab.TabItems;
import net.minecraft.item.ItemAxe;

/**
 * Created by Michael on 6/15/2014.
 */
public class DimensionAxe extends ItemAxe {

	public DimensionAxe(ToolMaterial material) {
		super(material);
		setCreativeTab(TabItems.tabPossession);
	}
}
