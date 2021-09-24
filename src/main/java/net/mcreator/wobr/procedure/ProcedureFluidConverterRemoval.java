package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

import java.util.Map;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureFluidConverterRemoval extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureFluidConverterRemoval(ElementsWastelandsofBaedoor instance) {
		super(instance, 249);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FluidConverterRemoval!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FluidConverterRemoval!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FluidConverterRemoval!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FluidConverterRemoval!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		{
			BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) (z - 1));
			IBlockState _bs = Blocks.AIR.getDefaultState();
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
			IBlockState _bs = Blocks.AIR.getDefaultState();
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
			IBlockState _bs = Blocks.AIR.getDefaultState();
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
			IBlockState _bs = Blocks.AIR.getDefaultState();
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
			IBlockState _bs = Blocks.AIR.getDefaultState();
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
			IBlockState _bs = Blocks.AIR.getDefaultState();
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
			IBlockState _bs = Blocks.AIR.getDefaultState();
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
