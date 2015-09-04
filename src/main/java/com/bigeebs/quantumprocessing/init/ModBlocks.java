package com.bigeebs.quantumprocessing.init;

import com.bigeebs.quantumprocessing.block.AluminumOre;
import com.bigeebs.quantumprocessing.block.QPBlock;
import com.bigeebs.quantumprocessing.names.BlockNames;
import com.bigeebs.quantumprocessing.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew.Ebert on 7/19/2015.
 */
public class ModBlocks {

    public static final int DEFAULT_ITEM_SUBTYPE = 0;

    public static QPBlock aluminumOre;

    public static void init()
    {
        aluminumOre = new AluminumOre();
    }

    public static void register()
    {
        GameRegistry.registerBlock(aluminumOre, BlockNames.AluminumOre);
    }

    public static void registerRenders()
    {
        registerRender(aluminumOre);
    }

    public static void registerRender(QPBlock block)
    {
        LogHelper.info(block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()));
        Item itemBlock = block.getItem(null, null);
        ModelResourceLocation itemModelLocation = new ModelResourceLocation(block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()), "inventory");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlock, DEFAULT_ITEM_SUBTYPE, itemModelLocation);

    }


}
