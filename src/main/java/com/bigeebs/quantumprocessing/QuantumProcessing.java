package com.bigeebs.quantumprocessing;


import com.bigeebs.quantumprocessing.handler.ConfigurationHandler;
import com.bigeebs.quantumprocessing.init.ModItems;
import com.bigeebs.quantumprocessing.proxy.IProxy;
import com.bigeebs.quantumprocessing.reference.Reference;
import com.bigeebs.quantumprocessing.utility.LogHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.sql.Ref;

@Mod(modid= Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VER, guiFactory = Reference.GUI_FACTORY_CLASS) //Initialize mod
public class QuantumProcessing {

    @Mod.Instance(Reference.MOD_ID) //Tell Forge what instance to use
    public static QuantumProcessing instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        ModItems.init();


        LogHelper.info("Pre Initialization Complete!!!");
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event)
    {
        LogHelper.info("Initialization Complete!!!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!!!");
    }
}
