package eu.fireblade.fireffa;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import eu.fireblade.fireffa.util.Tp;


public class Main extends JavaPlugin{
	
	public static Plugin plugin;
	
	@Override
	public void onEnable() {
		getLogger().info("FireFFA ON");
		getLogger().info("Plugin by Glowstoner ,_goldocelot_ & baptistego!");
		
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.cmd.GUI(), this);
		getServer().getPluginManager().registerEvents(new Events(), this);
		
		getCommand("kit").setExecutor(new eu.fireblade.fireffa.cmd.GUI());
		getCommand("tkit").setExecutor(new eu.fireblade.fireffa.cmd.TestKit());
		
		Tp.loadSpawnPoint();
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		Var.host = Main.plugin.getConfig().getString("sqlhost");
		Var.user = Main.plugin.getConfig().getString("sqluser");
		Var.password = Main.plugin.getConfig().getString("sqlpassword");
		
		Bukkit.broadcastMessage("test sql config => "+Var.host+" - "+Var.user+" - "+Var.password+".");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("FireFFA OFF");
	}

}
