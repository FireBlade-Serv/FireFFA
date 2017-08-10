package eu.fireblade.fireffa;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static Plugin plugin;
	
	@Override
	public void onEnable() {
		getLogger().info("FireFFA ON");
		
		getServer().getPluginManager().registerEvents(new Events(), this);
	}
	
	@Override
	public void onDisable() {
		getLogger().info("FireFFA OFF");
	}

}
