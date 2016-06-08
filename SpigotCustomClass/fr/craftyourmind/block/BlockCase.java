package fr.craftyourmind.block;

import net.minecraft.server.Block;
import net.minecraft.server.CreativeModeTab;
import net.minecraft.server.Material;

public class BlockCase extends Block{
	  
	
	public BlockCase(Material p_i45402_1_)
	    {
	        super(p_i45402_1_);
	        this.a(CreativeModeTab.b);
	    
	    }

	    public boolean isOpaqueCube()
	    {
	        return false;
	    }
}
