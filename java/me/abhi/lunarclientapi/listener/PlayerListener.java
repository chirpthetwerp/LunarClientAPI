package me.abhi.lunarclientapi.listener;

import me.abhi.lunarclientapi.LunarClientAPI;
import me.abhi.lunarclientapi.data.PlayerData;
import me.abhi.lunarclientapi.enums.Emote;
import me.abhi.lunarclientapi.enums.StaffMod;
import me.abhi.lunarclientapi.event.PlayerAuthenticateEvent;
import me.abhi.lunarclientapi.packet.impl.LCPacketEmoteBroadcast;
import me.abhi.lunarclientapi.packet.impl.LCPacketStaffModState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRegisterChannelEvent;

public class PlayerListener implements Listener {

    public LunarClientAPI plugin;

    public PlayerListener(LunarClientAPI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        this.plugin.addPlayer(player);
    }

    @EventHandler
    public void onRegister(PlayerRegisterChannelEvent event) {
        Player player = event.getPlayer();
        PlayerData playerData = this.plugin.getPlayerData(player);
        if (event.getChannel().equals("Lunar-Client") && playerData.isPassedMCBrand()) {
            this.plugin.getServer().getPluginManager().callEvent(new PlayerAuthenticateEvent(player));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        this.plugin.removePlayer(player);
    }

    @EventHandler
    public void onAuthenticate(PlayerAuthenticateEvent event) {
        Player player = event.getPlayer();
        PlayerData playerData = this.plugin.getPlayerData(player);
        playerData.setLunarClient(true);
        if (player.isOp()) {
            new LCPacketStaffModState(StaffMod.BHOP, true).broadcastFor(player);
            new LCPacketStaffModState(StaffMod.XRAY, true).broadcastFor(player);
            new LCPacketStaffModState(StaffMod.NOCLIP, true).broadcastFor(player);
        }
    }
}
