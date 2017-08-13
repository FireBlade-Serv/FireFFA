package eu.fireblade.fireffa.ability;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;

public class Fantôme implements Listener {
	
	private static HashMap<Player, Long> cooldown = new HashMap<Player, Long>();
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		final ItemStack item = e.getItem();
		
		if((a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) && item.equals(Kits.ItemGen(Material.BLAZE_ROD, ChatColor.GRAY+"Warp stick",
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Téléporte", ChatColor.BLUE+"Utilisable toute les minutes"), 1)) && Var.fantôme.contains(p)){
			
			if(cooldown.containsKey(p)){
				long rest = ((cooldown.get(p) + 5) / 1000) - (System.currentTimeMillis() / 1000);
				
				if(rest > 0){
					p.sendMessage(ChatColor.GOLD+"[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
					
					return;
				}else{
					cooldown.remove(p);
					
					applyVector(p);
				}
			}else{
				cooldown.put(p, System.currentTimeMillis());
				
				applyVector(p);
			}
		}
	}
	
	private static void applyVector(Player p){
		Vector vector = p.getLocation().getDirection().multiply(4);
		vector.setX(1);
		vector.setZ(1);
		
		p.setVelocity(vector);
	}

}
