package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_1_8;

import java.io.IOException;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleBlockAction;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleInDonjon;
import protocolsupport.protocol.packet.middleimpl.PacketData;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

//TANCOU
public class InDonjon extends MiddleInDonjon<RecyclableCollection<PacketData>> {

    @Override
    public RecyclableCollection<PacketData> toData(ProtocolVersion version) throws IOException {
        PacketData serializer = PacketData.create(ClientBoundPacket.PLAY_OUT_DONJON, version);
        serializer.writeVarInt(action);
        serializer.writeString(names);
        serializer.writeVarInt(playerNb);
        return RecyclableSingletonList.create(serializer);
    }

}
