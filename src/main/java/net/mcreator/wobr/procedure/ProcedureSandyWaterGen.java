package net.mcreator.wobr.procedure;

import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;

import net.mcreator.wobr.block.BlockVulcanicSand;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ProcedureSandyWaterGen extends ElementsWastelandsofBaedoor.ModElement {
	public ProcedureSandyWaterGen(ElementsWastelandsofBaedoor instance) {
		super(instance, 263);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SandyWaterGen!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SandyWaterGen!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SandyWaterGen!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SandyWaterGen!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BlockVulcanicSand.block.getDefaultState()
				.getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_porphyry"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) (y - 1), (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == BlockVulcanicSand.block.getDefaultState()
				.getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_porphyry"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) (x - 1), (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == BlockVulcanicSand.block.getDefaultState()
				.getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_porphyry"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) (x + 1), (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == BlockVulcanicSand.block.getDefaultState()
				.getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_porphyry"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) (z - 1));
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == BlockVulcanicSand.block.getDefaultState()
				.getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_porphyry"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) (z + 1));
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.SAND.getStateFromMeta(0).getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_sand"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) (y - 1), (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.SAND.getStateFromMeta(0).getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_sand"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) (x - 1), (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.SAND.getStateFromMeta(0).getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_sand"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) (x + 1), (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.SAND.getStateFromMeta(0).getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_sand"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) (z - 1));
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.SAND.getStateFromMeta(0).getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_sand"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) (z + 1));
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.STONE.getStateFromMeta(3).getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_alabaster"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) (y - 1), (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.STONE.getStateFromMeta(3).getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_alabaster"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) (x - 1), (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.STONE.getStateFromMeta(3).getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_alabaster"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) (x + 1), (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.STONE.getStateFromMeta(3).getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_alabaster"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) (z - 1));
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.STONE.getStateFromMeta(3).getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_alabaster"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) (z + 1));
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.COBBLESTONE.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_limestone"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) (y - 1), (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.COBBLESTONE.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_limestone"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) (x - 1), (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.COBBLESTONE.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_limestone"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) (x + 1), (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.COBBLESTONE.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_limestone"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) (z - 1));
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.COBBLESTONE.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_limestone"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) (z + 1));
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.GRAVEL.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_gravel"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) (y - 1), (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.GRAVEL.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_gravel"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) (x - 1), (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.GRAVEL.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_gravel"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) (x + 1), (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.GRAVEL.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_gravel"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) (z - 1));
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.GRAVEL.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_gravel"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) (z + 1));
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CLAY.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_marl"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) (y - 1), (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.CLAY.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_marl"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) (x - 1), (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.CLAY.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_marl"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) (x + 1), (int) y, (int) z);
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.CLAY.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_marl"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) (z - 1));
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.CLAY.getDefaultState().getBlock())) {
			if (!world.isRemote) {
				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
						new ResourceLocation("wobr", "addon_atum_marl"));
				if (template != null) {
					BlockPos spawnTo = new BlockPos((int) x, (int) y, (int) (z + 1));
					IBlockState iblockstate = world.getBlockState(spawnTo);
					world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
					template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
							.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
				}
			}
		}
	}
}
