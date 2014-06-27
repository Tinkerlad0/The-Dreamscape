package com.tinkerlad.dimension.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class EntityCamera extends EntityLivingBase {

	public int deathDelay;

	public EntityPlayer target;

	public EntityCamera(World world) {
		super(world);
		setSize(0.0F, 0.0F);
		boundingBox.setBounds(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		yOffset = 0.0F;
		deathDelay = 20;
	}

	public EntityCamera(EntityPlayer player) {
		this(player.worldObj);
		setTarget(player);
		setPositionAndRotation(target.posX, target.posY, target.posZ, 360.0F - target.rotationYaw, 360.0F - target.rotationPitch);
	}

	public EntityPlayer getTarget() {
		return target;
	}

	public void setTarget(EntityPlayer player) {
		target = player;
	}

	@Override
	public boolean isPotionActive(Potion potion) {
		return Minecraft.getMinecraft().thePlayer.isPotionActive(potion);
	}

	@Override
	protected void fall(float blocks) {

	}

	@Override
	public ItemStack getHeldItem() {
		return null;
	}

	@Override
	public ItemStack getEquipmentInSlot(int i) {
		return null;
	}

	@Override
	public void setCurrentItemOrArmor(int i, ItemStack itemstack) {

	}

	@Override
	public ItemStack[] getLastActiveItems() {
		return new ItemStack[]{null, null, null, null, null};
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (target != null) {
			//Takes the midpoint from the current position and the target's position so it's not so choppy
			setPosition((posX + target.posX) / 2.0F, ((posY + target.posY) / 2.0F) + 0.5F, (posZ + target.posZ) / 2.0F);

			setRotation(target.rotationYaw, target.rotationPitch);


			if ((!target.isEntityAlive() && --deathDelay <= 0)) {
				EntityCameraHelper.stopCam();
				return;
			}
		}

		//Counteract gravity
		if (!onGround && motionY < 0.0) {
			motionY = 0.0;
		}

		//The camera will get stuck if it is in an unloaded chunk
		Chunk chunk = worldObj.getChunkFromBlockCoords((int) posX, (int) posY);
		if (!chunk.isChunkLoaded) {
			worldObj.getChunkProvider().loadChunk(chunk.xPosition, chunk.zPosition);
		}

		if (Minecraft.getMinecraft().thePlayer == null) {
			EntityCameraHelper.stopCam();
		}
	}

	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public float getShadowSize() {
		return 0.0F;
	}

	@Override
	public boolean isEntityInvulnerable() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean canRenderOnFire() {
		return false;
	}
}
