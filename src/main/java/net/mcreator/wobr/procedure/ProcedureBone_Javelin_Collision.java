package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.EntityItem;

import net.mcreator.wobr.item.ItemBoneJavelin;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureBone_Javelin_Collision extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureBone_Javelin_Collision(ElementsWastelandsofBaedoor instance) {
		super(instance, 128);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Bone_Javelin_Collision!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Bone_Javelin_Collision!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Bone_Javelin_Collision!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Bone_Javelin_Collision!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			EntityItem entityToSpawn = new EntityItem(world, x, (y + 1), z, new ItemStack(ItemBoneJavelin.block, (int) (1)));
			entityToSpawn.setPickupDelay(10);
			world.spawnEntity(entityToSpawn);
		}
	}
}
