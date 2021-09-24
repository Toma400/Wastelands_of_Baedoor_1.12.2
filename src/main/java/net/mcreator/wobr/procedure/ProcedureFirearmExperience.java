package net.mcreator.wobr.procedure;

import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureFirearmExperience extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureFirearmExperience(ElementsWastelandsofBaedoor instance) {
		super(instance, 109);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FirearmExperience!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getEntityData().getDouble("gun_experience")) < 100)) {
			if (entity instanceof EntityPlayer) {
				Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
				ScoreObjective _so = _sc.getObjective("gun_xp_draw");
				if (_so == null) {
					_so = _sc.addScoreObjective("gun_xp_draw", ScoreCriteria.DUMMY);
				}
				Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
				_scr.setScorePoints((int) 1);
			}
		} else if ((((entity.getEntityData().getDouble("gun_experience")) < 200) && ((entity.getEntityData().getDouble("gun_experience")) >= 100))) {
			if (entity instanceof EntityPlayer) {
				Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
				ScoreObjective _so = _sc.getObjective("gun_xp_draw");
				if (_so == null) {
					_so = _sc.addScoreObjective("gun_xp_draw", ScoreCriteria.DUMMY);
				}
				Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
				_scr.setScorePoints((int) 0.8);
			}
		} else if ((((entity.getEntityData().getDouble("gun_experience")) < 300) && ((entity.getEntityData().getDouble("gun_experience")) >= 200))) {
			if (entity instanceof EntityPlayer) {
				Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
				ScoreObjective _so = _sc.getObjective("gun_xp_draw");
				if (_so == null) {
					_so = _sc.addScoreObjective("gun_xp_draw", ScoreCriteria.DUMMY);
				}
				Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
				_scr.setScorePoints((int) 0.6);
			}
		} else if ((((entity.getEntityData().getDouble("gun_experience")) < 400) && ((entity.getEntityData().getDouble("gun_experience")) >= 300))) {
			if (entity instanceof EntityPlayer) {
				Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
				ScoreObjective _so = _sc.getObjective("gun_xp_draw");
				if (_so == null) {
					_so = _sc.addScoreObjective("gun_xp_draw", ScoreCriteria.DUMMY);
				}
				Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
				_scr.setScorePoints((int) 0.4);
			}
		} else if ((((entity.getEntityData().getDouble("gun_experience")) < 500) && ((entity.getEntityData().getDouble("gun_experience")) >= 400))) {
			if (entity instanceof EntityPlayer) {
				Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
				ScoreObjective _so = _sc.getObjective("gun_xp_draw");
				if (_so == null) {
					_so = _sc.addScoreObjective("gun_xp_draw", ScoreCriteria.DUMMY);
				}
				Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
				_scr.setScorePoints((int) 0.2);
			}
		} else if (((entity.getEntityData().getDouble("gun_experience")) >= 500)) {
			if (entity instanceof EntityPlayer) {
				Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
				ScoreObjective _so = _sc.getObjective("gun_xp_draw");
				if (_so == null) {
					_so = _sc.addScoreObjective("gun_xp_draw", ScoreCriteria.DUMMY);
				}
				Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
				_scr.setScorePoints((int) 0);
			}
		}
	}
}
