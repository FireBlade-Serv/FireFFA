package eu.fireblade.fireffa.ability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class Invocation implements Listener {

	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	public static Map<Player, List<Block>> Oblocks = new HashMap<Player, List<Block>>();
	public static Map<Player, List<Location>> OLocs = new HashMap<Player, List<Location>>();
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void OnInteract(PlayerRightClickInteractEvent e) {
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
	
				if(Oblocks.containsKey(p)) {
					Oblocks.replace(p, new ArrayList<>());
				}else {
					Oblocks.put(p, new ArrayList<>());	
				}
				
				if(OLocs.containsKey(p)) {
					OLocs.replace(p, new ArrayList<>());
				}else {
					OLocs.put(p, new ArrayList<>());	
				}
				
				getBlockAtPlayer(p);
				
				List<Block> oblocks = Oblocks.get(p);
				List<Location> olocs = OLocs.get(p);
				
				for(int index = 0 ; index <= olocs.size() - 1 ; index++) {
					Block b = p.getWorld().getBlockAt(olocs.get(index));
					b.setType(oblocks.get(index).getType());
					b.setData(oblocks.get(index).getData());
				}
			}
		}
	}
	
	private static void getBlockAtPlayer(Player p) {	
		getBlockRelative(p, 5, -1, 0);
		getBlockRelative(p, 5, -1, -1);
		getBlockRelative(p, 5, -1, -2);
		getBlockRelative(p, 5, -1, 1);
		getBlockRelative(p, 5, -1, 2);
		getBlockRelative(p, 5, 0, 0);
		getBlockRelative(p, 5, 0, -1);
		getBlockRelative(p, 5, 0, -2);
		getBlockRelative(p, 5, 0, 1);
		getBlockRelative(p, 5, 0, 2);
		getBlockRelative(p, 5, 1, 0);
		getBlockRelative(p, 5, 1, -1);
		getBlockRelative(p, 5, 1, 1);
		getBlockRelative(p, -5, -1, 0);
		getBlockRelative(p, -5, -1, -1);
		getBlockRelative(p, -5, -1, -2);
		getBlockRelative(p, -5, -1, 1);
		getBlockRelative(p, -5, -1, 2);
		getBlockRelative(p, -5, 0, 0);
		getBlockRelative(p, -5, 0, -1);
		getBlockRelative(p, -5, 0, -2);
		getBlockRelative(p, -5, 0, 1);
		getBlockRelative(p, -5, 0, 2);
		getBlockRelative(p, -5, 1, 0);
		getBlockRelative(p, -5, 1, -1);
		getBlockRelative(p, -5, 1, 1);		
		getBlockRelative(p, 0, -1, 5);
		getBlockRelative(p, -1, -1, 5);
		getBlockRelative(p, -2, -1, 5);
		getBlockRelative(p, 1, -1, 5);
		getBlockRelative(p, 2, -1, 5);
		getBlockRelative(p, 0, 0, 5);
		getBlockRelative(p, -1, 0, 5);
		getBlockRelative(p, -2, 0, 5);
		getBlockRelative(p, 1, 0, 5);
		getBlockRelative(p, 2, 0, 5);
		getBlockRelative(p, 0, 1, 5);
		getBlockRelative(p, -1, 1, 5);
		getBlockRelative(p, 1, 1, 5);
		getBlockRelative(p, -1, -1, -5);
		getBlockRelative(p, -2, -1, -5);
		getBlockRelative(p, 1, -1, -5);
		getBlockRelative(p, 2, -1, -5);
		getBlockRelative(p, 0, 0, -5);
		getBlockRelative(p, -1, 0, -5);
		getBlockRelative(p, -2, 0, -5);
		getBlockRelative(p, 1, 0, -5);
		getBlockRelative(p, 2, 0, -5);
		getBlockRelative(p, 0, 1, -5);
		getBlockRelative(p, -1, 1, -5);
		getBlockRelative(p, 1, 1, -5);		
		getBlockRelative(p, 4, 2, 0);
		getBlockRelative(p, 4, 2, 1);
		getBlockRelative(p, 4, 2, 2);
		getBlockRelative(p, 4, 2, -1);
		getBlockRelative(p, 4, 2, -2);
		getBlockRelative(p, 4, 1, -2);
		getBlockRelative(p, 4, 1, 2);
		getBlockRelative(p, 4, 1, -3);
		getBlockRelative(p, 4, 1, 3);
		getBlockRelative(p, 4, 0, -3);
		getBlockRelative(p, 4, 0, 3);
		getBlockRelative(p, 4, -1, -3);
		getBlockRelative(p, 4, -1, 3);
		getBlockRelative(p, -4, 2, 0);
		getBlockRelative(p, -4, 2, 1);
		getBlockRelative(p, -4, 2, 2);
		getBlockRelative(p, -4, 2, -1);
		getBlockRelative(p, -4, 2, -2);
		getBlockRelative(p, -4, 1, -2);
		getBlockRelative(p, -4, 1, 2);
		getBlockRelative(p, -4, 1, -3);
		getBlockRelative(p, -4, 1, 3);
		getBlockRelative(p, -4, 0, -3);
		getBlockRelative(p, -4, 0, 3);
		getBlockRelative(p, -4, -1, -3);
		getBlockRelative(p, -4, -1, 3);		
		getBlockRelative(p, 0, 2, -4);
		getBlockRelative(p, 1, 2, -4);
		getBlockRelative(p, 2, 2, -4);
		getBlockRelative(p, -1, 2, -4);
		getBlockRelative(p, -2, 2, -4);
		getBlockRelative(p, -2, 1, -4);
		getBlockRelative(p, 2, 1, -4);
		getBlockRelative(p, -3, 1, -4);
		getBlockRelative(p, 3, 1, -4);
		getBlockRelative(p, -3, 0, -4);
		getBlockRelative(p, 3, 0, -4);
		getBlockRelative(p, -3, -1, -4);
		getBlockRelative(p, 3, -1, -4);
		getBlockRelative(p, 0, 2, 4);
		getBlockRelative(p, 1, 2, 4);
		getBlockRelative(p, 2, 2, 4);
		getBlockRelative(p, -1, 2, 4);
		getBlockRelative(p, -2, 2, 4);
		getBlockRelative(p, -2, 1, 4);
		getBlockRelative(p, 2, 1, 4);
		getBlockRelative(p, -3, 1, 4);
		getBlockRelative(p, 3, 1, 4);
		getBlockRelative(p, -3, 0, 4);
		getBlockRelative(p, 3, 0, 4);
		getBlockRelative(p, -3, -1, 4);
		getBlockRelative(p, 3, -1, 4);
		getBlockRelative(p, -3, 2, 3);
		getBlockRelative(p, -3, 2, -3);
		getBlockRelative(p, 3, 2, 3);
		getBlockRelative(p, 3, 2, -3);
		getBlockRelative(p, 0, 3, -3);
		getBlockRelative(p, 1, 3, -3);
		getBlockRelative(p, 2, 3, -3);
		getBlockRelative(p, -1, 3, -3);
		getBlockRelative(p, -2, 3, -3);
		getBlockRelative(p, -3, 3, 0);
		getBlockRelative(p, -3, 3, 1);
		getBlockRelative(p, -3, 3, 2);
		getBlockRelative(p, -3, 3, -1);
		getBlockRelative(p, -3, 3, -2);
		getBlockRelative(p, 0, 3, 3);
		getBlockRelative(p, 1, 3, 3);
		getBlockRelative(p, 2, 3, 3);
		getBlockRelative(p, -1, 3, 3);
		getBlockRelative(p, -2, 3, 3);
		getBlockRelative(p, 3, 3, 0);
		getBlockRelative(p, 3, 3, 1);
		getBlockRelative(p, 3, 3, 2);
		getBlockRelative(p, 3, 3, -1);
		getBlockRelative(p, 3, 3, -2);
		getBlockRelative(p, -2, 3, -2);
		getBlockRelative(p, 2, 3, -2);
		getBlockRelative(p, 2, 3, 2);
		getBlockRelative(p, -2, 3, 2);		
		getBlockRelative(p, 0, 4, -2);
		getBlockRelative(p, 1, 4, -2);
		getBlockRelative(p, -1, 4, -2);
		getBlockRelative(p, 0, 4, 2);
		getBlockRelative(p, 1, 4, 2);
		getBlockRelative(p, -1, 4, 2);
		getBlockRelative(p, -2, 4, 0);
		getBlockRelative(p, -2, 4, 1);
		getBlockRelative(p, -2, 4, -1);
		getBlockRelative(p, 2, 4, 0);
		getBlockRelative(p, 2, 4, 1);
		getBlockRelative(p, 2, 4, -1);
		getBlockRelative(p, -1, 4, 0);
		getBlockRelative(p, -1, 4, 1);
		getBlockRelative(p, -1, 4, -1);
		getBlockRelative(p, 1, 4, 0);
		getBlockRelative(p, 1, 4, 1);
		getBlockRelative(p, 1, 4, -1);
		getBlockRelative(p, 0, 4, -1);
		getBlockRelative(p, 1, 4, -1);
		getBlockRelative(p, -1, 4, -1);
		getBlockRelative(p, 0, 4, 1);
		getBlockRelative(p, 1, 4, 1);
		getBlockRelative(p, -1, 4, 1);
		getBlockRelative(p, 0, 4, 0);
 
	}
	
	private static Block getBlockRelative(Player p, int x, int y, int z){
	    Location newLoc = new Location(p.getWorld(), p.getLocation().getX() + x, p.getLocation().getY() + y, p.getLocation().getZ() + z);
	    
	    List<Block> list = Oblocks.get(p);
	    list.add(newLoc.getBlock());
	    
	    List<Location> list2 = OLocs.get(p);
	    list2.add(newLoc.getBlock().getLocation());
	    
	    Oblocks.replace(p, list);
	    OLocs.replace(p, list2);
	    
	    replace(newLoc.getBlock(), p.getWorld(), p);
	    
	    setIce(newLoc.getBlock());
	    
	    return newLoc.getBlock();
	}
	
	private static void setIce(Block b) {
		b.setType(Material.ICE);
	}
	
	private static void replace(Block old, World w, Player p) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				PacketPlayOutWorldParticles ppowp = new PacketPlayOutWorldParticles(EnumParticle.SMOKE_LARGE, true,
						(float) old.getLocation().getX(), (float) old.getLocation().getY(), (float) old.getLocation().getZ(), 1, 1, 1, 1, 20);
				
				for(Player online : Bukkit.getOnlinePlayers()) {
					((CraftPlayer)online).getHandle().playerConnection.sendPacket(ppowp);
				}
			}
			
		}, 200L);
	}
}
