package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Bouftout implements Listener {

	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerClick(PlayerInteractAtPlayerEvent e){
		final Player p = e.getPlayer();
		final Player target = e.getTarget();
		final ItemStack item = e.getItemInHand();
		
		if(Var.bouftout.contains(p)){
			if(item.equals(Kits.ItemGen1(Material.COOKED_CHICKEN, Enchantment.FIRE_ASPECT, 2, "§9Poulet Brûlant", 
					Kits.LoreCreator("§9Clique Droit - vole 3 coeurs", "§930 secondes de récupération"), 1))){
				
				if(cooldown.contains(p)){
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
					return;
				}else{
					damage(target);
					heal(p);
					
					cooldown.add(p);									
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

						@Override
						public void run() {
							if(Var.bouftout.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre attaque est prête !", 20, 30, 20);
								gt.send();
									
								p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
								
							}
							
							if(cooldown.contains(p)) {
								cooldown.remove(p);
							}
						}
						
					}, 600L);
				}
			}
		}
	}
	
	private static void damage(Player p){
		if(p.getHealth() <= 6){
			p.setHealth(0);
		}else{
			if(!p.getGameMode().equals(GameMode.CREATIVE)){
				p.setHealth(p.getHealth() - 6);
				
				p.sendMessage("§6[§eFireFFA§6] §fVotre vie a été drainée !");
				
				p.playSound(p.getLocation(), Sound.CHICKEN_HURT, 30, 30);
			}
		}
	}
	
	private static void heal(Player p){
		if(p.getHealth() >= 14){
			p.setHealth(20);
		}else{
			if(!p.getGameMode().equals(GameMode.CREATIVE)){
				p.setHealth(p.getHealth() + 6);
				
				p.sendMessage("§6[§eFireFFA§6] §fVous avez drainé de la vie !");
				
				p.playSound(p.getLocation(), Sound.CHICKEN_HURT, 30, 30);
			}
		}
	}

}
