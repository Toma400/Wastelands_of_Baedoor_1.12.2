package net.mcreator.wobr.procedure;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Blocks;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.wobr.item.ItemGlisteringAsh;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureGlisteringAshDrop extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureGlisteringAshDrop(ElementsWastelandsofBaedoor instance) {
		super(instance, 240);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GlisteringAshDrop!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure GlisteringAshDrop!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure GlisteringAshDrop!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure GlisteringAshDrop!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure GlisteringAshDrop!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.END_STONE.getDefaultState().getBlock())
				&& ((entity.dimension) == 1))) {
			if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
					((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY))) > 0)) {
				if (((0.02 + (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
						((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY))) * 2)
						/ 100)) >= Math.random())) {
					if (!world.isRemote) {
						EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemGlisteringAsh.block, (int) (1)));
						entityToSpawn.setPickupDelay(10);
						world.spawnEntity(entityToSpawn);
					}
				}
			} else {
				if ((0.02 >= Math.random())) {
					if (!world.isRemote) {
						EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(ItemGlisteringAsh.block, (int) (1)));
						entityToSpawn.setPickupDelay(10);
						world.spawnEntity(entityToSpawn);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		Entity entity = event.getPlayer();
		java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
		dependencies.put("xpAmount", event.getExpToDrop());
		dependencies.put("x", (int) event.getPos().getX());
		dependencies.put("y", (int) event.getPos().getY());
		dependencies.put("z", (int) event.getPos().getZ());
		dependencies.put("px", (int) entity.posX);
		dependencies.put("py", (int) entity.posY);
		dependencies.put("pz", (int) entity.posZ);
		dependencies.put("world", event.getWorld());
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
