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
package com.tinkerlad.dimension.reference;

import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class PossessionInfo {

	public ResourceLocation iconLoc(String itemName) {

		ResourceLocation resourceLocation = new ResourceLocation(ModInfo.ID
				+ ":" + itemName);
		return resourceLocation;
	}

	@SuppressWarnings("rawtypes")
	public static final Class[] VALID_MONSTER_ENTITY = { EntityZombie.class,
			EntityCaveSpider.class, EntityCreeper.class, EntityEnderman.class,
			EntityGhast.class, EntityGiantZombie.class, EntityMagmaCube.class,
			EntityPigZombie.class, EntitySkeleton.class, EntitySpider.class,
			EntityWitch.class, EntityZombie.class };

}
