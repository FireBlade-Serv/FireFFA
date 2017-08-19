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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Patissier implements Listener {
	
	private static ArrayList<Player> cooldown = new ArrayList<Player>(); 

	@EventHandler
	public void onInteract(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack item = e.getItem();
		
		if(item.equals(Kits.ItemGen(Material.COOKIE, ChatColor.LIGHT_PURPLE+"Cookie du patisser", 
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Régéne 2 coeurs + vitesse 2, 15 secondes", ChatColor.BLUE+"30 secondes de récupération"), 1))) {
			
			if(Var.patissier.contains(p)) {
				if(cooldown.contains(p)) {
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
					return;
				}else {
					if(p.getHealth() >= 16) {
						p.setHealth(p.getMaxHealth());
					}else {
						p.setHealth(p.getHealth() + 4);
					}
					
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 1));
					
					p.playSound(p.getLocation(), Sound.COW_IDLE, 30, 30);
					
					cooldown.add(p);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							if(Var.patissier.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre attaque est prête !", 20, 30, 20);
								gt.send();
								
								p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
							}
							
							cooldown.remove(p);
						}
						
					}, 600L);
				}
			}
		}
	}
}
