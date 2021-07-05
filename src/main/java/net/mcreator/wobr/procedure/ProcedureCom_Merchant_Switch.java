package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.WastelandsofBaedoorVariables;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureCom_Merchant_Switch extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureCom_Merchant_Switch(ElementsWastelandsofBaedoor instance) {
		super(instance, 124);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Com_Merchant_Switch!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Com_Merchant_Switch!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((WastelandsofBaedoorVariables.MapVariables.get(world).Merchable) == (false))) {
			if (entity instanceof EntityPlayer && !world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Merchant spawning activated"), (false));
			}
			WastelandsofBaedoorVariables.MapVariables.get(world).Merchable = (boolean) (true);
			WastelandsofBaedoorVariables.MapVariables.get(world).syncData(world);
		} else if (((WastelandsofBaedoorVariables.MapVariables.get(world).Merchable) == (true))) {
			if (entity instanceof EntityPlayer && !world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Merchant spawning deactivated"), (false));
			}
			WastelandsofBaedoorVariables.MapVariables.get(world).Merchable = (boolean) (false);
			WastelandsofBaedoorVariables.MapVariables.get(world).syncData(world);
		}
	}
}
