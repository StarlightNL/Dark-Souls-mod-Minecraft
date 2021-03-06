package starglas.dsremake.items.greathammers;

import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.WeaponScaling;


public class GenericGreatHammer extends Item
{
	private EntityPlayer player;
	private float weaponDamage;
    private WeaponScaling weaponScaling;
    public GenericGreatHammer(int dmg, char str, char grc)
    {
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(20);
        this.setCreativeTab(DSMainCreativeTabs.tabDSGreatHammers);
        this.weaponDamage = 20;
        this.setFull3D();
        weaponScaling = new WeaponScaling();
    }
    
    @Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, world, entity, itemSlot, isSelected);
		if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entity;
            player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 2, 2, true));
            if (!world.isRemote)
            {

            	if(isSelected){
                	this.weaponDamage = weaponScaling.CalcWeaponDMG(9, 'S', 'B', player);
        		}
            }
        }
	}

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.none;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
       
        return par1ItemStack;
    }

    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.weaponDamage, 0));
        return multimap;
    }
}