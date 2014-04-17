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
package com.tinkerlad.dimension;

import net.minecraftforge.common.MinecraftForge;

import com.tinkerlad.dimension.block.DimBlocks;
import com.tinkerlad.dimension.command.PossessionCommand;
import com.tinkerlad.dimension.config.ConfigHandler;
import com.tinkerlad.dimension.config.GameControls;
import com.tinkerlad.dimension.creativeTab.TabHandler;
import com.tinkerlad.dimension.entity.DimensionsEntity;
import com.tinkerlad.dimension.item.DimItem;
import com.tinkerlad.dimension.logging.LogHelper;
import com.tinkerlad.dimension.modules.FMLEventReciever;
import com.tinkerlad.dimension.modules.ForgeEventReciever;
import com.tinkerlad.dimension.modules.PossessionModule;
import com.tinkerlad.dimension.proxies.ClientProxy;
import com.tinkerlad.dimension.proxies.CommonProxy;
import com.tinkerlad.dimension.reference.ModInfo;
import com.tinkerlad.dimension.tileEntities.TileDimBed;
import com.tinkerlad.dimension.world.Dimension;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class Possession {

	@Instance(ModInfo.ID)
	public static Possession	instance;

	@SidedProxy(clientSide = "com.tinkerlad.dimension.proxies.ClientProxy", serverSide = "com.tinkerlad.dimension.proxies.CommonProxy")
	public static CommonProxy	proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		LogHelper.logger = event.getModLog();

		ConfigHandler.init(event.getSuggestedConfigurationFile());
		TabHandler.init();


		DimBlocks.init();
		DimItem.init();
		Dimension.init();
		DimensionsEntity.init();

		if (!GameControls.VANILLA_BED) {
			PossessionModule.removeVanillaBed();
		}

		ClientProxy.registerRenderThings();
		GameRegistry.registerTileEntity(TileDimBed.class, "tileDimBed");

		DimItem.addRecipes();
		MinecraftForge.EVENT_BUS.register(new ForgeEventReciever());
		FMLCommonHandler.instance().bus().register(new FMLEventReciever());
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {

		event.registerServerCommand(new PossessionCommand());
	}
}
