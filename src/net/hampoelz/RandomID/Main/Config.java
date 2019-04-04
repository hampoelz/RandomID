package net.hampoelz.RandomID.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config
{

	public static File ConfigFile = new File("plugins/RandomID", "config.yml");
	public static FileConfiguration Config = YamlConfiguration.loadConfiguration(ConfigFile);
	
	//----------------------------------------------------------------------------------------------------------------------\\
	
	public static void save() throws IOException
	{
		Config.save(ConfigFile);
	}
	
	public static void load() throws FileNotFoundException, IOException, InvalidConfigurationException
	{
		Config.load(ConfigFile);
	}
	
	private static void setConfigContent(int ConfigVersion) throws IOException
	{
		Config.set("config.ConfigVersion", ConfigVersion);
		
		Config.set("config.Messages.No Permissions", "&8[&6RandomID&8] &cYou not have permission to perform this command.");
		Config.set("config.Messages.Usage", "&8[&6RandomID&8] &7Usages:\n &c/uuid [player]\n &c/randomuuid\n &c/randomid [length / reload]");
		Config.set("config.Messages.Player not exist", "&8[&6RandomID&8] &cApparently, the specified player does not exist.");
		Config.set("config.Messages.Random ID.Name", "Random ID: ");
		Config.set("config.Messages.Random ID.Info", "&5&lThis is a randomly generated ID");
		Config.set("config.Messages.Random UUID.Name", "Random UUID: ");
		Config.set("config.Messages.Random UUID.Info", "&5&lThis is a randomly generated UUID");
		Config.set("config.Messages.Own UUID.Name", "Your UUID: ");
		Config.set("config.Messages.Own UUID.Info", "&5&lThis is your UUID");
		Config.set("config.Messages.Player UUID.Name", "%player%'s UUID: ");
		Config.set("config.Messages.Player UUID.Info", "&5&lThis is %player%'s UUID");
		Config.set("config.Settings.ID chars", "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		Config.set("config.Settings.ID length", 9);
		
		Config.set("config.Personal ID.Use", false);
		Config.set("config.Personal ID.Messages.Personal ID.Name", "Your Personal ID: ");
		Config.set("config.Personal ID.Messages.Personal ID.Info", "&5&lThis is your Personal ID, you can use it for support, reports, etc.");
		Config.set("config.Personal ID.Settings.Generate new ID on Join", true);
		Config.set("config.Personal ID.Settings.Use MySQL", true);
		Config.set("config.Personal ID.Settings.ID chars", "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		Config.set("config.Personal ID.Settings.ID length", 9);
		
		save();
	}
	
	public static void setConfig() throws IOException
	{
		int ConfigVersion = 3;
		
		int Version = Config.getInt("config.ConfigVersion");
		
		if(!ConfigFile.exists())
		{		
			setConfigContent(ConfigVersion);
		}
		else if (Version != ConfigVersion)
		{	
			File ConfigFileBackup = new File("plugins/RandomID", "old config [v" + Version + "].yml");
			
			FileUtils.copyFile(ConfigFile, ConfigFileBackup);
			
			for (String key : Config.getKeys(false))
		    {
				Config.set(key, null);
		    }
				
		    save();
				
		    setConfigContent(ConfigVersion);
		}
	}
	
	//----------------------------------------------------------------------------------------------------------------------\\
	
	public static String getMessagesNoPermissions()
	{
		return Config.getString("config.Messages.No Permissions");
	}
	
	public static String getMessagesUsage()
	{
		return Config.getString("config.Messages.Usage");
	}
	
	public static String getMessagesPlayerNotExist()
	{
		return Config.getString("config.Messages.Player not exist");
	}
	
	public static String getMessagesRandomIDName()
	{
		return Config.getString("config.Messages.Random ID.Name");
	}
	
	public static String getMessagesRandomIDInfo()
	{
		return Config.getString("config.Messages.Random ID.Info");
	}
	
	public static String getMessagesRandomUUIDName()
	{
		return Config.getString("config.Messages.Random UUID.Name");
	}
	
	public static String getMessagesRandomUUIDInfo()
	{
		return Config.getString("config.Messages.Random UUID.Info");
	}
	
	public static String getMessagesOwnUUIDName()
	{
		return Config.getString("config.Messages.Own UUID.Name");
	}
	
	public static String getMessagesOwnUUIDInfo()
	{
		return Config.getString("config.Messages.Own UUID.Info");
	}
	
	public static String getMessagesPlayerUUIDName()
	{
		return Config.getString("config.Messages.Player UUID.Name");
	}
	
	public static String getMessagesPlayerUUIDInfo()
	{
		return Config.getString("config.Messages.Player UUID.Info");
	}
	
	public static String getSettingsIDchars()
	{
		return Config.getString("config.Settings.ID chars");
	}
	
	public static int getSettingsIDlength()
	{
		return Config.getInt("config.Settings.ID length");
	}
}
