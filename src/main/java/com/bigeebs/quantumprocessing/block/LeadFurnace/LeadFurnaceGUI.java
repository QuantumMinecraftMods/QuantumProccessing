package com.bigeebs.quantumprocessing.block.LeadFurnace;

import com.bigeebs.quantumprocessing.reference.Names;
import com.bigeebs.quantumprocessing.reference.Reference;
import com.bigeebs.quantumprocessing.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.ArrayList;

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

    private final int FLAME_XPOS = 58;
    private final int FLAME_YPOS = 37;
    private final int FLAME_ICON_XPOS = 176;
    private final int FLAME_ICON_YPOS = 0;
    private final int FLAME_WIDTH = 14;
    private final int FLAME_HEIGHT = 14;

    private final int ARROW_XPOS = 79;
    private final int ARROW_YPOS = 35;
    private final int ARROW_ICON_XPOS = 176;
    private final int ARROW_ICON_YPOS = 14;
    private final int ARROW_WIDTH = 24;
    private final int ARROW_HEIGHT = 17;


    // draw the background for the GUI - rendered first
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {
        // Bind the image texture of our custom container
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        // Draw the image
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        double cookProgress = leadFurnaceTileEntity.fractionOfCookTimeComplete();
        // draw the cook progress bar
        drawTexturedModalRect(guiLeft + ARROW_XPOS, guiTop + ARROW_YPOS, ARROW_ICON_XPOS, ARROW_ICON_YPOS,
                (int)(cookProgress * ARROW_WIDTH), ARROW_HEIGHT);

        // draw the fuel remaining bar for each fuel slot flame
        double burnRemaining = leadFurnaceTileEntity.fractionOfFuelRemaining();
        int yOffset = (int)((1.0 - burnRemaining) * FLAME_HEIGHT);
        drawTexturedModalRect(guiLeft + FLAME_XPOS, guiTop + FLAME_YPOS + yOffset,
                FLAME_ICON_XPOS, FLAME_ICON_YPOS + yOffset, FLAME_WIDTH, FLAME_HEIGHT - yOffset);

    }

    // draw the foreground for the GUI - rendered after the slots, but before the dragged items and tooltips
    // renders relative to the top left corner of the background
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        int stringLen = (int)fontRendererObj.getStringWidth(leadFurnaceTileEntity.getDisplayName().getUnformattedText());
        int start = stringLen/2;
        fontRendererObj.drawString(leadFurnaceTileEntity.getDisplayName().getUnformattedText(), xSize/2 - start, 5, Color.darkGray.getRGB());

    }

    // Returns true if the given x,y coordinates are within the given rectangle
    public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY){
        return ((mouseX >= x && mouseX <= x+xSize) && (mouseY >= y && mouseY <= y+ySize));
    }
}
