package com.bigeebs.quantumprocessing.init;

import com.bigeebs.quantumprocessing.item.QPItem;
import com.bigeebs.quantumprocessing.item.MatterWrench;
import com.bigeebs.quantumprocessing.names.ItemNames;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew.Ebert on 7/11/2015.
 */
public class ModItems {

    public static QPItem Wrench = new MatterWrench();

    public static void init() {

        GameRegistry.registerItem(Wrench, ItemNames.MatterWrench);
    }
}
