/*    */ package fr.craftyourmind.item;
/*    */ 
/*    */ import fr.craftyourmind.block.CYMBlock;
/*    */ import net.minecraft.server.v1_9_R2.CreativeModeTab;
/*    */ import net.minecraft.server.v1_9_R2.Item;
/*    */ import net.minecraft.server.v1_9_R2.Items;
/*    */ import net.minecraft.server.v1_9_R2.MinecraftKey;
/*    */ 
/*    */ public class CYMItem
/*    */ {
/*    */   private static int i;
/*    */   private static Item UNIVERSAL_KEY;
/*    */ 
/*    */   public static void registerItems()
/*    */   {
/* 18 */     i = 1200;
/*    */ 
/* 20 */     registerItem("universal_key", new Item().c("keyUniversal").d(1).a(CreativeModeTab.f));
/*    */ 
/* 43 */     Item.b(CYMBlock.INVISIBLE_LAMP);
/* 44 */     Item.b(CYMBlock.LIGHTED_LAMP);
/* 45 */     Item.b(CYMBlock.ONYX_ORE);
/* 46 */     Item.b(CYMBlock.ONYX_BLOCK);
/* 47 */     Item.b(CYMBlock.RED_DIAMOND_ORE);
/* 48 */     Item.b(CYMBlock.RED_DIAMOND_BLOCK);
/* 49 */     Item.b(CYMBlock.CANDLE);
/* 50 */     Item.b(CYMBlock.CASE);
/* 51 */     Item.b(CYMBlock.BARREL);
/* 52 */     Item.b(CYMBlock.LOCK);
/*    */   }
/*    */ 
/*    */   public static void Items() {
/* 56 */     UNIVERSAL_KEY = getRegisteredItem("universal_key");
/*    */   }
/*    */ 
/*    */   private static Item getRegisteredItem(String name)
/*    */   {
/* 61 */     return Items.get(name);
/*    */   }
/*    */ 
/*    */   private static int i() {
/* 65 */     return i++;
/*    */   }
/*    */ 
/*    */   private static void registerItem(String textualID, Item itemIn)
/*    */   {
/* 70 */     Item.a(i(), new MinecraftKey("minecraft:" + textualID), itemIn);
/*    */   }
/*    */ }

/* Location:           I:\IntelliJ\JARS\paper-1.9.4.jar
 * Qualified Name:     fr.craftyourmind.item.CYMItem
 * JD-Core Version:    0.6.2
 */