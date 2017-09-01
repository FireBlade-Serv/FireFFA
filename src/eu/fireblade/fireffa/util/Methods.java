package eu.fireblade.fireffa.util;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldBorder;
import net.minecraft.server.v1_8_R3.WorldBorder;

public class Methods {
	
	public static void getConfig(){
		Var.host = Main.plugin.getConfig().getString("sqlhost");
		Var.user = Main.plugin.getConfig().getString("sqluser");
		Var.password = Main.plugin.getConfig().getString("sqlpassword");
	}
	
	public static ArrayList<Block> getBlocks(Location loc1, Location loc2){
		ArrayList<Block> blocks = new ArrayList<Block>();
		
		int topBlockX = (loc1.getBlockX() < loc2.getBlockX() ? loc2.getBlockX() : loc1.getBlockX());
        int bottomBlockX = (loc1.getBlockX() > loc2.getBlockX() ? loc2.getBlockX() : loc1.getBlockX());
 
        int topBlockY = (loc1.getBlockY() < loc2.getBlockY() ? loc2.getBlockY() : loc1.getBlockY());
        int bottomBlockY = (loc1.getBlockY() > loc2.getBlockY() ? loc2.getBlockY() : loc1.getBlockY());
 
        int topBlockZ = (loc1.getBlockZ() < loc2.getBlockZ() ? loc2.getBlockZ() : loc1.getBlockZ());
        int bottomBlockZ = (loc1.getBlockZ() > loc2.getBlockZ() ? loc2.getBlockZ() : loc1.getBlockZ());
 
        for(int x = bottomBlockX; x <= topBlockX; x++){
            for(int z = bottomBlockZ; z <= topBlockZ; z++){
                for(int y = bottomBlockY; y <= topBlockY; y++){
                	
                    Block block = loc1.getWorld().getBlockAt(x, y, z);
                   
                    blocks.add(block);
                }
            }
        }
       
        return blocks;
	}

	public static void schedulerUtils() {
		ArrayList<Player> wblist = new ArrayList<Player>();
		
		Var.wbtask = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				for(Player online : Bukkit.getOnlinePlayers()) {
					if(online.getHealth() <= 5) {
						WorldBorder w = new WorldBorder();
						w.setSize(1);
						w.setCenter(online.getLocation().getX() + 10_000, online.getLocation().getZ() + 10_000);
						
						PacketPlayOutWorldBorder packet = new PacketPlayOutWorldBorder(w, PacketPlayOutWorldBorder.EnumWorldBorderAction.INITIALIZE);
						
						((CraftPlayer) online).getHandle().playerConnection.sendPacket(packet);
						
						wblist.add(online);
					}else {
						if(wblist.contains(online)) {
							WorldBorder w = new WorldBorder();
							
							w.setSize(30_000_000);
							w.setCenter(online.getLocation().getX(), online.getLocation().getZ());
							
							PacketPlayOutWorldBorder packet = new PacketPlayOutWorldBorder(w, PacketPlayOutWorldBorder.EnumWorldBorderAction.INITIALIZE);
							((CraftPlayer)online).getHandle().playerConnection.sendPacket(packet);
							
							wblist.remove(online);
						}
					}
					
					if(Var.inGame.contains(online)) {
						online.setCompassTarget(NearbyPlayerLocationCalculator.getNearestPlayer(online).getLocation());
					}
				}
			}
			
		}, 0L, 1L);
	}
	
	
}
