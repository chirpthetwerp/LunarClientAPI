package me.abhi.lunarclientapi.commands;

import lombok.AllArgsConstructor;
import me.abhi.lunarclientapi.LunarClientAPI;
import me.abhi.lunarclientapi.enums.Emote;
import me.abhi.lunarclientapi.packet.impl.LCPacketEmoteBroadcast;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class EmoteCommand implements CommandExecutor {

    private LunarClientAPI plugin;

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        if (!sender.hasPermission("lunarclientapi.command.emote")) {
            sender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <emote:player:all> <possible argument>");
            return true;
        }
        try {
            if (args.length == 1) {
                Player player = (Player) sender;
                Emote emote = Emote.valueOf(args[0].toUpperCase());
                new LCPacketEmoteBroadcast(emote).broadcastFor(player);
                sender.sendMessage(ChatColor.WHITE + "Sent " + ChatColor.AQUA + emote.toString() + ChatColor.WHITE + " to " + ChatColor.AQUA + player.getName() + ChatColor.WHITE + ".");
                return true;
            }
            Emote emote = Emote.valueOf(args[1].toUpperCase());
            if (args[0].equalsIgnoreCase("all")) {
                for (Player all : this.plugin.getServer().getOnlinePlayers()) {
                    new LCPacketEmoteBroadcast(emote).broadcastFor(all);
                    sender.sendMessage(ChatColor.WHITE + "Sent " + ChatColor.AQUA + emote.toString() + ChatColor.WHITE + " to " + ChatColor.AQUA + all.getName() + ChatColor.WHITE + ".");
                }
                return true;
            }
            Player target = this.plugin.getServer().getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(ChatColor.RED + "Player not found.");
                return true;
            }
            new LCPacketEmoteBroadcast(emote).broadcastFor(target);
            sender.sendMessage(ChatColor.WHITE + "Sent " + ChatColor.AQUA + emote.toString() + ChatColor.WHITE + " to " + ChatColor.AQUA + target.getName() + ChatColor.WHITE + ".");
            return true;
        } catch (Exception ex) {
            sender.sendMessage(ChatColor.RED + "Emote not found.");
        }
        return true;
    }
}
