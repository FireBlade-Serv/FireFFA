package eu.fireblade.fireffa.ability;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class Nuage implements Listener {
	
	public static HashMap<Player, Integer> tasks = new HashMap<Player, Integer>();

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
	
	public static void particles(final Player p, World w) {
		if(tasks.containsKey(p)) {
			Bukkit.getScheduler().cancelTask(tasks.get(p));
			
			tasks.remove(p);
		}
		
		tasks.put(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				PacketPlayOutWorldParticles ppowp = new PacketPlayOutWorldParticles(EnumParticle.EXPLOSION_NORMAL, true,
						(float) p.getLocation().getX(), (float) p.getLocation().getY() + 1, (float) p.getLocation().getZ(), 0, 0, 0, 0, 20);
				
				for(Player online : Bukkit.getOnlinePlayers()) {
					((CraftPlayer)online).getHandle().playerConnection.sendPacket(ppowp);
				}
			}
				
		}, 140L, 3L));
	}
}
