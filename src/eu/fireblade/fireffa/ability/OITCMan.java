package eu.fireblade.fireffa.ability;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerKillEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class OITCMan implements Listener {
	
	@EventHandler
	public void onKill(PlayerKillEvent e){
		final Player killer = e.getKiller();
		
		if(Var.OITCman.contains(killer)){
			GlowstoneTitle gt = new GlowstoneTitle(killer, "", "+ 1 flèche", 10, 30, 10);
			gt.send();
			
			killer.getInventory().addItem(Kits.ItemGen(Material.ARROW, ChatColor.RED+"OITC arrow", null, 1));
			
			killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 30, 30);
		}
	}

}
