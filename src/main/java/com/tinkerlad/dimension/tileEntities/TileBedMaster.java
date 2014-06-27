package com.tinkerlad.dimension.tileEntities;

import com.tinkerlad.dimension.block.bed.BlockBed1;
import com.tinkerlad.dimension.block.bed.BlockBed2;
import com.tinkerlad.dimension.utils.Utils;
import com.tinkerlad.dimension.world.Dimension;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

/**
 * Created by Michael on 6/10/2014.
 */
public class TileBedMaster extends TileEntity {

	public int TIER;
	int ticks;

	public int getTier() {
		return TIER;
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
			Block masterBed = worldObj.getBlock(xCoord, yCoord, zCoord);
			masterBed.setLightLevel(TIER / 3);
		}
	}

	public void sleepPlayer(EntityPlayer player) {
		int chance = 10 * TIER;
		Random rand = new Random();
		rand.setSeed(this.ticks * worldObj.getSeed());

		for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
			if (rand.nextInt(chance) == 0) {
				player.inventory.setInventorySlotContents(i, null);
			}
		}
		int destination;
		switch (TIER) {
			default:
				destination = Dimension.nightmareID;
				break;
			case 1:
				destination = rand.nextBoolean() ? Dimension.nightmareID : Dimension.dreamID;
				break;
			case 2:
				destination = rand.nextBoolean() ? rand.nextBoolean() ? Dimension.nightmareID : Dimension.dreamID :
						              Dimension.dreamID;
				break;
			case 3:
				destination = Dimension.dreamID;
				break;
		}
		Utils.teleport(player, destination);
	}

	public int checkTier() {

		int x = xCoord;
		int y = yCoord;
		int z = zCoord;

		return tier1(x, y, z) ? tier2(x, y, z) ? tier3(x, y, z) ? 3 : 2 : 1 : 0;
	}

	public boolean tier1(int x, int y, int z) {

		if (!(worldObj.getBlock(x + 1, y - 1, z) instanceof BlockBed1)) { return false; }
		if (!(worldObj.getBlock(x - 1, y - 1, z) instanceof BlockBed1)) { return false; }
		if (!(worldObj.getBlock(x, y - 1, z - 1) instanceof BlockBed1)) { return false; }
		if (!(worldObj.getBlock(x, y - 1, z + 1) instanceof BlockBed1)) { return false; }

		return true;
	}

	public boolean tier2(int x, int y, int z) {

		if (!(worldObj.getBlock(x, y - 2, z - 2) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x - 1, y - 2, z - 1) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x + 1, y - 2, z - 1) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x - 2, y - 2, z) instanceof BlockBed2)) { return false; }

		if (!(worldObj.getBlock(x + 2, y - 2, z) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x - 1, y - 2, z + 1) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x + 1, y - 2, z + 1) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x, y - 2, z + 2) instanceof BlockBed2)) { return false; }

		if (!(worldObj.getBlock(x - 1, y - 1, z - 1) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x + 1, y - 1, z - 1) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x - 1, y - 1, z + 1) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x + 1, y - 1, z + 1) instanceof BlockBed2)) { return false; }

		return true;
	}

	public boolean tier3(int x, int y, int z) {

		if (!(worldObj.getBlock(x, y - 3, z - 3) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x - 1, y - 3, z - 2) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x, y - 3, z - 2) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x + 1, y - 3, z - 2) instanceof BlockBed2)) { return false; }

		if (!(worldObj.getBlock(x - 2, y - 3, z - 1) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x - 1, y - 3, z - 1) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x + 1, y - 3, z - 1) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x + 2, y - 3, z - 1) instanceof BlockBed2)) { return false; }

		if (!(worldObj.getBlock(x - 3, y - 3, z) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x - 2, y - 3, z) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x + 2, y - 3, z) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x + 3, y - 3, z) instanceof BlockBed2)) { return false; }

		if (!(worldObj.getBlock(x - 2, y - 3, z + 1) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x - 1, y - 3, z + 1) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x + 1, y - 3, z + 1) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x + 2, y - 3, z + 1) instanceof BlockBed2)) { return false; }

		if (!(worldObj.getBlock(x - 1, y - 3, z + 2) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x, y - 3, z + 2) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x + 1, y - 3, z + 2) instanceof BlockBed2)) { return false; }
		if (!(worldObj.getBlock(x, y - 3, z + 3) instanceof BlockBed2)) { return false; }

		return true;
	}
}