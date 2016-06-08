/*
 * Decompiled with CFR 0_114.
 */
package fr.craftyourmind.packets.client;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.server.v1_9_R2.Packet;
import net.minecraft.server.v1_9_R2.PacketDataSerializer;
import net.minecraft.server.v1_9_R2.PacketListener;

public class PacketOutDonjon
implements Packet<PacketListener> {
    public static final String DELIMITER = "";
    public static final int WORLD = 0;
    public int action;
    public String names;
    public int playerNb;

    public PacketOutDonjon() {
    }

    public PacketOutDonjon(int action, String names, int playerNb) {
        this.action = action;
        this.names = names;
        this.playerNb = playerNb;
    }

    @Override
    public void a(PacketDataSerializer arg0) throws IOException {
        this.action = arg0.readInt();
        this.names = arg0.e(32767);
        this.playerNb = arg0.readInt();
    }

    @Override
    public void a(PacketListener arg0) {
    }

    @Override
    public void b(PacketDataSerializer arg0) throws IOException {
        arg0.writeInt(this.action);
        arg0.a(this.names);
        arg0.writeInt(this.playerNb);
    }
}

