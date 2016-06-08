package protocolsupport.protocol.packet.middle.serverbound.play;

import protocolsupport.protocol.packet.ServerBoundPacket;
import protocolsupport.protocol.packet.middle.ServerBoundMiddlePacket;
import protocolsupport.protocol.packet.middleimpl.PacketCreator;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

//TANCOU
public abstract class MiddleOutDonjon extends ServerBoundMiddlePacket {

    public int action;
    public String names;
    public int playerNb;

    @Override
    public RecyclableCollection<PacketCreator> toNative() throws Exception {
        PacketCreator creator = PacketCreator.create(ServerBoundPacket.PLAY_OUT_DONJON);
        creator.writeInt(action);
        creator.writeString(names);
        creator.writeInt(playerNb);
        return RecyclableSingletonList.create(creator);
    }

}
