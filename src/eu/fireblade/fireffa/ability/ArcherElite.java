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
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import eu.fireblade.fireffa.nms.DamageArmorStand;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class ArcherElite implements Listener {
	
	public static Map<Player, Integer> tasks = new HashMap<Player, Integer>();
	public static Map<Player, Integer> arrowcount = new HashMap<Player, Integer>();
	public static ArrayList<Player> inLoad = new ArrayList<Player>();
	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onInteract(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack item = e.getItem();
		
			if(!cooldown.contains(p)) {
				if(item.equals(Kits.ItemGen1(Material.BOW, Enchantment.ARROW_INFINITE, 1, ChatColor.DARK_GREEN+"Arc mitrailleur", 
						Kits.LoreCreator(ChatColor.BLUE+"N'a pas besoin d'être chargé", ChatColor.BLUE+"2 secondes de récupération toute les 18 fléches."), 1))) {
						if(!arrowcount.containsKey(p)) {
							arrowcount.put(p, 1);
							p.setLevel(17);
						}else {
							arrowcount.put(p, arrowcount.get(p)+1);
							p.setLevel(18-arrowcount.get(p));
						}
						if(arrowcount.get(p) >= 18) {
							GlowstoneTitle gt = new GlowstoneTitle(p, "", "§cVous devez attendre 2 secondes avant de tirer!", 20, 30, 20);
							gt.send();
							p.getInventory().setItem(0, Kits.ItemGen(Material.BARRIER, ChatColor.RED+"En récupération", Kits.LoreCreator(ChatColor.BLUE+"2 secondes de récupération", null), 1));
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin , new Runnable() {
								
								@Override
								public void run() {
									GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Vous pouvez tirer!", 20, 30, 20);
									gt.send();	
									p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
									p.getInventory().setItem(0, Kits.ItemGen1(Material.BOW, Enchantment.ARROW_INFINITE, 1, ChatColor.DARK_GREEN+"Arc mitrailleur", Kits.LoreCreator(ChatColor.BLUE+"N'a pas besoin d'être chargé", ChatColor.BLUE+"2 secondes de récupération toute les 18 fléches."), 1));
									
									arrowcount.remove(p);
									p.setLevel(18);
								}
							}, 40L);
							return;
						}
					if(Var.archerélite.contains(p) && p.getInventory().containsAtLeast(Kits.ItemGen(Material.ARROW, ChatColor.GREEN+"Fléche de l'archer élite", null, 1), 1)); {
						p.launchProjectile(Arrow.class);
						return;
					}
				}
			}else {
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
			}			
	}

	@EventHandler
	public void onHitArrow(EntityDamageByEntityEvent e) {
		final Entity damager = e.getDamager();
		final Entity entity = e.getEntity();
		final World w = entity.getWorld();
		
		if(damager instanceof Arrow) {
			Arrow ar = (Arrow) damager;
			
			if(ar.getShooter() instanceof Player) {
				Player p = (Player) ar.getShooter();
				
				if(Var.archerélite.contains(p)) {
					ar.setCritical(false);
					
					ar.setKnockbackStrength(0);
					
					if(Var.nuage.contains(p)) {
						return;
					}else {
						e.setDamage(1.0d);
					}
					
					if(entity instanceof Player) {
						Player v = (Player) entity;
						
						if(Power.Bouclier.contains(v)){
							return;
						}
						
						DamageArmorStand as = new DamageArmorStand(((CraftWorld)w).getHandle());
						as.spawn((CraftPlayer) p, entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ(),
								entity.getLocation().getPitch(), entity.getLocation().getYaw(), 1.0d);
						as.destroyAuto((CraftPlayer) p);
					}
				}
			}
		}
	}
}