package com.bigeebs.quantumprocessing.init;

import com.bigeebs.quantumprocessing.item.*;
import com.bigeebs.quantumprocessing.names.ItemNames;
import com.bigeebs.quantumprocessing.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;


/**
 * Created by Andrew.Ebert on 7/11/2015.
 */
public class ModItems {

    //Tools
    public static QPItem matterWrench;

    //Dusts
    public static QPItem adamantiumDust;
    public static QPItem aluminumDust;
    public static QPItem copperDust;
    public static QPItem diamondDust;
    public static QPItem emeraldDust;
    public static QPItem enderDust;
    public static QPItem goldDust;
    public static QPItem ironDust;
    public static QPItem leadDust;
    public static QPItem plutoniumDust;
    public static QPItem tinDust;
    public static QPItem uraniumDust;
    public static QPItem vibraniumDust;

    //Ingots
    public static QPItem adamantiumIngot;
    public static QPItem aluminumIngot;
    public static QPItem copperIngot;
    public static QPItem leadIngot;
    public static QPItem plutoniumIngot;
    public static QPItem tinIngot;
    public static QPItem uraniumIngot;
    public static QPItem vibraniumIngot;

    public static void init()
    {
        //Tools
        matterWrench = new MatterWrench();

        //Dusts
        adamantiumDust = new AdamantiumDust();
        aluminumDust = new AluminumDust();
        copperDust = new CopperDust();
        diamondDust = new DiamondDust();
        emeraldDust = new EmeraldDust();
        enderDust = new EnderDust();
        goldDust = new GoldDust();
        ironDust = new IronDust();
        leadDust = new LeadDust();
        plutoniumDust = new PlutoniumDust();
        tinDust = new TinDust();
        uraniumDust = new UraniumDust();
        vibraniumDust = new VibraniumDust();

        //Ingots
        adamantiumIngot = new AdamantiumIngot();
        aluminumIngot = new AluminumIngot();
        copperIngot = new CopperIngot();
        leadIngot = new LeadIngot();
        plutoniumIngot = new PlutoniumIngot();
        tinIngot = new TinIngot();
        uraniumIngot = new UraniumIngot();
        vibraniumIngot = new VibraniumIngot();

    }

    public static void register()
    {
        //Tools
        GameRegistry.registerItem(matterWrench, ItemNames.MATTER_WRENCH);

        //Dusts
        GameRegistry.registerItem(adamantiumDust, ItemNames.ADAMANTIUM_DUST);
        GameRegistry.registerItem(aluminumDust, ItemNames.ALUMINUM_DUST);
        GameRegistry.registerItem(copperDust, ItemNames.COPPER_DUST);
        GameRegistry.registerItem(diamondDust, ItemNames.DIAMOND_DUST);
        GameRegistry.registerItem(emeraldDust, ItemNames.EMERALD_DUST);
        GameRegistry.registerItem(enderDust, ItemNames.ENDER_DUST);
        GameRegistry.registerItem(goldDust, ItemNames.GOLD_DUST);
        GameRegistry.registerItem(ironDust, ItemNames.IRON_DUST);
        GameRegistry.registerItem(leadDust, ItemNames.LEAD_DUST);
        GameRegistry.registerItem(plutoniumDust, ItemNames.PLUTONIUM_DUST);
        GameRegistry.registerItem(tinDust, ItemNames.TIN_DUST);
        GameRegistry.registerItem(uraniumDust, ItemNames.URANIUM_DUST);
        GameRegistry.registerItem(vibraniumDust, ItemNames.VIBRANIUM_DUST);

        //Ingots
        GameRegistry.registerItem(adamantiumIngot, ItemNames.ADAMANTIUM_INGOT);
        GameRegistry.registerItem(aluminumIngot, ItemNames.ALUMINUM_INGOT);
        GameRegistry.registerItem(copperIngot, ItemNames.COPPER_INGOT);
        GameRegistry.registerItem(leadIngot, ItemNames.LEAD_INGOT);
        GameRegistry.registerItem(plutoniumIngot, ItemNames.PLUTONIUM_INGOT);
        GameRegistry.registerItem(tinIngot, ItemNames.TIN_INGOT);
        GameRegistry.registerItem(uraniumIngot, ItemNames.URANIUM_INGOT);
        GameRegistry.registerItem(vibraniumIngot, ItemNames.VIBRANIUM_INGOT);
    }

    public static void registerRenders()
    {
        //Tools
        registerRender(matterWrench);

        //Dusts
        registerRender(adamantiumDust);
        registerRender(aluminumDust);
        registerRender(copperDust);
        registerRender(diamondDust);
        registerRender(emeraldDust);
        registerRender(enderDust);
        registerRender(goldDust);
        registerRender(ironDust);
        registerRender(leadDust);
        registerRender(plutoniumDust);
        registerRender(tinDust);
        registerRender(uraniumDust);
        registerRender(vibraniumDust);

        //Ingots
        registerRender(adamantiumIngot);
        registerRender(aluminumIngot);
        registerRender(copperIngot);
        registerRender(leadIngot);
        registerRender(plutoniumIngot);
        registerRender(tinIngot);
        registerRender(uraniumIngot);
        registerRender(vibraniumIngot);
    }

    public static void registerRender(QPItem item)
    {
        LogHelper.info(item.getUnwrappedUnlocalizedName(item.getUnlocalizedName()));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getUnwrappedUnlocalizedName(item.getUnlocalizedName()), "inventory"));
    }
}
