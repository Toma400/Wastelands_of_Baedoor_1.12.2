
package net.mcreator.wobr.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.GuiButton;

import net.mcreator.wobr.procedure.ProcedureWanderingTradeVulcanicVeil;
import net.mcreator.wobr.procedure.ProcedureWanderingTradeSandVeil;
import net.mcreator.wobr.procedure.ProcedureWanderingTradeGlowingObsidian;
import net.mcreator.wobr.procedure.ProcedureWanderingTradeFirearmTable;
import net.mcreator.wobr.procedure.ProcedureWanderingTradeBaedoorGoldIngot;
import net.mcreator.wobr.WastelandsofBaedoor;
import net.mcreator.wobr.ElementsWastelandsofBaedoor;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import java.io.IOException;

@ElementsWastelandsofBaedoor.ModElement.Tag
public class GuiWanderingTraderAlternativeGUI extends ElementsWastelandsofBaedoor.ModElement {
	public static int GUIID = 8;
	public static HashMap guistate = new HashMap();
	public GuiWanderingTraderAlternativeGUI(ElementsWastelandsofBaedoor instance) {
		super(instance, 207);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		elements.addNetworkMessage(GUIButtonPressedMessageHandler.class, GUIButtonPressedMessage.class, Side.SERVER);
		elements.addNetworkMessage(GUISlotChangedMessageHandler.class, GUISlotChangedMessage.class, Side.SERVER);
	}
	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private IInventory internal;
		private World world;
		private EntityPlayer entity;
		private int x, y, z;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		public GuiContainerMod(World world, int x, int y, int z, EntityPlayer player) {
			this.world = world;
			this.entity = player;
			this.x = x;
			this.y = y;
			this.z = z;
			this.internal = new InventoryBasic("", true, 0);
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(EntityPlayer player) {
			return internal.isUsableByPlayer(player);
		}

		@Override
		public void onContainerClosed(EntityPlayer playerIn) {
			super.onContainerClosed(playerIn);
			if ((internal instanceof InventoryBasic) && (playerIn instanceof EntityPlayerMP)) {
				this.clearContainer(playerIn, playerIn.world, internal);
			}
		}

		private void slotChanged(int slotid, int ctype, int meta) {
			if (this.world != null && this.world.isRemote) {
				WastelandsofBaedoor.PACKET_HANDLER.sendToServer(new GUISlotChangedMessage(slotid, x, y, z, ctype, meta));
				handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			}
		}
	}

