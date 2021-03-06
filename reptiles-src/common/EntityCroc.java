package reptiles.common;

import net.minecraft.src.*;

//
// Copyright 2011 Michael Sheppard (crackedEgg)
//

import java.util.*;

public class EntityCroc extends EntityAnimal {
	final float attackDistance;
	protected int attackStrength;
	private int maxHealth = 20;

	public EntityCroc(World world) {
		super(world);
		texture = "/mob/croc32.png";
		setSize(0.8F, 1.5F);

		attackStrength = 2;
		moveSpeed = 0.25F;
		attackDistance = 16F;
		health = maxHealth;

		getNavigator().setAvoidsWater(true);
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAILeapAtTarget(this, 0.5F));
		tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, moveSpeed, true));
		tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityCow.class, moveSpeed, true));
		tasks.addTask(2, new EntityAIAttackOnCollide(this, EntitySheep.class, moveSpeed, true));
		tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPig.class, moveSpeed, true));
		tasks.addTask(3, new EntityAIMate(this, moveSpeed));
		tasks.addTask(4, new EntityAIRandomMating(this));
		tasks.addTask(4, new EntityAIWander(this, moveSpeed));
		tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(5, new EntityAILookIdle(this));

		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, attackDistance, 0, true));
		targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityCow.class, attackDistance, 0, false));
		targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntitySheep.class, attackDistance, 0, false));
		targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityPig.class, attackDistance, 0, false));
	}

	public boolean isAIEnabled() {
		return true;
	}
	
	public EntityAnimal spawnBabyAnimal(EntityAgeable entityageable) {
		System.out.printf("Spawned entity of type %s", getClass().toString());
		return new EntityCroc(worldObj);
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	protected String getLivingSound() {
		return "croc.growl";
	}

	protected String getHurtSound() {
		return "croc.growl";
	}

	protected String getDeathSound() {
		return "croc.growl";
	}

	protected float getSoundVolume() {
		return 0.4F;
	}

	protected int getDropItemId() {
		return Item.leather.shiftedIndex;
	}

	protected void dropFewItems(boolean flag, int add) {
		int count = rand.nextInt(3) + rand.nextInt(1 + add);
		dropItem(Item.leather.shiftedIndex, count);

		count = rand.nextInt(3) + 1 + rand.nextInt(1 + add);
		if (isBurning()) {
			dropItem(Item.beefCooked.shiftedIndex, count);
		} else {
			dropItem(Item.beefRaw.shiftedIndex, count);
		}
	}
	
	protected int getExperiencePoints(EntityPlayer par1EntityPlayer) {
		return 1 + worldObj.rand.nextInt(4);
	}

	public boolean interact(EntityPlayer entityplayer) {
		// don't allow any interaction, especially breeding
		return false;
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 4);
	}

	@Override
	public EntityAgeable func_90011_a(EntityAgeable var1) {
		return this.spawnBabyAnimal(var1);
	}

}
