package com.tinkerlad.dimension.entity.nightmare;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.tinkerlad.dimension.reference.BlockInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRidgebackSpider extends RenderLiving {

	private static final ResourceLocation	spiderEyesTextures	= new ResourceLocation(BlockInfo.TEXTURE_LOCATION + "textures/model/ridgebackSpiderEyes.png");
	private static final ResourceLocation	spiderTextures		= new ResourceLocation(BlockInfo.TEXTURE_LOCATION + "textures/model/ridgebackSpider.png");

	public RenderRidgebackSpider() {

		super(new ModelRidgebackSpider(), 1.0F);
		this.setRenderPassModel(new ModelRidgebackSpider());
	}

	protected float getDeathMaxRotation(EntityRidgebackSpider par1EntitySpider) {

		return 180.0F;
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityRidgebackSpider par1EntitySpider, int par2, float par3) {

		if (par2 != 0) {
			return -1;
		} else {
			this.bindTexture(spiderEyesTextures);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

			if (par1EntitySpider.isInvisible()) {
				GL11.glDepthMask(false);
			} else {
				GL11.glDepthMask(true);
			}

			char c0 = 61680;
			int j = c0 % 65536;
			int k = c0 / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j / 1.0F, (float) k / 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			return 1;
		}
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityRidgebackSpider par1EntitySpider) {

		return spiderTextures;
	}

	protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase) {

		return this.getDeathMaxRotation((EntityRidgebackSpider) par1EntityLivingBase);
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3) {

		return this.shouldRenderPass((EntityRidgebackSpider) par1EntityLivingBase, par2, par3);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(Entity par1Entity) {

		return this.getEntityTexture((EntityRidgebackSpider) par1Entity);
	}
}