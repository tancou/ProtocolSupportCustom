package org.minicraft.manager.server.packet;

import java.io.IOException;

import org.minicraft.manager.server.IMIPacket;
import org.minicraft.manager.server.MIByteBuff;
import org.minicraft.manager.server.MIHandler;
import org.minicraft.manager.server.MiniPlayerConnection;

import net.minecraft.server.Packet;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.PlayerConnection;
import net.minecraft.server.PlayerConnectionUtils;

public class Packet197Generic implements Packet{
	
	public IMIPacket data = null;
	public int packetSize;
	
	public Packet197Generic() {
	}

	public Packet197Generic(IMIPacket data) {
		this.data = data;
		packetSize = 4;
	}

	@Override
	public void a(PacketDataSerializer input) throws IOException {
		int typedata = input.readInt();
		
		data = MIHandler.newpacket(typedata);
		if(data != null){
			data.readPacketData(new MIByteBuff(input));
		}
	}

	@Override
	public void b(PacketDataSerializer output) throws IOException {
		output.writeInt(data.getTypedata());
		data.writePacketData(new MIByteBuff(output));
	}

	@Override
	public void a(PacketListener cnx) {
		if(data != null){
			PlayerConnection pc = ((PlayerConnection)cnx);
			PlayerConnectionUtils.ensureMainThread(this, cnx, pc.player.x());
			data.receive(new MiniPlayerConnection((PlayerConnection)cnx));
		}
	}
	
}
