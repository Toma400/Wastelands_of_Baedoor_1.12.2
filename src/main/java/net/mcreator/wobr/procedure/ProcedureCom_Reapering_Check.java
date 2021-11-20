package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.WastelandsofBaedoorVariables;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureCom_Reapering_Check extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureCom_Reapering_Check(ElementsWastelandsofBaedoor instance) {
		super(instance, 201);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Com_Reapering_Check!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Com_Reapering_Check!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((WastelandsofBaedoorVariables.WorldVariables.get(world).Reapering) == (false))) {
			if (entity instanceof EntityPlayer && !world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Reapering Mode is not active"), (false));
			}
		} else if (((WastelandsofBaedoorVariables.WorldVariables.get(world).Reapering) == (true))) {
			if (entity instanceof EntityPlayer && !world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Reapering Mode is active"), (false));
			}
		}
	}
}
