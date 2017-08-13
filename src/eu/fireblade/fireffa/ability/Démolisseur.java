package eu.fireblade.fireffa.ability;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
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
		
		if((a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) && e.getItem().equals(Kits.ItemGen2(Material.IRON_AXE, Enchantment.DAMAGE_ALL, 1, 
				Enchantment.KNOCKBACK, 2, ChatColor.DARK_RED+"Hache de guerre",
				Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Boule de feu", ChatColor.BLUE+"Consomme une boule de feu"), 1)) && Var.démolisseur.contains(p)){
			
			if(p.getInventory().containsAtLeast(Kits.ItemGen(Material.FIREBALL, ChatColor.DARK_RED+"Boule de feu", null, 1), 1)) {
				p.launchProjectile(Fireball.class);
				p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 30, 30);
				p.getInventory().removeItem(Kits.ItemGen(Material.FIREBALL, ChatColor.DARK_RED+"Boule de feu", null, 1));
			} else {
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				p.sendMessage(ChatColor.GOLD+"[§eFireFFA§6] "+ChatColor.RED+"Vous n'avez plus de boule de feu.");
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
