package com.bigeebs.quantumprocessing.init;

import com.bigeebs.quantumprocessing.block.*;
import com.bigeebs.quantumprocessing.block.LeadFurnace.LeadFurnace;
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
    public static QPMachineBlock leadFurnace;


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
        leadFurnace = new LeadFurnace();
    }

    public static void register()
    {
        GameRegistry.registerBlock(adamantiumOre, BlockNames.ADAMANTIUM_ORE);
        GameRegistry.registerBlock(aluminumOre, BlockNames.ALUMINUM_ORE);
        GameRegistry.registerBlock(copperOre, BlockNames.COPPER_ORE);
        GameRegistry.registerBlock(tinOre, BlockNames.TIN_ORE);
        GameRegistry.registerBlock(leadOre, BlockNames.LEAD_ORE);
        GameRegistry.registerBlock(uraniumOre, BlockNames.URANIUM_ORE);
        GameRegistry.registerBlock(plutoniumOre, BlockNames.PLUTONIUM_ORE);
        GameRegistry.registerBlock(vibraniumOre, BlockNames.VIBRANIUM_ORE);
        GameRegistry.registerBlock(leadFurnace, BlockNames.LEAD_FURNACE);
    }

    public static void registerRenders()
    {
        registerRender(adamantiumOre);
        registerRender(aluminumOre);
        registerRender(copperOre);
        registerRender(tinOre);
        registerRender(leadOre);
        registerRender(uraniumOre);
        registerRender(plutoniumOre);
        registerRender(vibraniumOre);
        registerRender(leadFurnace);
    }

    public static void registerRender(QPBlock block)
    {
        LogHelper.info(block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()));
        Item itemBlock = block.getItem(null, null);
        ModelResourceLocation itemModelLocation = new ModelResourceLocation(block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()), "inventory");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlock, DEFAULT_ITEM_SUBTYPE, itemModelLocation);

    }

    public static void registerRender(QPMachineBlock block)
    {
        LogHelper.info(block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()));
        Item itemBlock = block.getItem(null, null);
        ModelResourceLocation itemModelLocation = new ModelResourceLocation(block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()), "inventory");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlock, DEFAULT_ITEM_SUBTYPE, itemModelLocation);
    }


}
