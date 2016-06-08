/*     */ package fr.craftyourmind.block;
/*     */ 
/*     */ import com.google.common.base.Predicate;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.server.v1_9_R2.AxisAlignedBB;
/*     */ import net.minecraft.server.v1_9_R2.Block;
/*     */ import net.minecraft.server.v1_9_R2.BlockFence;
/*     */ import net.minecraft.server.v1_9_R2.BlockPosition;
/*     */ import net.minecraft.server.v1_9_R2.BlockStateDirection;
/*     */ import net.minecraft.server.v1_9_R2.BlockStateList;
/*     */ import net.minecraft.server.v1_9_R2.Blocks;
/*     */ import net.minecraft.server.v1_9_R2.CreativeModeTab;
/*     */ import net.minecraft.server.v1_9_R2.EntityLiving;
/*     */ import net.minecraft.server.v1_9_R2.EnumBlockMirror;
/*     */ import net.minecraft.server.v1_9_R2.EnumBlockRotation;
/*     */ import net.minecraft.server.v1_9_R2.EnumDirection;
/*     */ import net.minecraft.server.v1_9_R2.EnumDirection.EnumAxis;
/*     */ import net.minecraft.server.v1_9_R2.EnumDirection.EnumDirectionLimit;
/*     */ import net.minecraft.server.v1_9_R2.IBlockAccess;
/*     */ import net.minecraft.server.v1_9_R2.IBlockData;
/*     */ import net.minecraft.server.v1_9_R2.IBlockState;
/*     */ import net.minecraft.server.v1_9_R2.Material;
/*     */ import net.minecraft.server.v1_9_R2.World;
/*     */ 
/*     */ public class BlockCandle extends Block
/*     */ {
/*  28 */   public static final BlockStateDirection FACING = BlockStateDirection.of("facing", new Predicate()
/*     */   {
/*     */     public boolean apply(Object paramAnonymousEnumDirection)
/*     */     {
/*  32 */       return paramAnonymousEnumDirection != EnumDirection.DOWN;
/*     */     }
/*     */   });
/*     */ 
/*  37 */   protected static final AxisAlignedBB b = new AxisAlignedBB(0.4000000059604645D, 0.0D, 0.4000000059604645D, 0.6000000238418579D, 0.6000000238418579D, 0.6000000238418579D);
/*  38 */   protected static final AxisAlignedBB c = new AxisAlignedBB(0.3499999940395355D, 0.2000000029802322D, 0.699999988079071D, 0.6499999761581421D, 0.800000011920929D, 1.0D);
/*  39 */   protected static final AxisAlignedBB d = new AxisAlignedBB(0.3499999940395355D, 0.2000000029802322D, 0.0D, 0.6499999761581421D, 0.800000011920929D, 0.300000011920929D);
/*  40 */   protected static final AxisAlignedBB e = new AxisAlignedBB(0.699999988079071D, 0.2000000029802322D, 0.3499999940395355D, 1.0D, 0.800000011920929D, 0.6499999761581421D);
/*  41 */   protected static final AxisAlignedBB f = new AxisAlignedBB(0.0D, 0.2000000029802322D, 0.3499999940395355D, 0.300000011920929D, 0.800000011920929D, 0.6499999761581421D);
/*     */ 
/*     */   protected BlockCandle()
/*     */   {
/*  45 */     super(Material.ORIENTABLE);
/*  46 */     w(this.blockStateList.getBlockData().set(FACING, EnumDirection.UP));
/*  47 */     a(true);
/*  48 */     a(CreativeModeTab.c);
/*     */   }
/*     */ 
/*     */   public AxisAlignedBB a(IBlockData paramIBlockData, IBlockAccess paramIBlockAccess, BlockPosition paramBlockPosition)
/*     */   {
/*  53 */     switch (((EnumDirection)paramIBlockData.get(FACING)).ordinal())
/*     */     {
/*     */     case 1:
/*  56 */       return f;
/*     */     case 2:
/*  58 */       return e;
/*     */     case 3:
/*  60 */       return d;
/*     */     case 4:
/*  62 */       return c;
/*     */     }
/*  64 */     return b;
/*     */   }
/*     */ 
/*     */   @Nullable
/*     */   public AxisAlignedBB a(IBlockData paramIBlockData, World paramWorld, BlockPosition paramBlockPosition)
/*     */   {
/*  70 */     return k;
/*     */   }
/*     */ 
/*     */   public boolean b(IBlockData paramIBlockData)
/*     */   {
/*  75 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean c(IBlockData paramIBlockData)
/*     */   {
/*  80 */     return false;
/*     */   }
/*     */ 
/*     */   private boolean b(World paramWorld, BlockPosition paramBlockPosition)
/*     */   {
/*  85 */     if (paramWorld.getType(paramBlockPosition).q()) {
/*  86 */       return true;
/*     */     }
/*  88 */     Block localBlock = paramWorld.getType(paramBlockPosition).getBlock();
/*  89 */     return ((localBlock instanceof BlockFence)) || (localBlock == Blocks.GLASS) || (localBlock == Blocks.COBBLESTONE_WALL) || (localBlock == Blocks.STAINED_GLASS);
/*     */   }
/*     */ 
/*     */   public boolean canPlace(World paramWorld, BlockPosition paramBlockPosition)
/*     */   {
/*  94 */     for (EnumDirection localEnumDirection : FACING.c()) {
/*  95 */       if (a(paramWorld, paramBlockPosition, localEnumDirection)) {
/*  96 */         return true;
/*     */       }
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */ 
/*     */   private boolean a(World paramWorld, BlockPosition paramBlockPosition, EnumDirection paramEnumDirection)
/*     */   {
/* 104 */     BlockPosition localBlockPosition = paramBlockPosition.shift(paramEnumDirection.opposite());
/*     */ 
/* 106 */     boolean bool = paramEnumDirection.k().c();
/* 107 */     return ((bool) && (paramWorld.d(localBlockPosition, true))) || ((paramEnumDirection.equals(EnumDirection.UP)) && (b(paramWorld, localBlockPosition)));
/*     */   }
/*     */ 
/*     */   public IBlockData getPlacedState(World paramWorld, BlockPosition paramBlockPosition, EnumDirection paramEnumDirection, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, EntityLiving paramEntityLiving)
/*     */   {
/* 112 */     if (a(paramWorld, paramBlockPosition, paramEnumDirection)) {
/* 113 */       return getBlockData().set(FACING, paramEnumDirection);
/*     */     }
/* 115 */     for (EnumDirection localEnumDirection : EnumDirection.EnumDirectionLimit.HORIZONTAL) {
/* 116 */       if (paramWorld.d(paramBlockPosition.shift(localEnumDirection.opposite()), true)) {
/* 117 */         return getBlockData().set(FACING, localEnumDirection);
/*     */       }
/*     */     }
/* 120 */     return getBlockData();
/*     */   }
/*     */ 
/*     */   public void onPlace(World paramWorld, BlockPosition paramBlockPosition, IBlockData paramIBlockData)
/*     */   {
/* 125 */     f(paramWorld, paramBlockPosition, paramIBlockData);
/*     */   }
/*     */ 
/*     */   public void a(IBlockData paramIBlockData, World paramWorld, BlockPosition paramBlockPosition, Block paramBlock)
/*     */   {
/* 130 */     e(paramWorld, paramBlockPosition, paramIBlockData);
/*     */   }
/*     */ 
/*     */   protected boolean e(World paramWorld, BlockPosition paramBlockPosition, IBlockData paramIBlockData)
/*     */   {
/* 135 */     if (!f(paramWorld, paramBlockPosition, paramIBlockData)) {
/* 136 */       return true;
/*     */     }
/* 138 */     EnumDirection localEnumDirection1 = (EnumDirection)paramIBlockData.get(FACING);
/* 139 */     EnumDirection.EnumAxis localEnumAxis = localEnumDirection1.k();
/* 140 */     EnumDirection localEnumDirection2 = localEnumDirection1.opposite();
/*     */ 
/* 142 */     int i = 0;
/* 143 */     if ((localEnumAxis.c()) && (!paramWorld.d(paramBlockPosition.shift(localEnumDirection2), true)))
/* 144 */       i = 1;
/* 145 */     else if ((localEnumAxis.b()) && (!b(paramWorld, paramBlockPosition.shift(localEnumDirection2)))) {
/* 146 */       i = 1;
/*     */     }
/* 148 */     if (i != 0)
/*     */     {
/* 150 */       b(paramWorld, paramBlockPosition, paramIBlockData, 0);
/* 151 */       paramWorld.setAir(paramBlockPosition);
/* 152 */       return true;
/*     */     }
/* 154 */     return false;
/*     */   }
/*     */ 
/*     */   protected boolean f(World paramWorld, BlockPosition paramBlockPosition, IBlockData paramIBlockData)
/*     */   {
/* 159 */     if ((paramIBlockData.getBlock() == this) && 
/* 160 */       (a(paramWorld, paramBlockPosition, 
/* 160 */       (EnumDirection)paramIBlockData
/* 160 */       .get(FACING))))
/*     */     {
/* 161 */       return true;
/*     */     }
/* 163 */     if (paramWorld.getType(paramBlockPosition).getBlock() == this)
/*     */     {
/* 165 */       b(paramWorld, paramBlockPosition, paramIBlockData, 0);
/* 166 */       paramWorld.setAir(paramBlockPosition);
/*     */     }
/* 168 */     return false;
/*     */   }
/*     */ 
/*     */   public IBlockData fromLegacyData(int paramInt)
/*     */   {
/* 173 */     IBlockData localIBlockData = getBlockData();
/* 174 */     switch (paramInt)
/*     */     {
/*     */     case 1:
/* 177 */       localIBlockData = localIBlockData.set(FACING, EnumDirection.EAST);
/* 178 */       break;
/*     */     case 2:
/* 180 */       localIBlockData = localIBlockData.set(FACING, EnumDirection.WEST);
/* 181 */       break;
/*     */     case 3:
/* 183 */       localIBlockData = localIBlockData.set(FACING, EnumDirection.SOUTH);
/* 184 */       break;
/*     */     case 4:
/* 186 */       localIBlockData = localIBlockData.set(FACING, EnumDirection.NORTH);
/* 187 */       break;
/*     */     case 5:
/*     */     default:
/* 190 */       localIBlockData = localIBlockData.set(FACING, EnumDirection.UP);
/*     */     }
/* 192 */     return localIBlockData;
/*     */   }
/*     */ 
/*     */   public int toLegacyData(IBlockData paramIBlockData)
/*     */   {
/* 197 */     int i = 0;
/* 198 */     switch (((EnumDirection)paramIBlockData.get(FACING)).ordinal())
/*     */     {
/*     */     case 1:
/* 201 */       i |= 1;
/* 202 */       break;
/*     */     case 2:
/* 204 */       i |= 2;
/* 205 */       break;
/*     */     case 3:
/* 207 */       i |= 3;
/* 208 */       break;
/*     */     case 4:
/* 210 */       i |= 4;
/* 211 */       break;
/*     */     case 5:
/*     */     case 6:
/*     */     default:
/* 215 */       i |= 5;
/*     */     }
/* 217 */     return i;
/*     */   }
/*     */ 
/*     */   public IBlockData a(IBlockData paramIBlockData, EnumBlockRotation paramEnumBlockRotation)
/*     */   {
/* 222 */     return paramIBlockData.set(FACING, paramEnumBlockRotation.a((EnumDirection)paramIBlockData.get(FACING)));
/*     */   }
/*     */ 
/*     */   public IBlockData a(IBlockData paramIBlockData, EnumBlockMirror paramEnumBlockMirror)
/*     */   {
/* 227 */     return paramIBlockData.a(paramEnumBlockMirror.a((EnumDirection)paramIBlockData.get(FACING)));
/*     */   }
/*     */ 
/*     */   protected BlockStateList getStateList()
/*     */   {
/* 232 */     return new BlockStateList(this, new IBlockState[] { FACING });
/*     */   }
/*     */ }

/* Location:           I:\IntelliJ\JARS\paper-1.9.4.jar
 * Qualified Name:     fr.craftyourmind.block.BlockCandle
 * JD-Core Version:    0.6.2
 */