package protocolsupport.protocol.packet.middleimpl.clientbound.play.v1_5_1_6_1_7;

import java.io.IOException;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.api.chat.ChatAPI;
import protocolsupport.protocol.legacyremapper.LegacyUtils;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleInventoryOpen;
import protocolsupport.protocol.packet.middleimpl.PacketData;
import protocolsupport.protocol.typeskipper.id.IdSkipper;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableEmptyList;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class InventoryOpen extends MiddleInventoryOpen<RecyclableCollection<PacketData>> {

	@Override
	public boolean needsPlayer() {
		return true;
	}

	@Override
	public RecyclableCollection<PacketData> toData(ProtocolVersion version) throws IOException {
		int id = LegacyUtils.getInventoryId(invname);
		if (IdSkipper.INVENTORY.getTable(version).shouldSkip(id)) {
			player.closeInventory();
			return RecyclableEmptyList.get();
		}
		PacketData serializer = PacketData.create(ClientBoundPacket.PLAY_WINDOW_OPEN_ID, version);
		serializer.writeByte(windowId);
		serializer.writeByte(id);
		serializer.writeString(ChatAPI.fromJSON(titleJson).toLegacyText());
		serializer.writeByte(slots);
		serializer.writeBoolean(true);
		if (id == 11) {
			serializer.writeInt(horseId);
		}
		return RecyclableSingletonList.create(serializer);
	}

}
