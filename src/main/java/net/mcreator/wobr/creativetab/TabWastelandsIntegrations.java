
package net.mcreator.wobr.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.wobr.item.ItemLavaIngot;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class TabWastelandsIntegrations extends ElementsWastelandsofBaedoor.ModElement {
	public TabWastelandsIntegrations(ElementsWastelandsofBaedoor instance) {
		super(instance, 250);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabwastelandsintegrations") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemLavaIngot.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
