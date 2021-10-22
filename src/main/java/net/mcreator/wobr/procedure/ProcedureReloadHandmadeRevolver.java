package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureReloadHandmadeRevolver extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureReloadHandmadeRevolver(ElementsWastelandsofBaedoor instance) {
		super(instance, 109);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ReloadHandmadeRevolver!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure ReloadHandmadeRevolver!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ReloadHandmadeRevolver!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		World world = (World) dependencies.get("world");
		if ((((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getDouble("Ammo") : -1) < 1)) {
			if (((entity instanceof EntityPlayer)
					? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(Items.GUNPOWDER, (int) (1)))
					: false)) {
				world.playSound((EntityPlayer) null, (entity.posX), (entity.posY), (entity.posZ),
						(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
								.getObject(new ResourceLocation("wobr:revolver_reload")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Items.GUNPOWDER, (int) (1)).getItem(), -1, (int) 1, null);
				{
					ItemStack _stack = (itemstack);
					if (!_stack.hasTagCompound())
						_stack.setTagCompound(new NBTTagCompound());
					_stack.getTagCompound().setDouble("Ammo",
							(((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getDouble("Ammo") : -1) + 1));
				}
				if (entity instanceof EntityPlayer)
					((EntityPlayer) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 60);
			} else {
				if (entity instanceof EntityPlayer && !world.isRemote) {
					((EntityPlayer) entity).sendStatusMessage(new TextComponentString("No bullets in inventory!"), (false));
				}
			}
		} else {
			world.playSound((EntityPlayer) null, (entity.posX), (entity.posY), (entity.posZ),
					(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("wobr:revolver_reload")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
			if (entity instanceof EntityPlayer && !world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Gun is full!"), (false));
			}
		}
	}
}
