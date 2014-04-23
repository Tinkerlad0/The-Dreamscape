package com.tinkerlad.dimension.modules;

import java.io.File;

import net.minecraft.util.ResourceLocation;

import com.tinkerlad.dimension.reference.ModInfo;

public class Resources {

	public static ResourceLocation getResourceLocation(String modId, String path) {

		return new ResourceLocation(modId, path);
	}

	public static ResourceLocation getResourceLocation(String path) {
		return getResourceLocation(ModInfo.ID, File.separator + path);
	}

}