package net.mcreator.wobr.procedure;

import net.minecraft.world.World;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Score;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureReloadScoreCheck extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureReloadScoreCheck(ElementsWastelandsofBaedoor instance) {
		super(instance, 111);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ReloadScoreCheck!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure ReloadScoreCheck!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ReloadScoreCheck!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		World world = (World) dependencies.get("world");
		while (((new Object() {
			public int getScore(String score) {
				if (entity instanceof EntityPlayer) {
					Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
					ScoreObjective _so = _sc.getObjective(score);
					if (_so != null) {
						Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
						return _scr.getScorePoints();
					}
				}
				return 0;
			}
		}.getScore("reloadscore")) == 1)) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				ProcedureReloadCheck.executeProcedure($_dependencies);
			}
		}
		if (((((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getDouble("firearm_type_check") : -1) != 55)
				&& (((((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getString("gun_verify") : "")).equals("firearm"))
						|| ((((itemstack).hasTagCompound() ? (itemstack).getTagCompound().getString("gun_verify") : "")).equals("ammo_box"))))) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureFirearmType.executeProcedure($_dependencies);
			}
		}
	}
}
