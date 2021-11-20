
package net.mcreator.wobr.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.wobr.block.BlockSmoothVulcanicSand;
import net.mcreator.wobr.block.BlockPolishedVulcanicSand;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class RecipeSmoothVulcanicSandRecipe extends ElementsWastelandsofBaedoor.ModElement {
	public RecipeSmoothVulcanicSandRecipe(ElementsWastelandsofBaedoor instance) {
		super(instance, 346);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockPolishedVulcanicSand.block, (int) (1)), new ItemStack(BlockSmoothVulcanicSand.block, (int) (1)),
				1F);
	}
}
