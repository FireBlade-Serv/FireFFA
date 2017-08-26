package eu.fireblade.fireffa.ability;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Var;

public class Swap implements Listener {
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		Entity sb = e.getDamager();
		Entity t = e.getEntity();
		
		if(sb instanceof Snowball) {
			Snowball sball = (Snowball) sb;
			
			if (sball.getShooter() instanceof Player) {
				Player p = (Player) sball.getShooter();
				
				if(Var.swap.contains(p) && t instanceof Player) {
					Player target = (Player) t;
					
					Var.switchArray(p, target);
					
					ItemStack [] pItems = p.getInventory().getContents();
					ItemStack [] pArmor = p.getInventory().getArmorContents();
					ItemStack [] tItems = target.getInventory().getContents();
					ItemStack [] tArmor = target.getInventory().getArmorContents();
					
					target.sendMessage("§6[§eFireFFA§6] §cVotre kit à été swap par "+p.getName()+" !");
					p.sendMessage("§6[§eFireFFA§6] §aVous avez swap le kit de "+target.getName()+" !");
					
					p.playSound(p.getLocation(), Sound.SHEEP_SHEAR, 30, 30);
					target.playSound(target.getLocation(), Sound.PIG_DEATH, 30, 30);
					
					target.getInventory().setContents(pItems);
					target.getInventory().setArmorContents(pArmor);
					p.getInventory().setContents(tItems);
					p.getInventory().setArmorContents(tArmor);
				}
			}
		}
	}	
}
