/*******************************************************************************
 * Copyright (c) 2013 Tinkerlad
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http:www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Tinkerlad - initial concept and implementation
 *****************************************************************************/
package com.tinkerlad.dimension.modules;

import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import org.apache.logging.log4j.Level;

import com.tinkerlad.dimension.config.GameControls;
import com.tinkerlad.dimension.logging.LogHelper;
import com.tinkerlad.dimension.reference.PossessionInfo;

public class PossessionModule {

	@SuppressWarnings("rawtypes")
	public static void getNearestValidEntity(World world, EntityPlayer player, int range) {

		if (!world.isRemote) {

			if (player.boundingBox != null) {
				AxisAlignedBB bb = player.boundingBox.expand(range, 6, range);

				if (world.findNearestEntityWithinAABB(Entity.class, bb, player) != null && world.findNearestEntityWithinAABB(Entity.class, bb, player) instanceof EntityMob) {
					EntityMob closest = (EntityMob) world.findNearestEntityWithinAABB(Entity.class, bb, player);
					if (GameControls.DEBUG_MODE) {
						player.addChatComponentMessage(new ChatComponentText("DimensionsEntity Class is " + closest.getClass()));
					}
					for (Class element : PossessionInfo.VALID_MONSTER_ENTITY) {
						if (closest.getClass() == element) {
							closest.setHealth(-1);
							// movePlayer(world, (EntityPlayerMP) player,
							// (int) closest.posX, (int) closest.posY,
							// (int) closest.posZ);

							if (GameControls.DEBUG_MODE) {
								;
							}
							player.addChatComponentMessage(new ChatComponentText(closest.posX + " " + closest.posY + " " + closest.posZ + " is " + closest.getClass()));

						}
					}
				}

			}
		}

	}

	@SuppressWarnings("unchecked")
	public static void removeVanillaBed() {

		Iterator<IRecipe> iterator = CraftingManager.getInstance().getRecipeList().iterator();
		while (iterator.hasNext()) {
			ItemStack r = iterator.next().getRecipeOutput();
			if (r != null && r.isItemEqual(new ItemStack(Items.bed, 1))) {
			iterator.remove();
				LogHelper.log(Level.INFO, "Vanilla Bed Recipe Removed");
			}
		}
	}



}
