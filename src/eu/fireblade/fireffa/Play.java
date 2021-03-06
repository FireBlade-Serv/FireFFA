package eu.fireblade.fireffa;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import eu.fireblade.fireffa.util.NearbyPlayerLocationCalculator;
import eu.fireblade.fireffa.util.Tp;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Play implements Listener {

	public static ArrayList<Player> invulnerability = new ArrayList<Player>();
	public static HashMap<Player, Integer> task = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> timer = new HashMap<Player, Integer>();
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		Entity entity = e.getEntity();
		 if(entity instanceof Player) {
			Player p = (Player) entity;
			 if(invulnerability.contains(p)) {
				 e.setCancelled(true);
			 }
		 }
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent e) {
		Entity et = e.getDamager();
		Entity t = e.getEntity();
		if (et instanceof Player && t instanceof Player) {
			Player p = (Player) et;
			Player targ = (Player) t;
			if(invulnerability.contains(p) || invulnerability.contains(targ)) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onRightClickInteract(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack item = e.getItem();
		
		if(Var.inGame.contains(p)) {
			if(item.equals(Kits.ItemGen(Material.COMPASS, "�9Localisation Joueur", null, 1))) {
				NearbyPlayerLocationCalculator.sendNearestPlayerActionBar(p, NearbyPlayerLocationCalculator.getNearestPlayer(p));
			}else if(item.equals(Kits.ItemGen(Material.DIAMOND, "�9Infos", null, 1))) {
				
			}else if(item.equals(Kits.ItemGen(Material.EMERALD, "�9Cr�dits", null, 1))) {
				
			}
		}
	}
	
	public static void removeInvu(Player p) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

			@Override
			public void run() {
				invulnerability.remove(p);
				
			}
			
		}, 100L);
	}
	
	public static void timerBeforePvp(Player p, ItemStack[] tab1, ItemStack[] tab2) {
		
		if(!task.containsKey(p)) {
			task.put(p, 0);
		}
		
		if(!timer.containsKey(p)) {
			timer.put(p, -1);
		}
		
		if(!(timer.get(p) == -1)){
			return;
		}
		
		task.replace(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				if (timer.get(p) < 4) {
					timer.replace(p, timer.get(p)+1);
					int number = 5-timer.get(p);
					GlowstoneTitle gt = new GlowstoneTitle(p, "", "�9"+number, 20, 30, 20);
					gt.send();
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 30, 30);
				}else {
					Bukkit.getScheduler().cancelTask(task.get(p));
					GlowstoneTitle gt = new GlowstoneTitle(p, ChatColor.RED+"Go !", "", 20, 30, 20);
					gt.send();
					p.playSound(p.getLocation(), Sound.WITHER_SPAWN, 30, 30);
					timer.remove(p);
					task.remove(p);
					p.getInventory().setContents(tab1);
					p.getInventory().setArmorContents(tab2);								
					p.getInventory().setHeldItemSlot(0);
				}
				
			}
			
		}, 0L, 20L));
		
		
	}
	
	public static void onPlay(Player p) {
		Var.inGame.add(p);
		Tp.randomtp(p);
		p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100, 0, false, false));
		p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0, false, false));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0, false, false));
		p.setHealth(p.getMaxHealth());
		p.setFoodLevel(20);
		ItemStack[] item = p.getInventory().getContents();
		ItemStack[] armor = p.getInventory().getArmorContents();
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		invulnerability.add(p);
		removeInvu(p);
		timerBeforePvp(p, item, armor);
	}
}
