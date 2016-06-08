/*
 * Decompiled with CFR 0_114.
 */
package fr.craftyourmind.block;

import fr.craftyourmind.block.CYMBlock;
import java.util.Random;
import net.minecraft.server.v1_9_R2.Block;
import net.minecraft.server.v1_9_R2.BlockFurnace;
import net.minecraft.server.v1_9_R2.BlockPosition;
import net.minecraft.server.v1_9_R2.BlockStateDirection;
import net.minecraft.server.v1_9_R2.BlockStateList;
import net.minecraft.server.v1_9_R2.Blocks;
import net.minecraft.server.v1_9_R2.EntityLiving;
import net.minecraft.server.v1_9_R2.EnumDirection;
import net.minecraft.server.v1_9_R2.IBlockData;
import net.minecraft.server.v1_9_R2.IBlockState;
import net.minecraft.server.v1_9_R2.Item;
import net.minecraft.server.v1_9_R2.Material;
import net.minecraft.server.v1_9_R2.TileEntity;
import net.minecraft.server.v1_9_R2.TileEntityFurnace;
import net.minecraft.server.v1_9_R2.World;

public class BlockLocker
extends Block {
    public static final BlockStateDirection FACING = BlockStateDirection.of("facing", EnumDirection.EnumDirectionLimit.HORIZONTAL);

    public BlockLocker(Material material) {
        super(material);
        this.w(this.blockStateList.getBlockData().set(BlockFurnace.FACING, EnumDirection.NORTH));
    }

    @Override
    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Item.getItemOf(Blocks.FURNACE);
    }

    @Override
    public void onPlace(World world, BlockPosition blockposition, IBlockData iblockdata) {
        this.e(world, blockposition, iblockdata);
    }

    private void e(World world, BlockPosition blockposition, IBlockData iblockdata) {
        if (!world.isClientSide) {
            IBlockData iblockdata1 = world.getType(blockposition.north());
            IBlockData iblockdata2 = world.getType(blockposition.south());
            IBlockData iblockdata3 = world.getType(blockposition.west());
            IBlockData iblockdata4 = world.getType(blockposition.east());
            EnumDirection enumdirection = (EnumDirection)iblockdata.get(BlockFurnace.FACING);
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

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityFurnace();
    }

    @Override
    public IBlockData getPlacedState(World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2, int i, EntityLiving entityliving) {
        return this.getBlockData().set(BlockFurnace.FACING, entityliving.getDirection().opposite());
    }

    public Item getItem(World worldIn, BlockPosition pos) {
        return Item.getItemOf(CYMBlock.LOCK);
    }

    public int getRenderType() {
        return 3;
    }

    @Override
    public IBlockData fromLegacyData(int i) {
        EnumDirection enumdirection = EnumDirection.fromType1(i);
        if (enumdirection.k() == EnumDirection.EnumAxis.Y) {
            enumdirection = EnumDirection.NORTH;
        }
        return this.getBlockData().set(BlockFurnace.FACING, enumdirection);
    }

    @Override
    public int toLegacyData(IBlockData iblockdata) {
        return ((EnumDirection)iblockdata.get(BlockFurnace.FACING)).a();
    }

    @Override
    protected BlockStateList getStateList() {
        return new BlockStateList(this, BlockFurnace.FACING);
    }
}

