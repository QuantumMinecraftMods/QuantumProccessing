package com.bigeebs.quantumprocessing.block.LeadFurnace;

import com.bigeebs.quantumprocessing.reference.Names;
import com.bigeebs.quantumprocessing.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

/**
 * Created by Andrew.Ebert on 9/23/2015.
 */

@SideOnly(Side.CLIENT)
public class LeadFurnaceGUI extends GuiContainer{

    // This is the resource location for the background image for the GUI
    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/container/leadFurnace.png");
    private LeadFurnaceTileEntity leadFurnaceTileEntity;

    public LeadFurnaceGUI(InventoryPlayer invPlayer, LeadFurnaceTileEntity tileEntity)
    {
        super(new LeadFurnaceContainer(invPlayer, tileEntity));
        leadFurnaceTileEntity = tileEntity;
        // Set the width and height of the gui.  Should match the size of the texture!
        xSize = 175;
        ySize = 165;
    }

    // draw the background for the GUI - rendered first
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {
        // Bind the image texture of our custom container
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        // Draw the image
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    // draw the foreground for the GUI - rendered after the slots, but before the dragged items and tooltips
    // renders relative to the top left corner of the background
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        int stringLen = (int)fontRendererObj.getStringWidth(leadFurnaceTileEntity.getDisplayName().getUnformattedText());
        int start = stringLen/2;
        fontRendererObj.drawString(leadFurnaceTileEntity.getDisplayName().getUnformattedText(), xSize/2 - start, 5, Color.darkGray.getRGB());
    }
}
