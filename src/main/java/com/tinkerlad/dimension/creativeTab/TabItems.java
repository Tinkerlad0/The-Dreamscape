/*******************************************************************************
 * Copyright (c) 2013 Tinkerlad
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * Contributors:
 *     Tinkerlad - initial concept and implementation
 ******************************************************************************/
package com.tinkerlad.dimension.creativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TabItems extends CreativeTabs {

	public static final CreativeTabs tabPossession = new TabItems("The Dimension");

	public TabItems(String name) {

		super(name);
	}

	@Override
	public String getTranslatedTabLabel() {

		return "The Dimension";
	}

	@Override
	public Item getTabIconItem() {
		return Items.nether_star;
	}
}
