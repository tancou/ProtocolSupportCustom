/*
 * Decompiled with CFR 0_114.
 */
package org.minicraft.manager.server;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.util.List;
import net.minecraft.server.v1_9_R2.PacketDataSerializer;

public class MIByteBuff {
    private PacketDataSerializer pd;

    public MIByteBuff(PacketDataSerializer pd) {
        this.pd = pd;
    }

    public String readStr() throws IOException {
        return this.pd.e(32767);
    }

    public int readInt() throws IOException {
        return this.pd.readInt();
    }

    public long readLong() throws IOException {
        return this.pd.readLong();
    }

    public float readFloat() throws IOException {
        return this.pd.readFloat();
    }

    public double readDouble() throws IOException {
        return this.pd.readDouble();
    }

    public boolean readBoolean() throws IOException {
        return this.pd.readBoolean();
    }

    public void writeStr(String s) throws IOException {
        this.pd.a(s);
    }

    public void writeInt(int i) throws IOException {
        this.pd.writeInt(i);
    }

    public void writeLong(long l) throws IOException {
        this.pd.writeLong(l);
    }

    public void writeFloat(float f) throws IOException {
        this.pd.writeFloat(f);
    }

    public void writeDouble(double d2) throws IOException {
        this.pd.writeDouble(d2);
    }

    public void writeBoolean(boolean b2) throws IOException {
        this.pd.writeBoolean(b2);
    }

    public void readList(List<Integer> listInt, List<String> listStr) throws IOException {
        int nb = this.readInt();
        for (int i = 0; i < nb; ++i) {
            listInt.add(this.readInt());
            listStr.add(this.readStr());
        }
    }

    public void readListBool(List<Boolean> listBool) throws IOException {
        int nb = this.readInt();
        for (int i = 0; i < nb; ++i) {
            listBool.add(this.readBoolean());
        }
    }

    public void readListInt(List<Integer> listInt) throws IOException {
        int nb = this.readInt();
        for (int i = 0; i < nb; ++i) {
            listInt.add(this.readInt());
        }
    }

    public void readListStr(List<String> listStr) throws IOException {
        int nb = this.readInt();
        for (int i = 0; i < nb; ++i) {
            listStr.add(this.readStr());
        }
    }

    public void writeList(List<Integer> listInt, List<String> listStr) throws IOException {
        this.writeInt(listInt.size());
        for (int i = 0; i < listInt.size(); ++i) {
            this.writeInt(listInt.get(i));
            this.writeStr(listStr.get(i));
        }
    }

    public void writeListStr(List<String> listStr) throws IOException {
        this.writeInt(listStr.size());
        for (int i = 0; i < listStr.size(); ++i) {
            this.writeStr(listStr.get(i));
        }
    }

    public void writeListInt(List<Integer> listInt) throws IOException {
        this.writeInt(listInt.size());
        for (int i = 0; i < listInt.size(); ++i) {
            this.writeInt(listInt.get(i));
        }
    }

    public void writeListBool(List<Boolean> listBool) throws IOException {
        this.writeInt(listBool.size());
        for (int i = 0; i < listBool.size(); ++i) {
            this.writeBoolean(listBool.get(i));
        }
    }
}

