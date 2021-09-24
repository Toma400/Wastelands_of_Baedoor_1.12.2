
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
import net.minecraft.block.BlockFalling;
import net.minecraft.block.Block;

import net.mcreator.wobr.creativetab.TabWastelandsofBaedoor;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class BlockVulcanicSand extends ElementsWastelandsofBaedoor.ModElement {
	@GameRegistry.ObjectHolder("wobr:vulcanic_sand")
	public static final Block block = null;
	public BlockVulcanicSand(ElementsWastelandsofBaedoor instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("vulcanic_sand"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("wobr:vulcanic_sand", "inventory"));
	}
	public static class BlockCustom extends BlockFalling {
		public BlockCustom() {
			super(Material.SAND);
			setUnlocalizedName("vulcanic_sand");
			setSoundType(SoundType.SAND);
			setHarvestLevel("shovel", 0);
			setHardness(1F);
			setResistance(1F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabWastelandsofBaedoor.tab);
		}
	}
}
