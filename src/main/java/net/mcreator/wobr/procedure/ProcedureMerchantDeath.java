package net.mcreator.wobr.procedure;

import net.minecraft.world.World;

import net.mcreator.wobr.WastelandsofBaedoorVariables;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureMerchantDeath extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureMerchantDeath(ElementsWastelandsofBaedoor instance) {
		super(instance, 172);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MerchantDeath!");
			return;
		}
		World world = (World) dependencies.get("world");
		WastelandsofBaedoorVariables.MapVariables.get(world).Merchant = (boolean) (false);
		WastelandsofBaedoorVariables.MapVariables.get(world).syncData(world);
	}
}
