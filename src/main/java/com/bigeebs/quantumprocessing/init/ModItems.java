package com.bigeebs.quantumprocessing.init;

import com.bigeebs.quantumprocessing.item.QPItem;
import com.bigeebs.quantumprocessing.item.MatterWrench;
import com.bigeebs.quantumprocessing.names.ItemNames;
import com.bigeebs.quantumprocessing.reference.Reference;
import com.bigeebs.quantumprocessing.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;


/**
 * Created by Andrew.Ebert on 7/11/2015.
 */
public class ModItems {

    public static Item Wrench;

    public static void init()
    {
        Wrench = new MatterWrench();
    }

    public static void register()
    {
        GameRegistry.registerItem(Wrench, ItemNames.MATTER_WRENCH);
    }

    public static void registerRenders()
    {
        registerRender(Wrench);
    }

    public static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ItemNames.MATTER_WRENCH, "inventory"));
    }
}
