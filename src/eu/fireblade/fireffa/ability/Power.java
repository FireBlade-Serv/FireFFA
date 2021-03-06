package eu.fireblade.fireffa.ability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
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
import eu.fireblade.fireffa.nms.DamageArmorStand;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Power implements Listener {

	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	public static ArrayList<Player> cooldown2 = new ArrayList<Player>();
	private static ArrayList<Player> nod = new ArrayList<Player>();
	public static ArrayList<Player> inload = new ArrayList<Player>();
	public static ArrayList<Player> Bouclier = new ArrayList<Player>();
	
	public static Map<Player, Integer> max = new HashMap<Player, Integer>();
	public static Map<Player, Integer> tasks = new HashMap<Player, Integer>();
	
	@EventHandler
	public void OnClick(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack i = e.getItem();
		
		if(Var.power.contains(p) && i.equals(Kits.ItemGen(Material.STICK, "�9Jumper", Kits.LoreCreator("�9Clique droit - jump de 12 blocs", ChatColor.BLUE+"15 secondes de r�cup�ration"), 1))){
			
			if(cooldown.contains(p)){
				p.sendMessage(ChatColor.GOLD+"�6[�eFireFFA�6] "+ChatColor.RED+"Vous �tes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
				return;
			} else {
				p.setVelocity(new Vector(0.0f, 1.1f, 0.0f));
				
				p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 30, 30);
				
				noDamage(p);
				
				cooldown.add(p);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						if(Var.power.contains(p)){
							GlowstoneTitle gt = new GlowstoneTitle(p, "", "�9Vous pouvez utiliser votre Jumper !", 20, 30, 20);
							gt.send();
							
							p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
						}
						
						if(cooldown.contains(p)) {
							cooldown.remove(p);
						}
					}
					
				}, 300L);
			
			}
		} else if (Var.power.contains(p) && i.equals(Kits.ItemGen(Material.SLIME_BALL, "�9Poing",
				Kits.LoreCreator("�9Clique droit - charge le poing", "�9Clique gauche - tape selon la charge"), 1))) {
			
			if(inload.contains(p)) {
				return;
			}
			
			inload.add(p);
			
			if(!tasks.containsKey(p)) {
				tasks.put(p, 0);
			}
			
			if(!max.containsKey(p)) {
				max.put(p, -1);
			}
			
			if(!(max.get(p) == -1) || !inload.contains(p)) {
				return;
			}
			
			tasks.replace(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
				
				@Override
				public void run() {
					if(max.get(p) < 10){
						if(Var.power.contains(p)) {
							max.replace(p, max.get(p) + 1);
							p.setLevel(max.get(p));
							p.playSound(p.getLocation(), Sound.LEVEL_UP, 30, 30);
						}
					}else {
						if(inload.contains(p)) {
							inload.remove(p);
						}
						
						Bukkit.getScheduler().cancelTask(tasks.get(p));
					}
				}
				
			}, 0L, 20L));
		}else if(Var.power.contains(p) && i.equals(Kits.ItemGen(Material.BANNER, "�9Invuln�rabilit�",
				Kits.LoreCreator("�9Clique droit - Rend invinsible pendant 3 secondes", ChatColor.BLUE+"15 secondes de r�cup�ration"), 1))){
			
			if(cooldown2.contains(p)){
				p.sendMessage(ChatColor.GOLD+"�6[�eFireFFA�6] "+ChatColor.RED+"Vous �tes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
			}else {
				cooldown2.add(p);
				Bouclier.add(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 30, 30);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						Bouclier.remove(p);
						
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

							@Override
							public void run() {
								if(Var.power.contains(p)) {
									cooldown2.remove(p);
									GlowstoneTitle gt = new GlowstoneTitle(p, "", "�9Vous pouvez utiliser votre invuln�rabilit� !", 20, 30, 20);
									gt.send();
									
									p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
								}							
							}
							
						}, 140L);
					}
					
				}, 60L);
			}
		}
	}
	
	@EventHandler
	public void OnDamage(EntityDamageByEntityEvent e) {
		Entity d = e.getDamager();
		Entity t = e.getEntity();
		
		if(d.getType().equals(EntityType.PLAYER) && t.getType().equals(EntityType.PLAYER)) {
			Player dp = (Player) d;
			Player tp = (Player) t;
			World w = d.getWorld();
			
			if(Var.power.contains(dp) && dp.getItemInHand().equals(Kits.ItemGen(Material.SLIME_BALL, "�9Poing",
				Kits.LoreCreator("�9Clique droit - charge le poing", "�9Clique gauche - tape selon la charge"), 1))) {
				e.setDamage(dp.getLevel());
				dp.setLevel(0);
				inload.remove(dp);
				
				Bukkit.getScheduler().cancelTask(tasks.get(dp));
				
				max.replace(dp, -1);
				
				if(Power.Bouclier.contains(tp)){
					dp.sendMessage(ChatColor.GOLD+"�6[�eFireFFA�6] "+ChatColor.RED+"Ce joueur est intouchable !");
					dp.playSound(dp.getLocation(), Sound.ITEM_BREAK, 30, 30);
					return;
				}
				
				DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
				as.spawn((CraftPlayer) dp, tp.getLocation().getX(), tp.getLocation().getY(), tp.getLocation().getZ(),
						tp.getLocation().getPitch(), tp.getLocation().getYaw(), e.getDamage());
				as.destroyAuto((CraftPlayer) dp);
			}
		}
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e){
		Entity entity = e.getEntity();
			
		if(entity instanceof Player){
			Player p = (Player) entity;
			
			if(Bouclier.contains(p)) {
				e.setCancelled(true);
			}
			
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
			
		}, 40L);
	}

}