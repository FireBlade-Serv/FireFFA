package eu.fireblade.fireffa.ability;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Swap implements Listener {
	
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		Entity sb = e.getDamager();
		Entity t = e.getEntity();
		
		if(sb instanceof Snowball) {
			Snowball sball = (Snowball) sb;
			
			if (sball.getShooter() instanceof Player) {
				Player p = (Player) sball.getShooter();
				
				if(Var.swap.contains(p) && t instanceof Player) {
					Player target = (Player) t;
					
					Var.switchArray(p, target);
					
					ItemStack [] pItems = p.getInventory().getContents();
					ItemStack [] pArmor = p.getInventory().getArmorContents();
					ItemStack [] tItems = target.getInventory().getContents();
					ItemStack [] tArmor = target.getInventory().getArmorContents();
					
					target.sendMessage("§6[§eFireFFA§6] §cVotre kit à été swap par "+p.getName()+" !");
					p.sendMessage("§6[§eFireFFA§6] §aVous avez swap le kit de "+target.getName()+" !");
					
					p.playSound(p.getLocation(), Sound.SHEEP_SHEAR, 30, 30);
					target.playSound(target.getLocation(), Sound.PIG_DEATH, 30, 30);
					
					target.getInventory().setContents(pItems);
					target.getInventory().setArmorContents(pArmor);
					p.getInventory().setContents(tItems);
					p.getInventory().setArmorContents(tArmor);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							if(Var.swap.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(target, "", "§9Vous avez récupéré une boule de neige !", 20, 30, 20);
								gt.send();
								target.getInventory().setItem(1, Kits.ItemGen(Material.SNOW_BALL, "§9Swaper", Kits.LoreCreator("§9Lancer la boule - Swap votre inventaire avec le joueur touché", ChatColor.BLUE+"20 secondes de récupération"), 1));
								target.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
							}
						}						
					}, 400L);
					target.getInventory().setItem(1, Kits.ItemGen(Material.SNOW_BALL, "§9Swaper", Kits.LoreCreator("§9Lancer la boule - Swap votre inventaire avec le joueur touché", ChatColor.BLUE+"20 secondes de récupération"), 1));
									
				}
			}
		}
	}
	
	@EventHandler
	public void onShoot(ProjectileLaunchEvent e) {
		final Entity entity = e.getEntity();
		
		if(entity instanceof Snowball) {
			final Snowball ball = (Snowball) entity;
			
			if(ball.getShooter() instanceof Player) {
				Player p = (Player) ball.getShooter();
			
			if(!Var.swap.contains(p)) {
				return;
			}
			
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						if(Var.swap.contains(p)){
							GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Vous avez récupéré une boule de neige !", 20, 30, 20);
							gt.send();
							p.getInventory().setItem(1, Kits.ItemGen(Material.SNOW_BALL, "§9Swaper", Kits.LoreCreator("§9Lancer la boule - Swap votre inventaire avec le joueur touché", ChatColor.BLUE+"20 secondes de récupération"), 1));
							p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
						}
					}						
				}, 400L);
			}
		}
	}
}
