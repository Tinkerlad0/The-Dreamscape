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

package com.tinkerlad.dimension.reference;

import net.minecraft.entity.monster.*;
import net.minecraft.util.ResourceLocation;

public class PossessionInfo {

	@SuppressWarnings("rawtypes")
	public static final Class[] VALID_MONSTER_ENTITY = {EntityZombie.class,
			                                                   EntityCaveSpider.class, EntityCreeper.class, EntityEnderman.class,
			                                                   EntityGhast.class, EntityGiantZombie.class, EntityMagmaCube.class,
			                                                   EntityPigZombie.class, EntitySkeleton.class, EntitySpider.class,
			                                                   EntityWitch.class, EntityZombie.class};

	public ResourceLocation iconLoc(String itemName) {

		ResourceLocation resourceLocation = new ResourceLocation(ModInfo.ID
				                                                         + ":" + itemName);
		return resourceLocation;
	}
}
