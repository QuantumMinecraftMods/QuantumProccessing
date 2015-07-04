package com.bigeebs.quantumprocessing;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=QuantumProcessing.MODID, name=QuantumProcessing.MODNAME, version=QuantumProcessing.MODVER) //Initialize mod
public class QuantumProcessing {

    //Set the ID of the mod
    public static final String MODID = "quantumprocessing";
    //Set the "Name" of the Mod
    public static final String MODNAME = "QuantumProcessing";
    //Set the version of the mod
    public static final String MODVER = "1.8.0-1.0";

    @Mod.Instance(QuantumProcessing.MODID) //Tell Forge what instance to use
    public static QuantumProcessing instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
