package net.hampoelz.RandomID.Commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import net.hampoelz.RandomID.API.GeneratorAPI;
import net.hampoelz.RandomID.Configs.Config;
import net.hampoelz.RandomID.Configs.PersonalID;
import net.md_5.bungee.api.ChatColor;

public class RandomID implements CommandExecutor
{	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (sender instanceof ConsoleCommandSender)
		{
			if (args.length == 0)
			{
				GeneratorAPI.SendMSGConsole(sender, GeneratorAPI.IDGenerator(Config.getSettingsIDlength(), Config.getSettingsIDchars()), Config.getMessagesRandomIDName(), Config.getMessagesRandomIDInfo());
			}
			else if (args.length == 1)
			{
				if (GeneratorAPI.isInteger(args[0]))
				{
					GeneratorAPI.SendMSGConsole(sender, GeneratorAPI.IDGenerator(Integer.valueOf(args[0]), Config.getSettingsIDchars()), Config.getMessagesRandomIDName(), Config.getMessagesRandomIDInfo());
				}
				else if (args[0].equalsIgnoreCase("reload"))
				{
					try
					{
						Config.load();
						
						if (Config.getPersonalIDUse())
						{
							try
				    		{
				    			PersonalID.save();
				    		}
				    		catch (IOException e)
				    		{
				    			e.printStackTrace();
				    		}
							
							PersonalID.load();
						}				
						
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aThe config was successfully reloaded"));
					}
					catch (IOException | InvalidConfigurationException e)
					{
						e.printStackTrace();
						
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cAn error occurred while reloading the configuration"));
					}
				}
				else
				{
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Usage: &crandomid [length / reload]"));
				}
			}
			else
			{				
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Usage: &crandomid [length / reload]"));
			}
	    }
		
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			
			if (args.length == 0)
			{
				if (p.hasPermission("RandomID.ID.random"))
				{
					GeneratorAPI.SendMSGPlayer(p, GeneratorAPI.IDGenerator(Config.getSettingsIDlength(), Config.getSettingsIDchars()), Config.getMessagesRandomIDName(), Config.getMessagesRandomIDInfo(), "Click to copy this ID in your chat");
				}
				else
				{
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getMessagesNoPermissions()));
				}
			}
			else if (args.length == 1)
			{
				if (GeneratorAPI.isInteger(args[0]))
				{
					if (p.hasPermission("RandomID.ID.random"))
					{
						GeneratorAPI.SendMSGPlayer(p, GeneratorAPI.IDGenerator(Integer.valueOf(args[0]), Config.getSettingsIDchars()), Config.getMessagesRandomIDName(), Config.getMessagesRandomIDInfo(), "Click to copy this ID in your chat");
					}
					else
					{
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getMessagesNoPermissions()));
					}
				}
				else if (args[0].equalsIgnoreCase("reload"))
				{
					if (p.hasPermission("RandomID.reload"))
					{
						try
						{
							Config.load();
							
							if (Config.getPersonalIDUse())
							{
								try
					    		{
					    			PersonalID.save();
					    		}
					    		catch (IOException e)
					    		{
					    			e.printStackTrace();
					    		}
								
								PersonalID.load();
							}
							
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6RandomID&8] &aThe config was successfully reloaded"));
						}
						catch (IOException | InvalidConfigurationException e)
						{
							e.printStackTrace();
							
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6RandomID&8] &cAn error occurred while reloading the configuration"));
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
			else
			{				
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getMessagesUsage()));
			}
		}
		
		return true;
	}
}
