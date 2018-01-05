package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.GlowstoneTick;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Domination implements Listener {
	
	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onClick(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack item = e.getItem();
		final World w = e.getWorld();
		
		if(item.equals(Kits.ItemGen1(Material.NETHER_STAR, Enchantment.DAMAGE_ALL, 3,ChatColor.BLACK+"Éclair de terreur", 
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Fait tomber la foudre", ChatColor.BLUE+"15 secondes de récupération"),1))) {
			
			if(Var.domination.contains(p)) {
				if(cooldown.contains(p)) {
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
					return;
				}else {
					p.playSound(p.getEyeLocation(), Sound.IRONGOLEM_DEATH, 30, 30);
					
					w.strikeLightning(p.getLocation());
					w.strikeLightning(p.getLocation());
					w.strikeLightning(p.getLocation());
					w.strikeLightning(p.getLocation());
					w.strikeLightning(p.getLocation());
					
					cooldown.add(p);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							if(Var.domination.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre attaque est prête !", 20, 30, 20);
								gt.send();
								
								p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
							}
							
							if(cooldown.contains(p)) {
								cooldown.remove(p);
							}
						}
						
					}, new GlowstoneTick(15).getTicks());
				}
			}
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		final Entity entity = e.getEntity();
		final DamageCause cause = e.getCause();
		
		if(entity instanceof Player) {
			Player p = (Player) entity;
			
			if(Var.domination.contains(p) && cause.equals(DamageCause.LIGHTNING)) {
				e.setCancelled(true);
			}
		}
	}

}
