package net.hampoelz.RandomID.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.hampoelz.RandomID.API.GeneratorAPI;
import net.hampoelz.RandomID.Configs.Config;
import net.md_5.bungee.api.ChatColor;

public class UUID implements CommandExecutor
{	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (sender instanceof ConsoleCommandSender)
		{
			if (args.length == 1)
			{
				OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
				
				GeneratorAPI.SendMSGConsole(sender, op.getUniqueId().toString(), Config.getMessagesPlayerUUIDName().replace("%player%", op.getName()), Config.getMessagesPlayerUUIDInfo().replace("%player%", op.getName()));
			}
			else
			{				
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Usage: &cid <player>"));
			}
	    }
		
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			
			if (args.length == 0)
			{	
				if (p.hasPermission("RandomID.UUID.self"))
				{
					GeneratorAPI.SendMSGPlayer(p, p.getUniqueId().toString(), Config.getMessagesOwnUUIDName(), Config.getMessagesOwnUUIDInfo(), "Click to copy your UUID in your chat");
				}
				else
				{					
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getMessagesNoPermissions()));
				}
			}
			else if (args.length == 1)
			{			
				OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
				
				if (p.hasPermission("RandomID.UUID.other"))
				{						
					if (op == null)
			        {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getMessagesPlayerNotExist()));
			        }
					else if(op == p)
					{
						if (p.hasPermission("RandomID.UUID.self"))
						{
							GeneratorAPI.SendMSGPlayer(p, p.getUniqueId().toString(), Config.getMessagesOwnUUIDName(), Config.getMessagesOwnUUIDInfo(), "Click to copy your UUID in your chat");
						}
						else
						{							
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getMessagesNoPermissions()));
						}
					}
					else
					{
						GeneratorAPI.SendMSGPlayer(p, op.getUniqueId().toString(), Config.getMessagesPlayerUUIDName().replace("%player%", op.getName()), Config.getMessagesPlayerUUIDInfo().replace("%player%", op.getName()), "Click to copy " + op.getName() + "'s UUID in your chat");
					}
				}
				else
				{					
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getMessagesNoPermissions()));
				}
			}
			else
			{				
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getMessagesUsage()));
			}
		}
		
		return true;
	}
}
