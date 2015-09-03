package com.bigeebs.quantumprocessing.block;

import com.bigeebs.quantumprocessing.creativeTab.CreativeTab;
import com.bigeebs.quantumprocessing.names.BlockNames;
import net.minecraft.block.material.Material;

/**
 * Created by Andrew.Ebert on 8/10/2015.
 */
public class AluminumOre extends QPBlock {

    public AluminumOre()
    {
        super(Material.iron);
        this.setUnlocalizedName(BlockNames.AluminumOre);
        this.setCreativeTab(CreativeTab.QUANTUM_PROCESSING);
    }
}
