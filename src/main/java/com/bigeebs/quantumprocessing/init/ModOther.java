package com.bigeebs.quantumprocessing.init;

import com.bigeebs.quantumprocessing.QuantumProcessing;
import com.bigeebs.quantumprocessing.block.LeadFurnace.LeadFurnaceGuiHandler;
import com.bigeebs.quantumprocessing.block.LeadFurnace.LeadFurnaceTileEntity;
import com.bigeebs.quantumprocessing.handler.GuiHandlerRegistry;
import com.bigeebs.quantumprocessing.names.TileEntityNames;
import com.bigeebs.quantumprocessing.worldGen.OreGeneration;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew.Ebert on 9/24/2015.
 */
public class ModOther {

    public static void init() {

        initTileEntity();

        //Gui Handler
        NetworkRegistry.INSTANCE.registerGuiHandler(QuantumProcessing.instance, GuiHandlerRegistry.getInstance());
        GuiHandlerRegistry.getInstance().registerGuiHandler(new LeadFurnaceGuiHandler(), LeadFurnaceGuiHandler.getGuiID());

        //Ore Gen
        GameRegistry.registerWorldGenerator(new OreGeneration(), 1);
    }

    public static void initTileEntity() {
        GameRegistry.registerTileEntity(LeadFurnaceTileEntity.class, TileEntityNames.LEAD_FURNACE_TILE_ENTITY);
    }
}
