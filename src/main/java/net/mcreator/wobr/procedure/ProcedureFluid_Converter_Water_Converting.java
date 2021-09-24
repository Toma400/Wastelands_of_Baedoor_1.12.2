package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;

import net.mcreator.wobr.block.BlockSandyWater;
import net.mcreator.wobr.block.BlockLavaBlock;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

import java.util.Map;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureFluid_Converter_Water_Converting extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureFluid_Converter_Water_Converting(ElementsWastelandsofBaedoor instance) {
		super(instance, 250);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Fluid_Converter_Water_Converting!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Fluid_Converter_Water_Converting!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Fluid_Converter_Water_Converting!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Fluid_Converter_Water_Converting!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Fluid_Converter_Water_Converting!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.MAGMA.getDefaultState().getBlock())) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) (z - 1));
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) (z + 1));
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y - 1), (int) z);
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y - 1), (int) z);
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y - 1), (int) (z - 1));
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y - 1), (int) (z + 1));
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y - 1), (int) (z - 1));
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y - 1), (int) (z + 1));
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
				IBlockState _bs = Blocks.AIR.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockLavaBlock.block.getDefaultState()
				.getBlock())) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) (z - 1));
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) (z + 1));
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y - 1), (int) z);
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y - 1), (int) z);
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y - 1), (int) (z - 1));
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y - 1), (int) (z + 1));
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y - 1), (int) (z - 1));
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y - 1), (int) (z + 1));
				IBlockState _bs = Blocks.LAVA.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			if ((0.05 >= Math.random())) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
					IBlockState _bs = Blocks.AIR.getDefaultState();
					IBlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
						IProperty _property = entry.getKey();
						if (_bs.getPropertyKeys().contains(_property))
							_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
					}
					world.setBlockState(_bp, _bs, 3);
				}
			}
		} else if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.SAND.getStateFromMeta(0).getBlock())
				&& ((entity.dimension) == 17))) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) (z - 1));
				IBlockState _bs = BlockSandyWater.block.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) (z + 1));
				IBlockState _bs = BlockSandyWater.block.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y - 1), (int) z);
				IBlockState _bs = BlockSandyWater.block.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y - 1), (int) z);
				IBlockState _bs = BlockSandyWater.block.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y - 1), (int) (z - 1));
				IBlockState _bs = BlockSandyWater.block.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y - 1), (int) (z + 1));
				IBlockState _bs = BlockSandyWater.block.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y - 1), (int) (z - 1));
				IBlockState _bs = BlockSandyWater.block.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y - 1), (int) (z + 1));
				IBlockState _bs = BlockSandyWater.block.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
				IBlockState _bs = Blocks.AIR.getDefaultState();
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
