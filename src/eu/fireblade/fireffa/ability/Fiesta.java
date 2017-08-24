package eu.fireblade.fireffa.ability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;

public class Fiesta implements Listener {
	
	private static ArrayList<Player> cooldown = new ArrayList<Player>();
	private static ArrayList<Player> playeronarea = new ArrayList<Player>();
	
	private static Map<Player, Location> loc = new HashMap<Player, Location>();
	
	@EventHandler
	public void OnClick(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack i = e.getItem();
		
		if (Var.fiesta.contains(p) && i.equals(Kits.ItemGen2(Material.ARROW, Enchantment.DAMAGE_ALL, 2, Enchantment.KNOCKBACK, 3, "§9Cotillon", 
				Kits.LoreCreator("§9Clique Droit - tp les joueurs sur 10 blocs", "§940 secodnes de récupération"), 1))) {
						
			if(cooldown.contains(p)){
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
				return;
			}else {
				for (Entity onarea : p.getNearbyEntities(20, 20, 20)) {
					if(onarea.getType().equals(EntityType.PLAYER)) {
						Player ponarea = (Player) onarea;
						playeronarea.add(ponarea);
					}
				} 
				
				playeronarea.add(p);
				
				for (Player inList : playeronarea) {
					loc.put(inList, inList.getLocation());
					playeronarea.remove(0);
				}
			}
		}	
	}
}
