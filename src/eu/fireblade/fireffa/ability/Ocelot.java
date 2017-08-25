package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.md_5.bungee.api.ChatColor;

public class Ocelot implements Listener {
	
	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	private static ItemStack getItem(){
		ItemStack bonemeal = new ItemStack(Material.INK_SACK, 1, (short)15);
		ItemMeta bonemealM = bonemeal.getItemMeta();
		bonemealM.setDisplayName(ChatColor.YELLOW+"Pelote de laine");
		bonemealM.setLore(Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Vitesse 2 pendant 5 secondes",
				ChatColor.BLUE+"Consomme 1 ficelle de pelote de laine, 10 secondes de récupération"));
		bonemeal.setItemMeta(bonemealM);
		
		return bonemeal;
	}
	
	@EventHandler
	public void onInteract(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		
		if(e.getItem().equals(getItem()) && Var.ocelot.contains(p)){
			
			if(p.getInventory().containsAtLeast(Kits.ItemGen(Material.STRING, ChatColor.YELLOW+"Ficelle de pelote laine", null, 1), 1)) {
				
				if(cooldown.contains(p)){
					p.playSound(p.getLocation(), Sound.CAT_HISS, 30, 30);
					
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
					
					return;
				}else{
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 110, 1));
				
					p.playSound(p.getLocation(), Sound.CAT_MEOW, 30, 30);
					p.getInventory().removeItem(Kits.ItemGen(Material.STRING, ChatColor.YELLOW+"Ficelle de pelote laine", null, 1));
					
					cooldown.add(p);
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

						@Override
						public void run() {
							if(Var.ocelot.contains(p)){
								if(p.getInventory().containsAtLeast(Kits.ItemGen(Material.STRING, ChatColor.YELLOW+"Ficelle de pelote laine", null, 1), 1)){
									GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre attaque est prête !", 20, 30, 20);
									gt.send();
									
									p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
								}
							}
							
							cooldown.remove(p);
						}
						
					}, 200L);
				}
			} else {
				p.playSound(p.getLocation(), Sound.CAT_HISS, 30, 30);
				
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous n'avez plus de ficelle de pelote laine.");
			}
		}
	}

}
