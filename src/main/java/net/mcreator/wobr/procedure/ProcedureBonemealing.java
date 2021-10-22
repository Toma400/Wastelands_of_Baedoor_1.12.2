package net.mcreator.wobr.procedure;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;

import net.mcreator.wobr.block.BlockVulcanic_Veil_Plant;
import net.mcreator.wobr.block.BlockVulcanic_Veil;
import net.mcreator.wobr.block.BlockSandy_Veil;
import net.mcreator.wobr.block.BlockSandyVeilPlant;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

import java.util.Map;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureBonemealing extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureBonemealing(ElementsWastelandsofBaedoor instance) {
		super(instance, 203);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Bonemealing!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Bonemealing!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Bonemealing!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Bonemealing!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure Bonemealing!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Bonemealing!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockSandyVeilPlant.block.getDefaultState().getBlock())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if ((45 >= (Math.random() * 100))) {
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
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlockVulcanic_Veil_Plant.block.getDefaultState()
				.getBlock())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if ((40 >= (Math.random() * 100))) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					IBlockState _bs = BlockVulcanic_Veil.block.getDefaultState();
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

	@SubscribeEvent
	public void onBonemeal(BonemealEvent event) {
		EntityPlayer entity = event.getEntityPlayer();
		int i = event.getPos().getX();
		int j = event.getPos().getY();
		int k = event.getPos().getZ();
		World world = event.getWorld();
		ItemStack itemstack = event.getStack();
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("itemstack", itemstack);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
