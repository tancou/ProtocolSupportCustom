package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_8;

import protocolsupport.protocol.packet.middle.serverbound.play.Middle197Generic;
import protocolsupport.protocol.serializer.ProtocolSupportPacketDataSerializer;

import java.io.IOException;

public class _197Generic extends Middle197Generic {

    @Override
    public void readFromClientData(ProtocolSupportPacketDataSerializer serializer) throws IOException {
        data = serializer.readImiPacket();
        packetSize = serializer.readVarInt();
    }

}
