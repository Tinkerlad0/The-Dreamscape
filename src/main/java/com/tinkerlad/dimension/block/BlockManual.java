package com.tinkerlad.dimension.block;

import com.tinkerlad.dimension.Possession;
import com.tinkerlad.dimension.GUI.GuiManual;
import com.tinkerlad.dimension.reference.BlockInfo;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Michael on 6/15/2014.
 */
public class BlockManual extends BlockGeneric {

	public BlockManual() {
		super(Material.circuits);
		setBlockName(BlockInfo.MANUAL_NAME);
		setLightLevel(0.2F);
		setBlockTextureName(BlockInfo.TEXTURE_LOCATION + BlockInfo.MANUAL_NAME);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
	                                int hitX, float hitY, float hitZ, float par9) {
		player.openGui(Possession.instance, GuiManual.GUI_ID, world, x, y, z);
		return true;
	}

	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {

		player.openGui(Possession.instance, GuiManual.GUI_ID, world, x, y, z);
	}
}
