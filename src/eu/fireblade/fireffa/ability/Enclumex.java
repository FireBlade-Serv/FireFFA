package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import eu.fireblade.fireffa.nms.DamageArmorStand;
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
			
			if(pp.getItemInHand().equals(Kits.ItemGen1(Material.ANVIL, Enchantment.DAMAGE_ALL, 1, "§9UltiMax", 
					Kits.LoreCreator("§9Clique Gauche - Tue votre ennemi", "§930 secondes de récupération"), 1)) && Var.enclumex.contains(pp)){
				
				pp.playSound(pp.getLocation(), Sound.ANVIL_LAND, 30, 30);
				pt.playSound(pt.getLocation(), Sound.ANVIL_LAND, 30, 30);
				pp.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous avez enclumé "+pt.getName()+" !");
				GlowstoneTitle gt = new GlowstoneTitle(pt, "", ChatColor.GRAY+"Vous vous êtes fait enclumé !", 20, 30, 20);
				gt.send();
				pp.getInventory().remove(Kits.ItemGen1(Material.ANVIL, Enchantment.DAMAGE_ALL, 1, "§9UltiMax", 
					Kits.LoreCreator("§9Clique Gauche - Tue votre ennemi", "§930 secondes de récupération"), 1));
				
				cooldown.add(pp);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						if(Var.enclumex.contains(p)){
							pp.getInventory().setItem(1, Kits.ItemGen1(Material.ANVIL, Enchantment.DAMAGE_ALL, 1, "§9UltiMax", 
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
	
	@EventHandler
	public void onAttack(EntityDamageByEntityEvent e) {
		final Entity entity = e.getEntity();
		final Entity damager = e.getDamager();
		final World w = entity.getWorld();
		
		if(entity instanceof Player && damager instanceof Player) {
			Player jawad = (Player) damager;
			ItemStack item = jawad.getItemInHand();
			
			if(Var.enclumex.contains(jawad)) {
				if(item.equals(Kits.ItemGen1(Material.ANVIL, Enchantment.DAMAGE_ALL, 1, "§9UltiMax", 
						Kits.LoreCreator("§9Clique Gauche - tue votre ennemis ", "§930 secondes de récupération"), 1))) {
					
					@SuppressWarnings("deprecation")
					FallingBlock fb = w.spawnFallingBlock(entity.getLocation().add(0.0d, 3.5d, 0.0d), Material.ANVIL, (byte) 0);
					
					fb.setDropItem(false);
					fb.setCustomName("§8§ltchoin");
					fb.setCustomNameVisible(true);
					
					DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
					as.spawn((CraftPlayer) jawad, entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ(),
							entity.getLocation().getPitch(), entity.getLocation().getYaw(), "§lENCLUMÉ !");
					as.destroyAuto((CraftPlayer) jawad);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							fb.remove();
						}
						
					}, 45L);
				}
			}
		}
		
		if(damager instanceof FallingBlock) {
			FallingBlock fb = (FallingBlock) damager;
			
			if(fb.getMaterial().equals(Material.ANVIL) && fb.getCustomName().equals("§8§ltchoin")) {
				e.setDamage(100.0d);
			}
		}
	}
	
	@EventHandler
	public void onChangeBlock(EntityChangeBlockEvent e) {
		if(e.getBlock().getType().equals(Material.ANVIL)) {
			e.setCancelled(true);
		}
	}
}
