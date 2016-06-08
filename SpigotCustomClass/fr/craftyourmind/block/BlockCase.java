/*    */ package fr.craftyourmind.block;
/*    */ 
/*    */ import net.minecraft.server.v1_9_R2.Block;
/*    */ import net.minecraft.server.v1_9_R2.CreativeModeTab;
/*    */ import net.minecraft.server.v1_9_R2.Material;
/*    */ 
/*    */ public class BlockCase extends Block
/*    */ {
/*    */   public BlockCase(Material p_i45402_1_)
/*    */   {
/* 12 */     super(p_i45402_1_);
/* 13 */     a(CreativeModeTab.b);
/*    */   }
/*    */ 
/*    */   public boolean isOpaqueCube()
/*    */   {
/* 19 */     return false;
/*    */   }
/*    */ }

/* Location:           I:\IntelliJ\JARS\paper-1.9.4.jar
 * Qualified Name:     fr.craftyourmind.block.BlockCase
 * JD-Core Version:    0.6.2
 */