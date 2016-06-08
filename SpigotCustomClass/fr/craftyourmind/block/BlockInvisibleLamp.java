package fr.craftyourmind.block;

import javax.annotation.Nullable;

import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Block;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumRenderType;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.World;

public class BlockInvisibleLamp
  extends Block
{
	  protected BlockInvisibleLamp()
	  {
	    super(Material.LAMP);
	    k();
	    b(6000001.0F);
	    q();
	    this.n = true;
	  }
	  
	  @Nullable
	  public AxisAlignedBB a(IBlockData paramIBlockData, World paramWorld, BlockPosition paramBlockPosition)
	  {
	    return k;
	  }
	  
	  public EnumRenderType a(IBlockData paramIBlockData)
	  {
	    return EnumRenderType.INVISIBLE;
	  }
  
	  public boolean d()
	  {
		  return false;
	  }
  
	  public boolean b(IBlockAccess paramIBlockAccess, BlockPosition paramBlockPosition)
	  {
		  return true;
	  }
  
	  public boolean c()
	  {
		  return false;
	  }
  
	  public void dropNaturally(World world, BlockPosition blockposition, IBlockData iblockdata, float f, int i) {}
}
