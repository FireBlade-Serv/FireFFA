package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import eu.fireblade.fireffa.util.Methods;

public class Invocation implements Listener {

	ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void OnInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack i = e.getItem();
		
		if(Var.invocation.contains(p) && i.equals(Kits.ItemGen1(Material.STICK, Enchantment.DAMAGE_ALL, 1, "§9Invocation Stick", 
				Kits.LoreCreator("§9Clique Droit - invoque un bouclier pendant 10s", "§945 secondes de récupération"), 1))) {
			if(cooldown.contains(p)) {
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				
				return;
			}else {
				cooldown.add(p);
				Location loc1 = new Location(p.getWorld(), p.getLocation().getX()+5, p.getLocation().getY()+5, p.getLocation().getZ()+5);
				Location loc2 = new Location(p.getWorld(), p.getLocation().getX()-5, p.getLocation().getY(), p.getLocation().getZ()-5);
				Methods.getBlocks(loc1, loc2);
				getBlockAtPlayer(p);
			}
		}
	}
	
	private static void getBlockAtPlayer(Player p) {	
		getBlockRelative(p.getLocation(), 5, -1, 0);
		getBlockRelative(p.getLocation(), 5, -1, -1);
		getBlockRelative(p.getLocation(), 5, -1, -2);
		getBlockRelative(p.getLocation(), 5, -1, 1);
		getBlockRelative(p.getLocation(), 5, -1, 2);
		getBlockRelative(p.getLocation(), 5, 0, 0);
		getBlockRelative(p.getLocation(), 5, 0, -1);
		getBlockRelative(p.getLocation(), 5, 0, -2);
		getBlockRelative(p.getLocation(), 5, 0, 1);
		getBlockRelative(p.getLocation(), 5, 0, 2);
		getBlockRelative(p.getLocation(), 5, 1, 0);
		getBlockRelative(p.getLocation(), 5, 1, -1);
		getBlockRelative(p.getLocation(), 5, 1, 1);
		getBlockRelative(p.getLocation(), -5, -1, 0);
		getBlockRelative(p.getLocation(), -5, -1, -1);
		getBlockRelative(p.getLocation(), -5, -1, -2);
		getBlockRelative(p.getLocation(), -5, -1, 1);
		getBlockRelative(p.getLocation(), -5, -1, 2);
		getBlockRelative(p.getLocation(), -5, 0, 0);
		getBlockRelative(p.getLocation(), -5, 0, -1);
		getBlockRelative(p.getLocation(), -5, 0, -2);
		getBlockRelative(p.getLocation(), -5, 0, 1);
		getBlockRelative(p.getLocation(), -5, 0, 2);
		getBlockRelative(p.getLocation(), -5, 1, 0);
		getBlockRelative(p.getLocation(), -5, 1, -1);
		getBlockRelative(p.getLocation(), -5, 1, 1);		
		getBlockRelative(p.getLocation(), 0, -1, 5);
		getBlockRelative(p.getLocation(), -1, -1, 5);
		getBlockRelative(p.getLocation(), -2, -1, 5);
		getBlockRelative(p.getLocation(), 1, -1, 5);
		getBlockRelative(p.getLocation(), 2, -1, 5);
		getBlockRelative(p.getLocation(), 0, 0, 5);
		getBlockRelative(p.getLocation(), -1, 0, 5);
		getBlockRelative(p.getLocation(), -2, 0, 5);
		getBlockRelative(p.getLocation(), 1, 0, 5);
		getBlockRelative(p.getLocation(), 2, 0, 5);
		getBlockRelative(p.getLocation(), 0, 1, 5);
		getBlockRelative(p.getLocation(), -1, 1, 5);
		getBlockRelative(p.getLocation(), 1, 1, 5);
		getBlockRelative(p.getLocation(), -1, -1, -5);
		getBlockRelative(p.getLocation(), -2, -1, -5);
		getBlockRelative(p.getLocation(), 1, -1, -5);
		getBlockRelative(p.getLocation(), 2, -1, -5);
		getBlockRelative(p.getLocation(), 0, 0, -5);
		getBlockRelative(p.getLocation(), -1, 0, -5);
		getBlockRelative(p.getLocation(), -2, 0, -5);
		getBlockRelative(p.getLocation(), 1, 0, -5);
		getBlockRelative(p.getLocation(), 2, 0, -5);
		getBlockRelative(p.getLocation(), 0, 1, -5);
		getBlockRelative(p.getLocation(), -1, 1, -5);
		getBlockRelative(p.getLocation(), 1, 1, -5);		
		getBlockRelative(p.getLocation(), 4, 2, 0);
		getBlockRelative(p.getLocation(), 4, 2, 1);
		getBlockRelative(p.getLocation(), 4, 2, 2);
		getBlockRelative(p.getLocation(), 4, 2, -1);
		getBlockRelative(p.getLocation(), 4, 2, -2);
		getBlockRelative(p.getLocation(), 4, 1, -2);
		getBlockRelative(p.getLocation(), 4, 1, 2);
		getBlockRelative(p.getLocation(), 4, 1, -3);
		getBlockRelative(p.getLocation(), 4, 1, 3);
		getBlockRelative(p.getLocation(), 4, 0, -3);
		getBlockRelative(p.getLocation(), 4, 0, 3);
		getBlockRelative(p.getLocation(), 4, -1, -3);
		getBlockRelative(p.getLocation(), 4, -1, 3);
		getBlockRelative(p.getLocation(), -4, 2, 0);
		getBlockRelative(p.getLocation(), -4, 2, 1);
		getBlockRelative(p.getLocation(), -4, 2, 2);
		getBlockRelative(p.getLocation(), -4, 2, -1);
		getBlockRelative(p.getLocation(), -4, 2, -2);
		getBlockRelative(p.getLocation(), -4, 1, -2);
		getBlockRelative(p.getLocation(), -4, 1, 2);
		getBlockRelative(p.getLocation(), -4, 1, -3);
		getBlockRelative(p.getLocation(), -4, 1, 3);
		getBlockRelative(p.getLocation(), -4, 0, -3);
		getBlockRelative(p.getLocation(), -4, 0, 3);
		getBlockRelative(p.getLocation(), -4, -1, -3);
		getBlockRelative(p.getLocation(), -4, -1, 3);		
		getBlockRelative(p.getLocation(), 0, 2, -4);
		getBlockRelative(p.getLocation(), 1, 2, -4);
		getBlockRelative(p.getLocation(), 2, 2, -4);
		getBlockRelative(p.getLocation(), -1, 2, -4);
		getBlockRelative(p.getLocation(), -2, 2, -4);
		getBlockRelative(p.getLocation(), -2, 1, -4);
		getBlockRelative(p.getLocation(), 2, 1, -4);
		getBlockRelative(p.getLocation(), -3, 1, -4);
		getBlockRelative(p.getLocation(), 3, 1, -4);
		getBlockRelative(p.getLocation(), -3, 0, -4);
		getBlockRelative(p.getLocation(), 3, 0, -4);
		getBlockRelative(p.getLocation(), -3, -1, -4);
		getBlockRelative(p.getLocation(), 3, -1, -4);
		getBlockRelative(p.getLocation(), 0, 2, 4);
		getBlockRelative(p.getLocation(), 1, 2, 4);
		getBlockRelative(p.getLocation(), 2, 2, 4);
		getBlockRelative(p.getLocation(), -1, 2, 4);
		getBlockRelative(p.getLocation(), -2, 2, 4);
		getBlockRelative(p.getLocation(), -2, 1, 4);
		getBlockRelative(p.getLocation(), 2, 1, 4);
		getBlockRelative(p.getLocation(), -3, 1, 4);
		getBlockRelative(p.getLocation(), 3, 1, 4);
		getBlockRelative(p.getLocation(), -3, 0, 4);
		getBlockRelative(p.getLocation(), 3, 0, 4);
		getBlockRelative(p.getLocation(), -3, -1, 4);
		getBlockRelative(p.getLocation(), 3, -1, 4);
		getBlockRelative(p.getLocation(), -3, 2, 3);
		getBlockRelative(p.getLocation(), -3, 2, -3);
		getBlockRelative(p.getLocation(), 3, 2, 3);
		getBlockRelative(p.getLocation(), 3, 2, -3);
		getBlockRelative(p.getLocation(), 0, 3, -3);
		getBlockRelative(p.getLocation(), 1, 3, -3);
		getBlockRelative(p.getLocation(), 2, 3, -3);
		getBlockRelative(p.getLocation(), -1, 3, -3);
		getBlockRelative(p.getLocation(), -2, 3, -3);
		getBlockRelative(p.getLocation(), -3, 3, 0);
		getBlockRelative(p.getLocation(), -3, 3, 1);
		getBlockRelative(p.getLocation(), -3, 3, 2);
		getBlockRelative(p.getLocation(), -3, 3, -1);
		getBlockRelative(p.getLocation(), -3, 3, -2);
		getBlockRelative(p.getLocation(), 0, 3, 3);
		getBlockRelative(p.getLocation(), 1, 3, 3);
		getBlockRelative(p.getLocation(), 2, 3, 3);
		getBlockRelative(p.getLocation(), -1, 3, 3);
		getBlockRelative(p.getLocation(), -2, 3, 3);
		getBlockRelative(p.getLocation(), 3, 3, 0);
		getBlockRelative(p.getLocation(), 3, 3, 1);
		getBlockRelative(p.getLocation(), 3, 3, 2);
		getBlockRelative(p.getLocation(), 3, 3, -1);
		getBlockRelative(p.getLocation(), 3, 3, -2);
		getBlockRelative(p.getLocation(), -2, 3, -2);
		getBlockRelative(p.getLocation(), 2, 3, -2);
		getBlockRelative(p.getLocation(), 2, 3, 2);
		getBlockRelative(p.getLocation(), -2, 3, 2);		
		getBlockRelative(p.getLocation(), 0, 4, -2);
		getBlockRelative(p.getLocation(), 1, 4, -2);
		getBlockRelative(p.getLocation(), -1, 4, -2);
		getBlockRelative(p.getLocation(), 0, 4, 2);
		getBlockRelative(p.getLocation(), 1, 4, 2);
		getBlockRelative(p.getLocation(), -1, 4, 2);
		getBlockRelative(p.getLocation(), -2, 4, 0);
		getBlockRelative(p.getLocation(), -2, 4, 1);
		getBlockRelative(p.getLocation(), -2, 4, -1);
		getBlockRelative(p.getLocation(), 2, 4, 0);
		getBlockRelative(p.getLocation(), 2, 4, 1);
		getBlockRelative(p.getLocation(), 2, 4, -1);
		getBlockRelative(p.getLocation(), -1, 4, 0);
		getBlockRelative(p.getLocation(), -1, 4, 1);
		getBlockRelative(p.getLocation(), -1, 4, -1);
		getBlockRelative(p.getLocation(), 1, 4, 0);
		getBlockRelative(p.getLocation(), 1, 4, 1);
		getBlockRelative(p.getLocation(), 1, 4, -1);
		getBlockRelative(p.getLocation(), 0, 4, -1);
		getBlockRelative(p.getLocation(), 1, 4, -1);
		getBlockRelative(p.getLocation(), -1, 4, -1);
		getBlockRelative(p.getLocation(), 0, 4, 1);
		getBlockRelative(p.getLocation(), 1, 4, 1);
		getBlockRelative(p.getLocation(), -1, 4, 1);
		getBlockRelative(p.getLocation(), 0, 4, 0);
 
	}
	
	private static void getBlockRelative(Location loc, int x, int y, int z){
	    Location newLoc = new Location(loc.getWorld(), loc.getX() + x, loc.getY() + y, loc.getZ() + z);
	    Block b = newLoc.getBlock();
	    b.setType(Material.ICE);
	}
}
