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
public class LunarClientCheckSubCommand implements CommandExecutor {

    private LunarClientAPI plugin;

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " check <player>");
            return true;
        }
        Player target = this.plugin.getServer().getPlayer(args[1]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Could not find player.");
            return true;
        }
        PlayerData targetData = this.plugin.getPlayerData(target);
        sender.sendMessage(targetData.isLunarClient() ? ChatColor.GREEN + target.getName() + " is using Lunar Client." : ChatColor.RED + target.getName() + " is not using Lunar Client.");
        return true;
    }
}
