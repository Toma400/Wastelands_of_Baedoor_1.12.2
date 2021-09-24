
package net.mcreator.wobr.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.wobr.item.ItemHandmadeRevolver;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class OreDictFirearms extends ElementsWastelandsofBaedoor.ModElement {
	public OreDictFirearms(ElementsWastelandsofBaedoor instance) {
		super(instance, 113);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("tag_firearms", new ItemStack(ItemHandmadeRevolver.block, (int) (1)));
	}
}
