package starglas.dsremake.client.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import starglas.dsremake.common.helpers.ModVars;

public class ItemRendererLance implements IItemRenderer {
	IModelCustom model;
	ResourceLocation texture = new ResourceLocation(ModVars.MODID,
			"textures/items/testtexture.png");

	public ItemRendererLance(){
		this.model = AdvancedModelLoader.loadModel(new ResourceLocation(
				ModVars.MODID, "obj/lance.obj"));
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch(type){
		case EQUIPPED:
		case EQUIPPED_FIRST_PERSON:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return false;
	}
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		GL11.glPushMatrix();
		GL11.glTranslatef(0.4F, 0.3F, 0F);
		GL11.glRotatef(0F, 0.0F, 0.0F, 0.0F);
		GL11.glRotatef(0F, 0.0F, 0.0F, 0.0F);
		GL11.glRotatef(0F, 0.0F, 0.0F, 0.0F);
		GL11.glScalef(0.2F,0.2F,0.2F);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		model.renderAll();
		GL11.glPopMatrix();
	}
}