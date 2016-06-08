package fr.craftyourmind.block;

import net.minecraft.server.Block;
import net.minecraft.server.BlockOre;
import net.minecraft.server.Blocks;
import net.minecraft.server.CreativeModeTab;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.SoundEffectType;

public class CYMBlock{
	static int i;
	
    public static Block INVISIBLE_LAMP;
    public static Block LIGHTED_LAMP;
    public static Block RED_DIAMOND_ORE;
    public static Block RED_DIAMOND_BLOCK;
    public static Block ONYX_ORE;
    public static Block ONYX_BLOCK;
    public static Block CANDLE;
    public static Block CASE;
    public static Block BARREL;
    public static Block LOCK;
	
	public static void registerBlocks(){
		
		i = 235;
		registerBlock("invisible_lamp", (new BlockInvisibleLamp()).a(1.0F).c("lampInvisible"));
		registerBlock("lighted_lamp", (new Block(Material.BUILDABLE_GLASS)).a(1.0F).c("lampOn"));
		registerBlock("onyx_ore", (new BlockOre()).a(3.0F).b(5.0F).a(SoundEffectType.d).c("oreOnyx").a(CreativeModeTab.b));
		registerBlock("onyx_block", (new Block(Material.ORE, MaterialMapColor.H)).a(3.0F).b(5.0F).a(SoundEffectType.d).c("blockOnyx").a(CreativeModeTab.b));
		registerBlock("red_diamond_ore", (new BlockOre()).a(3.0F).b(5.0F).a(SoundEffectType.d).c("oreRedDiamond").a(CreativeModeTab.b));
		registerBlock("red_diamond_block", (new Block(Material.ORE, MaterialMapColor.H)).a(3.0F).b(5.0F).a(SoundEffectType.d).c("blockRedDiamond").a(CreativeModeTab.b));
		registerBlock("candle", (new BlockCandle()).a(0.0F).a(0.9375F).a(SoundEffectType.a).c("bougie"));
		registerBlock("case", (new BlockCase(Material.WOOD)).a(2.0F).b(5.0F).a(SoundEffectType.a).c("caisse"));
		registerBlock("barrel", (new BlockCase(Material.WOOD)).a(2.0F).b(5.0F).a(SoundEffectType.a).c("barril"));
		registerBlock("lock", (new BlockLocker(Material.STONE)).c(50.0F).b(2000.0F).a(SoundEffectType.d).c("lock"));
	}
	
    private static int i() {
		return i++;
	}


    private static void registerBlock(String textualID, Block block_)
    {
        Block.a(i(), new MinecraftKey("minecraft:" + textualID), block_);
    }
    
    public static void Blocks(){
    	INVISIBLE_LAMP = get("invisible_lamp");
    	LIGHTED_LAMP = get("lighted_lamp");
        ONYX_ORE = get("onyx_ore");
        ONYX_BLOCK = get("onyx_block");
        RED_DIAMOND_ORE = get("red_diamond_ore");
        RED_DIAMOND_BLOCK = get("red_diamond_block");
        CANDLE = get("candle");
        CASE = get("case");
        BARREL = get("barrel");
        LOCK = get("lock");
    }  
    
    public static Block get(String p_180383_0_)
    {
    	return Blocks.get(p_180383_0_);
    }
}
