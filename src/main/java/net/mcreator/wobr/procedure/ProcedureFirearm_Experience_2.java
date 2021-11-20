package net.mcreator.wobr.procedure;

import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureFirearm_Experience_2 extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureFirearm_Experience_2(ElementsWastelandsofBaedoor instance) {
		super(instance, 131);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Firearm_Experience_2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getEntityData().getDouble("gun_experience")) < 100)) {
			if (entity instanceof EntityPlayer) {
				Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
				ScoreObjective _so = _sc.getObjective("gun_xp_iterator");
				if (_so == null) {
					_so = _sc.addScoreObjective("gun_xp_iterator", ScoreCriteria.DUMMY);
				}
				Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
				_scr.setScorePoints((int) 0.9);
			}
		} else if ((((entity.getEntityData().getDouble("gun_experience")) < 200) && ((entity.getEntityData().getDouble("gun_experience")) >= 100))) {
			if (entity instanceof EntityPlayer) {
				Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
				ScoreObjective _so = _sc.getObjective("gun_xp_draw");
				if (_so == null) {
					_so = _sc.addScoreObjective("gun_xp_draw", ScoreCriteria.DUMMY);
				}
				Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
				_scr.setScorePoints((int) 0.7);
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
