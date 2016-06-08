/*
 * Decompiled with CFR 0_114.
 */
package fr.craftyourmind.block;

import net.minecraft.server.v1_9_R2.Block;
import net.minecraft.server.v1_9_R2.CreativeModeTab;
import net.minecraft.server.v1_9_R2.Material;

public class BlockCase
extends Block {
    public BlockCase(Material p_i45402_1_) {
        super(p_i45402_1_);
        this.a(CreativeModeTab.b);
    }

    public boolean isOpaqueCube() {
        return false;
    }
}

