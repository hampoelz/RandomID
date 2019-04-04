package net.hampoelz.RandomID.Main;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.hampoelz.RandomID.Commands.ID;
import net.hampoelz.RandomID.Commands.RandomID;
import net.hampoelz.RandomID.Commands.RandomUUID;
import net.hampoelz.RandomID.Commands.UUID;
import net.hampoelz.RandomID.Configs.Config;
import net.hampoelz.RandomID.Configs.PersonalID;
import net.hampoelz.RandomID.Events.JoinEvent;

public class Main extends JavaPlugin
{
	static Main instance;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable()
	{			   
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI"))
        {
        	new Placeholder(this).hook();
        }
        
        try
		{
			Config.setConfig();
			Config.save();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
        
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
        }
        
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        
        getCommands();
        
        instance = this;
        
		System.out.println("[RandomID] v" + getDescription().getVersion() + " enabled!");
	}

	public static Main getInstance()
	{
		return instance;
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("[RandomID] v" + getDescription().getVersion() + " disabled!");
	}
	
	private void getCommands()
	{
		getCommand("id").setExecutor(new ID());
		getCommand("personalid").setExecutor(new ID());
		getCommand("myid").setExecutor(new ID());
		
		getCommand("uuid").setExecutor(new UUID());
		getCommand("randomid").setExecutor(new RandomID());
		getCommand("randomuuid").setExecutor(new RandomUUID());
	}
}
