package org.minicraft.manager.server;

import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

public abstract class MIHandler {

	public static MIHandler instance;
	
	public static IMIPacket newpacket(int type) {
		return instance.newdata(type);
	}

	public abstract IMIPacket newdata(int type);
	
	public static MiniPlayerConnection getPlayerConnection(Player p){
		return new MiniPlayerConnection(((CraftPlayer)p).getHandle().playerConnection);
	}
}
