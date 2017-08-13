package eu.fireblade.fireffa;


import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import eu.fireblade.fireffa.util.Scoreboard;
import eu.fireblade.fireffa.util.Tp;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand.EnumClientCommand;

public class Events implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		
		e.setJoinMessage("§6[§eFireFFA§6] §e"+p.getName()+"§f à rejoint le FireFFA !");
		
		Tp.tpSpawn(p);
		
		GlowstoneTitle gt = new GlowstoneTitle(p, "§6Bienvenue sur le FFA !", "§l"+p.getName(), 20, 50, 20);
		gt.send();
		
		Scoreboard.displayScoreboard(p);
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
	public void onDeath(PlayerDeathEvent e) {
		Player d = e.getEntity();
		Player p = d.getKiller();
		
		if (d.getType().equals(EntityType.PLAYER) && p.getType().equals(EntityType.PLAYER)) {
			if(d != p){
				p.setHealth(p.getHealth() + 5);
			}
		}
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

			@Override
			public void run() {
				if(p.isDead()){
					PacketPlayInClientCommand packet = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
					
					((CraftPlayer) p).getHandle().playerConnection.a(packet);
				}
			}
			
		});
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		Entity p = e.getEntity();
		if (p.getType().equals(EntityType.PLAYER) && Var.piaf.contains(p)) {
			if(e.getCause().equals(DamageCause.FALL)) {
				e.setCancelled(true);
			}
		}
	}		
}

