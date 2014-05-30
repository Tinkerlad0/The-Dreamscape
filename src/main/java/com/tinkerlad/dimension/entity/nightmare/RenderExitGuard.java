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

import com.tinkerlad.dimension.reference.BlockInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderExitGuard extends RenderBiped {

	public ResourceLocation func_110867_a = new ResourceLocation(BlockInfo.TEXTURE_LOCATION + "textures/model/exitGuard.png");

	public RenderExitGuard() {
		super(new ModelBiped(), 0.5F);
	}

	protected ResourceLocation func_110870_a(EntityExitGuard par1) {
		return func_110867_a;
	}

	protected ResourceLocation func_110867_a(Entity par1Entity) {
		return this.func_110870_a((EntityExitGuard) par1Entity);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.func_110867_a((EntityExitGuard) entity);
	}

	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
		super.doRender(entity, d, d1, d2, f, f1);
	}
}