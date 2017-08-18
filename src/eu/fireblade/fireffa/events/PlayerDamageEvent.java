package eu.fireblade.fireffa.events;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class PlayerDamageEvent extends Event {
	
	public static final HandlerList handlers = new HandlerList();
	
	private Player p;
	private World w;
	private double damage;
	private DamageCause cause;

	public PlayerDamageEvent(Player p, World w, double damage, DamageCause cause) {
		this.p = p;
		this.w = w;
		this.damage = damage;
		this.cause = cause;
	}
	
	public Player getPlayer() {
		return p;
	}

	public World getWorld() {
		return w;
	}
	
	public double getDamage() {
		return damage;
	}
	
	public DamageCause getCause() {
		return cause;
	}
	
	public HandlerList getHandlers(){
		return handlers;
	}
	
	public static HandlerList getHandlerList(){
		return handlers;
	}

}
