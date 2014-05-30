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

package com.tinkerlad.dimension.entity;

import com.tinkerlad.dimension.Possession;
import com.tinkerlad.dimension.entity.nightmare.EntityExitGuard;
import com.tinkerlad.dimension.entity.nightmare.EntityRidgebackSpider;
import com.tinkerlad.dimension.logging.LogHelper;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import org.apache.logging.log4j.Level;

import java.util.Random;

public class DimensionsEntity {

	static Possession instance = Possession.instance;

	public static void init() {

		registerEntity(EntityExitGuard.class, "entityExitGuard");
		registerEntity(EntityRidgebackSpider.class, "entityRidgebackSpider");
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void registerEntity(Class entityClass, String name) {
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		long seed = name.hashCode();
		Random rand = new Random(seed);
		int primaryColor = rand.nextInt() * 16777215;
		int secondaryColor = rand.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
		EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
		LogHelper.log(Level.INFO, "Added " + name + " with ID of " + entityID);
	}
}
