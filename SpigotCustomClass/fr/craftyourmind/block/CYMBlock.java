/*    */ package fr.craftyourmind.block;
/*    */ 
/*    */ import net.minecraft.server.v1_9_R2.Block;
/*    */ import net.minecraft.server.v1_9_R2.BlockOre;
/*    */ import net.minecraft.server.v1_9_R2.Blocks;
/*    */ import net.minecraft.server.v1_9_R2.CreativeModeTab;
/*    */ import net.minecraft.server.v1_9_R2.Material;
/*    */ import net.minecraft.server.v1_9_R2.MaterialMapColor;
/*    */ import net.minecraft.server.v1_9_R2.MinecraftKey;
/*    */ import net.minecraft.server.v1_9_R2.SoundEffectType;
/*    */ 
/*    */ public class CYMBlock
/*    */ {
/*    */   static int i;
/*    */   public static Block INVISIBLE_LAMP;
/*    */   public static Block LIGHTED_LAMP;
/*    */   public static Block RED_DIAMOND_ORE;
/*    */   public static Block RED_DIAMOND_BLOCK;
/*    */   public static Block ONYX_ORE;
/*    */   public static Block ONYX_BLOCK;
/*    */   public static Block CANDLE;
/*    */   public static Block CASE;
/*    */   public static Block BARREL;
/*    */   public static Block LOCK;
/*    */ 
/*    */   public static void registerBlocks()
/*    */   {
/* 28 */     i = 235;
/* 29 */     registerBlock("invisible_lamp", new BlockInvisibleLamp().a(1.0F).c("lampInvisible"));
/* 30 */     registerBlock("lighted_lamp", new Block(Material.BUILDABLE_GLASS).a(1.0F).c("lampOn"));
/* 31 */     registerBlock("onyx_ore", new BlockOre().a(3.0F).b(5.0F).a(SoundEffectType.d).c("oreOnyx").a(CreativeModeTab.b));
/* 32 */     registerBlock("onyx_block", new Block(Material.ORE, MaterialMapColor.H).a(3.0F).b(5.0F).a(SoundEffectType.d).c("blockOnyx").a(CreativeModeTab.b));
/* 33 */     registerBlock("red_diamond_ore", new BlockOre().a(3.0F).b(5.0F).a(SoundEffectType.d).c("oreRedDiamond").a(CreativeModeTab.b));
/* 34 */     registerBlock("red_diamond_block", new Block(Material.ORE, MaterialMapColor.H).a(3.0F).b(5.0F).a(SoundEffectType.d).c("blockRedDiamond").a(CreativeModeTab.b));
/* 35 */     registerBlock("candle", new BlockCandle().a(0.0F).a(0.9375F).a(SoundEffectType.a).c("bougie"));
/* 36 */     registerBlock("case", new BlockCase(Material.WOOD).a(2.0F).b(5.0F).a(SoundEffectType.a).c("caisse"));
/* 37 */     registerBlock("barrel", new BlockCase(Material.WOOD).a(2.0F).b(5.0F).a(SoundEffectType.a).c("barril"));
/* 38 */     registerBlock("lock", new BlockLocker(Material.STONE).c(50.0F).b(2000.0F).a(SoundEffectType.d).c("lock"));
/*    */   }
/*    */ 
/*    */   private static int i() {
/* 42 */     return i++;
/*    */   }
/*    */ 
/*    */   private static void registerBlock(String textualID, Block block_)
/*    */   {
/* 48 */     Block.a(i(), new MinecraftKey("minecraft:" + textualID), block_);
/*    */   }
/*    */ 
/*    */   public static void Blocks() {
/* 52 */     INVISIBLE_LAMP = get("invisible_lamp");
/* 53 */     LIGHTED_LAMP = get("lighted_lamp");
/* 54 */     ONYX_ORE = get("onyx_ore");
/* 55 */     ONYX_BLOCK = get("onyx_block");
/* 56 */     RED_DIAMOND_ORE = get("red_diamond_ore");
/* 57 */     RED_DIAMOND_BLOCK = get("red_diamond_block");
/* 58 */     CANDLE = get("candle");
/* 59 */     CASE = get("case");
/* 60 */     BARREL = get("barrel");
/* 61 */     LOCK = get("lock");
/*    */   }
/*    */ 
/*    */   public static Block get(String p_180383_0_)
/*    */   {
/* 66 */     return Blocks.get(p_180383_0_);
/*    */   }
/*    */ }

/* Location:           I:\IntelliJ\JARS\paper-1.9.4.jar
 * Qualified Name:     fr.craftyourmind.block.CYMBlock
 * JD-Core Version:    0.6.2
 */