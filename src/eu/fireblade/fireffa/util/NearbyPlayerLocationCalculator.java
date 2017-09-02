package eu.fireblade.fireffa.util;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class NearbyPlayerLocationCalculator implements Listener {
	
	/*
	private static Player near;
	private static double dist;
	
	public static Direction getDirection(Player p) {		
		if(Var.inGame.contains(p)) {
			double closest = Double.MAX_VALUE;
			Player t = null;
			
			for(Player i : Bukkit.getOnlinePlayers()){
				double distance = i.getLocation().distance(p.getLocation());
				
				if (closest == Double.MAX_VALUE || dist < closest){
					closest = dist;
					t = i;
					
					near = t;
					dist = distance;
					
					break;
				}
			}
			
			if (t == null){
			  return Direction.NOTHING;
			}
			
			if (p.getLocation().getX() == t.getLocation().getX() && p.getLocation().getY() > t.getLocation().getY()) {
				// Nord
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Nord
					
					return Direction.NORTH;
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Nord-Est
					
					return Direction.NORTH_EAST;
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Est
					
					return Direction.EAST;
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Sud-Est
					
					return Direction.SOUTH_EAST;
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Sud
					
					return Direction.SOUTH;
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Sud-Ouest
					
					return Direction.SOUTH_WEST;
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Ouest
					
					return Direction.WEST;
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Nord-Ouest
					
					return Direction.NORTH_WEST;
				}
			} else if (p.getLocation().getX() == t.getLocation().getX() && p.getLocation().getY() < t.getLocation().getY()) {
				// Sud
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Sud
					
					return Direction.SOUTH;
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Sud-Ouest
					
					return Direction.SOUTH_WEST;
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Ouest
					
					return Direction.WEST;
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Nord-Ouest
					
					return Direction.NORTH_WEST;
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Nord
					
					return Direction.NORTH;
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Nord-Est
					
					return Direction.NORTH_EAST;
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Est
					
					return Direction.EAST;
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Sud-Est
					
					return Direction.SOUTH_EAST;
				}
			} else if (p.getLocation().getY() == t.getLocation().getY() && p.getLocation().getX() > t.getLocation().getX()) {
				// Ouest
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Est
					
					return Direction.EAST;
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Sud-Est
					
					return Direction.SOUTH_EAST;
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Sud
					
					return Direction.SOUTH;
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Sud-Ouest
					
					return Direction.SOUTH_WEST;
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Ouest
					
					return Direction.WEST;
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Nord-Ouest
					
					return Direction.NORTH_WEST;
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Nord
					
					return Direction.NORTH;
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Nord-Est
					
					return Direction.NORTH_EAST;
				}
			} else if (p.getLocation().getY() == t.getLocation().getY() && p.getLocation().getX() < t.getLocation().getX()) {
				// Est 
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Ouest
					
					return Direction.WEST;
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Nord-Ouest
					
					return Direction.NORTH_WEST;
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Nord
					
					return Direction.NORTH;
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Nord-Est
					
					return Direction.NORTH_EAST;
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Est
					
					return Direction.EAST;
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Sud-Est
					
					return Direction.SOUTH_EAST;
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Sud
					
					return Direction.SOUTH;
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Sud-Ouest
					
					return Direction.SOUTH_WEST;
				}
			} else if (p.getLocation().getX() > t.getLocation().getX() && p.getLocation().getY() > t.getLocation().getY()) {
				// Nord-Est
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Nord-Ouest
					
					return Direction.NORTH_WEST;
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Nord
					
					return Direction.NORTH;
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Nord-Est
					
					return Direction.NORTH_EAST;
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Est
					
					return Direction.EAST;
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Sud-Est
					
					return Direction.SOUTH_EAST;
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Sud
					
					return Direction.SOUTH;
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Sud-Ouest
					
					return Direction.SOUTH_WEST;
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Ouest
					
					return Direction.WEST;
				}
			} else if (p.getLocation().getX() > t.getLocation().getX() && p.getLocation().getY() < t.getLocation().getY()) {
				// Nord-Ouest
				
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Nord
					
					return Direction.NORTH;
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Nord-Est
					
					return Direction.NORTH_EAST;
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Est
					
					return Direction.EAST;
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Sud-Est
					
					return Direction.SOUTH_EAST;
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Sud
					
					return Direction.SOUTH;
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Sud-Ouest
					
					return Direction.SOUTH_WEST;
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Ouest
					
					return Direction.WEST;
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Nord-Ouest
					
					return Direction.NORTH_WEST;
				}
			} else if (p.getLocation().getX() < t.getLocation().getX() && p.getLocation().getY() > t.getLocation().getY()) {
				// Sud-Est
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Sud
					
					return Direction.SOUTH;
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Sud-Ouest
					
					return Direction.SOUTH_WEST;
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Ouest
					
					return Direction.WEST;
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Nord-Ouest
					
					return Direction.NORTH_WEST;
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Nord
					
					return Direction.NORTH;
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Nord-Est
					
					return Direction.NORTH_EAST;
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Est
					
					return Direction.EAST;
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Sud-Est
					
					return Direction.SOUTH_EAST;
				}
			} else if (p.getLocation().getX() < t.getLocation().getX() && p.getLocation().getY() < t.getLocation().getY()) {
				// Sud-Ouest
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Est
					
					return Direction.EAST;
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Sud-Est
					
					return Direction.SOUTH_EAST;
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Sud
					
					return Direction.SOUTH;
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Sud-Ouest
					
					return Direction.SOUTH_WEST;
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Ouest
					
					return Direction.WEST;
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Nord-Ouest
					
					return Direction.NORTH_WEST;
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Nord
					
					return Direction.NORTH;
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Nord-Est
					
					return Direction.NORTH_EAST;
				}
			}else {
				return Direction.BUG;
			}
		}else {
			return Direction.NULL;
		}
		
		return Direction.NULL;
	}
	
	public static void send(Player p) {
		Direction d = getDirection(p);
		String message = "§cdefault"; 
		
		if(d.equals(Direction.NORTH)) {
			message = "§3↑ §9|§3 Joueur le plus proche : §9"+near+"§3 §9|§3 §9"+dist+" §3blocks";
		}else if(d.equals(Direction.NORTH_EAST)) {
			message = "§3↗ §9|§3 Joueur le plus proche : §9"+near+"§3 §9|§3 §9"+dist+" §3blocks";
		}else if(d.equals(Direction.NORTH_WEST)) {
			message = "§3↖ §9|§3 Joueur le plus proche : §9"+near+"§3 §9|§3 §9"+dist+" §3blocks";
		}else if(d.equals(Direction.EAST)) {
			message = "§3→ §9|§3 Joueur le plus proche : §9"+near+"§3 §9|§3 §9"+dist+" §3blocks";
		}else if(d.equals(Direction.WEST)) {
			message = "§3← §9|§3 Joueur le plus proche : §9"+near+"§3 §9|§3 §9"+dist+" §3blocks";
		}else if(d.equals(Direction.SOUTH)) {
			message = "§3↓ §9|§3 Joueur le plus proche : §9"+near+"§3 §9|§3 §9"+dist+" §3blocks";
		}else if(d.equals(Direction.SOUTH_EAST)) {
			message = "§3↘ §9|§3 Joueur le plus proche : §9"+near+"§3 §9|§3 §9"+dist+" §3blocks";
		}else if(d.equals(Direction.SOUTH_WEST)) {
			message = "§3↙ §9|§3 Joueur le plus proche : §9"+near+"§3 §9|§3 §9"+dist+" §3blocks";
		}else if(d.equals(Direction.NOTHING)) {
			message = "§c✖ §4|§c Aucun joueur proche !";
		}else if(d.equals(Direction.BUG)) {
			message = "§c✖ §4|§c Le jeu semble bug (ErrorType -> BUG) !";
		}else if(d.equals(Direction.NULL)) {
			message = "§c✖ §4§c| Le jeu semble bug ! (ErrorType -> NULL) !";
		}
		
		IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
		
		PacketPlayOutChat ppoc = new PacketPlayOutChat(icbc, (byte) 2);
		
		EntityPlayer ep = ((CraftPlayer)p).getHandle(); 
		
		ep.playerConnection.sendPacket(ppoc);
	}
	*/
	
	public static Player getNearestPlayer(Player p) {
		double nearest = 0.0d;
		Player near = null;
		
		for(Player online : Bukkit.getOnlinePlayers()) {
			if(p.getLocation().distance(online.getLocation()) > nearest) {
				nearest = p.getLocation().distance(online.getLocation());
				near = online;
			}
		}
		
		return near;
	}
	
	public static void sendNearestPlayerActionBar(Player p, Player nearP) {
		IChatBaseComponent icbc = null;
		
		if(nearP.equals(null)){
			icbc = ChatSerializer.a("{\"text\": \" §c✖ §4|§c Aucun joueur proche ! \"}");
		}else if((int) p.getLocation().distance(nearP.getLocation()) > 1){
			icbc = ChatSerializer.a("{\"text\": \" §9| §3Joueur le plus proche : §9§l"+
					nearP.getName()+" §9| §l"+(int) p.getLocation().distance(nearP.getLocation())+" §3blocks §9| \"}");
		}else if((int) p.getLocation().distance(nearP.getLocation()) == 0) {
			icbc = ChatSerializer.a("{\"text\": \" §9| §3Joueur le plus proche : §9§l"+
					nearP.getName()+" §9| §l ICI §9| \"}");
		}else if((int) p.getLocation().distance(nearP.getLocation()) == 1) {
			icbc = ChatSerializer.a("{\"text\": \" §9| §3Joueur le plus proche : §9§l"+
					nearP.getName()+" §9| §l"+(int) p.getLocation().distance(nearP.getLocation())+" §3block §9| \"}");
		}
		
		PacketPlayOutChat ppoc = new PacketPlayOutChat(icbc, (byte) 2);
		
		EntityPlayer ep = ((CraftPlayer)p).getHandle(); 
		
		ep.playerConnection.sendPacket(ppoc);
	}
}