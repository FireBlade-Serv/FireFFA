package eu.fireblade.fireffa.events;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class PlayerKillEvent extends Event {

	public static final HandlerList handlers = new HandlerList();
	
	private Player victim, killer;
	private ItemStack item;
	private World world;
	
	public PlayerKillEvent(Player victim, Player killer, ItemStack item, World world) {
		this.victim = victim;
		this.killer = killer;
		this.item = item;
		this.world = world;
	}
	
	public Player getPlayer(){
		return victim;
	}
	
	public Player getKiller(){
		return killer;
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
