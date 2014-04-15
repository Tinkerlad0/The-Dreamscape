package com.tinkerlad.dimension.entity;

import java.util.Random;

import net.minecraft.entity.EntityList;

import org.apache.logging.log4j.Level;

import com.tinkerlad.dimension.Possession;
import com.tinkerlad.dimension.entity.nightmare.EntityExitGuard;
import com.tinkerlad.dimension.logging.LogHelper;

import cpw.mods.fml.common.registry.EntityRegistry;

public class DimensionsEntity {

	static Possession	instance	= Possession.instance;

	public static void init() {

		registerEntity(EntityExitGuard.class, "entityExitGuard");

	}

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
