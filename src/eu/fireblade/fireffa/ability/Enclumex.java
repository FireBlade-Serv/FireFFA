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
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent;
import eu.fireblade.fireffa.items.Kits;
import eu.fireblade.fireffa.nms.DamageArmorStand;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.md_5.bungee.api.ChatColor;

public class Enclumex implements Listener {

	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void OnHit(PlayerInteractAtPlayerEvent e) {
		Player p = e.getPlayer();
		Player t = e.getTarget();
		World w = e.getWorld();
			
		if(p.getItemInHand().equals(Kits.ItemGen1(Material.ANVIL, Enchantment.DAMAGE_ALL, 1, "§9UltiMax", 
				Kits.LoreCreator("§9Clique Gauche - Tue votre ennemi", "§930 secondes de récupération"), 1)) && Var.enclumex.contains(p)){
				
			if(cooldown.contains(p)) {
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				
				return;
			}
			
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 30, 30);
			t.playSound(t.getLocation(), Sound.ANVIL_LAND, 30, 30);
			p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous avez enclumé "+t.getName()+" !");
			GlowstoneTitle gt = new GlowstoneTitle(t, "", ChatColor.GRAY+"Vous vous êtes fait enclumé !", 20, 30, 20);
			gt.send();
				
			cooldown.add(p);
			
			@SuppressWarnings("deprecation")
			FallingBlock fb = w.spawnFallingBlock(t.getLocation().add(0.0d, 3.5d, 0.0d), Material.ANVIL, (byte) 0);
			
			fb.setDropItem(false);
			fb.setCustomName("§8§ltchoin");
			fb.setCustomNameVisible(true);
			
			DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
			as.spawn((CraftPlayer) p, t.getLocation().getX(), t.getLocation().getY(), t.getLocation().getZ(),
					t.getLocation().getPitch(), t.getLocation().getYaw(), "§lENCLUMÉ !");
			as.destroyAuto((CraftPlayer) p);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

				@Override
				public void run() {
					fb.remove();
				}
				
			}, 45L);
				
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

				@Override
				public void run() {
					if(Var.enclumex.contains(p)){
						p.playSound(p.getLocation(), Sound.ANVIL_USE, 30, 30);
						GlowstoneTitle gt = new GlowstoneTitle(p, "", ChatColor.GRAY+"Vous avez récupéré votre UltiMax !", 20, 30, 20);
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
	}
	
	@EventHandler
	public void onAttack(EntityDamageByEntityEvent e) {
		final Entity damager = e.getDamager();
		
		if(e.getCause().equals(DamageCause.FALLING_BLOCK)) {
			FallingBlock fb = (FallingBlock) damager;
			
			if(fb.getMaterial().equals(Material.ANVIL) && fb.getCustomName().equals("§8§ltchoin")) {
				e.setDamage(100.0d);
			}
		}
	}
	
	@EventHandler
	public void onChangeBlock(EntityChangeBlockEvent e) {
		e.setCancelled(false);
	}
}
