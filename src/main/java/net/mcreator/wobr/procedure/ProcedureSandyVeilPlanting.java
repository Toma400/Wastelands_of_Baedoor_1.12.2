package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.block.material.Material;

import net.mcreator.wobr.item.ItemSandDust;
import net.mcreator.wobr.block.BlockSandyVeilPlant;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureSandyVeilPlanting extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureSandyVeilPlanting(ElementsWastelandsofBaedoor instance) {
		super(instance, 208);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SandyVeilPlanting!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SandyVeilPlanting!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SandyVeilPlanting!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SandyVeilPlanting!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SandyVeilPlanting!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getMaterial() == Material.SAND)) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == Material.AIR)) {
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemSandDust.block, (int) (1)).getItem(), -1, (int) 1, null);
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BlockSandyVeilPlant.block.getDefaultState(), 3);
			}
		}
	}
}
