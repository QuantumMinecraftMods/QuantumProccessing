package com.bigeebs.quantumprocessing.block;

import com.bigeebs.quantumprocessing.creativeTab.CreativeTab;
import com.bigeebs.quantumprocessing.names.BlockNames;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Andrew.Ebert on 8/10/2015.
 */
public class AluminumOre extends QPBlock {

    public AluminumOre()
    {
        super(Material.rock);
        this.setUnlocalizedName(BlockNames.AluminumOre);
        this.setCreativeTab(CreativeTab.QUANTUM_PROCESSING);
    }

    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.SOLID;
    }

    @Override
    public boolean isOpaqueCube() {
        return true;
    }

    @Override
    public boolean isFullCube() {
        return true;
    }

    @Override
    public int getRenderType() {
        return 3;
    }
}