	public static class GuiWindow extends GuiContainer {
		private World world;
		private int x, y, z;
		private EntityPlayer entity;
		public GuiWindow(World world, int x, int y, int z, EntityPlayer entity) {
			super(new GuiContainerMod(world, x, y, z, entity));
			this.world = world;
			this.x = x;
			this.y = y;
			this.z = z;
			this.entity = entity;
			this.xSize = 176;
			this.ySize = 166;
		}
		private static final ResourceLocation texture = new ResourceLocation("wobr:textures/wanderingtraderalternativegui.png");
		@Override
		public void drawScreen(int mouseX, int mouseY, float partialTicks) {
			this.drawDefaultBackground();
			super.drawScreen(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.mc.renderEngine.bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
			zLevel = 100.0F;
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_glowing_obsidian.png"));
			this.drawTexturedModalRect(this.guiLeft + 68, this.guiTop + 12, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_diamond_block.png"));
			this.drawTexturedModalRect(this.guiLeft + 10, this.guiTop + 11, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_obsidian.png"));
			this.drawTexturedModalRect(this.guiLeft + 34, this.guiTop + 12, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_emerald_block.png"));
			this.drawTexturedModalRect(this.guiLeft + 10, this.guiTop + 35, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_emerald.png"));
			this.drawTexturedModalRect(this.guiLeft + 10, this.guiTop + 58, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_emerald_2.png"));
			this.drawTexturedModalRect(this.guiLeft + 10, this.guiTop + 82, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_furnace.png"));
			this.drawTexturedModalRect(this.guiLeft + 34, this.guiTop + 34, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_sand.png"));
			this.drawTexturedModalRect(this.guiLeft + 34, this.guiTop + 58, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_soul_sand.png"));
			this.drawTexturedModalRect(this.guiLeft + 34, this.guiTop + 82, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_sand_dust.png"));
			this.drawTexturedModalRect(this.guiLeft + 67, this.guiTop + 58, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_ash_dust.png"));
			this.drawTexturedModalRect(this.guiLeft + 68, this.guiTop + 81, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_firearm_table.png"));
			this.drawTexturedModalRect(this.guiLeft + 68, this.guiTop + 34, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/ingot32.png"));
			this.drawTexturedModalRect(this.guiLeft + 69, this.guiTop + 128, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_emerald_3.png"));
			this.drawTexturedModalRect(this.guiLeft + 10, this.guiTop + 105, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/bone_meal.png"));
			this.drawTexturedModalRect(this.guiLeft + 33, this.guiTop + 105, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/ash32.png"));
			this.drawTexturedModalRect(this.guiLeft + 68, this.guiTop + 105, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gui_emerald_4.png"));
			this.drawTexturedModalRect(this.guiLeft + 10, this.guiTop + 127, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/gold_ingot.png"));
			this.drawTexturedModalRect(this.guiLeft + 34, this.guiTop + 128, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/cross_1.png"));
			this.drawTexturedModalRect(this.guiLeft + 26, this.guiTop + 131, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/cross_2.png"));
			this.drawTexturedModalRect(this.guiLeft + 26, this.guiTop + 108, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/cross_3.png"));
			this.drawTexturedModalRect(this.guiLeft + 26, this.guiTop + 85, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/cross_4.png"));
			this.drawTexturedModalRect(this.guiLeft + 26, this.guiTop + 62, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/cross_5.png"));
			this.drawTexturedModalRect(this.guiLeft + 26, this.guiTop + 37, 0, 0, 256, 256);
			this.mc.renderEngine.bindTexture(new ResourceLocation("wobr:textures/cross_6.png"));
			this.drawTexturedModalRect(this.guiLeft + 26, this.guiTop + 15, 0, 0, 256, 256);
		}

		@Override
		public void updateScreen() {
			super.updateScreen();
		}

		@Override
		protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
			super.mouseClicked(mouseX, mouseY, mouseButton);
		}

		@Override
		protected void keyTyped(char typedChar, int keyCode) throws IOException {
			super.keyTyped(typedChar, keyCode);
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		}

		@Override
		public void onGuiClosed() {
			super.onGuiClosed();
			Keyboard.enableRepeatEvents(false);
		}

		@Override
		public void initGui() {
			super.initGui();
			this.guiLeft = (this.width - 176) / 2;
			this.guiTop = (this.height - 166) / 2;
			Keyboard.enableRepeatEvents(true);
			this.buttonList.clear();
			this.buttonList.add(new GuiButton(0, this.guiLeft + 54, this.guiTop + 127, 9, 20, ">"));
			this.buttonList.add(new GuiButton(1, this.guiLeft + 54, this.guiTop + 33, 8, 20, ">"));
			this.buttonList.add(new GuiButton(2, this.guiLeft + 54, this.guiTop + 56, 8, 20, ">"));
			this.buttonList.add(new GuiButton(3, this.guiLeft + 54, this.guiTop + 81, 8, 20, ">"));
			this.buttonList.add(new GuiButton(4, this.guiLeft + 54, this.guiTop + 103, 8, 20, ">"));
			this.buttonList.add(new GuiButton(5, this.guiLeft + 54, this.guiTop + 127, 9, 20, ">"));
			this.buttonList.add(new GuiButton(6, this.guiLeft + 54, this.guiTop + 8, 8, 20, ">"));
		}

		@Override
		protected void actionPerformed(GuiButton button) {
			WastelandsofBaedoor.PACKET_HANDLER.sendToServer(new GUIButtonPressedMessage(button.id, x, y, z));
			handleButtonAction(entity, button.id, x, y, z);
		}

		@Override
		public boolean doesGuiPauseGame() {
			return false;
		}
	}

	public static class GUIButtonPressedMessageHandler implements IMessageHandler<GUIButtonPressedMessage, IMessage> {
		@Override
		public IMessage onMessage(GUIButtonPressedMessage message, MessageContext context) {
			EntityPlayerMP entity = context.getServerHandler().player;
			entity.getServerWorld().addScheduledTask(() -> {
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			return null;
		}
	}

	public static class GUISlotChangedMessageHandler implements IMessageHandler<GUISlotChangedMessage, IMessage> {
		@Override
		public IMessage onMessage(GUISlotChangedMessage message, MessageContext context) {
			EntityPlayerMP entity = context.getServerHandler().player;
			entity.getServerWorld().addScheduledTask(() -> {
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			return null;
		}
	}

	public static class GUIButtonPressedMessage implements IMessage {
		int buttonID, x, y, z;
		public GUIButtonPressedMessage() {
		}

		public GUIButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(buttonID);
			buf.writeInt(x);
			buf.writeInt(y);
			buf.writeInt(z);
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			buttonID = buf.readInt();
			x = buf.readInt();
			y = buf.readInt();
			z = buf.readInt();
		}
	}

	public static class GUISlotChangedMessage implements IMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage() {
		}

		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(slotID);
			buf.writeInt(x);
			buf.writeInt(y);
			buf.writeInt(z);
			buf.writeInt(changeType);
			buf.writeInt(meta);
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			slotID = buf.readInt();
			x = buf.readInt();
			y = buf.readInt();
			z = buf.readInt();
			changeType = buf.readInt();
			meta = buf.readInt();
		}
	}
	private static void handleButtonAction(EntityPlayer entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureWanderingTradeBaedoorGoldIngot.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 1) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureWanderingTradeFirearmTable.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 2) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureWanderingTradeSandVeil.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 3) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureWanderingTradeVulcanicVeil.executeProcedure($_dependencies);
			}
		}
		if (buttonID == 6) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureWanderingTradeGlowingObsidian.executeProcedure($_dependencies);
			}
		}
	}

	private static void handleSlotAction(EntityPlayer entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
