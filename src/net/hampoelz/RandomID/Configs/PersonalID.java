package net.hampoelz.RandomID.Configs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PersonalID
{
	public static File PersonalIDFile = new File("plugins/RandomID", "PersonalID.yml");
	public static FileConfiguration PersonalID = YamlConfiguration.loadConfiguration(PersonalIDFile);
	
	//----------------------------------------------------------------------------------------------------------------------\\
	
	public static void save() throws IOException
	{
		PersonalID.save(PersonalIDFile);
	}
	  
	public static void load() throws FileNotFoundException, IOException, InvalidConfigurationException
	{
		PersonalID.load(PersonalIDFile);
	}
	
	//----------------------------------------------------------------------------------------------------------------------\\
	
	public static void setPlayerID(UUID uuid, String id) throws IOException
	{
		PersonalID.set(uuid.toString(), id);
	    save();
	}
	
	//----------------------------------------------------------------------------------------------------------------------\\
	
	public static String getPlayerID(UUID uuid)
	{		
	    return PersonalID.getString(uuid.toString());
	}
}
