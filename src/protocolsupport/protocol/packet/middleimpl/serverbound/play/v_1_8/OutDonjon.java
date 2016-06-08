package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_8;

import protocolsupport.protocol.packet.middle.serverbound.play.MiddleOutDonjon;
import protocolsupport.protocol.serializer.ProtocolSupportPacketDataSerializer;

import java.io.IOException;

//TANCOU
public class OutDonjon extends MiddleOutDonjon {

    @Override
    public void readFromClientData(ProtocolSupportPacketDataSerializer serializer) throws IOException {
        action = serializer.readVarInt();
        names = serializer.readString(32767);
        playerNb = serializer.readVarInt();
    }

}
