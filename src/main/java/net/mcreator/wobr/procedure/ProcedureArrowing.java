package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import net.mcreator.wobr.item.ItemCrackedBone;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureArrowing extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureArrowing(ElementsWastelandsofBaedoor instance) {
		super(instance, 84);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Arrowing!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Arrowing!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemCrackedBone.block, (int) (1)).getItem())) {
			if (!world.isRemote && entity instanceof EntityLivingBase) {
				EntityTippedArrow entityToSpawn = new EntityTippedArrow(world, (EntityLivingBase) entity);
				entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, ((float) 1) * 2.0F, 0);
				entityToSpawn.setDamage(((float) 5) * 2.0F);
				entityToSpawn.setKnockbackStrength((int) 5);
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
				}, "/execute @e[type=Arrow] ~ ~ ~ summon Fireball ~ ~ ~ {direction:[0.0,0.0,0.0],ExplosionPower:1}");
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
				}, "execute @a[type=Arrow,distance=..2] ~ ~ ~ /summon fireball ~ ~ ~ {direction:[0.0,0.0,0.0]}");
			}
		}
	}
}
