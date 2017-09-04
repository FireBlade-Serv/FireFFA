package eu.fireblade.fireffa.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.sql.SQLConnection;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldBorder;
import net.minecraft.server.v1_8_R3.WorldBorder;

public class Methods {
	
	public static void getConfig(){
		Var.host = Main.plugin.getConfig().getString("sqlhost");
		Var.user = Main.plugin.getConfig().getString("sqluser");
		Var.password = Main.plugin.getConfig().getString("sqlpassword");
		Var.db = Main.plugin.getConfig().getString("sqldb");
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
				for(Player online : getOnlinePlayers()) {
					if(online.getHealth() <= 5) {
						if(!wblist.contains(online)){
							WorldBorder w = new WorldBorder();
							w.setSize(1);
							w.setCenter(online.getLocation().getX() + 10_000, online.getLocation().getZ() + 10_000);
							
							PacketPlayOutWorldBorder packet = new PacketPlayOutWorldBorder(w, PacketPlayOutWorldBorder.EnumWorldBorderAction.INITIALIZE);
							
							((CraftPlayer) online).getHandle().playerConnection.sendPacket(packet);
							
							wblist.add(online);
						}
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
						Player target = NearbyPlayerLocationCalculator.getNearestPlayer(online);
						
						if(target != null) {
							online.setCompassTarget(target.getLocation());
						}
					}
				}
			}
			
		}, 0L, 1L);
	}
	
	public static void refreshRank(Player p) {
		int kills = SQLConnection.getKills(p);
		
		if(kills < 50) {
			//Vagabond
			
			
		}else if(kills >= 50 && kills < 150) {
			//Inquisiteur
			
			if(kills == 50) {
				Firework f = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
				
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffect(FireworkEffect.builder()
						
						.flicker(false)
						.trail(false)
						.with(Type.STAR)
						.withColor(Color.YELLOW)
						.build());
				
				fm.setPower(1);
				f.setFireworkMeta(fm);
				
				Bukkit.broadcastMessage("§6[§eFireFFA§6] §aBravo à "+p.getName()+" ! Il a désormait le grade §e§lInquisiteur §a!");
				
				IChatBaseComponent chat = ChatSerializer.a("{\"text\": \" §aVous avez désormais le grade §e§lInquisiteur §a! \"}");
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(chat, (byte) 2));
				p.playSound(p.getEyeLocation(), Sound.LEVEL_UP, 30, 30);
			}
		}else if(kills >= 150 && kills < 300) {
			//Meurtrier
			
			if(kills == 150) {
				Firework f = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
				
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffect(FireworkEffect.builder()
						
						.flicker(false)
						.trail(false)
						.with(Type.STAR)
						.withColor(Color.PURPLE)
						.build());
				
				fm.setPower(1);
				f.setFireworkMeta(fm);
				
				Bukkit.broadcastMessage("§6[§eFireFFA§6] §aBravo à §l"+p.getName()+"§a ! Il a désormait le grade §5§lMeurtrier §a!");
				
				IChatBaseComponent chat = ChatSerializer.a("{\"text\": \" §aVous avez désormais le grade §5§lMeurtrier §a! \"}");
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(chat, (byte) 2));
				p.playSound(p.getEyeLocation(), Sound.LEVEL_UP, 30, 30);
			}
		}else if(kills >= 300 && kills < 500) {
			//Mercenaire
			
			if(kills == 300) {
				Firework f = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
				
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffect(FireworkEffect.builder()
						
						.flicker(false)
						.trail(false)
						.with(Type.STAR)
						.withColor(Color.GREEN)
						.build());
				
				fm.setPower(1);
				f.setFireworkMeta(fm);
				
				Bukkit.broadcastMessage("§6[§eFireFFA§6] §aBravo à §l"+p.getName()+"§a ! Il a désormait le grade §lMercenaire §a!");
				
				IChatBaseComponent chat = ChatSerializer.a("{\"text\": \" §aVous avez désormais le grade §lMercenaire §a! \"}");
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(chat, (byte) 2));
				p.playSound(p.getEyeLocation(), Sound.LEVEL_UP, 30, 30);
			}
		}else if(kills >= 500 && kills < 800) {
			//Bourreau
			
			if(kills == 500) {
				Firework f = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
				
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffect(FireworkEffect.builder()
						
						.flicker(false)
						.trail(false)
						.with(Type.STAR)
						.withColor(Color.BLUE)
						.build());
				
				fm.setPower(1);
				f.setFireworkMeta(fm);
				
				Bukkit.broadcastMessage("§6[§eFireFFA§6] §aBravo à §l"+p.getName()+"§a ! Il a désormait le grade §5§lMeurtrier §a!");
				
				IChatBaseComponent chat = ChatSerializer.a("{\"text\": \" §aVous avez désormais le grade §5§lMeurtrier §a! \"}");
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(chat, (byte) 2));
				p.playSound(p.getEyeLocation(), Sound.LEVEL_UP, 30, 30);
			}
		}else if(kills >= 800 && kills < 1200) {
			//Executeur
			
			if(kills == 800) {
				Firework f = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
				
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffect(FireworkEffect.builder()
						
						.flicker(false)
						.trail(false)
						.with(Type.STAR)
						.withColor(Color.BLUE)
						.build());
				
				fm.setPower(1);
				f.setFireworkMeta(fm);
				
				Bukkit.broadcastMessage("§6[§eFireFFA§6] §aBravo à §l"+p.getName()+"§a ! Il a désormait le grade §5§lMeurtrier §a!");
				
				IChatBaseComponent chat = ChatSerializer.a("{\"text\": \" §aVous avez désormais le grade §5§lMeurtrier §a! \"}");
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(chat, (byte) 2));
				p.playSound(p.getEyeLocation(), Sound.LEVEL_UP, 30, 30);
			}
		}else if(kills >= 1200 && kills < 1700) {
			//Sanguinaire
			
		}else if(kills >= 1700 && kills < 2300) {
			//Massacreur
			
		}else if(kills >= 2300 && kills < 3000) {
			//Déchiqueteur
			
		}else if(kills >= 3000) {
			//DeathGod
			
		}
	}
	
	public static List<Player> getOnlinePlayers() {
	     List<Player> players = new ArrayList<Player>();
	     for(World world : Bukkit.getWorlds()) {
	          for(Player player : world.getPlayers()) {
	               players.add(player);
	          }
	     }
	     return players;
	}
}
