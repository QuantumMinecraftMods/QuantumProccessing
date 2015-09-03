package com.bigeebs.quantumprocessing.init;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew.Ebert on 9/3/2015.
 */
public class Recipes {

    public static void init() {
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.Wrench), " i ", " ii", "i  " , 'i', new ItemStack(Items.iron_ingot));
    }
}
