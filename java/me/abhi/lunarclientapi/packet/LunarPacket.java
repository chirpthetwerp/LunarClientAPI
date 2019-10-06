package me.abhi.lunarclientapi.packet;

import org.bukkit.entity.Player;

public abstract class LunarPacket {

    public abstract int getPacketId();

    public abstract byte[] getData(Player player);

    public abstract void broadcastFor(Player player);
}
