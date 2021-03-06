package starglas.dsremake.entity.mobs.creature;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import starglas.dsremake.common.MCACommonLibrary.IMCAnimatedEntity;
import starglas.dsremake.common.MCACommonLibrary.animation.AnimationHandler;
import starglas.dsremake.common.animations.Deadsapsprout.AnimationHandlerDeadsapsprout;
import starglas.dsremake.entity.ai.EntityAIFleePlayer;
import starglas.dsremake.entity.ai.EntityAIRadiusInteractions;
import starglas.dsremake.items.ModItems;

public class EntityDeadsapsprout extends EntityCreature implements IMCAnimatedEntity {
	
	protected AnimationHandler animHandler = new AnimationHandlerDeadsapsprout(this);
	private EntityAIFleePlayer aiFleePlayer;
	
	public EntityDeadsapsprout(World par1World) {
		super(par1World);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRadiusInteractions(this, new PotionEffect(Potion.poison.id, 80, 0), Potion.poison, 5));
		this.tasks.addTask(3, new EntityAIRadiusInteractions(this, new PotionEffect(Potion.blindness.id, 80, 0), Potion.blindness, 2));
		this.tasks.addTask(8, this.aiFleePlayer = new EntityAIFleePlayer(this, EntityPlayer.class, 16.0F, 0.8D, 1.66D));
		this.tasks.addTask(9, new EntityAIWander(this, 0.8D));

	}
	
	 public boolean canBePushed()
    {
        return false;
    }
	
	protected boolean isAIEnabled()
    {
        return true;
    }
	
	public boolean doesEntityNotTriggerPressurePlate()
    {
        return true;
    }

	@Override
	protected void entityInit() {
		super.entityInit();
	}
	
	protected Item getDropItem()
    {
        return ModItems.LiquidDeath;
    }
	
	@Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
    }
	
	protected boolean canDespawn()
    {
        return this.ticksExisted > 2400;
    }
	
	protected boolean canTriggerWalking()
    {
        return false;
    }
	
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
	    return true;
	}
	
	@Override
	public AnimationHandler getAnimationHandler() {
		return animHandler;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if(!this.aiFleePlayer.isRunning()){
			if(!this.getAnimationHandler().isAnimationActive("Idle")) {
		        this.getAnimationHandler().activateAnimation("Idle", 0);
		    }
		}
		if(this.aiFleePlayer.isRunning()){
			if(this.getAnimationHandler().isAnimationActive("Idle")) {
		        this.getAnimationHandler().stopAnimation("Idle");
		    }
			
			if(!this.getAnimationHandler().isAnimationActive("FlyAway")) {
		        this.getAnimationHandler().activateAnimation("FlyAway", 0);
		    }
		}
		
		
    }

	@Override
	public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		super.readEntityFromNBT(nbttagcompound);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		super.writeEntityToNBT(nbttagcompound);
	}
}