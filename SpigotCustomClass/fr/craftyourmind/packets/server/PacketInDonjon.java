package fr.craftyourmind.packets.server;

import java.io.IOException;

import net.minecraft.server.Packet;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;

public class PacketInDonjon implements Packet{
	public final static String DELIMITER = "";
	
	public final static int WORLD = 0;
	
	public int action;
	public String names;
	public int playerNb;

	public PacketInDonjon(){}
	public PacketInDonjon(int action, String names, int playerNb) {
		this.action = action;
		this.names = names;
		this.playerNb = playerNb;
	}
	
	@Override
	public void a(PacketDataSerializer arg0) throws IOException {
		action = arg0.readInt();
		names = arg0.e(32767);
		playerNb = arg0.readInt();
		
	}
	@Override
	public void a(PacketListener arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void b(PacketDataSerializer arg0) throws IOException {
		arg0.writeInt(action);
		arg0.a(names);
		arg0.writeInt(playerNb);
	}
	public int getDongeon(){
		return this.action;
	}
	
	public String getPlayers(){
		return names;
	}
	
	public int getPlayerNumber(){
		return playerNb;
	}
}