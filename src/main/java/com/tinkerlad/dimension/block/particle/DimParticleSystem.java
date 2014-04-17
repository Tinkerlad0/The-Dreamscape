package com.tinkerlad.dimension.block.particle;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class DimParticleSystem extends EntityFX {
	/** the material type for dropped items/blocks */
	private Material	materialType;
	/** The height of the current bob */
	private int			bobTimer;

	public DimParticleSystem(World par1World, double par2, double par4, double par6, Material par8Material, IIcon icon) {
		super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
		this.motionX = this.motionY = this.motionZ = 0.0D;

			this.particleRed = 0.0F;
			this.particleGreen = 0.0F;
			this.particleBlue = 1.0F;

		this.setParticleIcon(icon);
		this.setSize(0.01F, 0.01F);
		this.particleGravity = 0.06F;
		this.materialType = par8Material;
		this.bobTimer = 40;
		this.particleMaxAge = (int) (64.0D / (Math.random() * 0.8D + 0.2D));
		this.motionX = this.motionY = this.motionZ = 0.0D;
	}

	public int getBrightnessForRender(float par1) {
		return 257;
	}

	/**
	 * Gets how bright this entity is.
	 */
	public float getBrightness(float par1) {
		return 1.0F;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		this.particleRed = 0.2F;
		this.particleGreen = 0.3F;
		this.particleBlue = 1.0F;

		this.motionY -= (double) this.particleGravity;

		if (this.bobTimer-- > 0) {
			this.motionX *= 0.02D;
			this.motionY *= 0.02D;
			this.motionZ *= 0.02D;
			this.setParticleTextureIndex(113);
		} else {
			this.setParticleTextureIndex(112);
		}

		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;

		if (this.particleMaxAge-- <= 0) {
			this.setDead();
		}

		if (this.onGround) {

			this.setDead();
			this.worldObj.spawnParticle("splash", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);

			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
		}

		Material material = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)).getMaterial();

		if (material.isLiquid() || material.isSolid()) {
			double d0 = (double) ((float) (MathHelper.floor_double(this.posY) + 1) - BlockLiquid.getLiquidHeightPercent(this.worldObj.getBlockMetadata(MathHelper.floor_double(this.posX),
					MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))));

			if (this.posY < d0) {
				this.setDead();
			}
		}
	}
}