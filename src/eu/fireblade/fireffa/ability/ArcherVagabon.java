package eu.fireblade.fireffa.ability;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class ArcherVagabon implements Listener {

	public void onShoot(ProjectileLaunchEvent e) {
		final Entity entity = e.getEntity();
		
			if(entity instanceof Arrow) {
				final Arrow ball = (Arrow) entity;
				
				if(ball.getShooter() instanceof Player) {
					Player p = (Player) ball.getShooter();
				
				if(!Var.archervagabon.contains(p)) {
					return;
				}
				
				if(p.getItemInHand().equals(Kits.ItemGen1(Material.BOW, Enchantment.ARROW_KNOCKBACK, 10, ChatColor.DARK_GREEN+"Arc de la mort", null, 1))){
					p.getInventory().setItem(0, Kits.ItemGen(Material.BARRIER, ChatColor.RED+"En récupération", Kits.LoreCreator(ChatColor.BLUE+"10 secondes de récupération", null), 1));
					p.playSound(p.getLocation(), Sound.FUSE, 30, 30);
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							if(Var.archervagabon.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre arc est prêt !", 20, 30, 20);
								gt.send();
								p.getInventory().setItem(0, Kits.ItemGen1(Material.BOW, Enchantment.ARROW_KNOCKBACK, 10, ChatColor.DARK_GREEN+"Arc de la mort", Kits.LoreCreator(ChatColor.BLUE+"Tirer normalement pour l'utiliser", ChatColor.BLUE+"10 secondes de récupération"), 1));
								p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
							}
						}						
					}, 200L);
				}
			}
		}
	}
}