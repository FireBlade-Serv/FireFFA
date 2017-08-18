package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class PandaRoux implements Listener {
	
	private static ArrayList<Player> cooldown = new ArrayList<Player>(); 

	@EventHandler
	public void onInteract(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack item = e.getItem();
		final World w = e.getWorld();
		
		if(item.equals(Kits.ItemGen(Material.CLAY_BALL, ChatColor.WHITE+"Charge au sol", 
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Petite explosion", ChatColor.BLUE+"30 secondes de récupération"), 1))) {
			
			if(Var.panda.contains(p)) {
				if(cooldown.contains(p)) {
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
					return;
				}else {
					Entity entity = w.spawn(p.getLocation(), TNTPrimed.class);
					
					TNTPrimed tnt = (TNTPrimed) entity;
					
					tnt.setFuseTicks(0);
					
					tnt.setYield(1.0f);
					
					cooldown.add(p);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							if(Var.panda.contains(p)){
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
	
	@EventHandler
	public void onExplode(EntityExplodeEvent e){
		final Entity entity = e.getEntity();
		
		if(entity instanceof TNTPrimed){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		final Entity entity = e.getEntity();
		final DamageCause cause = e.getCause();
		
		if(entity instanceof Player) {
			Player p = (Player) entity;
			
			if(Var.panda.contains(p) && cause.equals(DamageCause.ENTITY_EXPLOSION)) {
				e.setCancelled(true);
			}
		}
	}
}
