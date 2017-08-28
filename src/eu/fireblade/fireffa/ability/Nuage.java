package eu.fireblade.fireffa.ability;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import eu.fireblade.fireffa.Var;

public class Nuage implements Listener {

	@EventHandler
	public void onDamageEvent(EntityDamageEvent e) {
		final Entity entity = e.getEntity();
		final DamageCause cause = e.getCause();
		
		if(entity instanceof Player) {
			Player p = (Player) entity;
			if(Var.nuage.contains(p) && cause.equals(DamageCause.FALL)) {
				e.setCancelled(true);
			}
		}
	}
}
