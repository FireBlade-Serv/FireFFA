package eu.fireblade.fireffa;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import eu.fireblade.fireffa.util.Tp;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Events implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		
		e.setJoinMessage("�6[�eFireFFA�6] �e"+p.getName()+"�f � rejoint le FireFFA !");
		
		Tp.tpSpawn(p);
		
		GlowstoneTitle gt = new GlowstoneTitle(p, "�6Bienvenue sur le FFA !", "�l"+p.getName(), 20, 50, 20);
		gt.send();
	}
	
	@EventHandler
	public void onRain(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		final Player p = e.getPlayer();
		
		e.setQuitMessage("�6[�eFireFFA�6] �e"+p.getName()+"�f � quitt� le FireFFA !");
	}

}
