package eu.fireblade.fireffa;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	
	public static Plugin plugin;
	
	@Override
	public void onEnable() {
		getLogger().info("FireFFA ON");
		getLogger().info("Plugin by Glowstoner & _goldocelot_ !");
		
		getServer().getPluginManager().registerEvents(new Events(), this);
		
		getCommand("kit").setExecutor(new eu.fireblade.fireffa.cmd.Kit());
		
		eu.fireblade.fireffa.util.Tp.loadSpawnPoint();
	}
	
	@Override
	public void onDisable() {
		getLogger().info("FireFFA OFF");
	}

}
