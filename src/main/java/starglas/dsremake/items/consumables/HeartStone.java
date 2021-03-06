package starglas.dsremake.items.consumables;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.handler.ExtendedPlayer;

public class HeartStone extends Item {
	private int mark;

	public HeartStone(String texture, int mark){
		super();
		this.setCreativeTab(DSMainCreativeTabs.tabDSConsume);
		this.setTextureName(ModVars.MODID + "testtexture");
		this.mark = mark;
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
    {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		props.allowedRegeneration=true;
		if (!player.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }
		switch(this.mark){
		case 1:
			player.addPotionEffect((new PotionEffect(Potion.regeneration.getId(), 20*5, 1)));
			break;
		case 2:
			player.addPotionEffect((new PotionEffect(Potion.regeneration.getId(), 20*5, 2)));
			break;
		case 3:
			player.addPotionEffect((new PotionEffect(Potion.regeneration.getId(), 20*5, 3)));
			break;
		}
		return par1ItemStack;
    }
    
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){ // Sets name coloring
		switch(this.mark){
		case 1:
			return EnumRarity.common;
		case 2:
			return EnumRarity.uncommon;
		case 3:
			return EnumRarity.rare;
		default:
			return EnumRarity.common;
		}
	}
}