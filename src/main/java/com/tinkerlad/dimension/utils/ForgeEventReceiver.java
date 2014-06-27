package com.tinkerlad.dimension.utils;

import com.tinkerlad.dimension.Possession;
import com.tinkerlad.dimension.block.DimBlocks;
import com.tinkerlad.dimension.effects.potion.Potions;
import com.tinkerlad.dimension.gui.GUIEmpty;
import com.tinkerlad.dimension.item.DimItem;
import com.tinkerlad.dimension.reference.BlockInfo;
import com.tinkerlad.dimension.world.Dimension;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.util.Random;

/**
 * Created by Michael on 6/15/2014.
 */
public class ForgeEventReceiver {

	@SubscribeEvent
	public void harvestBlock(BlockEvent.HarvestDropsEvent event) {
		if (event.block == DimBlocks.BlockHardenedOre) {
			if (event.harvester.getCurrentEquippedItem().getItem() == DimItem.pickPlatinum) {
				Random random = new Random();
				int oreNum = random.nextInt(BlockInfo.HARDENED_ORE.length - 1);
				if (0 < oreNum && oreNum < BlockInfo.HARDENED_ORE.length) {
					Block ore = BlockInfo.HARDENED_ORE[oreNum];
					if (ore != null) {
						ItemStack stack = new ItemStack(ore, random.nextInt(3));
						event.drops.clear();
						event.drops.add(stack);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onSleep(PlayerSleepInBedEvent event) {
		int chance = 5;
		Random rand = new Random();
		EntityPlayer player = event.entityPlayer;
		for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
			if (rand.nextInt(chance) == 0) {
				player.inventory.setInventorySlotContents(i, null);
			}
		}
		int destination = Dimension.nightmareID;
		Utils.teleport(player, destination);
	}

	@SubscribeEvent
	public void potionEffectHandler(LivingEvent.LivingUpdateEvent event) {
		EntityLivingBase living = event.entityLiving;
		if (living.isPotionActive(Potions.immobilise.getId())) {
			if (living instanceof EntityPlayer) {
				((EntityPlayer) living).openGui(Possession.instance, GUIEmpty.GUI_ID, event.entity.worldObj,
						                               (int) ((EntityPlayer) living).posX, (int) ((EntityPlayer) living).posY,
						                               (int) ((EntityPlayer) living).posZ);
			}

			if (event.entityLiving.getActivePotionEffect(Potions.immobilise).getDuration() == 0) {
				event.entityLiving.removePotionEffect(Potions.immobilise.id);
				if (event.entityLiving instanceof EntityPlayer) {

				}
				return;
			}
		}
	}
}
