/*
 * Decompiled with CFR 0_114.
 */
package org.minicraft.manager.server;

import java.io.IOException;
import org.minicraft.manager.server.MIByteBuff;
import org.minicraft.manager.server.MiniPlayerConnection;

public interface IMIPacket {
    public void readPacketData(MIByteBuff var1) throws IOException;

    public void writePacketData(MIByteBuff var1) throws IOException;

    public void receive(MiniPlayerConnection var1);

    public int getTypedata();

    public void setTypedata(int var1);
}

