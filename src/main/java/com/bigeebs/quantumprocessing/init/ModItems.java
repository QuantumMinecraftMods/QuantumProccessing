package com.bigeebs.quantumprocessing.init;

import com.bigeebs.quantumprocessing.item.QPItem;
import com.bigeebs.quantumprocessing.item.MatterWrench;
import com.bigeebs.quantumprocessing.names.ItemNames;
import com.bigeebs.quantumprocessing.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;


/**
 * Created by Andrew.Ebert on 7/11/2015.
 */
public class ModItems {

    public static QPItem Wrench;

    public static void init()
    {
        Wrench = new MatterWrench();
    }

    public static void register()
    {
        GameRegistry.registerItem(Wrench, ItemNames.MatterWrench);
    }

    public static void registerRenders()
    {
        registerRender(Wrench);
    }

    public static void registerRender(QPItem item)
    {
        LogHelper.info(item.getUnwrappedUnlocalizedName(item.getUnlocalizedName()));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getUnwrappedUnlocalizedName(item.getUnlocalizedName()), "inventory"));
    }
}
