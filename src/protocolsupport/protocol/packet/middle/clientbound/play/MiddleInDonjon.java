package protocolsupport.protocol.packet.middle.clientbound.play;

import java.io.IOException;

import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.ProtocolSupportPacketDataSerializer;
import protocolsupport.protocol.utils.types.Position;

//TANCOU
public abstract class MiddleInDonjon<T> extends ClientBoundMiddlePacket<T> {

    protected int action;
    protected String names;
    protected int playerNb;

    @Override
    public void readFromServerData(ProtocolSupportPacketDataSerializer serializer) throws IOException {
        action = serializer.readVarInt();
        names = serializer.readString(32767);
        playerNb = serializer.readVarInt();
    }

}
