package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;

import net.mcreator.wobr.block.BlockSandy_Veil;
import net.mcreator.wobr.WastelandsofBaedoorVariables;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

import java.util.Map;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureSandyVeilGrowth extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureSandyVeilGrowth(ElementsWastelandsofBaedoor instance) {
		super(instance, 191);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SandyVeilGrowth!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SandyVeilGrowth!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SandyVeilGrowth!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SandyVeilGrowth!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((WastelandsofBaedoorVariables.Growth_Stadium) <= 320)) {
			world.notifyNeighborsOfStateChange(new BlockPos((int) x, (int) y, (int) z),
					world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), true);
		} else {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				IBlockState _bs = BlockSandy_Veil.block.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
	}
}
