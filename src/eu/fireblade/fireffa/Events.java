package eu.fireblade.fireffa;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import eu.fireblade.fireffa.util.Tp;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand.EnumClientCommand;

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
	
	@EventHandler
	public void onInteract (PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		if(a.equals(Action.RIGHT_CLICK_AIR) && e.getMaterial().equals(Material.IRON_AXE) && eu.fireblade.fireffa.Var.d�molisseur.contains(p)){
			if(p.getInventory().containsAtLeast(eu.fireblade.fireffa.items.Kits.ItemGen(Material.FIREBALL, ChatColor.DARK_RED+"Boule de feu", null, 1), 1)) {
				p.launchProjectile(Fireball.class);
				p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 30, 30);
				p.getInventory().removeItem(eu.fireblade.fireffa.items.Kits.ItemGen(Material.FIREBALL, ChatColor.DARK_RED+"Boule de feu", null, 1));
			} else {
			p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
			p.sendMessage(ChatColor.GOLD+"[FireFFA] "+ChatColor.RED+"Vous n'avez plus de boule de feu.");
			}
		}
	}		
}

