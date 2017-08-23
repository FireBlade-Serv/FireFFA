package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;

public class GuerrierGalactique implements Listener {
	
	private static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onInteract(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack item = e.getItem();
		
		if(item.equals(Kits.ItemGen(Material.GOLD_NUGGET, ChatColor.AQUA+"Pouvoir du guerrier galactique", 
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Boule de feu", ChatColor.BLUE+"20 secondes de récupération"), 1))){
			
			
		}
	}

}
