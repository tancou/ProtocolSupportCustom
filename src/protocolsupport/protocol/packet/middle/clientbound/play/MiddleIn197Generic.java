package protocolsupport.protocol.packet.middle.clientbound.play;

import java.io.IOException;

import org.minicraft.manager.server.IMIPacket;
import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.ProtocolSupportPacketDataSerializer;
import protocolsupport.protocol.utils.types.Position;

//TANCOU
public abstract class MiddleIn197Generic<T> extends ClientBoundMiddlePacket<T> {

    protected IMIPacket data;
    protected int packetSize;

    @Override
    public void readFromServerData(ProtocolSupportPacketDataSerializer serializer) throws IOException {
        data = serializer.readImiPacket();
        packetSize = serializer.readVarInt();
    }

}
