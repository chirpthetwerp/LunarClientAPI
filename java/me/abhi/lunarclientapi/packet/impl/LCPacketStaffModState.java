package me.abhi.lunarclientapi.packet.impl;

import lombok.AllArgsConstructor;
import me.abhi.lunarclientapi.LunarClientAPI;
import me.abhi.lunarclientapi.enums.StaffMod;
import me.abhi.lunarclientapi.packet.LunarPacket;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class LCPacketStaffModState extends LunarPacket {

    private StaffMod staffMod;
    private boolean value;

    @Override
    public int getPacketId() {
        return 12;
    }

    @Override
    public byte[] getData(Player player) {
        byte[] data = new byte[256];
        data[0] = (byte) getPacketId();
        data[1] = staffMod.getId();
        byte[] mod = staffMod.getName().getBytes();
        for (int i = 0; i < mod.length; i++) {
            data[i + 2] = mod[i];
        }
        data[mod.length + 2] = (byte) (value ? 1 : 0);
        return data;
    }

    @Override
    public void broadcastFor(Player player) {
        player.sendPluginMessage(LunarClientAPI.getInstance(), "Lunar-Client", getData(player));
    }
}
