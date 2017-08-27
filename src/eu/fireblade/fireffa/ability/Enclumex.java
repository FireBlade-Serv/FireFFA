package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.md_5.bungee.api.ChatColor;

public class Enclumex implements Listener {

	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void OnHit(EntityDamageByEntityEvent e) {
		Entity p = e.getDamager();
		Entity t = e.getEntity();
		
		if(p.getType().equals(EntityType.PLAYER) && t.getType().equals(EntityType.PLAYER)) {
			Player pp = (Player) p;
			Player pt = (Player) t;
			
			if(pp.getItemInHand().equals(Kits.ItemGen1(Material.ANVIL, Enchantment.DAMAGE_ALL, 999, "§9UltiMax", 
					Kits.LoreCreator("§9Clique Gauche - tue votre ennemis ", "§930 secondes de récupération"), 1)) && Var.enclumex.contains(pp)){
				
				pp.playSound(pp.getLocation(), Sound.ANVIL_LAND, 30, 30);
				pt.playSound(pt.getLocation(), Sound.ANVIL_LAND, 30, 30);
				pp.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous avez enclumé "+pt.getName()+" !");
				GlowstoneTitle gt = new GlowstoneTitle(pt, "", ChatColor.GRAY+"Vous vous êtes fait enclumé !", 20, 30, 20);
				gt.send();
				pp.getInventory().remove(Kits.ItemGen1(Material.ANVIL, Enchantment.DAMAGE_ALL, 999, "§9UltiMax", 
					Kits.LoreCreator("§9Clique Gauche - tue votre ennemis ", "§930 secondes de récupération"), 1));
				
				cooldown.add(pp);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						if(Var.enclumex.contains(p)){
							pp.getInventory().setItem(1, Kits.ItemGen1(Material.ANVIL, Enchantment.DAMAGE_ALL, 999, "§9UltiMax", 
									Kits.LoreCreator("§9Clique Gauche - tue votre ennemis ", "§930 secondes de récupération"), 1) );
							pp.playSound(pp.getLocation(), Sound.ANVIL_USE, 30, 30);
							GlowstoneTitle gt = new GlowstoneTitle(pp, "", ChatColor.GRAY+"Vous avez récupéré votre UltiMax !", 20, 30, 20);
							gt.send();
							
						}
						
						if(cooldown.contains(p)) {
							cooldown.remove(p);
						}
					}
					
				}, 600L);
			} else {
				return;
			}
		}else {
			return;
		}
	}
}
