package net.mcreator.wobr.procedure;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureFirearmJamming extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureFirearmJamming(ElementsWastelandsofBaedoor instance) {
		super(instance, 48);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FirearmJamming!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure FirearmJamming!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((Math.ceil(((((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getDouble("firearm_quality") : -1) * 10)
				* (entity.getEntityData().getDouble("gun_xp_draw")))) >= (Math.random() * 100))) {
			{
				ItemStack _stack = (itemstack);
				if (!_stack.hasTagCompound())
					_stack.setTagCompound(new NBTTagCompound());
				_stack.getTagCompound().setBoolean("jammed", (true));
			}
		}
	}
}
