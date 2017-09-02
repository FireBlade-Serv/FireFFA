package eu.fireblade.fireffa.ability;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
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

import eu.fireblade.fireffa.Main;
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
					tnt.setYield(6.5f);
					
					if(!p.getGameMode().equals(GameMode.CREATIVE)){
						p.setHealth(0);
					}
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							Location bloc = p.getLocation();
							
							Location nl = new Location(w, bloc.getX(), bloc.getZ(), bloc.getZ() - 1);
							Location sl = new Location(w, bloc.getX(), bloc.getY(), bloc.getZ() + 1);
							Location wl = new Location(w, bloc.getX() - 1, bloc.getY(), bloc.getZ());
							Location el = new Location(w, bloc.getX() + 1, bloc.getY(), bloc.getZ());
							
							double nlp = nl.getZ(), slp = sl.getZ(), wlp = wl.getX(), elp = el.getX();
							
							for(int i = 0 ; i <= 50 ; i++) {
								//n
								w.playEffect(new Location(w, nl.getX(), nl.getY(), nlp), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, nl.getX(), nl.getY(), nlp - 1), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, nl.getX(), nl.getY(), nlp - 2), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, nl.getX(), nl.getY(), nlp - 3), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, nl.getX(), nl.getY(), nlp - 4), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, nl.getX(), nl.getY(), nlp - 5), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, nl.getX(), nl.getY(), nlp - 6), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, nl.getX(), nl.getY(), nlp - 7), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, nl.getX(), nl.getY(), nlp - 8), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, nl.getX(), nl.getY(), nlp - 9), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, nl.getX(), nl.getY(), nlp - 10), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, nl.getX(), nl.getY(), nlp - 11), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, nl.getX(), nl.getY(), nlp - 12), Effect.VILLAGER_THUNDERCLOUD, 0);
								
								//s
								w.playEffect(new Location(w, sl.getX(), sl.getY(), slp), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, sl.getX(), sl.getY(), slp + 1), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, sl.getX(), sl.getY(), slp + 2), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, sl.getX(), sl.getY(), slp + 3), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, sl.getX(), sl.getY(), slp + 4), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, sl.getX(), sl.getY(), slp + 5), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, sl.getX(), sl.getY(), slp + 6), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, sl.getX(), sl.getY(), slp + 7), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, sl.getX(), sl.getY(), slp + 8), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, sl.getX(), sl.getY(), slp + 9), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, sl.getX(), sl.getY(), slp + 10), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, sl.getX(), sl.getY(), slp + 11), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, sl.getX(), sl.getY(), slp + 12), Effect.VILLAGER_THUNDERCLOUD, 0);
								
								//w
								w.playEffect(new Location(w, wlp, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, wlp - 1, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, wlp - 2, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, wlp - 3, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, wlp - 4, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, wlp - 5, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, wlp - 6, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, wlp - 7, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, wlp - 8, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, wlp - 9, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, wlp - 10, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, wlp - 11, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, wlp - 12, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								
								//e
								w.playEffect(new Location(w, elp, wl.getY(), wl.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, elp + 1, el.getY(), el.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, elp + 2, el.getY(), el.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, elp + 3, el.getY(), el.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, elp + 4, el.getY(), el.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, elp + 5, el.getY(), el.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, elp + 6, el.getY(), el.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, elp + 7, el.getY(), el.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, elp + 8, el.getY(), el.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, elp + 9, el.getY(), el.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, elp + 10, el.getY(), el.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, elp + 11, el.getY(), el.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
								w.playEffect(new Location(w, elp + 12, el.getY(), el.getZ()), Effect.VILLAGER_THUNDERCLOUD, 0);
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
