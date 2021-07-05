
package net.mcreator.wobr.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.wobr.item.ItemHandmadeRevolver;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class TabWastelandsofBaedoor extends ElementsWastelandsofBaedoor.ModElement {
	public TabWastelandsofBaedoor(ElementsWastelandsofBaedoor instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabwastelandsofbaedoor") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemHandmadeRevolver.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
