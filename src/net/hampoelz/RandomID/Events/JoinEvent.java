package net.hampoelz.RandomID.Events;

import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.hampoelz.RandomID.API.GeneratorAPI;
import net.hampoelz.RandomID.Configs.Config;
import net.hampoelz.RandomID.Configs.PersonalID;

public class JoinEvent implements Listener
{
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) throws IOException, InvalidConfigurationException
	{
		if (Config.getPersonalIDUse())
		{
			PersonalID.setPlayerID(event.getPlayer().getUniqueId(), GeneratorAPI.IDGenerator(Config.getPersonalIDSettingsIDlength(), Config.getPersonalIDSettingsIDchars()));
		}
	}
}
