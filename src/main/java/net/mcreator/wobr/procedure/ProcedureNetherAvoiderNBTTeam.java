package net.mcreator.wobr.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureNetherAvoiderNBTTeam extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureNetherAvoiderNBTTeam(ElementsWastelandsofBaedoor instance) {
		super(instance, 177);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NetherAvoiderNBTTeam!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getEntityData().setBoolean("avoider_killable", (true));
	}
}
