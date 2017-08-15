package eu.fireblade.fireffa.ability;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;

public class Djihadiste implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		final ItemStack item = e.getItem();
		final World w = p.getWorld();
		
		if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)){
			if(item.equals(Kits.ItemGen(Material.REDSTONE, ChatColor.DARK_RED+"Allah akbar",
					Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Se faire exploser", ChatColor.BLUE+"Vous tue instantanément"), 1))){
				
				if(Var.jihadist.contains(p)){
					Entity primed = w.spawn(p.getLocation(), TNTPrimed.class);
					
					TNTPrimed tnt = (TNTPrimed) primed;
					
					tnt.setFuseTicks(5);
					tnt.setCustomName("§4ALLAH AKBAR !!!");
					tnt.setCustomNameVisible(true);
					
					p.setHealth(0);
				}
			}
		}
	}
	
	@EventHandler
	public void onExplode(EntityExplodeEvent e){
		final Entity entity = e.getEntity();
		
		if(entity instanceof TNTPrimed){
			e.setCancelled(true);
		}
	}
}
