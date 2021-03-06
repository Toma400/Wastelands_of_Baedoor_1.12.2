package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureHeatedAirDisappearance extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureHeatedAirDisappearance(ElementsWastelandsofBaedoor instance) {
		super(instance, 329);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HeatedAirDisappearance!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HeatedAirDisappearance!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HeatedAirDisappearance!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HeatedAirDisappearance!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		{
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			IBlockState _bs = Blocks.AIR.getDefaultState();
			world.setBlockState(_bp, _bs, 3);
		}
	}
}
