package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.WastelandsofBaedoorVariables;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureComReaperingSwitch extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureComReaperingSwitch(ElementsWastelandsofBaedoor instance) {
		super(instance, 180);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ComReaperingSwitch!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ComReaperingSwitch!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((WastelandsofBaedoorVariables.WorldVariables.get(world).Reapering) == (false))) {
			if (entity instanceof EntityPlayer && !world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Reapering Mode activated"), (false));
			}
			WastelandsofBaedoorVariables.WorldVariables.get(world).Reapering = (boolean) (true);
			WastelandsofBaedoorVariables.WorldVariables.get(world).syncData(world);
		} else if (((WastelandsofBaedoorVariables.WorldVariables.get(world).Reapering) == (true))) {
			if (entity instanceof EntityPlayer && !world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Reapering Mode deactivated"), (false));
			}
			WastelandsofBaedoorVariables.WorldVariables.get(world).Reapering = (boolean) (false);
			WastelandsofBaedoorVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
