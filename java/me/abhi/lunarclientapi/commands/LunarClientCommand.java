package me.abhi.lunarclientapi.commands;

import me.abhi.lunarclientapi.LunarClientAPI;
import me.abhi.lunarclientapi.commands.subcommands.LunarClientCheckSubCommand;
import me.abhi.lunarclientapi.commands.subcommands.LunarClientUsersSubCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LunarClientCommand implements CommandExecutor {

    private LunarClientAPI plugin;
    private LunarClientUsersSubCommand lunarClientUsersSubCommand;
    private LunarClientCheckSubCommand lunarClientCheckSubCommand;

    public LunarClientCommand(LunarClientAPI plugin) {
        this.plugin = plugin;
        lunarClientUsersSubCommand = new LunarClientUsersSubCommand(this.plugin);
        lunarClientCheckSubCommand = new LunarClientCheckSubCommand(this.plugin);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!sender.hasPermission("lunarclientapi.command")) {
            sender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <users:check:feed>");
            return true;
        }
        if (args[0].equalsIgnoreCase("users")) {
            lunarClientUsersSubCommand.onCommand(sender, cmd, commandLabel, args);
            return true;
        } else if (args[0].equalsIgnoreCase("check")) {
            lunarClientCheckSubCommand.onCommand(sender, cmd, commandLabel, args);
        } else {
            sender.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <users:check:feed>");
        }
        return true;
    }
}
