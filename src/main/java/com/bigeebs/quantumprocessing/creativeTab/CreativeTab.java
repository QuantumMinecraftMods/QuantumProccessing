package com.bigeebs.quantumprocessing.creativeTab;

import com.bigeebs.quantumprocessing.init.ModItems;
import com.bigeebs.quantumprocessing.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by bigee_000 on 7/12/2015.
 */
public class CreativeTab {

    public static final CreativeTabs QUANTUM_PROCESSING = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {

        @Override
        public Item getTabIconItem() {
            return ModItems.Wrench;
        }
    };
}
