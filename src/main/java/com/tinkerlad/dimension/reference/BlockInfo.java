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
package com.tinkerlad.dimension.reference;

public class BlockInfo {

	public static final String	TEXTURE_LOCATION			= ModInfo.ID.toLowerCase() + ":";
	public static final String	DEFAULT						= "default";
	/*
	 * Contains All Information About All DimBlocks
	 */
	// particles
	public static final String	DIAMOND						= "textures/particle/diamond.png";

	// BlockTimerTile
	public static final String	TIMER_UNLOCALIZED_NAME		= "timerTile";
	public static final String	TIMER_NAME					= "Timer Tile";
	public static final String	TIMER_KEY					= "timerTile";
	public static final String	TIMER_COMMENT				= "For Measuring Time Spent in Bed";

	// BlockLightStone
	public static final String	LIGHTSTONE_ULOCALIZED_NAME	= "lightStone";
	public static final String	LIGHTSTONE_NAME				= "Light Stone";
	public static final String	LIGHTSTONE_KEY				= "lightStone";
	public static final String	LIGHTSTONE_TEXTURE			= "lightstone";

	// BlockPlatinumOre
	public static final String	PLATINUM_ULOCALIZED_NAME	= "platinumOre";
	public static final String	PLATINUM_NAME				= "Platinum Ore";
	public static final String	PLATINUM_OREDICT			= "orePlatinum";
	public static final String	PLATINUM_KEY				= "platinum";
	public static final String	PLATINUM_TEXTURE			= "platinum";

	// BlockRubyOre
	public static final String	RUBY_ULOCALIZED_NAME		= "rubyOre";
	public static final String	RUBY_NAME					= "Ruby Ore";
	public static final String	RUBY_OREDICT				= "oreRuby";
	public static final String	RUBY_KEY					= "ruby";
	public static final String	RUBY_TEXTURE				= "ruby";

	// BlockDebug
	public static final String	DEBUG_ULOCALIZED_NAME		= "debugDim";
	public static final String	DEBUG_NAME					= "Debug Block";
	public static final String	DEBUG_TEXTURE				= "default";

	// BlockDiamondLeaves
	public static final String	DIA_LEAVES_ULOCALIZED_NAME	= "leavesDiamond";
	public static final String	DIA_LEAVES_KEY				= "leavesDiamond";
	public static final String	DIA_LEAVES_TEXTURE[]		= { "leaves_diamond", "leaves_diamond_opaque" };

	// BlockDiamondWood
	public static final String	DIA_WOOD_ULOCALIZED_NAME	= "logDiamond";
	public static final String	DIA_WOOD_KEY				= "logDiamond";
	public static final String	DIA_WOOD_TEXTURE[]			= { "log_diamond", "log_diamond_top" };

}
