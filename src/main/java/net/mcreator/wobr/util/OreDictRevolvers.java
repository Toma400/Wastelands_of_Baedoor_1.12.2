
package net.mcreator.wobr.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.wobr.item.ItemHandmadeRevolver;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class OreDictRevolvers extends ElementsWastelandsofBaedoor.ModElement {
	public OreDictRevolvers(ElementsWastelandsofBaedoor instance) {
		super(instance, 115);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("tag_revolvers", new ItemStack(ItemHandmadeRevolver.block, (int) (1)));
	}
}
