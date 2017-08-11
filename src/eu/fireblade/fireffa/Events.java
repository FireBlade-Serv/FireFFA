package eu.fireblade.fireffa;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import eu.fireblade.fireffa.util.Tp;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.md_5.bungee.api.ChatColor;

public class Events implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		
		e.setJoinMessage("§6[§eFireFFA§6] §e"+p.getName()+"§f à rejoint le FireFFA !");
		
		Tp.tpSpawn(p);
		
		GlowstoneTitle gt = new GlowstoneTitle(p, "§6Bienvenue sur le FFA !", "§l"+p.getName(), 20, 50, 20);
		gt.send();
	}
	
	@EventHandler
	public void onRain(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		final Player p = e.getPlayer();
		
		e.setQuitMessage("§6[§eFireFFA§6] §e"+p.getName()+"§f à quitté le FireFFA !");
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player d = e.getEntity();
		Player p = d.getKiller();
		if (d.getType().equals(EntityType.PLAYER) && p.getType().equals(EntityType.PLAYER)) {
			p.setHealth(p.getHealth()+2);
			p.sendMessage(ChatColor.GOLD+"[FireFFA] "+ChatColor.RED+"La bravour dont vous avez fait preuve en tuant \""+ChatColor.WHITE+d.getName()+ChatColor.RED+"\" vous est récompensé, vous régénerez 2 coeurs.");
		}
	}
}
