package protocolsupport.protocol.packet.middleimpl.serverbound.handshake.v_1_7_1_8;

import java.io.IOException;

import protocolsupport.protocol.packet.middle.serverbound.handshake.MiddleSetProtocol;
import protocolsupport.protocol.serializer.ProtocolSupportPacketDataSerializer;

public class SetProtocol extends MiddleSetProtocol {

	@Override
	public void readFromClientData(ProtocolSupportPacketDataSerializer serializer) throws IOException {
		serializer.readVarInt();
		hostname = serializer.readString();
		port = serializer.readUnsignedShort();
		nextState = serializer.readVarInt();
	}

}
