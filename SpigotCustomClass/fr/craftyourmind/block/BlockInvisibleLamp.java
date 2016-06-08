/*    */ package fr.craftyourmind.block;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.server.v1_9_R2.AxisAlignedBB;
/*    */ import net.minecraft.server.v1_9_R2.Block;
/*    */ import net.minecraft.server.v1_9_R2.BlockPosition;
/*    */ import net.minecraft.server.v1_9_R2.EnumRenderType;
/*    */ import net.minecraft.server.v1_9_R2.IBlockAccess;
/*    */ import net.minecraft.server.v1_9_R2.IBlockData;
/*    */ import net.minecraft.server.v1_9_R2.Material;
/*    */ import net.minecraft.server.v1_9_R2.World;
/*    */ 
/*    */ public class BlockInvisibleLamp extends Block
/*    */ {
/*    */   protected BlockInvisibleLamp()
/*    */   {
/* 19 */     super(Material.LAMP);
/* 20 */     k();
/* 21 */     b(6000001.0F);
/* 22 */     q();
/* 23 */     this.n = true;
/*    */   }
/*    */ 
/*    */   @Nullable
/*    */   public AxisAlignedBB a(IBlockData paramIBlockData, World paramWorld, BlockPosition paramBlockPosition)
/*    */   {
/* 29 */     return k;
/*    */   }
/*    */ 
/*    */   public EnumRenderType a(IBlockData paramIBlockData)
/*    */   {
/* 34 */     return EnumRenderType.INVISIBLE;
/*    */   }
/*    */ 
/*    */   public boolean d()
/*    */   {
/* 39 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean b(IBlockAccess paramIBlockAccess, BlockPosition paramBlockPosition)
/*    */   {
/* 44 */     return true;
/*    */   }
/*    */ 
/*    */   public boolean c()
/*    */   {
/* 49 */     return false;
/*    */   }
/*    */ 
/*    */   public void dropNaturally(World world, BlockPosition blockposition, IBlockData iblockdata, float f, int i)
/*    */   {
/*    */   }
/*    */ }

/* Location:           I:\IntelliJ\JARS\paper-1.9.4.jar
 * Qualified Name:     fr.craftyourmind.block.BlockInvisibleLamp
 * JD-Core Version:    0.6.2
 */