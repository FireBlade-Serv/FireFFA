package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Fantôme implements Listener {
	
	private static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		final ItemStack item = e.getItem();
		
		if((a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) && item.equals(Kits.ItemGen(Material.BLAZE_ROD, ChatColor.GRAY+"Warp stick",
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Téléporte", ChatColor.BLUE+"Utilisable toute les minutes"), 1)) && Var.fantôme.contains(p)){
			
			if(cooldown.contains(p)) {
				p.sendMessage(ChatColor.GOLD+"[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				
				return;
			}else {
				applyVector(p);
				
				p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 30, 30);
				
				cooldown.add(p);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						if(Var.fantôme.contains(p)){
							GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre attaque est prête !", 20, 30, 20);
							gt.send();
							
							p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
						}
						
						cooldown.remove(p);
					}
					
				}, 300L);
			}
		}
	}
	
	private static void applyVector(Player p){
		Vector vector = p.getLocation().getDirection().multiply(3);
		
		
		p.setVelocity(vector);
	}

}
