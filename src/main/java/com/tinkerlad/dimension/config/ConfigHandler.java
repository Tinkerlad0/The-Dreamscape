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

package com.tinkerlad.dimension.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

	public static void init(File file) {

		Configuration config = new Configuration(file);

		config.load();

		GameControls.VANILLA_BED = config.get(GameControls.GAME_BOOLEANS, GameControls.VANILLA_BED_NAME, GameControls.VANILLA_BED_DEFAULT).getBoolean(GameControls.VANILLA_BED_DEFAULT);
		GameControls.DEBUG_MODE = config.get(GameControls.GAME_BOOLEANS, GameControls.DEBUG_NAME, GameControls.DEBUG_DEFAULT, GameControls.DEBUG_COMMENT).getBoolean(GameControls.DEBUG_DEFAULT);

		config.save();
	}
}
