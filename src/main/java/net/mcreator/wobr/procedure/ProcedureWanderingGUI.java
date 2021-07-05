package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.gui.GuiWanderingTraderGUI;
import net.mcreator.wobr.WastelandsofBaedoor;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureWanderingGUI extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureWanderingGUI(ElementsWastelandsofBaedoor instance) {
		super(instance, 98);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WanderingGUI!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WanderingGUI!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WanderingGUI!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WanderingGUI!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WanderingGUI!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).closeScreen();
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).openGui(WastelandsofBaedoor.instance, GuiWanderingTraderGUI.GUIID, world, x, y, z);
	}
}
