package net.mcreator.wobr.procedure;

import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureGunStatistics extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureGunStatistics(ElementsWastelandsofBaedoor instance) {
		super(instance, 45);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GunStatistics!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
			ScoreObjective _so = _sc.getObjective("gun_experience");
			if (_so == null) {
				_so = _sc.addScoreObjective("gun_experience", ScoreCriteria.DUMMY);
			}
			Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
			_scr.setScorePoints((int) ((new Object() {
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
			}.getScore("gun_experience")) + 1));
		}
		entity.getEntityData().setDouble("gun_experience", (new Object() {
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
		}.getScore("gun_experience")));
	}
}
