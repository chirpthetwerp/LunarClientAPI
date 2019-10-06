package me.abhi.lunarclientapi;

import lombok.Getter;
import me.abhi.lunarclientapi.commands.EmoteCommand;
import me.abhi.lunarclientapi.commands.LunarClientCommand;
import me.abhi.lunarclientapi.data.PlayerData;
import me.abhi.lunarclientapi.listener.MessageListener;
import me.abhi.lunarclientapi.listener.PlayerListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class LunarClientAPI extends JavaPlugin {

    @Getter
    private static LunarClientAPI instance;
    private Map<UUID, PlayerData> playerDataMap = new HashMap();

    public void onEnable() {
        instance = this;
        registerListeners();
        registerCommands();
    }

    private void registerListeners() {
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "MC|Brand", new MessageListener(this));
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "Lunar-Client", new MessageListener(this));
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "Lunar-Client");
        this.getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    }

    private void registerCommands() {
        getCommand("lunarclient").setExecutor(new LunarClientCommand(this));
        getCommand("emote").setExecutor(new EmoteCommand(this));
    }

    public void addPlayer(Player player) {
        playerDataMap.put(player.getUniqueId(), new PlayerData());
    }

    public void removePlayer(Player player) {
        playerDataMap.remove(player.getUniqueId());
    }

    public PlayerData getPlayerData(Player player) {
        return playerDataMap.get(player.getUniqueId());
    }

}
