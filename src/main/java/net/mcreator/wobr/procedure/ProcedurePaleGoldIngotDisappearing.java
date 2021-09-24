package net.mcreator.wobr.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedurePaleGoldIngotDisappearing extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedurePaleGoldIngotDisappearing(ElementsWastelandsofBaedoor instance) {
		super(instance, 244);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PaleGoldIngotDisappearing!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure PaleGoldIngotDisappearing!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double time_to_conversion = 0;
		if (((time_to_conversion) < 600)) {
			time_to_conversion = (double) ((time_to_conversion) + 1);
		} else {
			time_to_conversion = (double) 0;
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(Items.GOLD_INGOT, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}
}
