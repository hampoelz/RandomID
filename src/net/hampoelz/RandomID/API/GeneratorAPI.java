package net.hampoelz.RandomID.API;

import java.util.Random;
import java.util.UUID;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.hampoelz.RandomID.Configs.Config;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent.Action;

public class GeneratorAPI
{
	public static boolean isInteger(String s)
	{
	    try
	    { 
	        Integer.parseInt(s); 
	    }
	    catch(NumberFormatException e)
	    { 
	        return false; 
	    }
	    catch(NullPointerException e)
	    {
	        return false;
	    }

	    return true;
	}
	
	public static String IDGenerator(int length, String SALTCHARS)
	{
		if (SALTCHARS == null)
		{
			SALTCHARS = Config.getSettingsIDchars();
		}
		
        StringBuilder salt = new StringBuilder();
        
        Random rnd = new Random();
        
        if (length == 0)
        {
        	length = Config.getSettingsIDlength();
        }
        
        while (salt.length() < length)
        {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        
		return salt.toString();
    }
	
	public static String UUIDGenerator()
	{
        String uuid = UUID.randomUUID().toString();
        
        return uuid;
    }
	
	public static void SendMSGPlayer(Player p, String Content, String Name, String Info, String Hover)
	{
		TextComponent line1 = new TextComponent();
		line1.setText(ChatColor.translateAlternateColorCodes('&', Name));
		line1.setColor(ChatColor.BLUE);
		line1.setBold(true);
		
        TextComponent line1_id = new TextComponent();
        line1_id.setText(ChatColor.translateAlternateColorCodes('&', Content));
        line1_id.setColor(ChatColor.GOLD);
        line1_id.setBold(true);
        line1_id.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, Content));
        line1_id.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', "&a&l" + Hover)).create())); 
        
        line1.addExtra(line1_id);
        
        p.sendMessage("");
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&l-----------------------------------------"));
		p.spigot().sendMessage(line1);
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&l" + Info));
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&l-----------------------------------------"));
		p.sendMessage("");
	}
	
	public static void SendMSGConsole(CommandSender sender, String Content, String Name, String Info)
	{
		sender.sendMessage("");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&l-----------------------------------------"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&l" + Name + "&6&l" + Content));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&l" + Info));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&l-----------------------------------------"));
        sender.sendMessage("");
	}
}
