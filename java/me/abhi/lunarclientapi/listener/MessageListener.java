package me.abhi.lunarclientapi.listener;

import me.abhi.lunarclientapi.LunarClientAPI;
import me.abhi.lunarclientapi.data.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class MessageListener implements PluginMessageListener {

    private LunarClientAPI plugin;

    public MessageListener(LunarClientAPI plugin) {
        this.plugin = plugin;
    }

    public void onPluginMessageReceived(String s, Player player, byte[] bytes) {
        PlayerData playerData = this.plugin.getPlayerData(player);
        String clientName = new String(bytes);
        if (clientName.equalsIgnoreCase("abhi-best-dev")) {
            player.sendMessage("BlockGame Client?!?!!?");
        }
        if (s.equals("MC|Brand") && clientName.equals("vanilla")) {
            playerData.setPassedMCBrand(true);
        }
    }

}
