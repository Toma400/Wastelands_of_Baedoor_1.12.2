package net.mcreator.wobr.procedure;

import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;

import net.mcreator.wobr.WastelandsofBaedoorVariables;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureGlobalGrowth extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureGlobalGrowth(ElementsWastelandsofBaedoor instance) {
		super(instance, 126);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (((WastelandsofBaedoorVariables.Growth_Stadium) <= 333)) {
			WastelandsofBaedoorVariables.Growth_Stadium = (double) ((WastelandsofBaedoorVariables.Growth_Stadium) + 1);
		} else {
			WastelandsofBaedoorVariables.Growth_Stadium = (double) 1;
		}
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			World world = event.world;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("world", world);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
