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

package com.tinkerlad.dimension.utils;

import com.tinkerlad.dimension.logging.LogHelper;
import com.tinkerlad.dimension.reference.PossessionInfo;
import com.tinkerlad.dimension.world.nightmare.TeleporterNightmare;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;

import java.util.Iterator;

public class Utils {

	@SuppressWarnings("rawtypes")
	public static void getNearestValidEntity(World world, EntityPlayer player, int range) {

		if (!world.isRemote) {

			if (player.boundingBox != null) {
				AxisAlignedBB bb = player.boundingBox.expand(range, 6, range);

				if (world.findNearestEntityWithinAABB(Entity.class, bb, player) != null
						    && world.findNearestEntityWithinAABB(Entity.class, bb, player) instanceof EntityMob) {
					EntityMob closest = (EntityMob) world.findNearestEntityWithinAABB(Entity.class, bb, player);
					for (Class element : PossessionInfo.VALID_MONSTER_ENTITY) {
						if (closest.getClass() == element) {
							closest.setHealth(-1);
							// movePlayer(world, (EntityPlayerMP) player,
							// (int) closest.posX, (int) closest.posY,
							// (int) closest.posZ);

							player.addChatComponentMessage(new ChatComponentText(closest.posX + " " + closest.posY + " " + closest.posZ + " is "
									                                                     + closest.getClass()));
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

	public static void teleport(EntityPlayer par5Entity, int dimID) {

		if ((par5Entity.ridingEntity == null) && (par5Entity.riddenByEntity == null) && ((par5Entity instanceof EntityPlayerMP))) {
			EntityPlayerMP player = (EntityPlayerMP) par5Entity;

			MinecraftServer mServer = MinecraftServer.getServer();

			if (player.timeUntilPortal > 0) {
				player.timeUntilPortal = 10;
			} else if (player.dimension != dimID) {
				player.timeUntilPortal = 10;

				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, dimID,
						                                                                   new TeleporterNightmare(mServer.worldServerForDimension(dimID)));
			} else {
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterNightmare(mServer.worldServerForDimension(0)));
			}
		}
	}
}
