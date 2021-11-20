package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.block.state.IBlockState;

import net.mcreator.wobr.block.BlockHeatedAir;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureHeatFuelerTransforming extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureHeatFuelerTransforming(ElementsWastelandsofBaedoor instance) {
		super(instance, 330);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HeatFuelerTransforming!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HeatFuelerTransforming!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HeatFuelerTransforming!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HeatFuelerTransforming!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z)))) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				if (((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
					if (((world.getBlockState(new BlockPos((int) x, (int) (y + 3), (int) z))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock())) {
						{
							BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
							IBlockState _bs = BlockHeatedAir.block.getDefaultState();
							world.setBlockState(_bp, _bs, 3);
						}
						{
							BlockPos _bp = new BlockPos((int) x, (int) (y + 2), (int) z);
							IBlockState _bs = BlockHeatedAir.block.getDefaultState();
							world.setBlockState(_bp, _bs, 3);
						}
						{
							BlockPos _bp = new BlockPos((int) x, (int) (y + 3), (int) z);
							IBlockState _bs = BlockHeatedAir.block.getDefaultState();
							world.setBlockState(_bp, _bs, 3);
						}
						if ((((world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getTemperature(new BlockPos((int) x, (int) y, (int) z))
								* 100.f) > 0.9)
								&& ((world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getTemperature(new BlockPos((int) x, (int) y, (int) z))
										* 100.f) < 2))) {
							if ((Math.random() <= 0.25)) {
								if (!world.isRemote) {
									EntityItem entityToSpawn = new EntityItem(world, x, (y - 1), z, new ItemStack(Items.COAL, (int) (1), 1));
									entityToSpawn.setPickupDelay(10);
									world.spawnEntity(entityToSpawn);
								}
							}
						} else if (((world.getBiome(new BlockPos((int) x, (int) y, (int) z)).getTemperature(new BlockPos((int) x, (int) y, (int) z))
								* 100.f) >= 2)) {
							if (!world.isRemote) {
								EntityItem entityToSpawn = new EntityItem(world, x, (y - 1), z, new ItemStack(Items.COAL, (int) (1), 1));
								entityToSpawn.setPickupDelay(10);
								world.spawnEntity(entityToSpawn);
							}
						}
					}
				}
			}
		}
	}
}
