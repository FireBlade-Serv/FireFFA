package eu.fireblade.fireffa.aptitudes;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import net.md_5.bungee.api.ChatColor;

public class Démolisseur implements Listener {

	@EventHandler
	public void onInteract (PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		
		if(a.equals(Action.RIGHT_CLICK_AIR) && e.getMaterial().equals(Material.IRON_AXE) && Var.démolisseur.contains(p)){
			if(p.getInventory().containsAtLeast(Kits.ItemGen(Material.FIREBALL, ChatColor.DARK_RED+"Boule de feu", null, 1), 1)) {
				p.launchProjectile(Fireball.class);
				p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 30, 30);
				p.getInventory().removeItem(Kits.ItemGen(Material.FIREBALL, ChatColor.DARK_RED+"Boule de feu", null, 1));
			} else {
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				p.sendMessage(ChatColor.GOLD+"[FireFFA] "+ChatColor.RED+"Vous n'avez plus de boule de feu.");
			}
		}
	}
	
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent e){
		final Entity entity = e.getEntity();
		
		if(entity instanceof Fireball){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onEntityFire(ExplosionPrimeEvent e){
		final Entity entity = e.getEntity();
		
		if(entity instanceof Fireball){
			e.setFire(false);
		}
	}
	
}
