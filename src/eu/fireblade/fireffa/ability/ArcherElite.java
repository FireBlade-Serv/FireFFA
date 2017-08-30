package eu.fireblade.fireffa.ability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;

public class ArcherElite implements Listener {
	
	public static Map<Player, Integer> tasks = new HashMap<Player, Integer>();
	public static ArrayList<Player> inLoad = new ArrayList<Player>();
	
	@EventHandler
	public void onInteract(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack item = e.getItem();
		
		if(item.equals(Kits.ItemGen1(Material.BOW, Enchantment.ARROW_INFINITE, 1, ChatColor.DARK_GREEN+"Arc mitrailleur", 
				Kits.LoreCreator(ChatColor.BLUE+"N'a pas besoin d'être chargé", ChatColor.BLUE+"Pas de limite d'utilisation"), 1))) {
			
			if(Var.archerélite.contains(p)) {
				p.launchProjectile(Arrow.class);
			}
		}
	}

	@EventHandler
	public void onHitArrow(EntityDamageByEntityEvent e) {
		final Entity entity = e.getEntity();
		final Entity damager = e.getDamager();
		
		if(damager instanceof Arrow) {
			Arrow ar = (Arrow) entity;
			
			if(ar.getShooter() instanceof Player) {
				Player p = (Player) ar.getShooter();
				
				if(Var.archerélite.contains(p)) {
					ar.setCritical(false);
					
					ar.setKnockbackStrength(0);
					
					e.setDamage(1.0d);
				}
			}
		}
	}
}