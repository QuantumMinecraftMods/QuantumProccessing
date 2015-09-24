package com.bigeebs.quantumprocessing.block.LeadFurnace;

import com.bigeebs.quantumprocessing.QuantumProcessing;
import com.bigeebs.quantumprocessing.block.QPMachineBlock;
import com.bigeebs.quantumprocessing.creativeTab.CreativeTab;
import com.bigeebs.quantumprocessing.handler.GuiHandler;
import com.bigeebs.quantumprocessing.names.BlockNames;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Andrew.Ebert on 8/10/2015.
 */
public class LeadFurnace extends QPMachineBlock {

    public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public LeadFurnace(){
        this.setUnlocalizedName(BlockNames.LEAD_FURNACE);
        this.setCreativeTab(CreativeTab.QUANTUM_PROCESSING);
    }

    // Called when the block is placed or loaded client side to get the tile entity for the block
    // Should return a new instance of the tile entity for the block
    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new LeadFurnaceTileEntity();
    }

    // Called when the block is right clicked
    // In this block it is used to open the blocks gui when right clicked by a player
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        // Uses the gui handler registered to your mod to open the gui for the given gui id
        // open on the server side only  (not sure why you shouldn't open client side too... vanilla doesn't, so we better not either)
        if (worldIn.isRemote) return true;

        playerIn.openGui(QuantumProcessing.instance, GuiHandler.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    // This is where you can do something when the block is broken. In this case drop the inventory's contents
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

        IInventory inventory = worldIn.getTileEntity(pos) instanceof IInventory ? (IInventory)worldIn.getTileEntity(pos) : null;

        if (inventory != null){
            // For each slot in the inventory
            for (int i = 0; i < inventory.getSizeInventory(); i++){
                // If the slot is not empty
                if (inventory.getStackInSlot(i) != null)
                {
                    // Create a new entity item with the item stack in the slot
                    EntityItem item = new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory.getStackInSlot(i));

                    // Apply some random motion to the item
                    float multiplier = 0.1f;
                    float motionX = worldIn.rand.nextFloat() - 0.5f;
                    float motionY = worldIn.rand.nextFloat() - 0.5f;
                    float motionZ = worldIn.rand.nextFloat() - 0.5f;

                    item.motionX = motionX * multiplier;
                    item.motionY = motionY * multiplier;
                    item.motionZ = motionZ * multiplier;

                    // Spawn the item in the world
                    worldIn.spawnEntityInWorld(item);
                }
            }

            // Clear the inventory so nothing else (such as another mod) can do anything with the items
            inventory.clear();
        }

        // Super MUST be called last because it removes the tile entity
        super.breakBlock(worldIn, pos, state);
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.SOLID;
    }

    // used by the renderer to control lighting and visibility of other blocks.
    // set to false because this block doesn't fill the entire 1x1x1 space
    @Override
    public boolean isOpaqueCube()
    {
        return true;
    }

    // used by the renderer to control lighting and visibility of other blocks, also by
    // (eg) wall or fence to control whether the fence joins itself to this block
    @Override
    public boolean isFullCube()
    {
        return true;
    }

    // render using a BakedModel (mbe01_block_simple.json --> mbe01_block_simple_model.json)
    // not strictly required because the default (super method) is 3.
    @Override
    public int getRenderType() {
        return 3;
    }

    // getStateFromMeta, getMetaFromState are used to interconvert between the block's property values and
    //   the stored metadata (which must be an integer in the range 0 - 15 inclusive)
    // The property is encode as:
    // - lower two bits = facing direction (i.e. 0, 1, 2, 3)
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing facing = EnumFacing.getHorizontal(meta);
        return this.getDefaultState().withProperty(PROPERTYFACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);

        int facingbits = facing.getHorizontalIndex();
        return facingbits;
    }

    // necessary to define which properties your blocks use
    // will also affect the variants listed in the blockstates model file
    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {PROPERTYFACING});
    }

    // when the block is placed, set the appropriate facing direction based on which way the player is looking
    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw).getOpposite();

        return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing);
    }
}
