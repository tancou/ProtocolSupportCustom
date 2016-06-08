package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_1_8;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleIn197Generic;
import protocolsupport.protocol.packet.middleimpl.PacketData;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

import java.io.IOException;

//TANCOU
public class In197Generic extends MiddleIn197Generic<RecyclableCollection<PacketData>> {

    @Override
    public RecyclableCollection<PacketData> toData(ProtocolVersion version) throws IOException {
        PacketData serializer = PacketData.create(ClientBoundPacket.PLAY_197_GENERIC, version);
        serializer.writeImiPacket(data);
        serializer.writeVarInt(packetSize);
        return RecyclableSingletonList.create(serializer);
    }

}
