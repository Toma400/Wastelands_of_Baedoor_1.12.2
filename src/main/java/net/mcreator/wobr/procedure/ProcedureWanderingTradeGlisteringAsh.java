package net.mcreator.wobr.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.item.ItemGlisteringAsh;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureWanderingTradeGlisteringAsh extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureWanderingTradeGlisteringAsh(ElementsWastelandsofBaedoor instance) {
		super(instance, 253);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WanderingTradeGlisteringAsh!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(Items.DYE, (int) (1), 15)) : false)
				&& ((entity instanceof EntityPlayer)
						? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(Items.EMERALD, (int) (1)))
						: false))) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Items.DYE, (int) (1), 15).getItem(), 15, (int) 1, null);
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Items.EMERALD, (int) (1)).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemGlisteringAsh.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}
}
