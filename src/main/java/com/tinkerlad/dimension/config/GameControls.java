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
package com.tinkerlad.dimension.config;

public class GameControls {

	/*
	 * This Class Contains All Variables That Affect GamePlay
	 */

	// Categories
	public static final String GAME_BOOLEANS = "Game Settings";

	// Game Booleans
	public static boolean VANILLA_BED;
	public static boolean VANILLA_BED_DEFAULT = false;
	public static final String VANILLA_BED_NAME = "Vanilla Bed  Recipe Enabled?";

	public static boolean DEBUG_MODE;
	public static final boolean DEBUG_DEFAULT = false;
	public static final String DEBUG_NAME = "Debug Mode";
	public static final String DEBUG_COMMENT = "If Debug mode is enabled then you will recieve chat messages for various actions";
	
	public static final int DREAM_CHANCE = 10;
	public static final String DREAM_NAME = "Chance of DreamScape";
	public static final String DREAM_COMMENT = "The Chance of Travelling to the Dreamscape when Sleeping";
	
}
