package eu.fireblade.fireffa;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import eu.fireblade.fireffa.util.Methods;
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
		
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.Play(), this);
		
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Démolisseur(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Fantôme(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Flic(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Magicien(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.VoleurÂmes(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.OITCMan(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Grampa(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Djihadiste(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Gameur(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Sauvage(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.ArcherElementaire(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Ocelot(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.ArcherElite(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.PandaRoux(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.DevDePacotille(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Patissier(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Ours(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Ogre(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Timer(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.GuerrierGalactique(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Enderman(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Domination(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Power(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Fiesta(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Enclumex(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Bouftout(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Boucher(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Golem(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.RedMan(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Furicat(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Pharaon(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Copy(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Rulio(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Swap(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Mathématicien(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Pyro(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Glowstone(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Gandalf(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Invocation(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.RobinDesBois(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Moutarde(), this);
		getServer().getPluginManager().registerEvents(new eu.fireblade.fireffa.ability.Nuage(), this);
		
		
		for (Player online : Bukkit.getOnlinePlayers()){
			Var.killStreak.put(online, 0);
		}
		
		Tp.loadSpawnPoint();
		
		saveDefaultConfig();
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		Methods.getConfig();
	}
	
	@Override
	public void onDisable() {
		getLogger().info("FireFFA OFF");
		
		plugin = null;
	}

}
