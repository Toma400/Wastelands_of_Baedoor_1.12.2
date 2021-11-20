
package net.mcreator.wobr.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.wobr.block.BlockLava_Block_Cracked;
import net.mcreator.wobr.block.BlockLavaBlock;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class RecipeLavaBlockCrackedRecipe extends ElementsWastelandsofBaedoor.ModElement {
	public RecipeLavaBlockCrackedRecipe(ElementsWastelandsofBaedoor instance) {
		super(instance, 175);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockLavaBlock.block, (int) (1)), new ItemStack(BlockLava_Block_Cracked.block, (int) (1)), 1F);
	}
}
