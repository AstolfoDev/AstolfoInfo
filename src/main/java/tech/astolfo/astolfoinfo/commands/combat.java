package tech.astolfo.astolfoinfo.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class combat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player user;
        int pvp;
        int pve;
        int deaths;
        switch (args.length) {
            case 0:
                if (!(sender instanceof Player)) {
                    sender.sendMessage("You must be a player to execute that command!");
                    break;
                }
                user = (Player) sender;
                String name = user.getName();
                pvp = user.getStatistic(Statistic.valueOf("PLAYER_KILLS"));
                pve = user.getStatistic(Statistic.valueOf("MOB_KILLS"));
                deaths = user.getStatistic(Statistic.valueOf("DEATHS"));
                sender.sendMessage(ChatColor.BOLD + name + "'s Combat Stats\n" + ChatColor.WHITE + "Player Kills: " + ChatColor.GREEN + pvp + "\n" + ChatColor.WHITE + "Mob Kills: " + ChatColor.GREEN + pve + "\n" + ChatColor.WHITE + "Deaths: " + ChatColor.RED + deaths);
                break;
            case 1:
                String playerName = args[0];
                user = Bukkit.getPlayer(playerName);
                if (user == null) {
                    sender.sendMessage(ChatColor.GREEN+playerName+ChatColor.WHITE+" is not currently online!");
                    break;
                }
                pvp = user.getStatistic(Statistic.valueOf("PLAYER_KILLS"));
                pve = user.getStatistic(Statistic.valueOf("MOB_KILLS"));
                deaths = user.getStatistic(Statistic.valueOf("DEATHS"));
                sender.sendMessage(ChatColor.BOLD + playerName + "'s Combat Stats\n" + ChatColor.WHITE + "Player Kills: " + ChatColor.GREEN + pvp + "\n" + ChatColor.WHITE + "Mob Kills: " + ChatColor.GREEN + pve + "\n" + ChatColor.WHITE + "Deaths: " + ChatColor.RED + deaths);
                break;

            default:
                return false;
        }
        return true;
    }
}
