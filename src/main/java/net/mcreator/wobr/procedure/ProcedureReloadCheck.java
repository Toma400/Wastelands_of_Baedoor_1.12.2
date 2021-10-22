package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.item.ItemHandmadeRevolver;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureReloadCheck extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureReloadCheck(ElementsWastelandsofBaedoor instance) {
		super(instance, 110);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ReloadCheck!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure ReloadCheck!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ReloadCheck!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		World world = (World) dependencies.get("world");
		if (((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(ItemHandmadeRevolver.block, (int) (1)).getItem())
				|| (((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY).hasTagCompound()
						? ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getTagCompound().getString("gun_name")
						: "")).equals("Handmade Revolver")))) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				ProcedureReloadHandmadeRevolver.executeProcedure($_dependencies);
			}
		}
		if (entity instanceof EntityPlayer) {
			Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
			ScoreObjective _so = _sc.getObjective("reloadscore");
			if (_so == null) {
				_so = _sc.addScoreObjective("reloadscore", ScoreCriteria.DUMMY);
			}
			Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
			_scr.setScorePoints((int) 0);
		}
	}
}
