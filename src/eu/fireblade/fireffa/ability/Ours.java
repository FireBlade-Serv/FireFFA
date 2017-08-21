package eu.fireblade.fireffa.ability;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent;

public class Ours implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractAtPlayerEvent e) {
		final Player p = e.getPlayer();
		final Player target = e.getTarget();
	}

}
