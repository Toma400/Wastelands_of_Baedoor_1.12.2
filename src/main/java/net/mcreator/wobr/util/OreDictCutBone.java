
package net.mcreator.wobr.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.wobr.item.ItemCrackedBone;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class OreDictCutBone extends ElementsWastelandsofBaedoor.ModElement {
	public OreDictCutBone(ElementsWastelandsofBaedoor instance) {
		super(instance, 216);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("cut_bone", new ItemStack(ItemCrackedBone.block, (int) (1)));
	}
}
