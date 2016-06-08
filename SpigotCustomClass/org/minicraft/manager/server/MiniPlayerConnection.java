package org.minicraft.manager.server;

import org.bukkit.entity.Player;
import org.minicraft.manager.server.packet.Packet197Generic;

import net.minecraft.server.PlayerConnection;

public class MiniPlayerConnection {

	public PlayerConnection playercnx;
	
	public MiniPlayerConnection(PlayerConnection playercnx) {
		this.playercnx = playercnx;
	}
	
	public Player getPlayer(){
		return playercnx.getPlayer();
	}
	
	public void sendPacket(IMIPacket data){
		if(playercnx != null) playercnx.sendPacket(new Packet197Generic(data));
	}
}
