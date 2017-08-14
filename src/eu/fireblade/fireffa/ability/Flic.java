package eu.fireblade.fireffa.ability;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import net.md_5.bungee.api.ChatColor;

public class Flic implements Listener {
	
	@EventHandler
	public void onInteract (PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		
		if((a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) && e.getItem().equals(
				Kits.ItemGen1(Material.STICK, Enchantment.DAMAGE_ALL, 3, ChatColor.DARK_BLUE+"Matraque", null, 1)) && Var.démolisseur.contains(p)){
			
			if(p.getInventory().containsAtLeast(Kits.ItemGen(Material.SNOW_BALL, ChatColor.DARK_BLUE+"Munition", null, 12), 1)) {
				p.launchProjectile(Fireball.class);
				p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 30, 30);
				p.getInventory().removeItem(Kits.ItemGen(Material.SNOW_BALL, ChatColor.DARK_BLUE+"Munition", null, 12));
			} else {
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				p.sendMessage(ChatColor.GOLD+"[§eFireFFA§6] "+ChatColor.RED+"Vous n'avez plus de munitions.");
			}
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		final Entity damager = e.getDamager();
		final Entity victime = e.getEntity();
		
		if(damager instanceof Snowball){
			Snowball ball = (Snowball) damager;
			
			Player p = (Player) ball.getShooter();
			
			if(Var.flic.contains(p)){
				if(victime instanceof Player){
					Player grosBoloss = (Player) victime;
					
					if(grosBoloss.getHealth() <= 3){
						grosBoloss.setHealth(0);
					}else{
						grosBoloss.setHealth(grosBoloss.getHealth() - 3);
					}
				}
			}
		}
	}

}
