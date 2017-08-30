package eu.fireblade.fireffa.ability;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerKillEvent;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;

public class Boucher implements Listener {
	
	@EventHandler
	public void onInteract(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack item = e.getItem();
		
		if(!Var.boucher.contains(p)) {
			return;
		}
		
		if(item.equals(Kits.ItemGen(Material.RAW_BEEF, ChatColor.DARK_RED+"Viande saignante", 
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Régénère 1 §c❤", ChatColor.BLUE+"1 utilisation"), 1))) {
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

				@Override
				public void run() {
					p.getInventory().removeItem(Kits.ItemGen(Material.RAW_BEEF, ChatColor.DARK_RED+"Viande saignante", 
							Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Régénère 1 §c❤", ChatColor.BLUE+"1 utilisation"), 1));
					
					p.playSound(p.getEyeLocation(), Sound.COW_HURT, 30, 30);
					
					if(p.getHealth() >= 18) {
						p.setHealth(p.getMaxHealth());
					}else {
						p.setHealth(p.getHealth() + 2);
					}
				}		
			});
			
		}else if(item.equals(Kits.ItemGen(Material.MUTTON, ChatColor.DARK_RED+"Viande fraiche", 
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Régénère 2 §c❤", ChatColor.BLUE+"1 utilisation"), 1))) {
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

				@Override
				public void run() {
					p.getInventory().removeItem(Kits.ItemGen(Material.MUTTON, ChatColor.DARK_RED+"Viande fraiche", 
							Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Régénère 2 §c❤", ChatColor.BLUE+"1 utilisation"), 1));
					
					p.playSound(p.getEyeLocation(), Sound.PIG_DEATH, 30, 30);
					
					if(p.getHealth() >= 16) {
						p.setHealth(p.getMaxHealth());
					}else {
						p.setHealth(p.getHealth() + 4);
					}
				}
			});
		}
	}

	@EventHandler
	public void onKill(PlayerKillEvent e) {
		final Player p = e.getPlayer();
		final Player killer = e.getKiller();
		final World w = e.getWorld();
		
		if(Var.boucher.contains(killer)) {
			
			for(int i = 0 ; i <= 20 ; i++) {
				w.playEffect(p.getEyeLocation(), Effect.COLOURED_DUST, 1);
			}
		}
	}
}
