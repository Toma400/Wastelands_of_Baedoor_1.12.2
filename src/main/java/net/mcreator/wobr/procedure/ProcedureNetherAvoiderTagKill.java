package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import net.mcreator.wobr.WastelandsofBaedoorVariables;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureNetherAvoiderTagKill extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureNetherAvoiderTagKill(ElementsWastelandsofBaedoor instance) {
		super(instance, 182);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NetherAvoiderTagKill!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure NetherAvoiderTagKill!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure NetherAvoiderTagKill!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure NetherAvoiderTagKill!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NetherAvoiderTagKill!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((WastelandsofBaedoorVariables.WorldVariables.get(world).Reapering) == (false))) {
			if (((((entity.getEntityData().getBoolean("avoider_killable")) == (true))
					|| (((((entity instanceof EntitySlime) || (entity instanceof EntityBlaze))
							|| ((entity instanceof EntityGhast) || (entity instanceof EntityMagmaCube)))
							|| (((entity instanceof EntityWitherSkeleton) || (entity instanceof EntitySkeleton))
									|| ((entity instanceof EntitySpider) || (entity instanceof EntityZombie))))
							|| ((((entity instanceof EntityCreeper) || (entity instanceof EntityWitch))
									|| ((entity instanceof EntityHusk) || (entity instanceof EntityEnderman)))
									|| ((entity instanceof EntityZombie) || (entity instanceof EntityStray)))))
					&& ((entity.getEntityData().getBoolean("avoider_proof")) == (false)))) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 1000);
				if (!world.isRemote && world.getMinecraftServer() != null) {
					world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
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
							return world;
						}

						@Override
						public MinecraftServer getServer() {
							return world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return new BlockPos((int) x, (int) y, (int) z);
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(x, y, z);
						}
					}, "kill @e[type=item,r=1]");
				}
			}
		} else {
			if ((!((((entity.getEntityData().getBoolean("avoider_proof")) == (true)) || (entity instanceof EntityPlayer))
					|| ((entity instanceof EntityPlayerMP) || (entity instanceof EntityVillager))))) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 1000);
				if (!world.isRemote && world.getMinecraftServer() != null) {
					world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
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
							return world;
						}

						@Override
						public MinecraftServer getServer() {
							return world.getMinecraftServer();
						}

						@Override
						public boolean sendCommandFeedback() {
							return false;
						}

						@Override
						public BlockPos getPosition() {
							return new BlockPos((int) x, (int) y, (int) z);
						}

						@Override
						public Vec3d getPositionVector() {
							return new Vec3d(x, y, z);
						}
					}, "kill @e[type=item,distance=..1]");
				}
			}
		}
	}
}
