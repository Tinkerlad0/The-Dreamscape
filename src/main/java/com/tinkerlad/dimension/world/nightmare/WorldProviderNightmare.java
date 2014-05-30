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

package com.tinkerlad.dimension.world.nightmare;

import com.tinkerlad.dimension.world.Dimension;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderNightmare extends WorldProvider {

	public WorldProviderNightmare() {

		this.hasNoSky = true;
	}

	@Override
	protected void generateLightBrightnessTable() {

		float f = 0.0F;

		for (int i = 0; i <= 15; ++i) {
			float f1 = 1.0F - (float) i / 15.0F;
			f1 = f1 < 0.6F ? f1 : 0.6F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}

	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(Dimension.nightmare, 0.1F);
		this.dimensionId = Dimension.nightmareID;
	}

	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderNightmare(worldObj, worldObj.getSeed(), true);
	}

	public float calculateCelestialAngle(long par1, float par3) {

		return 0.5F;
	}

	public float[] calcSunriseSunsetColors(float par1, float par2) {
		return null;
	}

	public Vec3 getFogColor(float par1, float par2) {
		return this.worldObj.getWorldVec3Pool().getVecFromPool(0.0, 0.0, 0.0);
	}

	public boolean canRespawnHere() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public boolean isSkyColored() {
		return false;
	}

	/**
	 * Gets the hard-coded portal location to use when entering this dimension.
	 */
	public ChunkCoordinates getEntrancePortalLocation() {
		ChunkCoordinates portalLoc = new ChunkCoordinates(0, 0, 0);

		portalLoc.posX = 0;
		portalLoc.posZ = 0;
		portalLoc.posY = worldObj.getHeightValue(0, 0) + 1;
		return portalLoc;
	}

	public boolean doesXZShowFog(int par1, int par2) {
		return true;
	}

	public String getDimensionName() {
		return "Nightmare Realm";
	}

	public String getSaveFolder() {
		return "DIM-NGHT";
	}

	public String getWelcomeMessage() {
		return "Entering Your Nightmare";
	}

	public String getDepartMessage() {
		return "You wake up, sweating from the nightmare";
	}

	@Override
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
		return this.worldObj.getWorldVec3Pool().getVecFromPool(0, 0, 0.5);
	}

	public boolean canDoLightning(Chunk chunk) {
		return true;
	}

	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}
}