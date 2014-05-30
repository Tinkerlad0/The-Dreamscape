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

package com.tinkerlad.dimension.entity.nightmare;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Random;

public class EntityRidgebackSpider extends EntityMob {

	public EntityRidgebackSpider(World par1World) {
		super(par1World);
		this.setSize(1.4F, 0.9F);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte) 0));
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound() {
		return "mob.spider.say";
	}

	protected Item getDropItem() {
		return Items.string;
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
	 * par2 - Level of Looting used to kill this mob.
	 */
	protected void dropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);

		if (par1 && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(Items.spider_eye, 1);
		}
	}

	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData) {
		Object p_110161_1_1 = super.onSpawnWithEgg(par1EntityLivingData);

		if (this.worldObj.rand.nextInt(100) == 0) {
			EntitySkeleton entityskeleton = new EntitySkeleton(this.worldObj);
			entityskeleton.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			entityskeleton.onSpawnWithEgg((IEntityLivingData) null);
			this.worldObj.spawnEntityInWorld(entityskeleton);
			entityskeleton.mountEntity(this);
		}

		if (p_110161_1_1 == null) {
			p_110161_1_1 = new EntitySpider.GroupData();

			if (this.worldObj.difficultySetting == EnumDifficulty.HARD && this.worldObj.rand.nextFloat() < 0.1F * this.worldObj.func_147462_b(this.posX, this.posY, this.posZ)) {
				((EntitySpider.GroupData) p_110161_1_1).func_111104_a(this.worldObj.rand);
			}
		}

		if (p_110161_1_1 instanceof EntitySpider.GroupData) {
			int i = ((EntitySpider.GroupData) p_110161_1_1).field_111105_a;

			if (i > 0 && Potion.potionTypes[i] != null) {
				this.addPotionEffect(new PotionEffect(i, Integer.MAX_VALUE));
			}
		}

		return (IEntityLivingData) p_110161_1_1;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		super.onUpdate();

		if (!this.worldObj.isRemote) {
			this.setBesideClimbableBlock(this.isCollidedHorizontally);
		}
	}

	/**
	 * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
	 * (Animals, Spiders at day, peaceful PigZombies).
	 */
	protected Entity findPlayerToAttack() {

		double d0 = 16.0D;
		return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "mob.spider.say";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "mob.spider.death";
	}

	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
	 */
	protected void attackEntity(Entity par1Entity, float par2) {
		float f1 = this.getBrightness(1.0F);

		if (f1 > 0.5F && this.rand.nextInt(100) == 0) {
			this.entityToAttack = null;
		} else {
			if (par2 > 2.0F && par2 < 6.0F && this.rand.nextInt(10) == 0) {
				if (this.onGround) {
					double d0 = par1Entity.posX - this.posX;
					double d1 = par1Entity.posZ - this.posZ;
					float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
					this.motionX = d0 / (double) f2 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
					this.motionZ = d1 / (double) f2 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
					this.motionY = 0.4000000059604645D;
				}
			} else {
				super.attackEntity(par1Entity, par2);
			}
		}
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.800000011920929D);
	}

	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
		this.playSound("mob.spider.step", 0.15F, 1.0F);
	}

	/**
	 * Sets the Entity inside a web block.
	 */
	public void setInWeb() {}

	public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
	}

	/**
	 * returns true if this entity is by a ladder, false otherwise
	 */
	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}

	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}

	/**
	 * Returns true if the WatchableObject (Byte) is 0x01 otherwise returns false. The WatchableObject is updated using
	 * setBesideClimableBlock.
	 */
	public boolean isBesideClimbableBlock() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	/**
	 * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
	 * false.
	 */
	public void setBesideClimbableBlock(boolean par1) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if (par1) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 &= -2;
		}

		this.dataWatcher.updateObject(16, Byte.valueOf(b0));
	}

	public static class GroupData implements IEntityLivingData {

		public int field_111105_a;

		public void func_111104_a(Random par1Random) {
			int i = par1Random.nextInt(5);

			if (i <= 1) {
				this.field_111105_a = Potion.moveSpeed.id;
			} else if (i <= 2) {
				this.field_111105_a = Potion.damageBoost.id;
			} else if (i <= 3) {
				this.field_111105_a = Potion.regeneration.id;
			} else if (i <= 4) {
				this.field_111105_a = Potion.invisibility.id;
			}
		}
	}
}

