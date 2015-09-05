package com.bigeebs.quantumprocessing.block.inventoryFurnace;

import com.bigeebs.quantumprocessing.QuantumProcessing;
import com.bigeebs.quantumprocessing.creativeTab.CreativeTab;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by bigee_000 on 9/4/2015.
 */
public class BlockFurnace extends BlockContainer
{
    public BlockFurnace()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTab.QUANTUM_PROCESSING);
    }

    // Called when the block is placed or loaded client side to get the tile entity for the block
    // Should return a new instance of the tile entity for the block
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileFurnace();
    }

    // Called when the block is right clicked
    // In this block it is used to open the blocks gui when right clicked by a player
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        // Uses the gui handler registered to your mod to open the gui for the given gui id
        // open on the server side only
        if (worldIn.isRemote) return true;

       // playerIn.openGui(QuantumProcessing.instance, GuiHandler.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    //This is where you can do something when the block is broken. In this case drop the inventory's contents
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if (tileEntity instanceof IInventory) {
            InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileEntity);
        }
        super.breakBlock(worldIn, pos, state);
    }
    // update the block state depending on the number of slots which contain burning fuel
//    @Override
//    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
//    {
//        TileEntity tileEntity = worldIn.getTileEntity(pos);
//        if (tileEntity instanceof TileFurnace) {
//            TileFurnace tileFurnace = (TileFurnace)tileEntity;
//            int burningSlots = tileFurnace.numberOfBurningFuelSlots();
//            burningSlots = MathHelper.clamp_int(burningSlots, 0, 4);
//            return getDefaultState().withProperty(BURNING_SIDES_COUNT, burningSlots);
//        }
//        return state;
//    }
//
//    @Override
//    public IBlockState getStateFromMeta(int meta)
//    {
//        return this.getDefaultState();
////		return this.getDefaultState().withProperty(BURNING_SIDES_COUNT, Integer.valueOf(meta));
//    }
//
//    @Override
//    public int getMetaFromState(IBlockState state)
//    {
//        return 0;
////		return ((Integer)state.getValue(BURNING_SIDES_COUNT)).intValue();
//    }
//
//    // necessary to define which properties your blocks use
//    // will also affect the variants listed in the blockstates model file.  See MBE03 for more info.
//    @Override
//    protected BlockState createBlockState()
//    {
//        return new BlockState(this, new IProperty[] {BURNING_SIDES_COUNT});
//    }
//
//    public static final PropertyInteger BURNING_SIDES_COUNT = PropertyInteger.create("burning_sides_count", 0, 4);
//
//    // change the furnace emitted light ("block light") depending on how many slots are burning
//    private static final int FOUR_SIDE_LIGHT_VALUE = 15; // light value for four sides burning
//    private static final int ONE_SIDE_LIGHT_VALUE = 8;  // light value for a single side burning
//
//    public int getLightValue(IBlockAccess world, BlockPos pos) {
//        int lightValue = 0;
//        IBlockState blockState = getActualState(getDefaultState(), world, pos);
//        int burningSides = (Integer)blockState.getValue(BURNING_SIDES_COUNT);
//
//        if (burningSides == 0) {
//            lightValue = 0;
//        } else {
//            // linearly interpolate the light value depending on how many slots are burning
//            lightValue = ONE_SIDE_LIGHT_VALUE + (int)((FOUR_SIDE_LIGHT_VALUE - ONE_SIDE_LIGHT_VALUE) / (4.0 - 1.0) * burningSides);
//        }
//        lightValue = MathHelper.clamp_int(lightValue, 0, FOUR_SIDE_LIGHT_VALUE);
//        return lightValue;
//    }
//
//    // the block will render in the SOLID layer.  See http://greyminecraftcoder.blogspot.co.at/2014/12/block-rendering-18.html for more information.
//    @SideOnly(Side.CLIENT)
//    public EnumWorldBlockLayer getBlockLayer()
//    {
//        return EnumWorldBlockLayer.SOLID;
//    }
//
//    // used by the renderer to control lighting and visibility of other blocks.
//    // set to false because this block doesn't fill the entire 1x1x1 space
//    @Override
//    public boolean isOpaqueCube() {
//        return false;
//    }
//
//    // used by the renderer to control lighting and visibility of other blocks, also by
//    // (eg) wall or fence to control whether the fence joins itself to this block
//    // set to false because this block doesn't fill the entire 1x1x1 space
//    @Override
//    public boolean isFullCube() {
//        return false;
//    }
//
//    // render using a BakedModel
//    // not strictly required because the default (super method) is 3.
//    @Override
//    public int getRenderType() {
//        return 3;
//    }
}

