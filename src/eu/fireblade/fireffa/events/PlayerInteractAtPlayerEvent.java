package eu.fireblade.fireffa.events;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractAtPlayerEvent extends Event {

	public static final HandlerList handlers = new HandlerList();
	
	private Player p, target;
	private ItemStack item;
	private World world;
	
	public PlayerInteractAtPlayerEvent(Player p, Player target, ItemStack item, World world) {
		this.p = p;
		this.target = target;
		this.item = item;
		this.world = world;
	}
	
	public Player getPlayer(){
		return p;
	}
	
	public Player getTarget(){
		return target;
	}
	
	public ItemStack getItemInHand(){
		return item;
	}
	
	public World getWorld(){
		return world;
	}
	
	public HandlerList getHandlers(){
		return handlers;
	}
	
	public static HandlerList getHandlerList(){
		return handlers;
	}
}
