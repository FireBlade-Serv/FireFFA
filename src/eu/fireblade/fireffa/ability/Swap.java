package eu.fireblade.fireffa.ability;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.Inventory;

import eu.fireblade.fireffa.Var;

public class Swap implements Listener {
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		Entity sb = e.getDamager();
		Entity t = e.getEntity();
		
		if(sb instanceof Snowball) {
			Snowball sball = (Snowball) sb;
			if (((Snowball) sb).getShooter() instanceof Player) {
				Player p = (Player) sball.getShooter();
				if(Var.swap.contains(p) && t instanceof Player) {
					Player target = (Player) t;
					Inventory invp = p.getInventory();
					Inventory invt = target.getInventory();
					p.getInventory().clear();
					target.getInventory().clear();
					for (int nbr = 0 ; nbr < 40 ; nbr++) {
						p.getInventory().setItem(nbr, invt.getItem(nbr));
					}
					for (int nbr = 0 ; nbr < 40 ; nbr++) {
						target.getInventory().setItem(nbr, invp.getItem(nbr));
					}
					Var.switchArray(p, target);
				}
			}
		}
	}	
}
