package com.bigeebs.quantumprocessing.block.LeadFurnace;

import com.bigeebs.quantumprocessing.block.LeadFurnace.LeadFurnaceContainer;
import com.bigeebs.quantumprocessing.block.LeadFurnace.LeadFurnaceGUI;
import com.bigeebs.quantumprocessing.block.LeadFurnace.LeadFurnaceTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by Andrew.Ebert on 9/23/2015.
 */
public class LeadFurnaceGuiHandler implements IGuiHandler {
    private static final int GUIID_QP_ID = 31;
    public static int getGuiID() {return GUIID_QP_ID;}

    // Gets the server side element for the given gui id this should return a container
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID != getGuiID()) {
            System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
        }

        BlockPos xyz = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(xyz);
        if (tileEntity instanceof LeadFurnaceTileEntity) {
            LeadFurnaceTileEntity tileInventoryFurnace = (LeadFurnaceTileEntity) tileEntity;
            return new LeadFurnaceContainer(player.inventory, tileInventoryFurnace);
        }
        return null;
    }

    // Gets the client side element for the given gui id this should return a gui
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID != getGuiID()) {
            System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
        }

        BlockPos xyz = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(xyz);
        if (tileEntity instanceof LeadFurnaceTileEntity) {
            LeadFurnaceTileEntity tileInventoryFurnace = (LeadFurnaceTileEntity) tileEntity;
            return new LeadFurnaceGUI(player.inventory, tileInventoryFurnace);
        }
        return null;
    }
}
