package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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

	final static ArrayList<Player> cooldown = new ArrayList<Player>();
	final static ArrayList<Player> nod = new ArrayList<Player>();
	final static ArrayList<Player> inload = new ArrayList<Player>();
	
	@EventHandler
	public void OnClick(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack i = e.getItem();
		
		if(Var.power.contains(p) && i == Kits.ItemGen(Material.STICK, "§9Jumper", Kits.LoreCreator("§9Clique droit - jump de 12 blocs", "15 secondes de récupération"), 1)){
			
			if(cooldown.contains(p)){
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
				return;
			} else {
				p.setVelocity(new Vector(0, 2, 0));
				
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
		} else if (Var.power.contains(p) && !(inload.contains(p)) && i == Kits.ItemGen(Material.SLIME_BALL, "§9Poing", Kits.LoreCreator("§9Clique droit - charge le poing", "§9Clique gauche - tape selon la charge"), 1)) {
			
			inload.add(p);
			int task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
				int max = 0;
				
				@Override
				public void run() {
					if(max < 10){
						if(Var.power.contains(p)) {
							max++;
							p.setLevel(max);
						}
					}else {
						Bukkit.getScheduler().cancelTask(task);
						max = 0;
					}
				}
				
			}, 20L, 20L);
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
