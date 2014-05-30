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

package com.tinkerlad.dimension;

import com.tinkerlad.dimension.block.DimBlocks;
import com.tinkerlad.dimension.command.PossessionCommand;
import com.tinkerlad.dimension.config.ConfigHandler;
import com.tinkerlad.dimension.config.GameControls;
import com.tinkerlad.dimension.creativeTab.TabHandler;
import com.tinkerlad.dimension.entity.DimensionsEntity;
import com.tinkerlad.dimension.item.DimItem;
import com.tinkerlad.dimension.logging.LogHelper;
import com.tinkerlad.dimension.packetHandling.PacketPipeline;
import com.tinkerlad.dimension.proxies.ClientProxy;
import com.tinkerlad.dimension.proxies.CommonProxy;
import com.tinkerlad.dimension.reference.BlockInfo;
import com.tinkerlad.dimension.reference.ModInfo;
import com.tinkerlad.dimension.tileEntities.TileGlobalStorage;
import com.tinkerlad.dimension.utils.*;
import com.tinkerlad.dimension.world.Dimension;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;
import java.io.IOException;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class Possession {

	public static final PacketPipeline packetPipeline = new PacketPipeline();
	@Instance(ModInfo.ID)
	public static Possession instance;
	@SidedProxy(clientSide = "com.tinkerlad.dimension.proxies.ClientProxy", serverSide = "com.tinkerlad.dimension.proxies.CommonProxy")
	public static CommonProxy proxy;
	public static GlobalStorage storedInv;
	public static File configDir;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) throws ClassNotFoundException, IOException {

		LogHelper.logger = event.getModLog();
		configDir = event.getSuggestedConfigurationFile();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		TabHandler.init();


		DimBlocks.init();
		DimItem.init();
		Dimension.init();
		DimensionsEntity.init();

		if (!GameControls.VANILLA_BED) {
			Utils.removeVanillaBed();
		}

		ClientProxy.registerRenderThings();
		GameRegistry.registerTileEntity(TileGlobalStorage.class, BlockInfo.GLOBAL_ULOCALIZED_NAME);

		Recipes.addRecipes();
		MinecraftForge.EVENT_BUS.register(new ForgeEventReciever());
		FMLCommonHandler.instance().bus().register(new FMLEventReciever());
	}

	@EventHandler
	public void initialise(FMLInitializationEvent evt) {

		packetPipeline.initialise();
	}

	@EventHandler
	public void postInitialise(FMLPostInitializationEvent evt) {

		packetPipeline.postInitialise();
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {

		event.registerServerCommand(new PossessionCommand());
	}

	@EventHandler
	public void serverStarted(FMLServerStartedEvent event) throws IOException, ClassNotFoundException {

		storedInv = new GlobalStorage(configDir);
	}

	@EventHandler
	public void serverStopping(FMLServerStoppingEvent event) throws IOException {

		System.out.println(GlobalStorage.saveToFile() ? "Saved Inventories Correctly" : "Did not save correctly");
	}
}
