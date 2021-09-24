package net.mcreator.wobr.procedure;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;

import net.mcreator.wobr.item.ItemHandmadeRevolver;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureFirearmInfo extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureFirearmInfo(ElementsWastelandsofBaedoor instance) {
		super(instance, 142);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure FirearmInfo!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((((itemstack).hasTagCompound() && (itemstack).getTagCompound().getBoolean("wobr_verify")) == (false))) {
			if ((((itemstack).getItem() == new ItemStack(ItemHandmadeRevolver.block, (int) (1)).getItem())
					|| ((((itemstack).getDisplayName())).equals("Handmade Revolver")))) {
				{
					ItemStack _stack = (itemstack);
					if (!_stack.hasTagCompound())
						_stack.setTagCompound(new NBTTagCompound());
					_stack.getTagCompound().setString("gun_verify", "firearm");
				}
				{
					ItemStack _stack = (itemstack);
					if (!_stack.hasTagCompound())
						_stack.setTagCompound(new NBTTagCompound());
					_stack.getTagCompound().setString("gun_type", "revolver");
				}
				{
					ItemStack _stack = (itemstack);
					if (!_stack.hasTagCompound())
						_stack.setTagCompound(new NBTTagCompound());
					_stack.getTagCompound().setString("gun_quality", "handmade");
				}
			}
			if ((((((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getString("gun_verify") : "")).equals("firearm"))
					|| ((((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getString("gun_verify") : "")).equals("ammo_box")))) {
				{
					ItemStack _stack = (itemstack);
					if (!_stack.hasTagCompound())
						_stack.setTagCompound(new NBTTagCompound());
					_stack.getTagCompound().setString("gun_name", ((itemstack).getDisplayName()));
				}
				{
					ItemStack _stack = (itemstack);
					if (!_stack.hasTagCompound())
						_stack.setTagCompound(new NBTTagCompound());
					_stack.getTagCompound().setBoolean("wobr_verify", (true));
				}
			}
		}
	}
}
