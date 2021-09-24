package net.mcreator.wobr.procedure;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureFirearmType extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureFirearmType(ElementsWastelandsofBaedoor instance) {
		super(instance, 108);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FirearmType!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY).hasTagCompound()
				? ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY).getTagCompound()
						.getString("gun_quality")
				: "")).equals("handmade"))) {
			{
				ItemStack _stack = ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				if (!_stack.hasTagCompound())
					_stack.setTagCompound(new NBTTagCompound());
				_stack.getTagCompound().setDouble("firearm_quality", 2);
			}
		} else if ((((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY).hasTagCompound()
				? ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY).getTagCompound()
						.getString("gun_quality")
				: "")).equals("scheme"))) {
			{
				ItemStack _stack = ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				if (!_stack.hasTagCompound())
					_stack.setTagCompound(new NBTTagCompound());
				_stack.getTagCompound().setDouble("firearm_quality", 1);
			}
		}
		{
			ItemStack _stack = ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY);
			if (!_stack.hasTagCompound())
				_stack.setTagCompound(new NBTTagCompound());
			_stack.getTagCompound().setDouble("firearm_type_check", 55);
		}
	}
}
