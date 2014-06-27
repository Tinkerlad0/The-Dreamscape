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
import com.tinkerlad.dimension.creativeTab.TabHandler;
import com.tinkerlad.dimension.effects.potion.Potions;
import com.tinkerlad.dimension.entity.DimensionsEntity;
import com.tinkerlad.dimension.GUI.GUIHandler;
import com.tinkerlad.dimension.item.DimItem;
import com.tinkerlad.dimension.logging.LogHelper;
import com.tinkerlad.dimension.packetHandling.PacketPipeline;
import com.tinkerlad.dimension.proxies.ClientProxy;
import com.tinkerlad.dimension.proxies.CommonProxy;
import com.tinkerlad.dimension.reference.BlockInfo;
import com.tinkerlad.dimension.reference.ModInfo;
import com.tinkerlad.dimension.tileEntities.TileBedMaster;
import com.tinkerlad.dimension.tileEntities.TileGlobalStorage;
import com.tinkerlad.dimension.utils.FMLEventReceiver;
import com.tinkerlad.dimension.utils.ForgeEventReceiver;
import com.tinkerlad.dimension.utils.Recipes;
import com.tinkerlad.dimension.utils.Utils;
import com.tinkerlad.dimension.world.Dimension;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.io.IOException;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class Possession {

	public static final PacketPipeline packetPipeline = new PacketPipeline();
	@Instance(ModInfo.ID)
	public static Possession instance;
	@SidedProxy(clientSide = "com.tinkerlad.dimension.proxies.ClientProxy", serverSide = "com.tinkerlad.dimension.proxies.CommonProxy")
	public static CommonProxy proxy;

	public static Configuration configFile;
	public static boolean VANILLA_BED = false;

	public static void syncConfig() {

		VANILLA_BED = configFile.hasChanged();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) throws ClassNotFoundException, IOException {

		configFile = new Configuration(event.getSuggestedConfigurationFile());

		syncConfig();

		LogHelper.logger = event.getModLog();
		TabHandler.init();

		DimBlocks.init();
		DimItem.init();
		Dimension.init();
		DimensionsEntity.init();

		if (!VANILLA_BED) {
			Utils.removeVanillaBed();
		}

		ClientProxy.registerRenderThings();
		GameRegistry.registerTileEntity(TileGlobalStorage.class, BlockInfo.GLOBAL_ULOCALIZED_NAME);
		GameRegistry.registerTileEntity(TileBedMaster.class, BlockInfo.MASTER_ULOCALIZED_NAME);

		MinecraftForge.EVENT_BUS.register(new ForgeEventReceiver());
		FMLCommonHandler.instance().bus().register(new FMLEventReceiver());

		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());

		Potions.preInit();
		Potions.init();

		Recipes.addRecipes();
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
}
