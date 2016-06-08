/*
 * Decompiled with CFR 0_114.
 */
package org.minicraft.manager.server;

import net.minecraft.server.v1_9_R2.EntityPlayer;
import net.minecraft.server.v1_9_R2.PlayerConnection;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.minicraft.manager.server.IMIPacket;
import org.minicraft.manager.server.MiniPlayerConnection;

public abstract class MIHandler {
    public static MIHandler instance;

    public static IMIPacket newpacket(int type) {
        return instance.newdata(type);
    }

    public abstract IMIPacket newdata(int var1);

    public static MiniPlayerConnection getPlayerConnection(Player p) {
        return new MiniPlayerConnection(((CraftPlayer)p).getHandle().playerConnection);
    }
}

