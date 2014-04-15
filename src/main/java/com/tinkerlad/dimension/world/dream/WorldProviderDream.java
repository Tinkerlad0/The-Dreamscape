package com.tinkerlad.dimension.world.dream;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import com.tinkerlad.dimension.world.Dimension;

public class WorldProviderDream extends WorldProvider {
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(Dimension.nightmare, 0.1F);
		this.dimensionId = Dimension.dreamID;
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

	public boolean canRespawnHere() {
		return true;
	}

	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderDream(worldObj, worldObj.getSeed(), true);
	}

	public String getDimensionName() {
		return "The Dreamscape";
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

}