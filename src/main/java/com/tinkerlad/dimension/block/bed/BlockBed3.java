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
public class BlockBed3 extends BlockBed2 {

	public BlockBed3() {
		setHardness(3F);
		setResistance(3F);
		setStepSound(soundTypeStone);
		setBlockName(BlockInfo.BASE_ULOCALIZED_NAME[2]);
		setBlockTextureName(BlockInfo.BASE_TEXTURE[2]);
	}

	@Override
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		if (par5Entity instanceof EntityPlayer) {
			((EntityPlayer) par5Entity).addPotionEffect(new PotionEffect(Potion.heal.getId(), 50, 3, false));
			((EntityPlayer) par5Entity).addPotionEffect(new PotionEffect(Potion.confusion.getId(), 20, 2, false));
			((EntityPlayer) par5Entity).addPotionEffect(new PotionEffect(Potion.hunger.getId(), 20, 2, false));
		}
	}
}

