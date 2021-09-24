
package net.mcreator.wobr.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.wobr.creativetab.TabWastelandsofBaedoor;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class BlockFirearmTable extends ElementsWastelandsofBaedoor.ModElement {
	@GameRegistry.ObjectHolder("wobr:firearm_table")
	public static final Block block = null;
	public BlockFirearmTable(ElementsWastelandsofBaedoor instance) {
		super(instance, 62);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("firearm_table"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("wobr:firearm_table", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.WOOD);
			setUnlocalizedName("firearm_table");
			setSoundType(SoundType.WOOD);
			setHarvestLevel("axe", 0);
			setHardness(1F);
			setResistance(6F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabWastelandsofBaedoor.tab);
		}
	}
}
