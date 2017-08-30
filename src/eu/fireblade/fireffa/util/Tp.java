package eu.fireblade.fireffa.util;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import eu.fireblade.fireffa.Var;

public class Tp {
	
	public static void tpSpawn(Player p){
		p.teleport(new Location(p.getWorld(), 80, 114.5, -47.5, -90, 0));
	}

	public static void loadSpawnPoint() {
		Var.spawn.add(new Location(Bukkit.getWorld("World"), 94.5, 93, -79.5, -1, 0));
		Var.spawn.add(new Location(Bukkit.getWorld("World"), 100, 75, 2, 140, 0));
		Var.spawn.add(new Location(Bukkit.getWorld("World"), 38.5, 65, -118.5, 13, 0));
		Var.spawn.add(new Location(Bukkit.getWorld("World"), 7.5, 66, 51.5, 98, -6));
		Var.spawn.add(new Location(Bukkit.getWorld("World"), -110, 66, 39.5, -90, -5));
		Var.spawn.add(new Location(Bukkit.getWorld("World"), -110, 66, 39.5, -90, -5));
	}
	
	public static void randomtp(Player p) {
		Random r = new Random();
		int n = r.nextInt(6);
		
		if(n == 0) {
			p.teleport(Var.spawn.get(0));
		}else {
			p.teleport(Var.spawn.get(n - 1));
		}
	}
}
