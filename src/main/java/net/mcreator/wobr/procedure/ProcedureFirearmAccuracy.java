package net.mcreator.wobr.procedure;

import net.minecraftforge.oredict.OreDictionary;

import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Score;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureFirearmAccuracy extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureFirearmAccuracy(ElementsWastelandsofBaedoor instance) {
		super(instance, 121);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FirearmAccuracy!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((OreDictionary.containsMatch(false, OreDictionary.getOres("tag_shotguns"),
				((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)))) {
			{
				ItemStack _stack = ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				if (!_stack.hasTagCompound())
					_stack.setTagCompound(new NBTTagCompound());
				_stack.getTagCompound().setDouble("aim_penalty_value", 22);
			}
		} else {
			{
				ItemStack _stack = ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				if (!_stack.hasTagCompound())
					_stack.setTagCompound(new NBTTagCompound());
				_stack.getTagCompound().setDouble("aim_penalty_value", 20);
			}
		}
		if (((entity.getEntityData().getBoolean("google_user")) == (false))) {
			{
				ItemStack _stack = ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				if (!_stack.hasTagCompound())
					_stack.setTagCompound(new NBTTagCompound());
				_stack.getTagCompound().setDouble("accuracy_penalty",
						((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.hasTagCompound()
										? ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
												.getTagCompound().getDouble("aim_penalty_value")
										: -1)
								* (new Object() {
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
								}.getScore("gun_xp_iterator"))));
			}
		} else {
			{
				ItemStack _stack = ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				if (!_stack.hasTagCompound())
					_stack.setTagCompound(new NBTTagCompound());
				_stack.getTagCompound().setDouble("accuracy_penalty",
						(((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.hasTagCompound()
										? ((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
												.getTagCompound().getDouble("aim_penalty_value")
										: -1)
								* (new Object() {
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
								}.getScore("gun_xp_iterator"))) * 0.5));
			}
		}
	}
}
