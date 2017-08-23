package eu.fireblade.fireffa.ability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Power implements Listener {

	private static ArrayList<Player> cooldown = new ArrayList<Player>();
	private static ArrayList<Player> nod = new ArrayList<Player>();
	private static ArrayList<Player> inload = new ArrayList<Player>();
	
	private static Map<Player, Integer> max = new HashMap<Player, Integer>();
	private static Map<Player, Integer> tasks = new HashMap<Player, Integer>();
	
	@EventHandler
	public void OnClick(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack i = e.getItem();
		
		if(Var.power.contains(p) && i.equals(Kits.ItemGen(Material.STICK, "§9Jumper", Kits.LoreCreator("§9Clique droit - jump de 12 blocs", "15 secondes de récupération"), 1))){
			
			if(cooldown.contains(p)){
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
				return;
			} else {
				p.setVelocity(new Vector(0.0f, 1.2f, 0.0f));
				
				p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 30, 30);
				
				noDamage(p);
				
				cooldown.add(p);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						if(Var.power.contains(p)){
							GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Vous pouvez utiliser votre Jumper !", 20, 30, 20);
							gt.send();
							
							p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
						}
						
						cooldown.remove(p);
					}
					
				}, 300L);
			
			}
		} else if (Var.power.contains(p) && !(inload.contains(p)) && i.equals(Kits.ItemGen(Material.SLIME_BALL, "§9Poing",
				Kits.LoreCreator("§9Clique droit - charge le poing", "§9Clique gauche - tape selon la charge"), 1))) {
			
			inload.add(p);
			
			if(!tasks.containsKey(p)) {
				tasks.put(p, 0);
			}
			
			if(!max.containsKey(p)) {
				max.put(p, 0);
			}
			
			tasks.replace(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
				
				@Override
				public void run() {
					if(max.get(p) < 10){
						if(Var.power.contains(p) && inload.contains(p)) {
							max.replace(p, max.get(p) + 1);
							p.setLevel(max.get(p));
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 30, 30);
						}
					}else {
						max.replace(p, 0);
						
						Bukkit.getScheduler().cancelTask(tasks.get(p));
					}
				}
				
			}, 20L, 20L));
		}
	}
	
	public void OnDamage(EntityDamageByEntityEvent e) {
		Entity d = e.getDamager();
		Entity t = e.getEntity();
		
		if(d.getType().equals(EntityType.PLAYER) && t.getType().equals(EntityType.PLAYER)) {
			Player dp = (Player) d;
			
			if(Var.power.contains(dp) && dp.getItemInHand().equals(Kits.ItemGen(Material.SLIME_BALL, "§9Poing",
				Kits.LoreCreator("§9Clique droit - charge le poing", "§9Clique gauche - tape selon la charge"), 1))) {
				e.setDamage(dp.getLevel());
				dp.setLevel(0);
				inload.remove(dp);
			}
		}
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e){
		final Entity entity = e.getEntity();
		
		if(entity instanceof Player){
			Player p = (Player) entity;
			
			if(Var.power.contains(p) && nod.contains(p)){
				if(e.getCause().equals(DamageCause.FALL)){
					e.setCancelled(true);
				}
			}
		}
	}

	private void noDamage(Player p) {
		nod.add(p);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				nod.remove(p);
			}
			
		}, 30L);
	}

}
