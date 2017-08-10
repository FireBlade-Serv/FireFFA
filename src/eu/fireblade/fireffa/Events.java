package eu.fireblade.fireffa;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Events implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		
		e.setJoinMessage("§e"+p.getName()+" à rejoint le FireFFA !");
		
		
	}
	
	@EventHandler
	public void onRain(WeatherChangeEvent e){
		e.setCancelled(true);
	}

}
