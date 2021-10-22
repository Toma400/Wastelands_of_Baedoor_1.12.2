package net.mcreator.wobr.procedure;

import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.entity.EntityWanderingMerchant;
import net.mcreator.wobr.WastelandsofBaedoorVariables;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureWanderingSpawn extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureWanderingSpawn(ElementsWastelandsofBaedoor instance) {
		super(instance, 170);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WanderingSpawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WanderingSpawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WanderingSpawn!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WanderingSpawn!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((WastelandsofBaedoorVariables.MapVariables.get(world).Merchant) == (false)) && ((world.getWorldTime()) == 1000))) {
			if ((5 >= (Math.random() * 100))) {
				if (!world.isRemote) {
					Entity entityToSpawn = new EntityWanderingMerchant.EntityCustom(world);
					if (entityToSpawn != null) {
						entityToSpawn.setLocationAndAngles((x + ((Math.random() * 100) / 3)), y, (z + ((Math.random() * 100) / 3)),
								world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntity(entityToSpawn);
					}
				}
				WastelandsofBaedoorVariables.MapVariables.get(world).Merchant = (boolean) (true);
				WastelandsofBaedoorVariables.MapVariables.get(world).syncData(world);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			int i = (int) entity.posX;
			int j = (int) entity.posY;
			int k = (int) entity.posZ;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
