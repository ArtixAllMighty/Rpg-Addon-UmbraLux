package subaraki.umbralux.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketTransformMob implements IMessage{

	public int mob_id;
	
	public PacketTransformMob() {
	}
	
	public PacketTransformMob(int mob_id) {
		this.mob_id = mob_id;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		mob_id = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(mob_id);
	}
	
	public static class PacketTransformMobHandler implements IMessageHandler<PacketTransformMob, IMessage> {

		@Override
		public IMessage onMessage(PacketTransformMob message, MessageContext ctx) {
				
			return null;
		}
	}
}
