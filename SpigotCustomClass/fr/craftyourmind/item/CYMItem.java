package fr.craftyourmind.item;

import fr.craftyourmind.block.CYMBlock;
import net.minecraft.server.CreativeModeTab;
import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.MinecraftKey;

public class CYMItem {
	private static int i;

	private static Item UNIVERSAL_KEY;

	
	
	public static void registerItems(){
		
		i = 1200;
		
        registerItem("universal_key", (new Item()).c("keyUniversal").d(1).a(CreativeModeTab.f));
       /* registerItem("red_diamond", (new Item()).setUnlocalizedName("redDiamond").setCreativeTab(CreativeTabs.tabMaterials));
        registerItem("onyx", (new Item()).setUnlocalizedName("onyx").setCreativeTab(CreativeTabs.tabMaterials));
        
        registerItem("red_diamond_helmet", (new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 5, 0)).setUnlocalizedName("helmetRedDiamond").setCreativeTab(CreativeTabs.tabCombat));
        registerItem("red_diamond_chestplate", (new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 5, 1)).setUnlocalizedName("chestplateRedDiamond").setCreativeTab(CreativeTabs.tabCombat));
        registerItem("red_diamond_leggings", (new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 5, 2)).setUnlocalizedName("leggingsRedDiamond").setCreativeTab(CreativeTabs.tabCombat));
        registerItem("red_diamond_boots", (new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 5, 3)).setUnlocalizedName("bootsRedDiamond").setCreativeTab(CreativeTabs.tabCombat));
        registerItem("onyx_helmet", (new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 6, 0)).setUnlocalizedName("helmetOnyx").setCreativeTab(CreativeTabs.tabCombat));
        registerItem("onyx_chestplate", (new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 6, 1)).setUnlocalizedName("chestplateOnyx").setCreativeTab(CreativeTabs.tabCombat));
        registerItem("onyx_leggings", (new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 6, 2)).setUnlocalizedName("leggingsOnyx").setCreativeTab(CreativeTabs.tabCombat));
        registerItem("onyx_boots", (new ItemArmor(ItemArmor.ArmorMaterial.DIAMOND, 6, 3)).setUnlocalizedName("bootsOnyx").setCreativeTab(CreativeTabs.tabCombat));
        
        registerItem("red_diamond_sword", (new ItemSword(Item.ToolMaterial.STONE)).setUnlocalizedName("swordRedOnyx"));
        registerItem("red_diamond_shovel", (new ItemSpade(Item.ToolMaterial.STONE)).setUnlocalizedName("shovelRedOnyx"));
        registerItem("red_diamond_pickaxe", (new ItemPickaxe(Item.ToolMaterial.STONE)).setUnlocalizedName("pickaxeRedOnyx"));
        registerItem("red_diamond_axe", (new ItemAxe(Item.ToolMaterial.STONE)).setUnlocalizedName("hatchetRedOnyx"));
        registerItem("onyx_sword", (new ItemSword(Item.ToolMaterial.EMERALD)).setUnlocalizedName("swordOnyx"));
        registerItem("onyx_shovel", (new ItemSpade(Item.ToolMaterial.EMERALD)).setUnlocalizedName("shovelOnyx"));
        registerItem("onyx_pickaxe", (new ItemPickaxe(Item.ToolMaterial.EMERALD)).setUnlocalizedName("pickaxeOnyx"));
        registerItem("onyx_axe", (new ItemAxe(Item.ToolMaterial.EMERALD)).setUnlocalizedName("hatchetOnyx"));*/
        
        
        Item.b(CYMBlock.INVISIBLE_LAMP);
        Item.b(CYMBlock.LIGHTED_LAMP);
        Item.b(CYMBlock.ONYX_ORE);
        Item.b(CYMBlock.ONYX_BLOCK);
        Item.b(CYMBlock.RED_DIAMOND_ORE);
        Item.b(CYMBlock.RED_DIAMOND_BLOCK);
        Item.b(CYMBlock.CANDLE);
        Item.b(CYMBlock.CASE);
        Item.b(CYMBlock.BARREL);
        Item.b(CYMBlock.LOCK);
	}
	
	public static void Items(){
        UNIVERSAL_KEY = getRegisteredItem("universal_key");
	}
	
    private static Item getRegisteredItem(String name)
    {
    	return Items.get(name);
    }
	
    private static int i() {
		return i++;
	}

    private static void registerItem(String textualID, Item itemIn)
    {
    	Item.a(i(), new MinecraftKey("minecraft:" + textualID), itemIn);
    }
}
