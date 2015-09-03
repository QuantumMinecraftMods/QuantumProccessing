package com.bigeebs.quantumprocessing.init;

import com.bigeebs.quantumprocessing.block.AluminumOre;
import com.bigeebs.quantumprocessing.block.FissionFurnaceT1;
import com.bigeebs.quantumprocessing.block.QPBlock;
import com.bigeebs.quantumprocessing.item.QPItem;
import com.bigeebs.quantumprocessing.names.BlockNames;
import com.bigeebs.quantumprocessing.reference.Reference;
import com.bigeebs.quantumprocessing.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew.Ebert on 7/19/2015.
 */
public class ModBlocks {

    public static QPBlock fissionFurnaceT1;
    public static QPBlock aluminumOre;

    public static void init()
    {
        fissionFurnaceT1 = new FissionFurnaceT1(Material.rock);

        //World Gen
        aluminumOre = new AluminumOre();
    }

    public static void register()
    {
        GameRegistry.registerBlock(fissionFurnaceT1, BlockNames.FissionFurnaceT1);
        GameRegistry.registerBlock(aluminumOre, BlockNames.AluminumOre);
    }

    public static void registerRenders()
    {
        registerRender(fissionFurnaceT1);
        registerRender(aluminumOre);
    }

    public static void registerRender(QPBlock block)
    {
        LogHelper.info(block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()), "normal"));
    }


}
