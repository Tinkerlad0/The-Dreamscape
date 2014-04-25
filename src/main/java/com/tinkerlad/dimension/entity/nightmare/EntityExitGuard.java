package com.tinkerlad.dimension.entity.nightmare;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityExitGuard extends EntityMob {
	public EntityExitGuard(World par1World) {
		super(par1World);
		setSize(1.0F, 1.75F);
		//this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));

		ItemStack armour = new ItemStack(Items.leather_chestplate);
		armour.addEnchantment(Enchantment.blastProtection, 50);

		// this.setCurrentItemOrArmor(2, armour);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false));
		this.tasks.addTask(3, new EntityAIWander(this, 9.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));

		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	public boolean isAIEnabled() {
		return true;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.6D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);

	}

	@Override
	protected void onDeathUpdate() {
		++this.deathTime;

		if (this.deathTime == 20) {
			int i;

			if (!this.worldObj.isRemote && (this.recentlyHit > 0 || this.isPlayer()) && !this.isChild() && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot")) {
				i = this.getExperiencePoints(this.attackingPlayer);

				while (i > 0) {
					int j = EntityXPOrb.getXPSplit(i);
					i -= j;
					this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
				}
			}
		}

		for (int i = 0; i < 20; ++i) {
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle("explode", this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + (double) (this.rand.nextFloat() * this.height),
					this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 0.002F, false);
		}

		if (this.deathTime >= 40) {
			for (int i = 0; i < 20; ++i) {
				double d0 = this.rand.nextGaussian() * 0.02D;
				double d1 = this.rand.nextGaussian() * 0.02D;
				double d2 = this.rand.nextGaussian() * 0.02D;
				this.worldObj.spawnParticle("explode", this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY
						+ (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
			}
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 4F, false);
			this.setDead();
		}
	}
}
