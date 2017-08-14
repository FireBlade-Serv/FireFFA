package eu.fireblade.fireffa;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import eu.fireblade.fireffa.cmd.GUI;
import eu.fireblade.fireffa.items.Kits;
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
		Entity victime = e.getEntity();
		
		if(!(victime instanceof Player)){
			return;
		}
		
		Player p = (Player) victime;
		Player jawad = p.getKiller();
		
		if(!jawad.equals(p)){
			if(jawad.getHealth() >= 14){
				jawad.setHealth(jawad.getMaxHealth());
			}else{
				jawad.setHealth(jawad.getHealth() + 6);
			}
		}
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){
			
            public void run(){
                if(p.isDead()){
                	 ((CraftPlayer) p).getHandle().playerConnection.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));
                }
            }
            
        });
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

			@Override
			public void run() {
				Tp.tpSpawn(p);
				
				Kits.Clear(p);
				
				GUI.mainMenu(p);
			}
			
		}, 10L);
	}	
}

