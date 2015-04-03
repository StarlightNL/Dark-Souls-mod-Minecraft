package starglas.dsremake.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import starglas.dsremake.common.CreateCreativeTab;
import starglas.dsremake.common.helpers.RegisterHelper;
import starglas.dsremake.common.items.bloodstone.BloodStone;
import starglas.dsremake.common.items.consumables.Estus;
import starglas.dsremake.common.items.consumables.HeartStone;
import starglas.dsremake.common.items.consumables.VitaCrystal;
import starglas.dsremake.common.items.swords.Longsword;

public class ModItems{
	public static Item myFirstItem;
	public static Item MK1HeartStone = new HeartStone(":MK1Heart",1).setUnlocalizedName("MK1HeartStone");
	public static Item MK2HeartStone = new HeartStone(":MK2Heart",2).setUnlocalizedName("MK2HeartStone");
	public static Item MK3HeartStone = new HeartStone(":MK3Heart",3).setUnlocalizedName("MK3HeartStone");
	public static Item MK1VitaCrystal = new VitaCrystal(":MK1vita",1).setUnlocalizedName("MK1VitaCrystal");
	public static Item MK2VitaCrystal = new VitaCrystal(":MK2vita",2).setUnlocalizedName("MK2VitaCrystal");
	public static Item MK3VitaCrystal = new VitaCrystal(":MK3vita",3).setUnlocalizedName("MK3VitaCrystal");
	public static Item MK4VitaCrystal = new VitaCrystal(":MK4vita",4).setUnlocalizedName("MK4VitaCrystal");
	public static Item MK5VitaCrystal = new VitaCrystal(":MK5vita",5).setUnlocalizedName("MK5VitaCrystal");
	public static Item Estus = new Estus().setUnlocalizedName("Estus");
	public static Item MK1BloodStone = new BloodStone(":MK1Blood",1).setUnlocalizedName("MK1BloodStone");
	public static Item MK2BloodStone = new BloodStone(":MK2Blood",2).setUnlocalizedName("MK2BloodStone");
	public static Item MK3BloodStone = new BloodStone(":MK3Blood",3).setUnlocalizedName("MK3BloodStone");
	public static Item MK4BloodStone = new BloodStone(":MK4Blood",4).setUnlocalizedName("MK4BloodStone");
	public static Item MK5BloodStone = new BloodStone(":MK5Blood",5).setUnlocalizedName("MK5BloodStone");
	
	// Swords
	public static Item longSword = new Longsword("dsremake:longsword").setUnlocalizedName("longSword"); 
	
		
	public static void init(){
		// Heart Crystals
		RegisterHelper.registerItem(MK1HeartStone);
		RegisterHelper.registerItem(MK2HeartStone);
		RegisterHelper.registerItem(MK3HeartStone);
		
		// Vita crystals
		RegisterHelper.registerItem(MK1VitaCrystal);
		RegisterHelper.registerItem(MK2VitaCrystal);
		RegisterHelper.registerItem(MK3VitaCrystal);
		RegisterHelper.registerItem(MK4VitaCrystal);
		RegisterHelper.registerItem(MK5VitaCrystal);
		
		RegisterHelper.registerItem(Estus);
		
		// BloodStones
		RegisterHelper.registerItem(MK1BloodStone);
		RegisterHelper.registerItem(MK2BloodStone);
		RegisterHelper.registerItem(MK3BloodStone);
		RegisterHelper.registerItem(MK4BloodStone);
		RegisterHelper.registerItem(MK5BloodStone);
		
		// Tools
		RegisterHelper.registerItem(longSword);
	}
}