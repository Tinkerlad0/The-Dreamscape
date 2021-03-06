package com.tinkerlad.dimension.world.nightmare;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureMineshaftStartNightmare extends StructureStart
{
	public StructureMineshaftStartNightmare() {}

    @SuppressWarnings("unchecked")
	public StructureMineshaftStartNightmare(World par1World, Random par2Random, int par3, int par4)
    {
    	super(par3, par4);
		StructureMineshaftPiecesNightmare.Room var5 = new StructureMineshaftPiecesNightmare.Room(0, par2Random, (par3 << 4) + 2, (par4 << 4) + 2);
        this.components.add(var5);
        var5.buildComponent(var5, this.components, par2Random);
        this.updateBoundingBox();
        this.markAvailableHeight(par1World, par2Random, 10);
    }
}