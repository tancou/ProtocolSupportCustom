/*     */ package fr.craftyourmind.block;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.server.v1_9_R2.Block;
/*     */ import net.minecraft.server.v1_9_R2.BlockFurnace;
/*     */ import net.minecraft.server.v1_9_R2.BlockPosition;
/*     */ import net.minecraft.server.v1_9_R2.BlockStateDirection;
/*     */ import net.minecraft.server.v1_9_R2.BlockStateList;
/*     */ import net.minecraft.server.v1_9_R2.Blocks;
/*     */ import net.minecraft.server.v1_9_R2.EntityLiving;
/*     */ import net.minecraft.server.v1_9_R2.EnumDirection;
/*     */ import net.minecraft.server.v1_9_R2.EnumDirection.EnumAxis;
/*     */ import net.minecraft.server.v1_9_R2.EnumDirection.EnumDirectionLimit;
/*     */ import net.minecraft.server.v1_9_R2.IBlockData;
/*     */ import net.minecraft.server.v1_9_R2.IBlockState;
/*     */ import net.minecraft.server.v1_9_R2.Item;
/*     */ import net.minecraft.server.v1_9_R2.Material;
/*     */ import net.minecraft.server.v1_9_R2.TileEntity;
/*     */ import net.minecraft.server.v1_9_R2.TileEntityFurnace;
/*     */ import net.minecraft.server.v1_9_R2.World;
/*     */ 
/*     */ public class BlockLocker extends Block
/*     */ {
/*  26 */   public static final BlockStateDirection FACING = BlockStateDirection.of("facing", EnumDirection.EnumDirectionLimit.HORIZONTAL);
/*     */ 
/*     */   public BlockLocker(Material material)
/*     */   {
/*  30 */     super(material);
/*  31 */     w(this.blockStateList.getBlockData().set(BlockFurnace.FACING, EnumDirection.NORTH));
/*     */   }
/*     */ 
/*     */   public Item getDropType(IBlockData iblockdata, Random random, int i)
/*     */   {
/*  38 */     return Item.getItemOf(Blocks.FURNACE);
/*     */   }
/*     */ 
/*     */   public void onPlace(World world, BlockPosition blockposition, IBlockData iblockdata) {
/*  42 */     e(world, blockposition, iblockdata);
/*     */   }
/*     */ 
/*     */   private void e(World world, BlockPosition blockposition, IBlockData iblockdata) {
/*  46 */     if (!world.isClientSide) {
/*  47 */       IBlockData iblockdata1 = world.getType(blockposition.north());
/*  48 */       IBlockData iblockdata2 = world.getType(blockposition.south());
/*  49 */       IBlockData iblockdata3 = world.getType(blockposition.west());
/*  50 */       IBlockData iblockdata4 = world.getType(blockposition.east());
/*  51 */       EnumDirection enumdirection = (EnumDirection)iblockdata.get(BlockFurnace.FACING);
/*     */ 
/*  53 */       if ((enumdirection == EnumDirection.NORTH) && (iblockdata1.b()) && (!iblockdata2.b()))
/*  54 */         enumdirection = EnumDirection.SOUTH;
/*  55 */       else if ((enumdirection == EnumDirection.SOUTH) && (iblockdata2.b()) && (!iblockdata1.b()))
/*  56 */         enumdirection = EnumDirection.NORTH;
/*  57 */       else if ((enumdirection == EnumDirection.WEST) && (iblockdata3.b()) && (!iblockdata4.b()))
/*  58 */         enumdirection = EnumDirection.EAST;
/*  59 */       else if ((enumdirection == EnumDirection.EAST) && (iblockdata4.b()) && (!iblockdata3.b())) {
/*  60 */         enumdirection = EnumDirection.WEST;
/*     */       }
/*     */ 
/*  63 */       world.setTypeAndData(blockposition, iblockdata.set(BlockFurnace.FACING, enumdirection), 2);
/*     */     }
/*     */   }
/*     */ 
/*     */   public TileEntity createNewTileEntity(World worldIn, int meta)
/*     */   {
/*  72 */     return new TileEntityFurnace();
/*     */   }
/*     */ 
/*     */   public IBlockData getPlacedState(World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2, int i, EntityLiving entityliving)
/*     */   {
/*  80 */     return getBlockData().set(BlockFurnace.FACING, entityliving.getDirection().opposite());
/*     */   }
/*     */ 
/*     */   public Item getItem(World worldIn, BlockPosition pos)
/*     */   {
/*  85 */     return Item.getItemOf(CYMBlock.LOCK);
/*     */   }
/*     */ 
/*     */   public int getRenderType()
/*     */   {
/*  93 */     return 3;
/*     */   }
/*     */ 
/*     */   public IBlockData fromLegacyData(int i)
/*     */   {
/* 100 */     EnumDirection enumdirection = EnumDirection.fromType1(i);
/*     */ 
/* 102 */     if (enumdirection.k() == EnumDirection.EnumAxis.Y) {
/* 103 */       enumdirection = EnumDirection.NORTH;
/*     */     }
/*     */ 
/* 106 */     return getBlockData().set(BlockFurnace.FACING, enumdirection);
/*     */   }
/*     */ 
/*     */   public int toLegacyData(IBlockData iblockdata) {
/* 110 */     return ((EnumDirection)iblockdata.get(BlockFurnace.FACING)).a();
/*     */   }
/*     */ 
/*     */   protected BlockStateList getStateList() {
/* 114 */     return new BlockStateList(this, new IBlockState[] { BlockFurnace.FACING });
/*     */   }
/*     */ }

/* Location:           I:\IntelliJ\JARS\paper-1.9.4.jar
 * Qualified Name:     fr.craftyourmind.block.BlockLocker
 * JD-Core Version:    0.6.2
 */