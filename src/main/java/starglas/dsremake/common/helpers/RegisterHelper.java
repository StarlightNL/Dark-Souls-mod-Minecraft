package starglas.dsremake.common.helpers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import starglas.dsremake.common.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelper
{
	public static void registerBlock(Block block)
	{
		GameRegistry.registerBlock(block, Reference.MODID + block.getUnlocalizedName().substring(5));
	}

	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, Reference.MODID + item.getUnlocalizedName().substring(5));
	}
	public static void registerRender(Item item, IItemRenderer toRender){
		MinecraftForgeClient.registerItemRenderer(item , toRender);
	}
	/*
	 * Register smeling recipe using Item(What to smelt), ItemStack(What to return), float(What XP to gain)
	 */
	public static void registerSmelting(Item item, ItemStack itemstack, float XP){
		GameRegistry.addSmelting(item, itemstack, XP);
	}
}