package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Moutarde implements Listener {
public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onInteract(PlayerInteractAtPlayerEvent e) {
		final Player p = e.getPlayer();
		final Player target = e.getTarget();
		final ItemStack item = e.getItemInHand();
		
		if(item.equals(Kits.ItemGen(Material.POTION, ChatColor.YELLOW+"Gaz moutarde", 
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Donne poison 2 à la cible pendant 2 secondes", ChatColor.BLUE+"15 secondes de récupération"), 1))) {
			
			if(Var.moutarde.contains(p)) {
				if(cooldown.contains(p)) {
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
					return;
				}else {
					effect(p, target);
					
					cooldown.add(p);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							if(Var.moutarde.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre attaque est prête !", 20, 30, 20);
								gt.send();
								
								p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
							}
							
							if(cooldown.contains(p)) {
								cooldown.remove(p);
							}
						}						
					}, 300L);
				}
			}
		}
	}
	
	private static void effect(Player p, Player target) {
		p.playSound(p.getLocation(), Sound.GLASS, 30, 30);
		
		target.playSound(p.getLocation(), Sound.GLASS, 30, 30);
		
		target.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 1));
	}
}
