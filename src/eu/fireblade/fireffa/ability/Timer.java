package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.md_5.bungee.api.ChatColor;

public class Timer implements Listener {

	public static ArrayList<Player> cooldown = new ArrayList<Player>();

 	@EventHandler
 	public void onDamage(PlayerInteractAtPlayerEvent e){
 		final Player Timer1 = e.getPlayer();
 		final Player Trouduc = e.getTarget();
	
 		if(Trouduc instanceof Player){
 			Player Trouduc2 = (Player) Trouduc;
 					
 			if(Var.timer.contains(Timer1)){ 				
 				if(!Timer1.getItemInHand().equals(Kits.ItemGen1(Material.COMPASS, Enchantment.KNOCKBACK, 5, "§9Ejecteur Temporel", Kits.LoreCreator("§9Clique droit - permet de frezze 5s", "§930 secondes de récupération"), 1))) {
 					return;
 				}
 						
				
 				if(Timer1.getInventory().containsAtLeast(Kits.ItemGen1(Material.COMPASS, Enchantment.KNOCKBACK, 5, "§9Ejecteur Temporel", Kits.LoreCreator("§9Clique droit - permet de frezze 5s", "§930 secondes de récupération"), 1), 1)){
					if(cooldown.contains(Timer1)){
						Timer1.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
						Timer1.playSound(Timer1.getLocation(), Sound.ITEM_BREAK, 30, 30);
						
						return;
					}else{
						damage(Trouduc2);
						
						Timer1.playSound(Timer1.getLocation(), Sound.VILLAGER_YES, 30, 30);
						
						
						
						cooldown.add(Timer1);
						
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

							@Override
							public void run() {
								if(Var.timer.contains(Timer1)){
									GlowstoneTitle gt = new GlowstoneTitle(Timer1, "", "§9Votre attaque est prête !", 20, 30, 20);
									gt.send();
										
									Timer1.playSound(Timer1.getLocation(), Sound.VILLAGER_YES, 30, 30);
									
								}
								
								if(cooldown.contains(Timer1)) {
									cooldown.remove(Timer1);
								}
							}
							
						}, 600L);
					}
 				  
 				}
 			}
 		}
	}
 
 	private static void damage(Player batard){
 		batard.setWalkSpeed(0.0f);
	
 		batard.playSound(batard.getLocation(), Sound.PORTAL_TRAVEL, 30, 30);
		
 		batard.sendMessage("§6[§eFireFFA§6] §fTu es piégé dans une boucle temporelle!");
 		
 		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

			@Override
			public void run() {
				batard.playSound(batard.getLocation(), Sound.PORTAL_TRAVEL, 30, 30);
				
				batard.sendMessage("§6[§eFireFFA§6] §fTu es sorti de la boucle temporelle!");
				
				batard.setWalkSpeed(0.2f);
			}
			
		}, 100L);
 	}
}



