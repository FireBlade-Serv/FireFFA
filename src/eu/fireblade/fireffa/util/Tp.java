package eu.fireblade.fireffa.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Tp {
	
	public static void tpSpawn(Player p){
		//tp Glowstoner 80 114 -47 90 180
		
		p.teleport(new Location(p.getWorld(), 80.5, 114, -46.5, -90, 0));
	}

}
