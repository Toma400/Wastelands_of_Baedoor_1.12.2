package net.mcreator.wobr.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

import java.util.function.Supplier;
import java.util.Map;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureWanderingGUIReset extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureWanderingGUIReset(ElementsWastelandsofBaedoor instance) {
		super(instance, 180);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WanderingGUIReset!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayerMP) {
			Container _current = ((EntityPlayerMP) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					((Slot) ((Map) invobj).get((int) (3))).putStack(ItemStack.EMPTY);
					_current.detectAndSendChanges();
				}
			}
		}
	}
}
