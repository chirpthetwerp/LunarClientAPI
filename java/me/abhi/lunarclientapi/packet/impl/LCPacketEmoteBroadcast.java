package me.abhi.lunarclientapi.packet.impl;

import lombok.AllArgsConstructor;
import me.abhi.lunarclientapi.enums.Emote;
import me.abhi.lunarclientapi.packet.LunarPacket;
import me.abhi.lunarclientapi.util.ServerUtil;
import me.abhi.lunarclientapi.util.UUIDUtil;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class LCPacketEmoteBroadcast extends LunarPacket {

    private Emote emote;

    @Override
    public int getPacketId() {
        return 26;
    }

    @Override
    public byte[] getData(Player player) {
        byte[] data = new byte[256];
        data[0] = (byte) getPacketId();
        data[20] = emote.getValue();
        byte[] uuid = UUIDUtil.asBytes(player.getUniqueId());
        for (int i = 1; i <= uuid.length; i++) {
            data[i] = uuid[i - 1];
        }
        return data;
    }

    @Override
    public void broadcastFor(Player player) {
        ServerUtil.broadcastPluginMessage(getData(player));
    }
}
