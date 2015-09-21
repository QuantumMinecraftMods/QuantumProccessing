package com.bigeebs.quantumprocessing.init;

import com.typesafe.config.ConfigException;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew.Ebert on 9/3/2015.
 */
public class Recipes {

    public static void initShapedRecipes(){
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.matterWrench), " i ", " ii", "i  " , 'i', new ItemStack(Items.iron_ingot));
    }

    public static void initShaplessRecipes(){

    }

    public static void initSmeltingRecipes(){
        GameRegistry.addSmelting(new ItemStack(ModBlocks.adamantiumOre),new ItemStack(ModItems.adamantiumIngot), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.aluminumOre),new ItemStack(ModItems.aluminumIngot), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.copperOre),new ItemStack(ModItems.copperIngot), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.leadOre),new ItemStack(ModItems.leadIngot), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.uraniumOre),new ItemStack(ModItems.uraniumIngot), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.plutoniumOre),new ItemStack(ModItems.plutoniumIngot), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.vibraniumOre),new ItemStack(ModItems.vibraniumIngot), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.tinOre),new ItemStack(ModItems.tinIngot), 0.0F);
    }
}
