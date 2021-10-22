package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.WastelandsofBaedoorVariables;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureWanderingDespawn extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureWanderingDespawn(ElementsWastelandsofBaedoor instance) {
		super(instance, 171);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WanderingDespawn!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WanderingDespawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((entity.getEntityData().getDouble("merch_time")) <= 45000)) {
			entity.getEntityData().setDouble("merch_time", ((entity.getEntityData().getDouble("merch_time")) + 1));
		} else {
			entity.world.removeEntity(entity);
			WastelandsofBaedoorVariables.MapVariables.get(world).Merchant = (boolean) (false);
			WastelandsofBaedoorVariables.MapVariables.get(world).syncData(world);
		}
	}
}
