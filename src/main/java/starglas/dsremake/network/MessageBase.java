package starglas.dsremake.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import starglas.dsremake.common.DSMain;

/**
 * Created by Starlight on 11-9-2015.
 */
public abstract class MessageBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ>{
    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    @Override
    public REQ onMessage(REQ message, MessageContext ctx) {
        if(ctx.side == Side.SERVER){
            handleServerSide(message, ctx.getServerHandler().playerEntity);
        } else {
            handleClientSide(message, null);
        }
        return null;
    }

    public abstract void handleClientSide(REQ message, EntityPlayer player);

    public abstract void handleServerSide(REQ message, EntityPlayer player);
}
