package com.tinkerlad.dimension.tileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Michael on 6/10/2014.
 */
public class TileBedMaster extends TileEntity {

	public int TIER;
	int ticks;

	public int checkTier() {


		return 0;
	}

	public void readFromNBT(NBTTagCompound var1) {
		super.readFromNBT(var1);
	}

	public void writeToNBT(NBTTagCompound var1) {
		super.writeToNBT(var1);
	}

	public void updateEntity() {
		ticks++;
		if (ticks % 20 == 0) {
			TIER = checkTier();
		}
	}

	public void onChunkUnload() {
		worldObj.getChunkProvider().loadChunk(this.xCoord / 16, this.zCoord / 16);
	}
}
