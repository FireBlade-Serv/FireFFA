package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class GuerrierGalactique implements Listener {
	
	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onInteract(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack item = e.getItem();
		
		if(item.equals(Kits.ItemGen(Material.GOLD_NUGGET, ChatColor.AQUA+"Pouvoir du guerrier galactique", 
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Boule de feu", ChatColor.BLUE+"20 secondes de récupération"), 1))){
			
			if(Var.guerriergalactique.contains(p)) {
				if(cooldown.contains(p)) {
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
					return;
				}else {
					p.playSound(p.getEyeLocation(), Sound.FIRE_IGNITE, 30, 30);
					
					p.launchProjectile(Fireball.class);
					
					cooldown.add(p);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							if(Var.guerriergalactique.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre attaque est prête !", 20, 30, 20);
								gt.send();
								
								p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);						
							}
						
							if(cooldown.contains(p)) {
								cooldown.remove(p);
							}
						}
					
					}, 400L);
				}
			}
		}
	}
	
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent e){
		final Entity entity = e.getEntity();
		
		if(entity instanceof Fireball){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onEntityFire(ExplosionPrimeEvent e){
		final Entity entity = e.getEntity();
		
		if(entity instanceof Fireball){
			e.setFire(false);
		}
	}
}
