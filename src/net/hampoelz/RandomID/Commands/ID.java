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
import net.hampoelz.RandomID.Configs.PersonalID;
import net.md_5.bungee.api.ChatColor;

public class ID implements CommandExecutor
{
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (Config.getPersonalIDUse())
		{
			if (sender instanceof ConsoleCommandSender)
			{
				if (args.length == 1)
				{					
					OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
					
					if (PersonalID.getPlayerID(op.getUniqueId()) != null)
					{
						GeneratorAPI.SendMSGConsole(sender, PersonalID.getPlayerID(op.getUniqueId()), Config.getPersonalIDMessagesPlayerIDName().replace("%player%", op.getName()), Config.getPersonalIDMessagesPlayerIDInfo().replace("%player%", op.getName()));
					}
					else
					{
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getPersonalIDMessagesNoIDPlayer()));
					}
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
					if (p.hasPermission("RandomID.PersonalID.self"))
					{
						if (PersonalID.getPlayerID(p.getUniqueId()) != null)
						{
							GeneratorAPI.SendMSGPlayer(p, PersonalID.getPlayerID(p.getUniqueId()), Config.getPersonalIDMessagesOwnIDName(), Config.getPersonalIDMessagesOwnIDInfo(), "Click to copy your ID in your chat");
						}
						else
						{
							p.kickPlayer(ChatColor.translateAlternateColorCodes('&', Config.getPersonalIDMessagesNoIDKick()));
						}
					}
					else
					{					
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getMessagesNoPermissions()));
					}
				}
				else if (args.length == 1)
				{			
					OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
					
					if (p.hasPermission("RandomID.PersonalID.other"))
					{						
						if (op == null)
				        {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getMessagesPlayerNotExist()));
				        }
						else if(op == p)
						{
							if (p.hasPermission("RandomID.PersonalID.self"))
							{
								if (PersonalID.getPlayerID(p.getUniqueId()) != null)
								{
									GeneratorAPI.SendMSGPlayer(p, PersonalID.getPlayerID(p.getUniqueId()), Config.getPersonalIDMessagesOwnIDName(), Config.getPersonalIDMessagesOwnIDInfo(), "Click to copy your ID in your chat");
								}
								else
								{
									p.kickPlayer(ChatColor.translateAlternateColorCodes('&', Config.getPersonalIDMessagesNoIDKick()));
								}
							}
							else
							{							
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getMessagesNoPermissions()));
							}
						}
						else
						{
							if (PersonalID.getPlayerID(op.getUniqueId()) != null)
							{
								GeneratorAPI.SendMSGPlayer(p, PersonalID.getPlayerID(op.getUniqueId()), Config.getPersonalIDMessagesPlayerIDName().replace("%player%", op.getName()), Config.getPersonalIDMessagesPlayerIDInfo().replace("%player%", op.getName()), "Click to copy " + op.getName() + "'s ID in your chat");
							}
							else
							{
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getPersonalIDMessagesNoIDPlayer()));
							}
						}
					}
					else
					{					
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getMessagesNoPermissions()));
					}
				}
				else
				{				
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getPersonalIDMessagesUsage()));
				}
			}
		}
		else
		{
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getMessagesModuleDisabled()));
		}
		
		return true;
	}
}
