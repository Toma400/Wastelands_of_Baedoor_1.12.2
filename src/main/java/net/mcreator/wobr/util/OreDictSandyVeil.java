
package net.mcreator.wobr.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.wobr.block.BlockSandy_Veil;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class OreDictSandyVeil extends ElementsWastelandsofBaedoor.ModElement {
	public OreDictSandyVeil(ElementsWastelandsofBaedoor instance) {
		super(instance, 215);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("sandy_veil", new ItemStack(BlockSandy_Veil.block, (int) (1)));
	}
}
