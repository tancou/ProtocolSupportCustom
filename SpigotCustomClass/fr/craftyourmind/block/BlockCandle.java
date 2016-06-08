package fr.craftyourmind.block;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Block;
import net.minecraft.server.BlockFence;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.BlockStateDirection;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.Blocks;
import net.minecraft.server.CreativeModeTab;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EnumBlockMirror;
import net.minecraft.server.EnumBlockRotation;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.IBlockData;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class BlockCandle
  extends Block
{
  public static final BlockStateDirection FACING = BlockStateDirection.of("facing", new Predicate()
  {
	  public boolean apply(Object paramAnonymousEnumDirection)
    {
      return paramAnonymousEnumDirection != EnumDirection.DOWN;
    }


  });
  protected static final AxisAlignedBB b = new AxisAlignedBB(0.4000000059604645D, 0.0D, 0.4000000059604645D, 0.6000000238418579D, 0.6000000238418579D, 0.6000000238418579D);
  protected static final AxisAlignedBB c = new AxisAlignedBB(0.3499999940395355D, 0.20000000298023224D, 0.699999988079071D, 0.6499999761581421D, 0.800000011920929D, 1.0D);
  protected static final AxisAlignedBB d = new AxisAlignedBB(0.3499999940395355D, 0.20000000298023224D, 0.0D, 0.6499999761581421D, 0.800000011920929D, 0.30000001192092896D);
  protected static final AxisAlignedBB e = new AxisAlignedBB(0.699999988079071D, 0.20000000298023224D, 0.3499999940395355D, 1.0D, 0.800000011920929D, 0.6499999761581421D);
  protected static final AxisAlignedBB f = new AxisAlignedBB(0.0D, 0.20000000298023224D, 0.3499999940395355D, 0.30000001192092896D, 0.800000011920929D, 0.6499999761581421D);
  
  protected BlockCandle()
  {
    super(Material.ORIENTABLE);
    w(this.blockStateList.getBlockData().set(FACING, EnumDirection.UP));
    a(true);
    a(CreativeModeTab.c);
  }
  
  public AxisAlignedBB a(IBlockData paramIBlockData, IBlockAccess paramIBlockAccess, BlockPosition paramBlockPosition)
  {
    switch (((EnumDirection)paramIBlockData.get(FACING)).ordinal())
    {
    case 1: 
      return f;
    case 2: 
      return e;
    case 3: 
      return d;
    case 4: 
      return c;
    }
    return b;
  }
  
  @Nullable
  public AxisAlignedBB a(IBlockData paramIBlockData, World paramWorld, BlockPosition paramBlockPosition)
  {
    return k;
  }
  
  public boolean b(IBlockData paramIBlockData)
  {
    return false;
  }
  
  public boolean c(IBlockData paramIBlockData)
  {
    return false;
  }
  
  private boolean b(World paramWorld, BlockPosition paramBlockPosition)
  {
    if (paramWorld.getType(paramBlockPosition).q()) {
      return true;
    }
    Block localBlock = paramWorld.getType(paramBlockPosition).getBlock();
    return ((localBlock instanceof BlockFence)) || (localBlock == Blocks.GLASS) || (localBlock == Blocks.COBBLESTONE_WALL) || (localBlock == Blocks.STAINED_GLASS);
  }
  
  public boolean canPlace(World paramWorld, BlockPosition paramBlockPosition)
  {
    for (EnumDirection localEnumDirection : FACING.c()) {
      if (a(paramWorld, paramBlockPosition, localEnumDirection)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(World paramWorld, BlockPosition paramBlockPosition, EnumDirection paramEnumDirection)
  {
    BlockPosition localBlockPosition = paramBlockPosition.shift(paramEnumDirection.opposite());
    
    boolean bool = paramEnumDirection.k().c();
    return ((bool) && (paramWorld.d(localBlockPosition, true))) || ((paramEnumDirection.equals(EnumDirection.UP)) && (b(paramWorld, localBlockPosition)));
  }
  
  public IBlockData getPlacedState(World paramWorld, BlockPosition paramBlockPosition, EnumDirection paramEnumDirection, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, EntityLiving paramEntityLiving)
  {
    if (a(paramWorld, paramBlockPosition, paramEnumDirection)) {
      return getBlockData().set(FACING, paramEnumDirection);
    }
    for (EnumDirection localEnumDirection : EnumDirection.EnumDirectionLimit.HORIZONTAL) {
      if (paramWorld.d(paramBlockPosition.shift(localEnumDirection.opposite()), true)) {
        return getBlockData().set(FACING, localEnumDirection);
      }
    }
    return getBlockData();
  }
  
  public void onPlace(World paramWorld, BlockPosition paramBlockPosition, IBlockData paramIBlockData)
  {
    f(paramWorld, paramBlockPosition, paramIBlockData);
  }
  
  public void a(IBlockData paramIBlockData, World paramWorld, BlockPosition paramBlockPosition, Block paramBlock)
  {
    e(paramWorld, paramBlockPosition, paramIBlockData);
  }
  
  protected boolean e(World paramWorld, BlockPosition paramBlockPosition, IBlockData paramIBlockData)
  {
    if (!f(paramWorld, paramBlockPosition, paramIBlockData)) {
      return true;
    }
    EnumDirection localEnumDirection1 = (EnumDirection)paramIBlockData.get(FACING);
    EnumDirection.EnumAxis localEnumAxis = localEnumDirection1.k();
    EnumDirection localEnumDirection2 = localEnumDirection1.opposite();
    
    int i = 0;
    if ((localEnumAxis.c()) && (!paramWorld.d(paramBlockPosition.shift(localEnumDirection2), true))) {
      i = 1;
    } else if ((localEnumAxis.b()) && (!b(paramWorld, paramBlockPosition.shift(localEnumDirection2)))) {
      i = 1;
    }
    if (i != 0)
    {
      b(paramWorld, paramBlockPosition, paramIBlockData, 0);
      paramWorld.setAir(paramBlockPosition);
      return true;
    }
    return false;
  }
  
  protected boolean f(World paramWorld, BlockPosition paramBlockPosition, IBlockData paramIBlockData)
  {
    if ((paramIBlockData.getBlock() == this) && 
      (a(paramWorld, paramBlockPosition, (EnumDirection)paramIBlockData.get(FACING)))) {
      return true;
    }
    if (paramWorld.getType(paramBlockPosition).getBlock() == this)
    {
      b(paramWorld, paramBlockPosition, paramIBlockData, 0);
      paramWorld.setAir(paramBlockPosition);
    }
    return false;
  }
  
  public IBlockData fromLegacyData(int paramInt)
  {
    IBlockData localIBlockData = getBlockData();
    switch (paramInt)
    {
    case 1: 
      localIBlockData = localIBlockData.set(FACING, EnumDirection.EAST);
      break;
    case 2: 
      localIBlockData = localIBlockData.set(FACING, EnumDirection.WEST);
      break;
    case 3: 
      localIBlockData = localIBlockData.set(FACING, EnumDirection.SOUTH);
      break;
    case 4: 
      localIBlockData = localIBlockData.set(FACING, EnumDirection.NORTH);
      break;
    case 5: 
    default: 
      localIBlockData = localIBlockData.set(FACING, EnumDirection.UP);
    }
    return localIBlockData;
  }
  
  public int toLegacyData(IBlockData paramIBlockData)
  {
    int i = 0;
    switch (((EnumDirection)paramIBlockData.get(FACING)).ordinal())
    {
    case 1: 
      i |= 0x1;
      break;
    case 2: 
      i |= 0x2;
      break;
    case 3: 
      i |= 0x3;
      break;
    case 4: 
      i |= 0x4;
      break;
    case 5: 
    case 6: 
    default: 
      i |= 0x5;
    }
    return i;
  }
  
  public IBlockData a(IBlockData paramIBlockData, EnumBlockRotation paramEnumBlockRotation)
  {
    return paramIBlockData.set(FACING, paramEnumBlockRotation.a((EnumDirection)paramIBlockData.get(FACING)));
  }
  
  public IBlockData a(IBlockData paramIBlockData, EnumBlockMirror paramEnumBlockMirror)
  {
    return paramIBlockData.a(paramEnumBlockMirror.a((EnumDirection)paramIBlockData.get(FACING)));
  }
  
  protected BlockStateList getStateList()
  {
    return new BlockStateList(this, new IBlockState[] { FACING });
  }
}
