/*
 * Decompiled with CFR 0_114.
 */
package org.minicraft.manager.server.packet;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.server.v1_9_R2.EntityPlayer;
import net.minecraft.server.v1_9_R2.Packet;
import net.minecraft.server.v1_9_R2.PacketDataSerializer;
import net.minecraft.server.v1_9_R2.PacketListener;
import net.minecraft.server.v1_9_R2.PlayerConnection;
import net.minecraft.server.v1_9_R2.PlayerConnectionUtils;
import net.minecraft.server.v1_9_R2.WorldServer;
import org.minicraft.manager.server.IMIPacket;
import org.minicraft.manager.server.MIByteBuff;
import org.minicraft.manager.server.MIHandler;
import org.minicraft.manager.server.MiniPlayerConnection;

public class Packet197Generic
implements Packet<PacketListener> {
    public IMIPacket data = null;
    public int packetSize;

    public Packet197Generic() {
    }

    public Packet197Generic(IMIPacket data) {
        this.data = data;
        this.packetSize = 4;
    }

    @Override
    public void a(PacketDataSerializer input) throws IOException {
        int typedata = input.readInt();
        this.data = MIHandler.newpacket(typedata);
        if (this.data != null) {
            this.data.readPacketData(new MIByteBuff(input));
        }
    }

    @Override
    public void b(PacketDataSerializer output) throws IOException {
        output.writeInt(this.data.getTypedata());
        this.data.writePacketData(new MIByteBuff(output));
    }

    @Override
    public void a(PacketListener cnx) {
        if (this.data != null) {
            PlayerConnection pc = (PlayerConnection)cnx;
            PlayerConnectionUtils.ensureMainThread(this, cnx, pc.player.x());
            this.data.receive(new MiniPlayerConnection((PlayerConnection)cnx));
        }
    }
}

