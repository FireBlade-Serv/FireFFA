package eu.fireblade.fireffa;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import eu.fireblade.fireffa.util.Config;
import eu.fireblade.fireffa.util.Tp;

public class Main extends JavaPlugin{
	
	public static Plugin plugin;
	
	@Override
	public void onEnable() {
		getLogger().info("FireFFA ON");
		getLogger().info("Plugin by Glowstoner ,_goldocelot_ & baptistego!");
		
		plugin = this;
		
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.cmd.GUI(), this);
		getServer().getPluginManager().registerEvents(new Events(), this);
		
		getCommand("kit").setExecutor(new eu.fireblade.fireffa.cmd.GUI());
		getCommand("tkit").setExecutor(new eu.fireblade.fireffa.cmd.TestKit());
		
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.D�molisseur(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Fant�me(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Flic(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Magicien(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Voleur�mes(), this);
		
		Tp.loadSpawnPoint();
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		Config.getConfig();
	}
	
	@Override
	public void onDisable() {
		getLogger().info("FireFFA OFF");
		
		plugin = null;
	}

}
