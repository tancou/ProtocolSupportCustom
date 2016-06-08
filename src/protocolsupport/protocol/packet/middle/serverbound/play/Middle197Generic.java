package protocolsupport.protocol.packet.middle.serverbound.play;

import org.minicraft.manager.server.IMIPacket;
import protocolsupport.protocol.packet.ServerBoundPacket;
import protocolsupport.protocol.packet.middle.ServerBoundMiddlePacket;
import protocolsupport.protocol.packet.middleimpl.PacketCreator;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public abstract class Middle197Generic extends ServerBoundMiddlePacket {

    public IMIPacket data = null;
    public int packetSize;

    @Override
    public RecyclableCollection<PacketCreator> toNative() throws Exception {
        PacketCreator creator = PacketCreator.create(ServerBoundPacket.PLAY_197_GENERIC);
        creator.writeImiPacket(data);
        creator.writeVarInt(packetSize);
        return RecyclableSingletonList.create(creator);
    }

}
