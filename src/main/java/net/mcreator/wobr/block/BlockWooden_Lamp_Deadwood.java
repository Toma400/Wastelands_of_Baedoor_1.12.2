
package net.mcreator.wobr.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.wobr.creativetab.TabWastelandsIntegrations;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

import java.util.List;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class BlockWooden_Lamp_Deadwood extends ElementsWastelandsofBaedoor.ModElement {
	@GameRegistry.ObjectHolder("wobr:wooden_lamp_deadwood")
	public static final Block block = null;
	public BlockWooden_Lamp_Deadwood(ElementsWastelandsofBaedoor instance) {
		super(instance, 90);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("wooden_lamp_deadwood"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("wobr:wooden_lamp_deadwood", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.WOOD);
			setUnlocalizedName("wooden_lamp_deadwood");
			setSoundType(SoundType.WOOD);
			setHarvestLevel("axe", 0);
			setHardness(2F);
			setResistance(3F);
			setLightLevel(1F);
			setLightOpacity(0);
			setCreativeTab(TabWastelandsIntegrations.tab);
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add("\u00A76Atum 2 Integration");
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		@Override
		public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 5;
		}
	}
}
