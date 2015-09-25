package com.bigeebs.quantumprocessing.block.LeadFurnace;

import com.bigeebs.quantumprocessing.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Andrew.Ebert on 9/23/2015.
 */
public class LeadFurnaceContainer extends Container {

    // Stores a reference to the tile entity instance for later use
    private LeadFurnaceTileEntity leadFurnaceTileEntity;

    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 39 = TileInventory slots, which map to our TileEntity slot numbers 0 - 3)

    private final int HOTBAR_SLOT_COUNT = 9;
    private final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private final int PLAYER_INVENTORY_COLUMN_COUNT = 9;

    private final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;

    private final int VANILLA_FIRST_SLOT_INDEX = 0;

    private final int LEAD_FURNACE_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private final int LEAD_FURNACE_SLOT_COUNT = 4;

    public LeadFurnaceContainer(InventoryPlayer invPlayer, LeadFurnaceTileEntity tileEntity)
    {
        this.leadFurnaceTileEntity = tileEntity;

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
        }

        if (LEAD_FURNACE_SLOT_COUNT != leadFurnaceTileEntity.getSizeInventory()) {
            LogHelper.debug("Mismatched slot count in ContainerBasic(" + LEAD_FURNACE_SLOT_COUNT
                    + ") and TileInventory (" + leadFurnaceTileEntity.getSizeInventory() + ")");
        }
        addSlotToContainer(new Slot(leadFurnaceTileEntity, 0, 35, 17));
        addSlotToContainer(new Slot(leadFurnaceTileEntity, 1, 56, 17));
        addSlotToContainer(new Slot(leadFurnaceTileEntity, 2, 45, 53));
        addSlotToContainer(new Slot(leadFurnaceTileEntity, 3, 116, 35));
    }

    // Vanilla calls this method every tick to make sure the player is still able to access the inventory, and if not closes the gui
    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return leadFurnaceTileEntity.isUseableByPlayer(player);
    }

    // This is where you specify what happens when a player shift clicks a slot in the gui
    //  (when you shift click a slot in the TileEntity Inventory, it moves it to the first available position in the hotbar and/or
    //    player inventory.  When you you shift-click a hotbar or player inventory item, it moves it to the first available
    //    position in the TileEntity inventory)
    // At the very least you must override this and return null or the game will crash when the player shift clicks a slot
    // returns null if the source slot is empty, or if none of the the source slot items could be moved
    //   otherwise, returns a copy of the source stack
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int sourceSlotIndex)
    {
        Slot sourceSlot = (Slot)inventorySlots.get(sourceSlotIndex);
        if (sourceSlot == null || !sourceSlot.getHasStack()) return null;
        ItemStack sourceStack = sourceSlot.getStack();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (sourceSlotIndex >= VANILLA_FIRST_SLOT_INDEX && sourceSlotIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!mergeItemStack(sourceStack, LEAD_FURNACE_FIRST_SLOT_INDEX, LEAD_FURNACE_FIRST_SLOT_INDEX + LEAD_FURNACE_SLOT_COUNT, false)){
                return null;
            }
        } else if (sourceSlotIndex >= LEAD_FURNACE_FIRST_SLOT_INDEX && sourceSlotIndex < LEAD_FURNACE_FIRST_SLOT_INDEX + LEAD_FURNACE_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!mergeItemStack(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return null;
            }
        } else {
            System.err.print("Invalid slotIndex:" + sourceSlotIndex);
            return null;
        }

        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.stackSize == 0) {
            sourceSlot.putStack(null);
        } else {
            sourceSlot.onSlotChanged();
        }

        sourceSlot.onPickupFromSlot(player, sourceStack);
        return copyOfSourceStack;
    }

    // pass the close container message to the tileEntityInventory (not strictly needed for this example)
    //  see ContainerChest and TileEntityChest
    @Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        this.leadFurnaceTileEntity.closeInventory(playerIn);
    }
}
