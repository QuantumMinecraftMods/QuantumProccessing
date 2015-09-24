package com.bigeebs.quantumprocessing.block.LeadFurnace;

import com.bigeebs.quantumprocessing.block.QPMachineBlock;
import com.bigeebs.quantumprocessing.block.inventoryFurnace.BlockFurnace;
import com.bigeebs.quantumprocessing.creativeTab.CreativeTab;
import com.bigeebs.quantumprocessing.init.ModBlocks;
import com.bigeebs.quantumprocessing.names.BlockNames;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Created by Andrew.Ebert on 8/10/2015.
 */
public class LeadFurnace extends QPMachineBlock {

    public static final PropertyDirection FACING =
            PropertyDirection.create("facing",
                    EnumFacing.Plane.HORIZONTAL);
    private static boolean hasTileEntity;

    public LeadFurnace()
    {
        super();
        this.setUnlocalizedName(BlockNames.LEAD_FURNACE);
        this.setDefaultState(blockState.getBaseState().withProperty(
                FACING, EnumFacing.NORTH));
        this.setCreativeTab(CreativeTab.QUANTUM_PROCESSING);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(ModBlocks.leadFurnace);
    }

//    @Override
//    public boolean onBlockActivated(
//            World parWorld,
//            BlockPos parBlockPos,
//            IBlockState parIBlockState,
//            EntityPlayer parPlayer,
//            EnumFacing parSide,
//            float hitX,
//            float hitY,
//            float hitZ)
//    {
//        if (!parWorld.isRemote)
//        {
//            parPlayer.openGui(BlockSmith.instance,
//                    BlockSmith.GUI_ENUM.GRINDER.ordinal(),
//                    parWorld,
//                    parBlockPos.getX(),
//                    parBlockPos.getY(),
//                    parBlockPos.getZ());
//        }
//
//        return true;
//    }

//    @Override
//    public TileEntity createNewTileEntity(World worldIn, int meta)
//    {
//        // DEBUG
//        System.out.println("BlockGrinder createNewTileEntity()");
//        return new TileEntityGrinder();
//    }

    @Override
    public IBlockState onBlockPlaced(
            World worldIn,
            BlockPos pos,
            EnumFacing facing,
            float hitX,
            float hitY,
            float hitZ,
            int meta,
            EntityLivingBase placer)
    {
        return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(
            World worldIn,
            BlockPos pos,
            IBlockState state,
            EntityLivingBase placer,
            ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(
                        FACING,
                        placer.getHorizontalFacing().getOpposite()),
                2);
    }

//    @Override
//    public void breakBlock(
//            World worldIn,
//            BlockPos pos,
//            IBlockState state)
//    {
//        if (!hasTileEntity)
//        {
//            TileEntity tileentity = worldIn.getTileEntity(pos);
//
//            if (tileentity instanceof TileEntityGrinder)
//            {
//                InventoryHelper.dropInventoryItems(worldIn, pos,
//                        (TileEntityGrinder) tileentity);
//                worldIn.updateComparatorOutputLevel(pos, this);
//            }
//        }
//
//        super.breakBlock(worldIn, pos, state);
//    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(ModBlocks.leadFurnace);
    }

    @Override
    public int getRenderType()
    {
        return 3;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        return getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING});
    }

    @SideOnly(Side.CLIENT)
    static final class SwitchEnumFacing {
        static final int[] enumFacingArray = new int[EnumFacing.values()
                .length];

        static {
            try {
                enumFacingArray[EnumFacing.WEST.ordinal()] = 1;
            } catch (NoSuchFieldError var4) {
                ;
            }

            try {
                enumFacingArray[EnumFacing.EAST.ordinal()] = 2;
            } catch (NoSuchFieldError var3) {
                ;
            }

            try {
                enumFacingArray[EnumFacing.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError var2) {
                ;
            }

            try {
                enumFacingArray[EnumFacing.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError var1) {
                // You should improve the error handling here
            }
        }
    }
}
