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
import eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.GlowstoneTick;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class DevDePacotille implements Listener {
	
	private static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onInteract(PlayerInteractAtPlayerEvent e) {
		final Player p = e.getPlayer();
		final Player target = e.getTarget();
		final ItemStack item = e.getItemInHand();
		
		if(item.equals(Kits.ItemGen(Material.IRON_INGOT, ChatColor.DARK_PURPLE+"Command prompt: BLIND",
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Aveugle", ChatColor.BLUE+"5 secondes de récupération"), 1))) {
			
			if(Var.programmeur.contains(p)) {
				if(cooldown.contains(p)) {
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
					return;
				}else {
					blind(p, target);
					
					cooldown.add(p);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							if(Var.programmeur.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre attaque est prête !", 20, 30, 20);
								gt.send();
								
								p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
							}
							
							cooldown.remove(p);
						}
						
					}, new GlowstoneTick(5).getTicks());
				}
			}
		}
	}
	
	private static void blind(Player p, Player target) {
		p.playSound(p.getLocation(), Sound.IRONGOLEM_HIT, 30, 30);
		
		target.playSound(p.getLocation(), Sound.PIG_DEATH, 30, 30);
		
		target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 0));
	}

}
