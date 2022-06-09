package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.item.ItemBulletRanged;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

import java.util.Random;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureShotHandmadeRevolver extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureShotHandmadeRevolver(ElementsWastelandsofBaedoor instance) {
		super(instance, 124);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ShotHandmadeRevolver!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ShotHandmadeRevolver!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ShotHandmadeRevolver!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ShotHandmadeRevolver!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure ShotHandmadeRevolver!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ShotHandmadeRevolver!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		World world = (World) dependencies.get("world");
		String comm = "";
		if ((((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getDouble("Ammo") : -1) > 0)) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureGunStatistics.executeProcedure($_dependencies);
			}
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureFirearmExperience.executeProcedure($_dependencies);
			}
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				ProcedureFirearmJamming.executeProcedure($_dependencies);
			}
			if ((((itemstack).hasTagCompound() && (itemstack).getTagCompound().getBoolean("jammed")) == (false))) {
				world.playSound((EntityPlayer) null, x, y, z, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
						.getObject(new ResourceLocation("wobr:handmade_revolver_shot")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
				{
					ItemStack _stack = (itemstack);
					if (!_stack.hasTagCompound())
						_stack.setTagCompound(new NBTTagCompound());
					_stack.getTagCompound().setDouble("Ammo",
							(((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getDouble("Ammo") : -1) - 1));
				}
				if (!world.isRemote && entity instanceof EntityLivingBase) {
					ItemBulletRanged.EntityArrowCustom entityToSpawn = new ItemBulletRanged.EntityArrowCustom(world, (EntityLivingBase) entity);
					// edited code + imported
					entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, ((float) 1) * 2.0F, 0);
					entityToSpawn.setDamage(((float) 2) * 2.0F);
					entityToSpawn.setKnockbackStrength((int) 1);
					world.spawnEntity(entityToSpawn);
				}
			} else {
				world.playSound((EntityPlayer) null, x, y, z,
						(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("wobr:failed_shot")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
				{
					ItemStack _stack = (itemstack);
					if (!_stack.hasTagCompound())
						_stack.setTagCompound(new NBTTagCompound());
					_stack.getTagCompound().setBoolean("jammed", (false));
				}
			}
			if (itemstack.attemptDamageItem((int) 1, new Random(), null)) {
				itemstack.shrink(1);
				itemstack.setItemDamage(0);
			}
		} else {
			world.playSound((EntityPlayer) null, x, y, z,
					(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("wobr:failed_shot")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
			if (entity instanceof EntityPlayer && !world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Revolver out of bullets!"), (false));
			}
		}
	}
}
