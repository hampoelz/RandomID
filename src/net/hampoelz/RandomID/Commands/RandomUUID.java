package net.hampoelz.RandomID.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.hampoelz.RandomID.API.GeneratorAPI;
import net.hampoelz.RandomID.Configs.Config;
import net.md_5.bungee.api.ChatColor;

public class RandomUUID implements CommandExecutor
{	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (sender instanceof ConsoleCommandSender)
		{
			if (args.length == 0)
			{
				GeneratorAPI.SendMSGConsole(sender, GeneratorAPI.UUIDGenerator(), Config.getMessagesRandomUUIDName(), Config.getMessagesRandomUUIDInfo());
			}
			else
			{				
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Usage: &crandomuuid"));
			}
	    }
		
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			
			if (args.length == 0)
			{
				if (p.hasPermission("RandomID.UUID.random"))
				{
					GeneratorAPI.SendMSGPlayer(p, GeneratorAPI.UUIDGenerator(), Config.getMessagesRandomUUIDName(), Config.getMessagesRandomUUIDInfo(), "Click to copy this UUID in your chat");
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
