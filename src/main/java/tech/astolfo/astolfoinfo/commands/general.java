package tech.astolfo.astolfoinfo.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.MessageFormat;
import java.util.Date;

public class general implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player user;
        long first;
        long current;
        Date firstdate;
        int mins;

        switch (args.length) {
            case 0:
                if (!(sender instanceof Player)) {
                    sender.sendMessage("You must be a player to execute that command!");
                    break;
                }
                user = (Player) sender;
                String name = user.getName();
                first = user.getFirstPlayed();
                current = user.getLastPlayed();
                firstdate = new Date(first);
                mins = Math.toIntExact((System.currentTimeMillis() - current) / 60000);
                if (Math.toIntExact(System.currentTimeMillis()/60000) == mins) mins = 0;
                sender.sendMessage(MessageFormat.format("{0}{1}''s General Stats\n{2}First Join: {3}{4} EDT\n{5}Playtime: {6}{7} minutes", ChatColor.BOLD, name, ChatColor.WHITE, ChatColor.GREEN, firstdate, ChatColor.WHITE, ChatColor.GREEN, mins));
                break;

            case 1:
                String playerName;
                playerName = args[0];
                user = Bukkit.getPlayer(playerName);
                if (user == null) {
                    sender.sendMessage(MessageFormat.format("{0}{1}{2} is not currently online!", ChatColor.GREEN, playerName, ChatColor.WHITE));
                    break;
                }
                first = user.getFirstPlayed();
                current = user.getLastPlayed();
                firstdate = new Date(first);
                mins = Math.toIntExact((System.currentTimeMillis() - current) / 60000);
                if (Math.toIntExact(System.currentTimeMillis()/60000) == mins) mins = 0;
                sender.sendMessage(MessageFormat.format("{0}{1}''s General Stats\n{2}First Join: {3}{4} EDT\n{5}Playtime: {6}{7} minutes", ChatColor.BOLD, playerName, ChatColor.WHITE, ChatColor.GREEN, firstdate, ChatColor.WHITE, ChatColor.GREEN, mins));
                break;
            default:
                return false;
        }
        return true;
    }
}
