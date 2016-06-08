/*
 * Decompiled with CFR 0_114.
 */
package fr.craftyourmind.block;

import com.google.common.base.Predicate;
import java.util.Collection;
import javax.annotation.Nullable;
import net.minecraft.server.v1_9_R2.AxisAlignedBB;
import net.minecraft.server.v1_9_R2.Block;
import net.minecraft.server.v1_9_R2.BlockFence;
import net.minecraft.server.v1_9_R2.BlockPosition;
import net.minecraft.server.v1_9_R2.BlockStainedGlass;
import net.minecraft.server.v1_9_R2.BlockStateDirection;
import net.minecraft.server.v1_9_R2.BlockStateList;
import net.minecraft.server.v1_9_R2.Blocks;
import net.minecraft.server.v1_9_R2.CreativeModeTab;
import net.minecraft.server.v1_9_R2.EntityLiving;
import net.minecraft.server.v1_9_R2.EnumBlockMirror;
import net.minecraft.server.v1_9_R2.EnumBlockRotation;
import net.minecraft.server.v1_9_R2.EnumDirection;
import net.minecraft.server.v1_9_R2.IBlockAccess;
import net.minecraft.server.v1_9_R2.IBlockData;
import net.minecraft.server.v1_9_R2.IBlockState;
import net.minecraft.server.v1_9_R2.Material;
import net.minecraft.server.v1_9_R2.World;

