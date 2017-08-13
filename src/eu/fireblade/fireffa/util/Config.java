package eu.fireblade.fireffa.util;

import org.bukkit.Bukkit;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;

public class Config {
	
	public static void getConfig(){
		Var.host = Main.plugin.getConfig().getString("sql-host");
		Var.user = Main.plugin.getConfig().getString("sql-user");
		Var.password = Main.plugin.getConfig().getString("sql-password");
		
		Bukkit.broadcastMessage("test sql config => "+Var.host+" - "+Var.user+" - "+Var.password+".");
	}

}
