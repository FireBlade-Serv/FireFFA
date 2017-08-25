package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Ours implements Listener {
	
	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onInteract(PlayerInteractAtPlayerEvent e) {
		final Player p = e.getPlayer();
		final Player target = e.getTarget();
		final ItemStack item = e.getItemInHand();
		
		if(item.equals(Kits.ItemGen(Material.WOOD_PICKAXE, ChatColor.DARK_GRAY+"Crocs de l'ours", 
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Vole 2 coeurs à la cible", ChatColor.BLUE+"1 minute de récupération"), 1))) {
			
			if(Var.ours.contains(p)) {
				if(cooldown.contains(p)) {
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
					
					return;
				}else {
					damage(p, target);
					
					cooldown.add(p);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							if(Var.ours.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre attaque est prête !", 20, 30, 20);
								gt.send();
								
								p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
							}
							
							if(cooldown.contains(p)) {
								cooldown.remove(p);
							}
						}
						
					}, 1200L);
				}
			}
		}
	}
	
	private static void damage(Player p, Player target) {
		target.sendMessage("§6[§eFireFFA§6] Un ours vous a attaqué !");
		target.playSound(target.getLocation(), Sound.WOLF_GROWL, 30, 30);
		p.playSound(p.getLocation(), Sound.WOLF_GROWL, 30, 30);
		
		if(target.getHealth() <= 4) {
			target.setHealth(0.0d);
		}else {
			target.setHealth(target.getHealth() - 4);
		}
		
		if(p.getHealth() >= 16) {
			p.setHealth(p.getMaxHealth());
		}else {
			p.setHealth(p.getHealth() + 4);
		}
	}
}
