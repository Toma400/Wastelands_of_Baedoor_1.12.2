
package net.mcreator.wobr.potion;

import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.EntityLivingBase;

import net.mcreator.wobr.procedure.ProcedureNetherAvoiderShieldActivate;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

import java.util.List;
import java.util.ArrayList;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class PotionNether_Avoider_Shield_Potion extends ElementsWastelandsofBaedoor.ModElement {
	@GameRegistry.ObjectHolder("wobr:nether_avoider_shield_potion")
	public static final Potion potion = null;
	public PotionNether_Avoider_Shield_Potion(ElementsWastelandsofBaedoor instance) {
		super(instance, 195);
	}

	@Override
	public void initElements() {
		elements.potions.add(() -> new PotionCustom());
	}
	public static class PotionCustom extends Potion {
		private final ResourceLocation potionIcon;
		public PotionCustom() {
			super(false, -14117740);
			setRegistryName("nether_avoider_shield_potion");
			setPotionName("effect.nether_avoider_shield_potion");
			potionIcon = new ResourceLocation("wobr:textures/mob_effect/nether_avoider_shield_potion.png");
		}

		@Override
		public boolean isInstant() {
			return false;
		}

		@Override
		public List<ItemStack> getCurativeItems() {
			List<ItemStack> ret = new ArrayList<>();
			return ret;
		}

		@Override
		public boolean shouldRenderInvText(PotionEffect effect) {
			return false;
		}

		@Override
		public boolean shouldRenderHUD(PotionEffect effect) {
			return false;
		}

		@Override
		public void applyAttributesModifiersToEntity(EntityLivingBase entity, AbstractAttributeMap attributeMapIn, int amplifier) {
			World world = entity.world;
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureNetherAvoiderShieldActivate.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
