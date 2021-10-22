package net.mcreator.wobr.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureThrowingDaggerInventory extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureThrowingDaggerInventory(ElementsWastelandsofBaedoor instance) {
		super(instance, 132);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ThrowingDaggerInventory!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure ThrowingDaggerInventory!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(
					((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem(), -1,
					(int) 1, null);
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 20);
	}
}
