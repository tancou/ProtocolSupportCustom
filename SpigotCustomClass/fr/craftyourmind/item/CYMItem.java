/*
 * Decompiled with CFR 0_114.
 */
package fr.craftyourmind.item;

import fr.craftyourmind.block.CYMBlock;
import net.minecraft.server.v1_9_R2.Block;
import net.minecraft.server.v1_9_R2.CreativeModeTab;
import net.minecraft.server.v1_9_R2.Item;
import net.minecraft.server.v1_9_R2.Items;
import net.minecraft.server.v1_9_R2.MinecraftKey;

public class CYMItem {
    private static int i;
    private static Item UNIVERSAL_KEY;

    public static void registerItems() {
        i = 1200;
        CYMItem.registerItem("universal_key", new Item().c("keyUniversal").d(1).a(CreativeModeTab.f));
        Item.b(CYMBlock.INVISIBLE_LAMP);
        Item.b(CYMBlock.LIGHTED_LAMP);
        Item.b(CYMBlock.ONYX_ORE);
        Item.b(CYMBlock.ONYX_BLOCK);
        Item.b(CYMBlock.RED_DIAMOND_ORE);
        Item.b(CYMBlock.RED_DIAMOND_BLOCK);
        Item.b(CYMBlock.CANDLE);
        Item.b(CYMBlock.CASE);
        Item.b(CYMBlock.BARREL);
        Item.b(CYMBlock.LOCK);
    }

    public static void Items() {
        UNIVERSAL_KEY = CYMItem.getRegisteredItem("universal_key");
    }

    private static Item getRegisteredItem(String name) {
        return Items.get(name);
    }

    private static int i() {
        return i++;
    }

    private static void registerItem(String textualID, Item itemIn) {
        Item.a(CYMItem.i(), new MinecraftKey("minecraft:" + textualID), itemIn);
    }
}

