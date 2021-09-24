package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;

import net.mcreator.wobr.block.BlockGolden_Fluid_Converter_Active;
import net.mcreator.wobr.block.BlockGoldenFluidConverterTank;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

import java.util.Map;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureFluidConverterStates extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureFluidConverterStates(ElementsWastelandsofBaedoor instance) {
		super(instance, 247);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FluidConverterStates!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FluidConverterStates!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FluidConverterStates!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FluidConverterStates!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockGoldenFluidConverterTank.block.getDefaultState()
				.getBlock())) {
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "energy")) > 0)) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					IBlockState _bs = BlockGolden_Fluid_Converter_Active.block.getDefaultState();
					IBlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
						IProperty _property = entry.getKey();
						if (_bs.getPropertyKeys().contains(_property))
							_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
					}
					TileEntity _te = world.getTileEntity(_bp);
					NBTTagCompound _bnbt = null;
					if (_te != null) {
						_bnbt = _te.writeToNBT(new NBTTagCompound());
						_te.invalidate();
					}
					world.setBlockState(_bp, _bs, 3);
					if (_bnbt != null) {
						_te = world.getTileEntity(_bp);
						if (_te != null) {
							try {
								_te.readFromNBT(_bnbt);
							} catch (Exception ignored) {
							}
						}
					}
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockGolden_Fluid_Converter_Active.block
				.getDefaultState().getBlock())) {
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "energy")) == 0)) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					IBlockState _bs = BlockGoldenFluidConverterTank.block.getDefaultState();
					IBlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
						IProperty _property = entry.getKey();
						if (_bs.getPropertyKeys().contains(_property))
							_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
					}
					TileEntity _te = world.getTileEntity(_bp);
					NBTTagCompound _bnbt = null;
					if (_te != null) {
						_bnbt = _te.writeToNBT(new NBTTagCompound());
						_te.invalidate();
					}
					world.setBlockState(_bp, _bs, 3);
					if (_bnbt != null) {
						_te = world.getTileEntity(_bp);
						if (_te != null) {
							try {
								_te.readFromNBT(_bnbt);
							} catch (Exception ignored) {
							}
						}
					}
				}
			}
		}
	}
}
