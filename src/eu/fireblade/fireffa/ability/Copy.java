package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
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
import eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.md_5.bungee.api.ChatColor;

public class Copy implements Listener {

	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	public static ArrayList<Player> nod = new ArrayList<Player>();
	
	@EventHandler
	public void onInteract(PlayerInteractAtPlayerEvent e) {
		final Player p = e.getPlayer();
		final Player target = e.getTarget();
		final ItemStack item = e.getItemInHand();
		
		if(Var.copy.contains(p)) {
			if(item.equals(Kits.ItemGen(Material.TRIPWIRE_HOOK, "§9Copieur d'armure", Kits.LoreCreator("§9Clique Droit - Copie l'armure ennemie", null), 1))) {
				p.getInventory().setHelmet(target.getInventory().getHelmet());
				p.getInventory().setChestplate(target.getInventory().getChestplate());
				p.getInventory().setLeggings(target.getInventory().getLeggings());
				p.getInventory().setBoots(target.getInventory().getBoots());
				p.getInventory().remove(item);
				p.playSound(p.getLocation(), Sound.SHEEP_SHEAR, 30, 30);
				GlowstoneTitle gt = new GlowstoneTitle(p, "", ChatColor.BLUE+"Armure copiée !", 20, 30, 20);
				gt.send();
			} else if(item.equals(Kits.ItemGen(Material.STRING, "§9Copieur d'arme", Kits.LoreCreator("§9Clique Droit - Copie l'arme ennemie", null), 1))) {
				p.getInventory().setItem(0, target.getInventory().getItem(0));
				p.getInventory().remove(item);
				p.playSound(p.getLocation(), Sound.SHEEP_SHEAR, 30, 30);
				GlowstoneTitle gt = new GlowstoneTitle(p, "", ChatColor.BLUE+"Arme copiée !", 20, 30, 20);
				gt.send();
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack item = e.getItem();
		
		if (item.equals(Kits.ItemGen(Material.FEATHER, "§9Plumart", Kits.LoreCreator("§9Clique Droit - Saut de plusieurs blocs", "§915 secondes de récupération"), 1))){
			if(cooldown.contains(p)) {
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
				return;
			} else {
				p.setVelocity(new Vector(0.0f, 1.4f, 0.0f));
					
				p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 30, 30);
					
				noDamage(p);
					
				cooldown.add(p);
					
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						if(Var.copy.contains(p)){
							GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Vous pouvez utiliser votre Plumart !", 20, 30, 20);
							gt.send();
								
							p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
						}
						
						if(cooldown.contains(p)) {
							cooldown.remove(p);
						}
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
			
			if(Var.copy.contains(p) && nod.contains(p)){
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
			
		}, 65L);
	}
}
