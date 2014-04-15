package com.tinkerlad.dimension.entity.nightmare;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.tinkerlad.dimension.entity.LabelRenderer;
import com.tinkerlad.dimension.reference.BlockInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderExitGuard extends RenderBiped {
	public ResourceLocation	func_110867_a	= new ResourceLocation(BlockInfo.TEXTURE_LOCATION + "textures/model/exitGuard.png");
	private LabelRenderer	lr;

	public RenderExitGuard() {
		super(new ModelBiped(), 0.5F);
		lr = new LabelRenderer();
	}

	protected ResourceLocation func_110870_a(EntityExitGuard par1) {
		return func_110867_a;
	}

	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
		super.doRender(entity, d, d1, d2, f, f1);
	}

	protected ResourceLocation func_110867_a(Entity par1Entity) {
		return this.func_110870_a((EntityExitGuard) par1Entity);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.func_110867_a((EntityExitGuard) entity);
	}
}