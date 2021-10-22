package net.mcreator.wobr.procedure;

import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureReloadScore extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureReloadScore(ElementsWastelandsofBaedoor instance) {
		super(instance, 114);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ReloadScore!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
			ScoreObjective _so = _sc.getObjective("reloadscore");
			if (_so == null) {
				_so = _sc.addScoreObjective("reloadscore", ScoreCriteria.DUMMY);
			}
			Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
			_scr.setScorePoints((int) 1);
		}
	}
}
