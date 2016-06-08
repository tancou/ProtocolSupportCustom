package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_1_4_1_5_1_6_1_7;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleBlockChangeMulti;
import protocolsupport.protocol.packet.middleimpl.PacketData;
import protocolsupport.protocol.typeremapper.id.IdRemapper;
import protocolsupport.protocol.typeremapper.id.RemappingTable;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class BlockChangeMulti extends MiddleBlockChangeMulti<RecyclableCollection<PacketData>> {

	@Override
	public RecyclableCollection<PacketData> toData(ProtocolVersion version) {
		RemappingTable remapper = IdRemapper.BLOCK.getTable(version);
		PacketData serializer = PacketData.create(ClientBoundPacket.PLAY_BLOCK_CHANGE_MULTI_ID, version);
		serializer.writeInt(chunkX);
		serializer.writeInt(chunkZ);
		serializer.writeShort(records.length);
		serializer.writeInt(records.length * 4);
		for (Record record : records) {
			serializer.writeShort(record.coord);
			serializer.writeShort(remapper.getRemap(record.id));
		}
		return RecyclableSingletonList.create(serializer);
	}

}
