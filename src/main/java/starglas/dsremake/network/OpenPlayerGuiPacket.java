package starglas.dsremake.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import starglas.dsremake.common.helpers.ModVars;

public class OpenPlayerGuiPacket extends AbstractPacket

{

	// this will store the id of the gui to open

	private int id;

	// The basic, no-argument constructor MUST be included to use the new
	// automated handling

	public OpenPlayerGuiPacket() {
	}

	// if there are any class fields, be sure to provide a constructor that
	// allows

	// for them to be initialized, and use that constructor when sending the
	// network

	public OpenPlayerGuiPacket(int id) {

		this.id = id;

	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {

		// basic Input/Output operations, very much like DataOutputStream

		buffer.writeInt(id);

	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		// basic Input/Output operations, very much like DataInputStream
		id = buffer.readInt();
		System.out.println("ctx = [" + ctx + "], buffer = [" + buffer + "]");
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		// for opening a GUI, we don't need to do anything here
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		// because we sent the gui's id with the network, we can handle all cases
		// with one line:
		player.openGui(ModVars.MODID, id, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
	}
}