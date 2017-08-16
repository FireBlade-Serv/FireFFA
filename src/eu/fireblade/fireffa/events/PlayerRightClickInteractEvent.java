package eu.fireblade.fireffa.events;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class PlayerRightClickInteractEvent extends Event {

	public static final HandlerList handlers = new HandlerList();
	
	private Player p;
	private ItemStack item;
	private World world;
	
	public PlayerRightClickInteractEvent(Player p, ItemStack item, World world) {
		this.p = p;
		this.item = item;
		this.world = world;
	}
	
	public Player getPlayer(){
		return p;
	}
	
	public ItemStack getItem(){
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
