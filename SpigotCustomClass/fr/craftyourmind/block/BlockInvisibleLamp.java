/*
 * Decompiled with CFR 0_114.
 */
package fr.craftyourmind.block;

import javax.annotation.Nullable;
import net.minecraft.server.v1_9_R2.AxisAlignedBB;
import net.minecraft.server.v1_9_R2.Block;
import net.minecraft.server.v1_9_R2.BlockPosition;
import net.minecraft.server.v1_9_R2.EnumRenderType;
import net.minecraft.server.v1_9_R2.IBlockAccess;
import net.minecraft.server.v1_9_R2.IBlockData;
import net.minecraft.server.v1_9_R2.Material;
import net.minecraft.server.v1_9_R2.World;

public class BlockInvisibleLamp
extends Block {
    protected BlockInvisibleLamp() {
        super(Material.LAMP);
        this.k();
        this.b(6000001.0f);
        this.q();
        this.n = true;
    }

    @Nullable
    @Override
    public AxisAlignedBB a(IBlockData paramIBlockData, World paramWorld, BlockPosition paramBlockPosition) {
        return k;
    }

    @Override
    public EnumRenderType a(IBlockData paramIBlockData) {
        return EnumRenderType.INVISIBLE;
    }

    @Override
    public boolean d() {
        return false;
    }

    @Override
    public boolean b(IBlockAccess paramIBlockAccess, BlockPosition paramBlockPosition) {
        return true;
    }

    public boolean c() {
        return false;
    }

    @Override
    public void dropNaturally(World world, BlockPosition blockposition, IBlockData iblockdata, float f, int i) {
    }
}

