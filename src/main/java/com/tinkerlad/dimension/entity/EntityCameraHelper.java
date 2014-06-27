package com.tinkerlad.dimension.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class EntityCameraHelper {

	@SideOnly(Side.CLIENT)
	public static EntityCamera camera;
	/**
	 * Stores whether or not the GUI is hidden before entering arrow cam
	 */
	private static boolean hideGUI;
	/**
	 * Stores the FOV before entering arrow cam
	 */
	private static float fovSetting;
	/**
	 * Stores the POV before entering arrow cam
	 */
	private static int thirdPersonView;

	@SideOnly(Side.CLIENT)
	public static void startCamera(EntityPlayer player) {
		if (!isInArrowCam()) {
			camera = new EntityCamera(player);

			if (camera.worldObj.spawnEntityInWorld(camera)) {
				Minecraft mc = Minecraft.getMinecraft();

				hideGUI = mc.gameSettings.hideGUI;
				fovSetting = mc.gameSettings.fovSetting;
				thirdPersonView = mc.gameSettings.thirdPersonView;

				mc.gameSettings.hideGUI = true;
				mc.gameSettings.fovSetting *= 1.1F;
				mc.gameSettings.thirdPersonView = thirdPersonView != 0 ? thirdPersonView : 1;
				mc.renderViewEntity = camera;
			} else {
				camera = null;
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public static void stopCam() {
		if (isInArrowCam()) {
			Minecraft mc = Minecraft.getMinecraft();
			mc.gameSettings.hideGUI = hideGUI;
			mc.gameSettings.fovSetting = fovSetting;
			mc.gameSettings.thirdPersonView = thirdPersonView;
			mc.renderViewEntity = mc.thePlayer;

			camera.setDead();
			camera = null;
		}
	}

	@SideOnly(Side.CLIENT)
	public static boolean isInArrowCam() {
		return camera != null;
	}
}