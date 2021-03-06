package reptiles.common;

import java.util.List;

import net.minecraft.src.*;

public class EntityAIRandomMating extends EntityAIBase {

	private EntityLiving creature;
	private World theWorld;
	int matingTick = 0;

	public EntityAIRandomMating(EntityLiving entityLiving) {
		creature = entityLiving;
		theWorld = entityLiving.worldObj;
		setMutexBits(7);
	}

	public boolean shouldExecute() {
		if (creature.getRNG().nextInt(8192) != 0 || creature.isChild()) {
//			System.err.println("shouldExecute is returning false. (RND != 0 || isChild)");
			return false;
		}
		double range = 16.0;
		List list = theWorld.getEntitiesWithinAABB(creature.getClass(), creature.boundingBox.expand(range, range, range));
		if (list.size() > 4) {
//			System.err.println("shouldExecute is returning false. (too many entities in area)");
			return false;
		}
//		System.err.println("shouldExecute is returning true.");
		return true;
	}

	public void startExecuting() {
		matingTick = 40;
	}

	public void resetTask() {
		matingTick = 0;
	}
	
	public boolean continueExecuting() {
		return matingTick > 0;
	}

	public int getMatingTick() {
		return matingTick;
	}

	public void updateTask() {
		matingTick = Math.max(0, matingTick - 1); // decrement matingTick

		if (matingTick == 4 && creature.getRNG().nextInt(4) == 0) {
			((EntityAnimal)creature).inLove = 600;
//			System.err.println("matingTick == 4 condition is TRUE. (mating may occur).");
			resetTask();
		}
	}

}
