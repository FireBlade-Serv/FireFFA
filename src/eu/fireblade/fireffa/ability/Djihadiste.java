package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import eu.fireblade.fireffa.util.Methods;

public class Djihadiste implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		final ItemStack item = e.getItem();
		final World w = p.getWorld();
		
		if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)){
			if(Var.jihadist.contains(p) && item.equals(Kits.ItemGen(Material.REDSTONE, ChatColor.DARK_RED+"Allah akbar",
					Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Se faire exploser", ChatColor.BLUE+"Vous tue instantanément"), 1))){
				
				if(Var.jihadist.contains(p)){
					Entity primed = w.spawn(p.getLocation(), TNTPrimed.class);
					
					TNTPrimed tnt = (TNTPrimed) primed;
					final Location bloc = tnt.getLocation();
					
					tnt.setFuseTicks(5);
					tnt.setCustomName("§4ALLAH AKBAR !!!");
					tnt.setCustomNameVisible(true);
					tnt.setYield(6.5f);
					
					if(!p.getGameMode().equals(GameMode.CREATIVE)){
						p.setHealth(0);
					}
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							ArrayList<Block> locs = Methods.getBlocks(new Location(w, bloc.getX() - 12, bloc.getY(), bloc.getZ() - 12),
									new Location(w, bloc.getX() + 12, bloc.getY(), bloc.getZ() + 12));
							
							for(int i = 0 ; i <= 5 ; i++) {
								for(Block blocs : locs) {
									w.playEffect(blocs.getLocation(), Effect.EXPLOSION, 0);
								}
							}
						}
						
					}, 8L);
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
