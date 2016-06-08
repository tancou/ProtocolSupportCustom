/*
 * Decompiled with CFR 0_114.
 */
package fr.craftyourmind.block;

import fr.craftyourmind.block.BlockCandle;
import fr.craftyourmind.block.BlockCase;
import fr.craftyourmind.block.BlockInvisibleLamp;
import fr.craftyourmind.block.BlockLocker;
import net.minecraft.server.v1_9_R2.Block;
import net.minecraft.server.v1_9_R2.BlockOre;
import net.minecraft.server.v1_9_R2.Blocks;
import net.minecraft.server.v1_9_R2.CreativeModeTab;
import net.minecraft.server.v1_9_R2.Material;
import net.minecraft.server.v1_9_R2.MaterialMapColor;
import net.minecraft.server.v1_9_R2.MinecraftKey;
import net.minecraft.server.v1_9_R2.SoundEffectType;

public class CYMBlock {
    static int i;
    public static Block INVISIBLE_LAMP;
    public static Block LIGHTED_LAMP;
    public static Block RED_DIAMOND_ORE;
    public static Block RED_DIAMOND_BLOCK;
    public static Block ONYX_ORE;
    public static Block ONYX_BLOCK;
    public static Block CANDLE;
    public static Block CASE;
    public static Block BARREL;
    public static Block LOCK;

    public static void registerBlocks() {
        i = 235;
        CYMBlock.registerBlock("invisible_lamp", new BlockInvisibleLamp().a(1.0f).c("lampInvisible"));
        CYMBlock.registerBlock("lighted_lamp", new Block(Material.BUILDABLE_GLASS).a(1.0f).c("lampOn"));
        CYMBlock.registerBlock("onyx_ore", new BlockOre().a(3.0f).b(5.0f).a(SoundEffectType.d).c("oreOnyx").a(CreativeModeTab.b));
        CYMBlock.registerBlock("onyx_block", new Block(Material.ORE, MaterialMapColor.H).a(3.0f).b(5.0f).a(SoundEffectType.d).c("blockOnyx").a(CreativeModeTab.b));
        CYMBlock.registerBlock("red_diamond_ore", new BlockOre().a(3.0f).b(5.0f).a(SoundEffectType.d).c("oreRedDiamond").a(CreativeModeTab.b));
        CYMBlock.registerBlock("red_diamond_block", new Block(Material.ORE, MaterialMapColor.H).a(3.0f).b(5.0f).a(SoundEffectType.d).c("blockRedDiamond").a(CreativeModeTab.b));
        CYMBlock.registerBlock("candle", new BlockCandle().a(0.0f).a(0.9375f).a(SoundEffectType.a).c("bougie"));
        CYMBlock.registerBlock("case", new BlockCase(Material.WOOD).a(2.0f).b(5.0f).a(SoundEffectType.a).c("caisse"));
        CYMBlock.registerBlock("barrel", new BlockCase(Material.WOOD).a(2.0f).b(5.0f).a(SoundEffectType.a).c("barril"));
        CYMBlock.registerBlock("lock", new BlockLocker(Material.STONE).c(50.0f).b(2000.0f).a(SoundEffectType.d).c("lock"));
    }

    private static int i() {
        return i++;
    }

    private static void registerBlock(String textualID, Block block_) {
        Block.a(CYMBlock.i(), new MinecraftKey("minecraft:" + textualID), block_);
    }

    public static void Blocks() {
        INVISIBLE_LAMP = CYMBlock.get("invisible_lamp");
        LIGHTED_LAMP = CYMBlock.get("lighted_lamp");
        ONYX_ORE = CYMBlock.get("onyx_ore");
        ONYX_BLOCK = CYMBlock.get("onyx_block");
        RED_DIAMOND_ORE = CYMBlock.get("red_diamond_ore");
        RED_DIAMOND_BLOCK = CYMBlock.get("red_diamond_block");
        CANDLE = CYMBlock.get("candle");
        CASE = CYMBlock.get("case");
        BARREL = CYMBlock.get("barrel");
        LOCK = CYMBlock.get("lock");
    }

    public static Block get(String p_180383_0_) {
        return Blocks.get(p_180383_0_);
    }
}

