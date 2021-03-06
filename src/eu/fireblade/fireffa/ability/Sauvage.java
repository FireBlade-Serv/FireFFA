package eu.fireblade.fireffa.ability;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import net.md_5.bungee.api.ChatColor;

public class Sauvage implements Listener {
	
	@EventHandler
	public void onInteract(PlayerRightClickInteractEvent e){
		final Player p = e.getPlayer();
		final ItemStack item = e.getItem();

		if(item.equals(Kits.ItemGen(Material.GRILLED_PORK, ChatColor.DARK_PURPLE+"Nourriture charnue", 
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - R�g�ne 3 coeurs", ChatColor.BLUE+"1 utilisation"), 1))){
			
			if(Var.sauvage.contains(p)){
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

					@Override
					public void run() {
						p.getInventory().removeItem(Kits.ItemGen(Material.GRILLED_PORK, ChatColor.DARK_PURPLE+"Nourriture charnue", 
								Kits.LoreCreator(ChatColor.BLUE+"Clique droit - R�g�ne 3 coeurs", ChatColor.BLUE+"1 utilisation"), 1));
						
						p.playSound(p.getLocation(), Sound.BURP, 30, 30);
						
						if(p.getHealth() >= 14){
							p.setHealth(p.getMaxHealth());
						}else{
							p.setHealth(p.getHealth() + 6);
						}
					}
					
				});
			}
		}
	}

}
