package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

import net.mcreator.wobr.item.ItemMushroomPoison;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureMushroomPoisonArrow extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureMushroomPoisonArrow(ElementsWastelandsofBaedoor instance) {
		super(instance, 147);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MushroomPoisonArrow!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemMushroomPoison.block, (int) (1)).getItem())
				&& ((entity instanceof EntityPlayer)
						? ((EntityPlayer) entity).inventory.hasItemStack(new ItemStack(Items.ARROW, (int) (1)))
						: false))) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(
						((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem(), -1,
						(int) 1, null);
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Items.ARROW, (int) (1)).getItem(), -1, (int) 1, null);
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
				}, "give @p tipped_arrow 1 0 {Potion:\"minecraft:long_poison\"}");
			}
		}
	}
}
