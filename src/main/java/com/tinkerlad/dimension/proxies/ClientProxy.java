/*******************************************************************************
 * Copyright (c) 2013 Tinkerlad
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Tinkerlad - initial concept and implementation
 ******************************************************************************/
package com.tinkerlad.dimension.proxies;



import org.apache.logging.log4j.Level;

import com.tinkerlad.dimension.entity.nightmare.EntityExitGuard;
import com.tinkerlad.dimension.entity.nightmare.RenderExitGuard;
import com.tinkerlad.dimension.logging.LogHelper;
import com.tinkerlad.dimension.tileEntities.TileDimBed;
import com.tinkerlad.dimension.tileEntities.TESR.TileDimBedRenderer;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void initSounds() {

		// init all the sounds;
	}

	@Override
	public void initRenderers() {


	}

	public static void registerRenderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileDimBed.class, new TileDimBedRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityExitGuard.class, new RenderExitGuard());
		LogHelper.log(Level.DEBUG, "RENDER INITIALISED");
	}
}
