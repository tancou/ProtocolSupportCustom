package protocolsupport.protocol.packet.middleimpl.serverbound.login.v_1_4_1_5_1_6_1_7_1_8;

import java.io.IOException;

import protocolsupport.protocol.packet.middle.serverbound.login.MiddleEncryptionResponse;
import protocolsupport.protocol.serializer.ProtocolSupportPacketDataSerializer;

public class EncryptionResponse extends MiddleEncryptionResponse {

	@Override
	public void readFromClientData(ProtocolSupportPacketDataSerializer serializer) throws IOException {
		sharedSecret = serializer.readByteArray(256);
		verifyToken = serializer.readByteArray(256);
	}

}
