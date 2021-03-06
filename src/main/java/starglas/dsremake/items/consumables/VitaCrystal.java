package starglas.dsremake.items.consumables;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModVars;

public class VitaCrystal extends Item {

	private int mark;
	public VitaCrystal(String texture, int mark) {
		super();
		this.setCreativeTab(DSMainCreativeTabs.tabDSConsume);
		this.setTextureName(ModVars.MODID + ":vitacrystal" + mark);
		this.mark = mark;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){
		switch(this.mark){
		case 1:
			return EnumRarity.common;
		case 2:
			return EnumRarity.common;
		case 3:
			return EnumRarity.uncommon;
		case 4:
			return EnumRarity.rare;
		case 5:
			return EnumRarity.epic;
		default:
			return EnumRarity.common;
		}
	}
	public boolean hasEffect(ItemStack par1ItemStack){
		return this.mark == 5;
	}
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
    {
		if (!player.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }
		switch(this.mark){
			case 1:
				player.addExperience(50);
				break;
			case 2:
				player.addExperience(300);
				break;
			case 3:
				player.addExperience(1000);
				break;
			case 4:
				player.addExperience(5000);
				break;
			case 5:
				player.addExperience(20000);
				break;
			default:
				break;
		}
        return par1ItemStack;
    }

}
