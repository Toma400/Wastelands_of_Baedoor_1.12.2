
package net.mcreator.wobr.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ActionResult;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;

import net.mcreator.wobr.ElementsWastelandsofBaedoor;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class ItemBulletRanged extends ElementsWastelandsofBaedoor.ModElement {
	@GameRegistry.ObjectHolder("wobr:bullet_ranged")
	public static final Item block = null;
	public static final int ENTITYID = 1;
	public ItemBulletRanged(ElementsWastelandsofBaedoor instance) {
		super(instance, 123);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new RangedItem());
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityArrowCustom.class)
				.id(new ResourceLocation("wobr", "entitybulletbullet_ranged"), ENTITYID).name("entitybulletbullet_ranged").tracker(64, 1, true)
				.build());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("wobr:bullet_ranged", "inventory"));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, renderManager -> {
			return new RenderSnowball(renderManager, new ItemStack(ItemProjectileBullet.block, (int) (1)).getItem(),
					Minecraft.getMinecraft().getRenderItem());
		});
	}
	public static class RangedItem extends Item {
		public RangedItem() {
			super();
			setMaxDamage(100);
			setFull3D();
			setUnlocalizedName("bullet_ranged");
			setRegistryName("bullet_ranged");
			maxStackSize = 1;
			setCreativeTab(null);
		}

		@Override
		public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityLivingBase entityLivingBase, int timeLeft) {
			if (!world.isRemote && entityLivingBase instanceof EntityPlayerMP) {
				EntityPlayerMP entity = (EntityPlayerMP) entityLivingBase;
				float power = 0f;
				EntityArrowCustom entityarrow = new EntityArrowCustom(world, entity);
				entityarrow.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, power * 2, 0);
				entityarrow.setSilent(true);
				entityarrow.setIsCritical(false);
				entityarrow.setDamage(0);
				entityarrow.setKnockbackStrength(0);
				itemstack.damageItem(1, entity);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				world.playSound((EntityPlayer) null, (double) x, (double) y, (double) z,
						(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation((""))),
						SoundCategory.NEUTRAL, 1, 1f / (itemRand.nextFloat() * 0.5f + 1f) + (power / 2));
				entityarrow.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
				if (!world.isRemote)
					world.spawnEntity(entityarrow);
			}
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
			entity.setActiveHand(hand);
			return new ActionResult(EnumActionResult.SUCCESS, entity.getHeldItem(hand));
		}

		@Override
		public EnumAction getItemUseAction(ItemStack itemstack) {
			return EnumAction.BOW;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack itemstack) {
			return 72000;
		}
	}

	public static class EntityArrowCustom extends EntityTippedArrow {
		public EntityArrowCustom(World a) {
			super(a);
		}

		public EntityArrowCustom(World worldIn, double x, double y, double z) {
			super(worldIn, x, y, z);
		}

		public EntityArrowCustom(World worldIn, EntityLivingBase shooter) {
			super(worldIn, shooter);
		}

		@Override
		protected void onHit(RayTraceResult raytraceResultIn) {
			// whole class overridden
			Entity entity = raytraceResultIn.entityHit;
			if (entity != null) {
				float f = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
				int i = MathHelper.ceil((double) f * this.damage);
				if (this.getIsCritical()) {
					i += this.rand.nextInt(i / 2 + 2);
				}
				DamageSource damagesource;
				if (this.shootingEntity == null) {
					damagesource = DamageSource.causeArrowDamage(this, this);
				} else {
					damagesource = DamageSource.causeArrowDamage(this, this.shootingEntity);
				}
				if (this.isBurning() && !(entity instanceof EntityEnderman)) {
					entity.setFire(5);
				}
				if (entity.attackEntityFrom(damagesource, (float) i)) {
					if (entity instanceof EntityLivingBase) {
						EntityLivingBase entitylivingbase = (EntityLivingBase) entity;
						if (!this.world.isRemote) {
							entitylivingbase.setArrowCountInEntity(entitylivingbase.getArrowCountInEntity() + 1);
						}
						if (this.knockbackStrength > 0) {
							float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
							if (f1 > 0.0F) {
								entitylivingbase.addVelocity(this.motionX * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1, 0.1D,
										this.motionZ * (double) this.knockbackStrength * 0.6000000238418579D / (double) f1);
							}
						}
						if (this.shootingEntity instanceof EntityLivingBase) {
							EnchantmentHelper.applyThornEnchantments(entitylivingbase, this.shootingEntity);
							EnchantmentHelper.applyArthropodEnchantments((EntityLivingBase) this.shootingEntity, entitylivingbase);
						}
						this.arrowHit(entitylivingbase);
						if (this.shootingEntity != null && entitylivingbase != this.shootingEntity && entitylivingbase instanceof EntityPlayer
								&& this.shootingEntity instanceof EntityPlayerMP) {
							((EntityPlayerMP) this.shootingEntity).connection.sendPacket(new SPacketChangeGameState(6, 0.0F));
						}
					}
					if (!(entity instanceof EntityEnderman)) {
						this.setDead();
					}
				} else {
					this.motionX *= -0.10000000149011612D;
					this.motionY *= -0.10000000149011612D;
					this.motionZ *= -0.10000000149011612D;
					this.rotationYaw += 180.0F;
					this.prevRotationYaw += 180.0F;
					this.ticksInAir = 0;
					if (!this.world.isRemote
							&& this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ < 0.0010000000474974513D) {
						if (this.pickupStatus == EntityArrow.PickupStatus.ALLOWED) {
							this.entityDropItem(this.getArrowStack(), 0.1F);
						}
						this.setDead();
					}
				}
			} else {
				BlockPos blockpos = raytraceResultIn.getBlockPos();
				this.xTile = blockpos.getX();
				this.yTile = blockpos.getY();
				this.zTile = blockpos.getZ();
				IBlockState iblockstate = this.world.getBlockState(blockpos);
				this.inTile = iblockstate.getBlock();
				this.inData = this.inTile.getMetaFromState(iblockstate);
				this.motionX = (double) ((float) (raytraceResultIn.hitVec.x - this.posX));
				this.motionY = (double) ((float) (raytraceResultIn.hitVec.y - this.posY));
				this.motionZ = (double) ((float) (raytraceResultIn.hitVec.z - this.posZ));
				float f2 = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
				this.posX -= this.motionX / (double) f2 * 0.05000000074505806D;
				this.posY -= this.motionY / (double) f2 * 0.05000000074505806D;
				this.posZ -= this.motionZ / (double) f2 * 0.05000000074505806D;
				this.inGround = true;
				this.arrowShake = 7;
				this.setIsCritical(false);
				if (iblockstate.getMaterial() != Material.AIR) {
					this.inTile.onEntityCollidedWithBlock(this.world, blockpos, iblockstate, this);
				}
			}
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			World world = this.world;
			Entity entity = (Entity) shootingEntity;
			if (this.inGround) {
				this.world.removeEntity(this);
			}
		}
	}
}
