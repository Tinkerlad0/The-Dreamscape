package com.tinkerlad.dimension.block.bed;

import com.tinkerlad.dimension.reference.BlockInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by Michael on 6/10/2014.
 */
public class BlockBed2 extends BlockBed1 {

	public BlockBed2() {
		setHardness(2F);
		setResistance(2F);
		setStepSound(soundTypeStone);
		setBlockName(BlockInfo.BASE_ULOCALIZED_NAME[1]);
		setBlockTextureName(BlockInfo.TEXTURE_LOCATION + BlockInfo.BEDROCK_TEXTURE);
		//setBlockTextureName(BlockInfo.BASE_TEXTURE[1]);
	}

	@Override
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		if (par5Entity instanceof EntityPlayer) {
			((EntityPlayer) par5Entity).addPotionEffect(new PotionEffect(Potion.heal.getId(), 50, 1, false));
			((EntityPlayer) par5Entity).addPotionEffect(new PotionEffect(Potion.confusion.getId(), 20, 1, false));
		}
	}
}
