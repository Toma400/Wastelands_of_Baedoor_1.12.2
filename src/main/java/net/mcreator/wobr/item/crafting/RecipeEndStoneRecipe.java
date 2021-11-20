
package net.mcreator.wobr.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;

import net.mcreator.wobr.block.BlockGlisteringClay;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class RecipeEndStoneRecipe extends ElementsWastelandsofBaedoor.ModElement {
	public RecipeEndStoneRecipe(ElementsWastelandsofBaedoor instance) {
		super(instance, 318);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockGlisteringClay.block, (int) (1)), new ItemStack(Blocks.END_STONE, (int) (1)), 1F);
	}
}
