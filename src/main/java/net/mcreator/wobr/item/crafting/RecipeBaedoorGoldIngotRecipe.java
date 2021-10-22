
package net.mcreator.wobr.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.wobr.item.ItemPaleGoldIngot;
import net.mcreator.wobr.item.ItemBaedoorGoldIngot;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class RecipeBaedoorGoldIngotRecipe extends ElementsWastelandsofBaedoor.ModElement {
	public RecipeBaedoorGoldIngotRecipe(ElementsWastelandsofBaedoor instance) {
		super(instance, 252);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemPaleGoldIngot.block, (int) (1)), new ItemStack(ItemBaedoorGoldIngot.block, (int) (1)), 1F);
	}
}
