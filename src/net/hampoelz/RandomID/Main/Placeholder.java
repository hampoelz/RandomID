package net.hampoelz.RandomID.Main;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.external.EZPlaceholderHook;
import net.hampoelz.RandomID.API.GeneratorAPI;
import net.hampoelz.RandomID.Configs.Config;
import net.hampoelz.RandomID.Configs.PersonalID;
import net.md_5.bungee.api.ChatColor;

@SuppressWarnings("deprecation")
public class Placeholder extends EZPlaceholderHook
{
	@SuppressWarnings("unused")
	private Main ourPlugin;
	
	public Placeholder(Main ourPlugin)
	{
		super(ourPlugin, "RandomID");
		this.ourPlugin = ourPlugin;
	}
	
	@Override
	public String onPlaceholderRequest(Player p, String identifier)
	{ 	
		int length = 0;
		OfflinePlayer op = null;
		
		String[] parts = identifier.split("-");
		
		if (parts.length == 2 || parts.length == 3)
		{
			op = Bukkit.getOfflinePlayer(parts[1]);
			
			if (GeneratorAPI.isInteger(parts[1]))
			{
				length = Integer.valueOf(parts[1]);
			}
		}
		
		if (identifier.equals("personal_id"))
		{
			if (Config.getPersonalIDUse())
			{
				if (PersonalID.getPlayerID(p.getUniqueId()) != null)
				{
					return PersonalID.getPlayerID(p.getUniqueId());
				}
				else
				{
					p.kickPlayer(ChatColor.translateAlternateColorCodes('&', Config.getPersonalIDMessagesNoIDKick()));
				}
			}
			
			return null;
		}
		
		if (identifier.equals("personal_id-msg"))
		{
			if (Config.getPersonalIDUse())
			{
				if (PersonalID.getPlayerID(p.getUniqueId()) != null)
				{
					GeneratorAPI.SendMSGPlayer(p, PersonalID.getPlayerID(p.getUniqueId()), Config.getPersonalIDMessagesOwnIDName(), Config.getPersonalIDMessagesOwnIDInfo(), "Click to copy your ID in your chat");
					
					return PersonalID.getPlayerID(p.getUniqueId());
				}
				else
				{
					p.kickPlayer(ChatColor.translateAlternateColorCodes('&', Config.getPersonalIDMessagesNoIDKick()));
				}
			}
			
			return null;
		}
		
		if (identifier.equals("personal_id-" + op.getName()))
		{
			if (Config.getPersonalIDUse())
			{
				if (PersonalID.getPlayerID(op.getUniqueId()) != null)
				{
					return PersonalID.getPlayerID(op.getUniqueId());
				}
				else
				{
					return " ";
				}
			}
			
			return null;
		}
		
		if (identifier.equals("personal_id-" + op.getName() + "-msg"))
		{
			if (Config.getPersonalIDUse())
			{
				if (PersonalID.getPlayerID(op.getUniqueId()) != null)
				{
					GeneratorAPI.SendMSGPlayer(p, PersonalID.getPlayerID(op.getUniqueId()), Config.getPersonalIDMessagesPlayerIDName().replace("%player%", op.getName()), Config.getPersonalIDMessagesPlayerIDInfo().replace("%player%", op.getName()), "Click to copy " + op.getName() + "'s ID in your chat");
					
					return PersonalID.getPlayerID(op.getUniqueId());
				}
				else
				{
					return " ";
				}
			}
			
			return null;
		}
		
		if (identifier.equals("player_uuid"))
		{		
			if (p != null)
			{
				String UUID = p.getUniqueId().toString();
				
				return UUID;
			}
			
			return null;
		}
		
		if (identifier.equals("player_uuid-msg"))
		{
			String UUID = p.getUniqueId().toString();
			
			if (p != null)
			{
				GeneratorAPI.SendMSGPlayer(p, UUID, Config.getMessagesOwnUUIDName(), Config.getMessagesOwnUUIDInfo(), "Click to copy your UUID in your chat");
			}
			
			return UUID;
		}
		
		if (identifier.equals("player_uuid-" + op.getName()))
		{
			String UUID = op.getUniqueId().toString();

			return UUID;
		}
		
		if (identifier.equals("player_uuid-" + op.getName() + "-msg"))
		{
			String UUID = op.getUniqueId().toString();
			
	        GeneratorAPI.SendMSGPlayer(p, UUID, Config.getMessagesPlayerUUIDName().replace("%player%", op.getName()), Config.getMessagesPlayerUUIDInfo().replace("%player%", op.getName()), "Click to copy " + op.getName() + "'s UUID in your chat");
			
			return UUID;
		}
		
		if (identifier.equals("id"))
		{	
			String ID = GeneratorAPI.IDGenerator(Config.getSettingsIDlength(), Config.getSettingsIDchars());
			
			return ID;
		}
		
		if (identifier.equals("id-msg"))
		{
			String ID = GeneratorAPI.IDGenerator(Config.getSettingsIDlength(), Config.getSettingsIDchars());
			
			if (p != null)
			{
				GeneratorAPI.SendMSGPlayer(p, ID, Config.getMessagesRandomIDName(), Config.getMessagesRandomIDInfo(), "Click to copy this ID in your chat");
			}
			
			return ID;
		}
		
		if (identifier.equals("id-" + length))
		{
			String ID = GeneratorAPI.IDGenerator(length, Config.getSettingsIDchars());
			
			return ID;
		}
		
		if (identifier.equals("id-" + length + "-msg"))
		{
			String ID = GeneratorAPI.IDGenerator(length, Config.getSettingsIDchars());
			
			if (p != null)
			{
				GeneratorAPI.SendMSGPlayer(p, ID, Config.getMessagesRandomIDName(), Config.getMessagesRandomIDInfo(), "Click to copy this ID in your chat");
			}
			
			return ID;
		}
		
		if (identifier.equals("uuid"))
		{	
			String UUID = GeneratorAPI.UUIDGenerator();
					
			return UUID;
		}
		
		if (identifier.equals("uuid-msg"))
		{
			String UUID = GeneratorAPI.UUIDGenerator();
			
			if (p != null)
			{
				GeneratorAPI.SendMSGPlayer(p, UUID, Config.getMessagesRandomUUIDName(), Config.getMessagesRandomUUIDInfo(), "Click to copy this UUID in your chat");
			}
			
			return UUID;	
		}
		
		return null;
	}
}
