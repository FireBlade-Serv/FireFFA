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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Gameur implements Listener {
	
	private static ArrayList<Player> cooldown = new ArrayList<Player>();
	private static ArrayList<Player> cooldown2 = new ArrayList<Player>();
	
	private static ArrayList<Player> nod = new ArrayList<Player>();
	
	@EventHandler
	public void onInteract(PlayerRightClickInteractEvent e){
		final ItemStack item = e.getItem();
		final Player p = e.getPlayer();
		
		if(item.equals(Kits.ItemGen(Material.RED_MUSHROOM, ChatColor.GREEN+"Super champignon",Kits.
				LoreCreator(ChatColor.BLUE+"Clique droit - Force 1, 3 secondes", ChatColor.BLUE+"Récupération 30 secondes"), 1))){
			
			if(!Var.gamer.contains(p)){
				return;
			}
			
			if(cooldown.contains(p)){
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
				return;
			}else{
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 0));
				
				p.playSound(p.getEyeLocation(), Sound.VILLAGER_IDLE, 30, 30);
				
				cooldown.add(p);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						if(Var.gamer.contains(p)){
							GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Vous pouvez utiliser votre Super Champignion !", 20, 30, 20);
							gt.send();
							
							p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
						}
						
						cooldown.remove(p);
					}
					
				}, 600L);
			}
		}else if(item.equals(Kits.ItemGen(Material.RABBIT_FOOT, ChatColor.GREEN+"Super jump",
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Saute à une hauteur de 5 blocs", ChatColor.BLUE+"Récupération 15 secondes"), 1))){
			
			if(!Var.gamer.contains(p)){
				return;
			}
			
			if(cooldown2.contains(p)){
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
				return;
			}else{
				p.setVelocity(new Vector(0, 5, 0));
				
				p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 30, 30);
				
				noDamage(p);
				
				cooldown2.add(p);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						if(Var.gamer.contains(p)){
							GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Vous pouvez utiliser votre Super Jump !", 20, 30, 20);
							gt.send();
							
							p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
						}
						
						cooldown2.remove(p);
					}
					
				}, 300L);
			}
		}
	}
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e){
		final Entity entity = e.getEntity();
		
		if(entity instanceof Player){
			Player p = (Player) entity;
			
			if(Var.gamer.contains(p) && nod.contains(p)){
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
			
		}, 45L);
	}

}
