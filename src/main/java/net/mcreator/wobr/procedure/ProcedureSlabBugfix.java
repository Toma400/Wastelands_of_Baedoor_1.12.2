package net.mcreator.wobr.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.wobr.item.ItemMimic_Spruce_Slab_Chisel;
import net.mcreator.wobr.item.ItemMimic_Spruce_Slab;
import net.mcreator.wobr.item.ItemMimic_Palm_Slab_Chisel;
import net.mcreator.wobr.item.ItemMimic_Palm_Slab;
import net.mcreator.wobr.item.ItemMimic_Oak_Slab_Chisel;
import net.mcreator.wobr.item.ItemMimic_Oak_Slab;
import net.mcreator.wobr.item.ItemMimic_Jungle_Slab_Chisel;
import net.mcreator.wobr.item.ItemMimic_Jungle_Slab;
import net.mcreator.wobr.item.ItemMimic_Deadwood_Slab_Chisel;
import net.mcreator.wobr.item.ItemMimic_Deadwood_Slab;
import net.mcreator.wobr.item.ItemMimic_Dark_Oak_Slab_Chisel;
import net.mcreator.wobr.item.ItemMimic_Dark_Oak_Slab;
import net.mcreator.wobr.item.ItemMimic_Birch_Slab_Chisel;
import net.mcreator.wobr.item.ItemMimic_Birch_Slab;
import net.mcreator.wobr.item.ItemMimic_Acacia_Slab_Chisel;
import net.mcreator.wobr.item.ItemMimic_Acacia_Slab;
import net.mcreator.wobr.item.ItemMimicGoldSlab;
import net.mcreator.wobr.block.BlockSpruce_Wooden_Slab;
import net.mcreator.wobr.block.BlockPalm_Wooden_Slab;
import net.mcreator.wobr.block.BlockOakWoodenSlab;
import net.mcreator.wobr.block.BlockJungle_Wooden_Slab;
import net.mcreator.wobr.block.BlockDeadwood_Wooden_Slab;
import net.mcreator.wobr.block.BlockDark_Oak_Wooden_Slab;
import net.mcreator.wobr.block.BlockChiseled_Spruce_Wooden_Slab;
import net.mcreator.wobr.block.BlockChiseled_Palm_Wooden_Slab;
import net.mcreator.wobr.block.BlockChiseled_Oak_Wooden_Slab;
import net.mcreator.wobr.block.BlockChiseled_Jungle_Wooden_Slab;
import net.mcreator.wobr.block.BlockChiseled_Deadwood_Wooden_Slab;
import net.mcreator.wobr.block.BlockChiseled_Dark_Oak_Wooden_Slab;
import net.mcreator.wobr.block.BlockChiseled_Birch_Wooden_Slab;
import net.mcreator.wobr.block.BlockChiseled_Acacia_Wooden_Slab;
import net.mcreator.wobr.block.BlockBirch_Wooden_Slab;
import net.mcreator.wobr.block.BlockBaedoorFuntBlockSlab;
import net.mcreator.wobr.block.BlockAcacia_Wooden_Slab;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureSlabBugfix extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureSlabBugfix(ElementsWastelandsofBaedoor instance) {
		super(instance, 286);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SlabBugfix!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure SlabBugfix!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((itemstack).getItem() == new ItemStack(ItemMimicGoldSlab.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockBaedoorFuntBlockSlab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Oak_Slab.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockOakWoodenSlab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Oak_Slab_Chisel.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockChiseled_Oak_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Dark_Oak_Slab.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockDark_Oak_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Dark_Oak_Slab_Chisel.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockChiseled_Dark_Oak_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Spruce_Slab.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockSpruce_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Spruce_Slab_Chisel.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockChiseled_Spruce_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Jungle_Slab.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockJungle_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Jungle_Slab_Chisel.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockChiseled_Jungle_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Acacia_Slab.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockAcacia_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Acacia_Slab_Chisel.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockChiseled_Acacia_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Birch_Slab.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockBirch_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Birch_Slab_Chisel.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockChiseled_Birch_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
		if (((itemstack).getItem() == new ItemStack(ItemMimic_Deadwood_Slab.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockDeadwood_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Deadwood_Slab_Chisel.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockChiseled_Deadwood_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Palm_Slab.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockPalm_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if (((itemstack).getItem() == new ItemStack(ItemMimic_Palm_Slab_Chisel.block, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems((itemstack).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(BlockChiseled_Palm_Wooden_Slab.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}
}
