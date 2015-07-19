package com.bigeebs.quantumprocessing.item;

import com.bigeebs.quantumprocessing.creativeTab.CreativeTab;
import com.bigeebs.quantumprocessing.names.ItemNames;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew.Ebert on 7/11/2015.
 */
public class MatterWrench extends QPItem {

    public MatterWrench() {
        super();
        this.setCreativeTab(CreativeTab.QUANTUM_PROCESSING);
        this.setUnlocalizedName(ItemNames.MATTER_WRENCH);
    }
}
