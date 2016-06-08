package org.minicraft.manager.server;

import java.io.IOException;

public interface IMIPacket {
	
	public abstract void readPacketData(MIByteBuff input) throws IOException;
	public abstract void writePacketData(MIByteBuff output) throws IOException;

	public void receive(MiniPlayerConnection playercnx) ;
	public abstract int getTypedata();
	public abstract void setTypedata(int typedata);
	
}
