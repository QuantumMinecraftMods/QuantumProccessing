package com.bigeebs.quantumprocessing.init;

import com.bigeebs.quantumprocessing.block.*;
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
    public static QPBlock copperOre;
    public static QPBlock tinOre;
    public static QPBlock leadOre;
    public static QPBlock uraniumOre;
    public static QPBlock plutoniumOre;
    public static QPBlock vibraniumOre;
    public static QPBlock adamantiumOre;

    public static void init()
    {
        aluminumOre = new AluminumOre();
        copperOre = new CopperOre();
        tinOre = new TinOre();
        leadOre = new LeadOre();
        uraniumOre = new UraniumOre();
        plutoniumOre = new PlutoniumOre();
        vibraniumOre = new VibraniumOre();
        adamantiumOre = new AdamantiumOre();

    }

    public static void register()
    {
        GameRegistry.registerBlock(aluminumOre, BlockNames.AluminumOre);
        GameRegistry.registerBlock(copperOre, BlockNames.CopperOre);
        GameRegistry.registerBlock(tinOre, BlockNames.TinOre);
        GameRegistry.registerBlock(leadOre, BlockNames.LeadOre);
        GameRegistry.registerBlock(uraniumOre, BlockNames.UraniumOre);
        GameRegistry.registerBlock(plutoniumOre, BlockNames.PlutoniumOre);
        GameRegistry.registerBlock(vibraniumOre, BlockNames.VibraniumOre);
        GameRegistry.registerBlock(adamantiumOre, BlockNames.AdamantiumOre);
    }

    public static void registerRenders()
    {
        registerRender(aluminumOre);
        registerRender(copperOre);
        registerRender(tinOre);
        registerRender(leadOre);
        registerRender(uraniumOre);
        registerRender(plutoniumOre);
        registerRender(vibraniumOre);
        registerRender(adamantiumOre);
    }

    public static void registerRender(QPBlock block)
    {
        LogHelper.info(block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()));
        Item itemBlock = block.getItem(null, null);
        ModelResourceLocation itemModelLocation = new ModelResourceLocation(block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()), "inventory");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlock, DEFAULT_ITEM_SUBTYPE, itemModelLocation);

    }


}
