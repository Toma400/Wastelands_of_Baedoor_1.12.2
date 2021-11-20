package net.mcreator.wobr.procedure;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureHeatedAirDamage extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureHeatedAirDamage(ElementsWastelandsofBaedoor instance) {
		super(instance, 328);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure HeatedAirDamage!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.HOT_FLOOR, (float) 2);
	}
}
