package org.minicraft.manager.server;

import java.io.IOException;
import java.util.List;

import net.minecraft.server.PacketDataSerializer;

public class MIByteBuff {

	private PacketDataSerializer pd;
	
	public MIByteBuff(PacketDataSerializer pd) { this.pd = pd; }

	public String readStr() throws IOException{ return pd.e(32767); }
	
	public int readInt() throws IOException{ return pd.readInt(); }
	
	public long readLong() throws IOException{ return pd.readLong(); }
	
	public float readFloat() throws IOException{ return pd.readFloat(); }
	
	public double readDouble() throws IOException{ return pd.readDouble(); }
	
	public boolean readBoolean() throws IOException{ return pd.readBoolean(); }
	
	public void writeStr(String s) throws IOException{ pd.a(s); }
	
	public void writeInt(int i) throws IOException{ pd.writeInt(i); }
	
	public void writeLong(long l) throws IOException{ pd.writeLong(l); }
	
	public void writeFloat(float f) throws IOException{ pd.writeFloat(f); }
	
	public void writeDouble(double d) throws IOException{ pd.writeDouble(d); }
	
	public void writeBoolean(boolean b) throws IOException{ pd.writeBoolean(b); }
	
	public void readList(List<Integer> listInt, List<String> listStr) throws IOException{
		int nb = readInt();
		for(int i = 0 ; i < nb ; i++){
			listInt.add(readInt());
			listStr.add(readStr());
		}
	}
	
	public void readListBool(List<Boolean> listBool) throws IOException{
		int nb = readInt();
		for(int i = 0 ; i < nb ; i++) listBool.add(readBoolean());
	}
	
	public void readListInt(List<Integer> listInt) throws IOException{
		int nb = readInt();
		for(int i = 0 ; i < nb ; i++) listInt.add(readInt());
	}
	
	public void readListStr(List<String> listStr) throws IOException{
		int nb = readInt();
		for(int i = 0 ; i < nb ; i++) listStr.add(readStr());
	}
	
	public void writeList(List<Integer> listInt, List<String> listStr) throws IOException{
		writeInt(listInt.size());
		for(int i = 0 ; i < listInt.size() ; i++){
			writeInt(listInt.get(i));
			writeStr(listStr.get(i));
		}
	}
	
	public void writeListStr(List<String> listStr) throws IOException{
		writeInt(listStr.size());
		for(int i = 0 ; i < listStr.size() ; i++) writeStr(listStr.get(i));		
	}
	
	public void writeListInt(List<Integer> listInt) throws IOException{
		writeInt(listInt.size());
		for(int i = 0 ; i < listInt.size() ; i++) writeInt(listInt.get(i));
	}
	
	public void writeListBool(List<Boolean> listBool) throws IOException{
		writeInt(listBool.size());
		for(int i = 0 ; i < listBool.size() ; i++) writeBoolean(listBool.get(i));
	}
	
}
