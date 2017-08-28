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
	public static Map<Player, List<Block>> Nblocks = new HashMap<Player, List<Block>>();
	
	
	@EventHandler
	public void OnInteract(PlayerRightClickInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack i = e.getItem();
		
		if(Var.invocation.contains(p) && i.equals(Kits.ItemGen1(Material.STICK, Enchantment.DAMAGE_ALL, 1, "�9Invocation Stick", 
				Kits.LoreCreator("�9Clique Droit - invoque un bouclier pendant 10s", "�945 secondes de r�cup�ration"), 1))) {
			if(cooldown.contains(p)) {
				p.sendMessage(ChatColor.GOLD+"�6[�eFireFFA�6] "+ChatColor.RED+"Vous �tes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				
				return;
			}else {
	
				if(Oblocks.containsKey(p)) {
					Oblocks.replace(p, new ArrayList<>());
				}else {
					Oblocks.put(p, new ArrayList<>());	
				}
				
				if(Nblocks.containsKey(p)) {
					Nblocks.replace(p, new ArrayList<>());
				}else {
					Nblocks.put(p, new ArrayList<>());	
				}
				
				getBlockAtPlayer(p);
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
	
	@SuppressWarnings("deprecation")
	private static void getBlockRelative(Player p, int x, int y, int z){
	    Location newLoc = new Location(p.getWorld(), p.getLocation().getX() + x, p.getLocation().getY() + y, p.getLocation().getZ() + z);
	    
	    final Material oldm = newLoc.getBlock().getType();
		final byte oldb = newLoc.getBlock().getData();
	    
	    Block newb = newLoc.getBlock();
	    
	    newb.setType(Material.ICE);
	    
	    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				newb.setType(oldm);
				newb.setData(oldb);
				
				Bukkit.broadcastMessage("�6oldb type -> "+oldm.toString()+" �9newb type -> "+newb.getType().toString());
				
				PacketPlayOutWorldParticles ppowp = new PacketPlayOutWorldParticles(EnumParticle.SMOKE_LARGE, true,
						(float) newb.getLocation().getX(), (float) newb.getLocation().getY(), (float) newb.getLocation().getZ(), 1, 1, 1, 1, 20);
				
				for(Player online : Bukkit.getOnlinePlayers()) {
					((CraftPlayer)online).getHandle().playerConnection.sendPacket(ppowp);
				}
			}
			
		}, 200L);
	}
}
