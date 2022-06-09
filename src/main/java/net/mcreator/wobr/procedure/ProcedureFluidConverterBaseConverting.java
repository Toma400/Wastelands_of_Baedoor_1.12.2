package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;

import net.mcreator.wobr.block.BlockVulcanicSand;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureFluidConverterBaseConverting extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureFluidConverterBaseConverting(ElementsWastelandsofBaedoor instance) {
		super(instance, 350);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FluidConverterBaseConverting!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FluidConverterBaseConverting!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FluidConverterBaseConverting!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FluidConverterBaseConverting!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double sx = 0;
		double sz = 0;
		sx = (double) -1;
		for (int index0 = 0; index0 < (int) (3); index0++) {
			sz = (double) -1;
			for (int index1 = 0; index1 < (int) (3); index1++) {
				if (((((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y - 2), (int) (z + (sz))))).getBlock() == Blocks.STONE
						.getStateFromMeta(1).getBlock())
						|| ((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y - 2), (int) (z + (sz))))).getBlock() == Blocks.STONE
								.getStateFromMeta(5).getBlock()))
						|| (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y - 2), (int) (z + (sz))))).getBlock() == Blocks.STONE
								.getStateFromMeta(3).getBlock())
								|| ((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y - 2), (int) (z + (sz))))).getBlock() == Blocks.STONE
										.getStateFromMeta(0).getBlock())))) {
					world.setBlockState(new BlockPos((int) (x + (sx)), (int) (y - 2), (int) (z + (sz))), Blocks.NETHERRACK.getDefaultState(), 3);
				} else if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y - 2), (int) (z + (sz))))).getMaterial() == Material.GRASS)) {
					world.setBlockState(new BlockPos((int) (x + (sx)), (int) (y - 2), (int) (z + (sz))), BlockVulcanicSand.block.getDefaultState(),
							3);
				}
				sz = (double) ((sz) + 1);
			}
			sx = (double) ((sx) + 1);
		}
	}
}
