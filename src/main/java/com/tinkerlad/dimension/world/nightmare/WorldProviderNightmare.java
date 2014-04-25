package com.tinkerlad.dimension.world.nightmare;

import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

import com.tinkerlad.dimension.world.Dimension;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderNightmare extends WorldProvider {

	public WorldProviderNightmare() {

		this.hasNoSky = true;
	}
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(Dimension.nightmare, 0.1F);
		this.dimensionId = Dimension.nightmareID;
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

	public boolean canRespawnHere() {
		return true;
	}

	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderNightmare(worldObj, worldObj.getSeed(), true);
	}

	public String getDimensionName() {
		return "Nightmare Realm";
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

	public boolean canDoLightning(Chunk chunk) {
		return true;
	}

	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean isSkyColored() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean hasNoSky() {
		return true;
	}

	public boolean doesXZShowFog(int par1, int par2) {
		return true;
	}

	public float[] calcSunriseSunsetColors(float par1, float par2) {
		return null;
	}

	public Vec3 getFogColor(float par1, float par2) {
		return this.worldObj.getWorldVec3Pool().getVecFromPool(0.0, 0.0, 0.0);
	}

	public float calculateCelestialAngle(long par1, float par3) {
		return (float) ((3 * Math.PI) / 2);
	}

	@Override
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
		return this.worldObj.getWorldVec3Pool().getVecFromPool(0, 0, 0.5);
	}
}