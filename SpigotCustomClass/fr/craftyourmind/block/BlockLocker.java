package fr.craftyourmind.block;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.server.Block;
import net.minecraft.server.BlockFurnace;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.BlockStateDirection;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.Blocks;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.IBlockData;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Item;
import net.minecraft.server.Material;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityFurnace;
import net.minecraft.server.World;

public class BlockLocker extends Block
{
    @SuppressWarnings("unchecked")
	public static final BlockStateDirection FACING = BlockStateDirection.of("facing", (Predicate) EnumDirection.EnumDirectionLimit.HORIZONTAL);

    public BlockLocker(Material material)
    {
        super(material);
        this.w(this.blockStateList.getBlockData().set(BlockFurnace.FACING, EnumDirection.NORTH));
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Item.getItemOf(Blocks.FURNACE);
    }

    public void onPlace(World world, BlockPosition blockposition, IBlockData iblockdata) {
        this.e(world, blockposition, iblockdata);
    }

    private void e(World world, BlockPosition blockposition, IBlockData iblockdata) {
        if (!world.isClientSide) {
            IBlockData iblockdata1 = world.getType(blockposition.north());
            IBlockData iblockdata2 = world.getType(blockposition.south());
            IBlockData iblockdata3 = world.getType(blockposition.west());
            IBlockData iblockdata4 = world.getType(blockposition.east());
            EnumDirection enumdirection = (EnumDirection) iblockdata.get(BlockFurnace.FACING);

            if (enumdirection == EnumDirection.NORTH && iblockdata1.b() && !iblockdata2.b()) {
                enumdirection = EnumDirection.SOUTH;
            } else if (enumdirection == EnumDirection.SOUTH && iblockdata2.b() && !iblockdata1.b()) {
                enumdirection = EnumDirection.NORTH;
            } else if (enumdirection == EnumDirection.WEST && iblockdata3.b() && !iblockdata4.b()) {
                enumdirection = EnumDirection.EAST;
            } else if (enumdirection == EnumDirection.EAST && iblockdata4.b() && !iblockdata3.b()) {
                enumdirection = EnumDirection.WEST;
            }

            world.setTypeAndData(blockposition, iblockdata.set(BlockFurnace.FACING, enumdirection), 2);
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityFurnace();
    }

    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    public IBlockData getPlacedState(World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2, int i, EntityLiving entityliving) {
        return this.getBlockData().set(BlockFurnace.FACING, entityliving.getDirection().opposite());
    }

    public Item getItem(World worldIn, BlockPosition pos)
    {
        return Item.getItemOf(CYMBlock.LOCK); 
    }

    /**
     * The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render
     */
    public int getRenderType()
    {
        return 3;
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockData fromLegacyData(int i) {
        EnumDirection enumdirection = EnumDirection.fromType1(i);

        if (enumdirection.k() == EnumDirection.EnumAxis.Y) {
            enumdirection = EnumDirection.NORTH;
        }

        return this.getBlockData().set(BlockFurnace.FACING, enumdirection);
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((EnumDirection) iblockdata.get(BlockFurnace.FACING)).a();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockFurnace.FACING});
    }
}