public class BlockCandle
extends Block {
    public static final BlockStateDirection FACING = BlockStateDirection.of("facing", new Predicate(){

        public boolean apply(Object paramAnonymousEnumDirection) {
            return paramAnonymousEnumDirection != EnumDirection.DOWN;
        }
    });
    protected static final AxisAlignedBB b = new AxisAlignedBB(0.4000000059604645, 0.0, 0.4000000059604645, 0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
    protected static final AxisAlignedBB c = new AxisAlignedBB(0.3499999940395355, 0.20000000298023224, 0.699999988079071, 0.6499999761581421, 0.800000011920929, 1.0);
    protected static final AxisAlignedBB d = new AxisAlignedBB(0.3499999940395355, 0.20000000298023224, 0.0, 0.6499999761581421, 0.800000011920929, 0.30000001192092896);
    protected static final AxisAlignedBB e = new AxisAlignedBB(0.699999988079071, 0.20000000298023224, 0.3499999940395355, 1.0, 0.800000011920929, 0.6499999761581421);
    protected static final AxisAlignedBB f = new AxisAlignedBB(0.0, 0.20000000298023224, 0.3499999940395355, 0.30000001192092896, 0.800000011920929, 0.6499999761581421);

    protected BlockCandle() {
        super(Material.ORIENTABLE);
        this.w(this.blockStateList.getBlockData().set(FACING, EnumDirection.UP));
        this.a(true);
        this.a(CreativeModeTab.c);
    }

    @Override
    public AxisAlignedBB a(IBlockData paramIBlockData, IBlockAccess paramIBlockAccess, BlockPosition paramBlockPosition) {
        switch (((EnumDirection)paramIBlockData.get(FACING)).ordinal()) {
            case 1: {
                return f;
            }
            case 2: {
                return e;
            }
            case 3: {
                return d;
            }
            case 4: {
                return c;
            }
        }
        return b;
    }

    @Nullable
    @Override
    public AxisAlignedBB a(IBlockData paramIBlockData, World paramWorld, BlockPosition paramBlockPosition) {
        return k;
    }

    @Override
    public boolean b(IBlockData paramIBlockData) {
        return false;
    }

    @Override
    public boolean c(IBlockData paramIBlockData) {
        return false;
    }

    private boolean b(World paramWorld, BlockPosition paramBlockPosition) {
        if (paramWorld.getType(paramBlockPosition).q()) {
            return true;
        }
        Block localBlock = paramWorld.getType(paramBlockPosition).getBlock();
        return localBlock instanceof BlockFence || localBlock == Blocks.GLASS || localBlock == Blocks.COBBLESTONE_WALL || localBlock == Blocks.STAINED_GLASS;
    }

    @Override
    public boolean canPlace(World paramWorld, BlockPosition paramBlockPosition) {
        for (EnumDirection localEnumDirection : FACING.c()) {
            if (!this.a(paramWorld, paramBlockPosition, localEnumDirection)) continue;
            return true;
        }
        return false;
    }

    private boolean a(World paramWorld, BlockPosition paramBlockPosition, EnumDirection paramEnumDirection) {
        BlockPosition localBlockPosition = paramBlockPosition.shift(paramEnumDirection.opposite());
        boolean bool = paramEnumDirection.k().c();
        return bool && paramWorld.d(localBlockPosition, true) || paramEnumDirection.equals(EnumDirection.UP) && this.b(paramWorld, localBlockPosition);
    }

    @Override
    public IBlockData getPlacedState(World paramWorld, BlockPosition paramBlockPosition, EnumDirection paramEnumDirection, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, EntityLiving paramEntityLiving) {
        if (this.a(paramWorld, paramBlockPosition, paramEnumDirection)) {
            return this.getBlockData().set(FACING, paramEnumDirection);
        }
        for (EnumDirection localEnumDirection : EnumDirection.EnumDirectionLimit.HORIZONTAL) {
            if (!paramWorld.d(paramBlockPosition.shift(localEnumDirection.opposite()), true)) continue;
            return this.getBlockData().set(FACING, localEnumDirection);
        }
        return this.getBlockData();
    }

    @Override
    public void onPlace(World paramWorld, BlockPosition paramBlockPosition, IBlockData paramIBlockData) {
        this.f(paramWorld, paramBlockPosition, paramIBlockData);
    }

    @Override
    public void a(IBlockData paramIBlockData, World paramWorld, BlockPosition paramBlockPosition, Block paramBlock) {
        this.e(paramWorld, paramBlockPosition, paramIBlockData);
    }

    protected boolean e(World paramWorld, BlockPosition paramBlockPosition, IBlockData paramIBlockData) {
        if (!this.f(paramWorld, paramBlockPosition, paramIBlockData)) {
            return true;
        }
        EnumDirection localEnumDirection1 = (EnumDirection)paramIBlockData.get(FACING);
        EnumDirection.EnumAxis localEnumAxis = localEnumDirection1.k();
        EnumDirection localEnumDirection2 = localEnumDirection1.opposite();
        boolean i = false;
        if (localEnumAxis.c() && !paramWorld.d(paramBlockPosition.shift(localEnumDirection2), true)) {
            i = true;
        } else if (localEnumAxis.b() && !this.b(paramWorld, paramBlockPosition.shift(localEnumDirection2))) {
            i = true;
        }
        if (i) {
            this.b(paramWorld, paramBlockPosition, paramIBlockData, 0);
            paramWorld.setAir(paramBlockPosition);
            return true;
        }
        return false;
    }

    protected boolean f(World paramWorld, BlockPosition paramBlockPosition, IBlockData paramIBlockData) {
        if (paramIBlockData.getBlock() == this && this.a(paramWorld, paramBlockPosition, (EnumDirection)paramIBlockData.get(FACING))) {
            return true;
        }
        if (paramWorld.getType(paramBlockPosition).getBlock() == this) {
            this.b(paramWorld, paramBlockPosition, paramIBlockData, 0);
            paramWorld.setAir(paramBlockPosition);
        }
        return false;
    }

    @Override
    public IBlockData fromLegacyData(int paramInt) {
        IBlockData localIBlockData = this.getBlockData();
        switch (paramInt) {
            case 1: {
                localIBlockData = localIBlockData.set(FACING, EnumDirection.EAST);
                break;
            }
            case 2: {
                localIBlockData = localIBlockData.set(FACING, EnumDirection.WEST);
                break;
            }
            case 3: {
                localIBlockData = localIBlockData.set(FACING, EnumDirection.SOUTH);
                break;
            }
            case 4: {
                localIBlockData = localIBlockData.set(FACING, EnumDirection.NORTH);
                break;
            }
            default: {
                localIBlockData = localIBlockData.set(FACING, EnumDirection.UP);
            }
        }
        return localIBlockData;
    }

    @Override
    public int toLegacyData(IBlockData paramIBlockData) {
        int i = 0;
        switch (((EnumDirection)paramIBlockData.get(FACING)).ordinal()) {
            case 1: {
                i |= true;
                break;
            }
            case 2: {
                i |= 2;
                break;
            }
            case 3: {
                i |= 3;
                break;
            }
            case 4: {
                i |= 4;
                break;
            }
            default: {
                i |= 5;
            }
        }
        return i;
    }

    @Override
    public IBlockData a(IBlockData paramIBlockData, EnumBlockRotation paramEnumBlockRotation) {
        return paramIBlockData.set(FACING, paramEnumBlockRotation.a((EnumDirection)paramIBlockData.get(FACING)));
    }

    @Override
    public IBlockData a(IBlockData paramIBlockData, EnumBlockMirror paramEnumBlockMirror) {
        return paramIBlockData.a(paramEnumBlockMirror.a((EnumDirection)paramIBlockData.get(FACING)));
    }

    @Override
    protected BlockStateList getStateList() {
        return new BlockStateList(this, FACING);
    }

}

