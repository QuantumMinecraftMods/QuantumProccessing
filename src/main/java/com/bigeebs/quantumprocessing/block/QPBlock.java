package com.bigeebs.quantumprocessing.block;

import com.bigeebs.quantumprocessing.creativeTab.CreativeTab;
import com.bigeebs.quantumprocessing.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class QPBlock extends Block {

    public QPBlock(Material material) {
        super(material);
        this.setCreativeTab(CreativeTab.QUANTUM_PROCESSING);

    }

    public String getUnlocalizedName() {
        return String.format("block.%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    public String getUnlocalizedName(Block block) {
        return String.format("block.%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    public String getUnwrappedUnlocalizedName(String unlocalizedName) {

        return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
    }

}
