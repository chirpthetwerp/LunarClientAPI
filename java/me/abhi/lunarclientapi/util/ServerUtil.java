package me.abhi.lunarclientapi.util;

import me.abhi.lunarclientapi.LunarClientAPI;
import org.bukkit.entity.Player;

public class ServerUtil {

    public static void broadcastPluginMessage(byte[] data) {
        for (Player player : LunarClientAPI.getInstance().getServer().getOnlinePlayers()) {
            player.sendPluginMessage(LunarClientAPI.getInstance(), "Lunar-Client", data);
        }
    }
}
