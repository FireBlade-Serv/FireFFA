package eu.fireblade.fireffa.ability;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;


public class Piaf implements Listener {

	public static void onDamage(EntityDamageEvent e) {
		Entity ep = e.getEntity();
		DamageCause dc = e.getCause();
		
		if(ep instanceof Player) {
			Player p = (Player) ep;
			if(Var.piaf.contains(p) && dc.equals(DamageCause.FALL)) {
				e.setCancelled(true);
			}		
		}		
	}	
	
	public static void onRightClick(PlayerRightClickInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack i = e.getItem();
		
		if (Var.piaf.contains(p) && i.equals(Kits.ItemGen(Material.FEATHER, ChatColor.GRAY+"Vol",
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Propulse en hauteur", ChatColor.BLUE+"Utilisable 25 fois"), 25))) {
			if(p.getInventory().containsAtLeast(Kits.ItemGen(Material.FEATHER, ChatColor.GRAY+"Vol",
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Propulse en hauteur", ChatColor.BLUE+"Utilisable 25 fois"), 1), 1)) {
				p.getInventory().removeItem(Kits.ItemGen(Material.FEATHER, ChatColor.GRAY+"Vol",
						Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Propulse en hauteur", ChatColor.BLUE+"Utilisable 25 fois"), 1));
				p.setVelocity(new Vector(0, 1, 0));
			}else {
				p.sendMessage(ChatColor.GOLD+"�6[�eFireFFA�6] "+ChatColor.RED+"Vous n'avez plus d'aile !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
				return;
			}
		}
	}
}
