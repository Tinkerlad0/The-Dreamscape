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

package com.tinkerlad.dimension.proxies;

import com.tinkerlad.dimension.entity.nightmare.EntityExitGuard;
import com.tinkerlad.dimension.entity.nightmare.EntityRidgebackSpider;
import com.tinkerlad.dimension.entity.nightmare.RenderExitGuard;
import com.tinkerlad.dimension.entity.nightmare.RenderRidgebackSpider;
import com.tinkerlad.dimension.logging.LogHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import org.apache.logging.log4j.Level;

public class ClientProxy extends CommonProxy {

	public static void registerRenderThings() {
		RenderingRegistry.registerEntityRenderingHandler(EntityExitGuard.class, new RenderExitGuard());
		RenderingRegistry.registerEntityRenderingHandler(EntityRidgebackSpider.class, new RenderRidgebackSpider());
		LogHelper.log(Level.DEBUG, "RENDER INITIALISED");
	}

	@Override
	public void initSounds() {

		// init all the sounds;
	}

	@Override
	public void initRenderers() {


	}
}
