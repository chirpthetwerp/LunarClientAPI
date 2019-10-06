package me.abhi.lunarclientapi.commands.subcommands;

import lombok.AllArgsConstructor;
import me.abhi.lunarclientapi.LunarClientAPI;
import me.abhi.lunarclientapi.data.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class LunarClientUsersSubCommand implements CommandExecutor {

    private LunarClientAPI plugin;

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-------" + ChatColor.AQUA + " Lunar Client Users " + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-------");
        for (Player player : this.plugin.getServer().getOnlinePlayers()) {
            PlayerData playerData = this.plugin.getPlayerData(player);
            if (playerData.isLunarClient()) {
                sender.sendMessage(player.getName());
            }
        }
        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "------------------------------");
        return true;
    }
}
