package com.bigeebs.quantumprocessing.init;

import com.bigeebs.quantumprocessing.item.QPItem;
import com.bigeebs.quantumprocessing.item.T1FissionFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew.Ebert on 7/11/2015.
 */
public class ModItems {

    public static QPItem t1FissionFurnace = new T1FissionFurnace();

    public static void init() {

        GameRegistry.registerItem(t1FissionFurnace, "fissionFurnace");
    }
}
