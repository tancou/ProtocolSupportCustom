/*
 * Decompiled with CFR 0_114.
 */
package org.minicraft.manager.server;

import net.minecraft.server.v1_9_R2.Packet;
import net.minecraft.server.v1_9_R2.PlayerConnection;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.minicraft.manager.server.IMIPacket;
import org.minicraft.manager.server.packet.Packet197Generic;

public class MiniPlayerConnection {
    public PlayerConnection playercnx;

    public MiniPlayerConnection(PlayerConnection playercnx) {
        this.playercnx = playercnx;
    }

    public Player getPlayer() {
        return this.playercnx.getPlayer();
    }

    public void sendPacket(IMIPacket data) {
        if (this.playercnx != null) {
            this.playercnx.sendPacket(new Packet197Generic(data));
        }
    }
}

