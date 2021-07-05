package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

import java.util.Random;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureShotHandmadeRevolver extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureShotHandmadeRevolver(ElementsWastelandsofBaedoor instance) {
		super(instance, 42);
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
					EntityTippedArrow entityToSpawn = new EntityTippedArrow(world, (EntityLivingBase) entity);
					entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, ((float) 2) * 2.0F, 0);
					entityToSpawn.setDamage(((float) 2) * 2.0F);
					entityToSpawn.setKnockbackStrength((int) 1);
					world.spawnEntity(entityToSpawn);
				}
				if (!entity.world.isRemote && entity.world.getMinecraftServer() != null) {
					entity.world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
						@Override
						public String getName() {
							return "";
						}

						@Override
						public boolean canUseCommand(int permission, String command) {
							return true;
						}

						@Override
						public World getEntityWorld() {
							return entity.world;
						}

						@Override
						public MinecraftServer getServer() {
							return entity.world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return entity.getPosition();
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(entity.posX, entity.posY, entity.posZ);
						}

						@Override
						public Entity getCommandSenderEntity() {
							return entity;
						}
					}, "/execute @e[type=Arrow] ~ ~ ~ summon Fireball ~ ~ ~ {direction:[0.0,0.0,0.0],ExplosionPower:0}");
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
