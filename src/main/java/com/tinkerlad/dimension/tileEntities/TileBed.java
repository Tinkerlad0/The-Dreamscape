/*******************************************************************************
 * Copyright (c) 2013 Tinkerlad
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Tinkerlad - initial concept and implementation
 ******************************************************************************/
package com.tinkerlad.dimension.tileEntities;



import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileBed extends TileEntity {

	public int						ticked				= 0;

	public TileBed(World world) {

	}

	@Override
	public void updateEntity() {
		ticked++;
	}

	public void storeInventory(EntityPlayer player) {


	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {

		super.writeToNBT(tag);

	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {

		super.readFromNBT(tag);
	}


}
