package com.tinkerlad.dimension.modules;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.client.FMLClientHandler;

/**
 * 
 * UtilsFX
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class UtilsFX {

	public static double getDistanceToPlayer(Vector3 vec) {
		EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;

		return vec.distanceSquared(new Vector3(player.posX, player.posY, player.posZ));
	}

	public static double getRenderRadius() {
		int renderRadius = FMLClientHandler.instance().getClient().gameSettings.renderDistanceChunks;

		return Math.pow(renderRadius, 2);
	}

	public static void bindTexture(ResourceLocation path) {
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(path);
	}

	public static void bindTexture(String path) {
		bindTexture(Resources.getResourceLocation(path));
	}

}