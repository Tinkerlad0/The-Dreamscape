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

package com.tinkerlad.dimension.world.dream;

import com.tinkerlad.dimension.world.Dimension;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderDream extends WorldProvider {

	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(Dimension.dreamscape, 0.1F);
		this.dimensionId = Dimension.dreamID;
	}

	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderDream(worldObj, worldObj.getSeed(), true);
	}

	public float calculateCelestialAngle(long par1, float par3) {

		return 0F;// (float) ((Math.PI) / 2);
	}

	public boolean canRespawnHere() {
		return true;
	}

	/**
	 * Gets the hard-coded portal location to use when entering this dimension.
	 */
	public ChunkCoordinates getEntrancePortalLocation() {

		ChunkCoordinates portalLoc = new ChunkCoordinates(0, 0, 0);

		portalLoc.posX = 0;
		portalLoc.posZ = 0;
		portalLoc.posY = worldObj.getTopSolidOrLiquidBlock(0, 0);
		return portalLoc;
	}

	public String getDimensionName() {

		return "The DreamScape";
	}

	public String getSaveFolder() {
		return "DIM-DRM";
	}

	public String getWelcomeMessage() {
		return "Entering Your Dreams";
	}

	public String getDepartMessage() {
		return "You wake up, pleased at your nights accomplishments";
	}
}