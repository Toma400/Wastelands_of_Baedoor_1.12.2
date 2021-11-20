
package net.mcreator.wobr.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.wobr.block.BlockGlisteringSandstoneSmooth;
import net.mcreator.wobr.block.BlockGlisteringSandstone;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class RecipeGlisteringSandstoneSmoothRecipe extends ElementsWastelandsofBaedoor.ModElement {
	public RecipeGlisteringSandstoneSmoothRecipe(ElementsWastelandsofBaedoor instance) {
		super(instance, 320);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockGlisteringSandstone.block, (int) (1)),
				new ItemStack(BlockGlisteringSandstoneSmooth.block, (int) (1)), 1F);
	}
}
