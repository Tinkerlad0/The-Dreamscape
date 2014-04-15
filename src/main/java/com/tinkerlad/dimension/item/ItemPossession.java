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
package com.tinkerlad.dimension.item;

import net.minecraft.item.Item;

import com.tinkerlad.dimension.creativeTab.TabItems;

public class ItemPossession extends Item {

	public ItemPossession() {

		super();
		setCreativeTab(TabItems.tabPossession);
	}

}
