package eu.fireblade.fireffa.util;

import java.util.ArrayList;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import eu.fireblade.fireffa.Var;

public class NearbyPlayerLocationCalculator implements Listener {

	private static ArrayList<Player> playerInArea = new ArrayList<Player>();
	
	@EventHandler
	public static void onMouve(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(Var.inGame.contains(p)) {
			for(Entity inArea : p.getNearbyEntities(254, 170, 254)) {
				if(inArea instanceof Player) {
					if (Var.inGame.contains(inArea))
						playerInArea.add((Player) inArea);
				}
			}
			if (p.getLocation().getX() == playerInArea.get(0).getLocation().getX() && p.getLocation().getY() > playerInArea.get(0).getLocation().getY()) {
				// Nord
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Nord
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Nord-Est
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Est
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Sud-Est
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Sud
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Sud-Ouest
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Ouest
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Nord-Ouest
				}
			} else if (p.getLocation().getX() == playerInArea.get(0).getLocation().getX() && p.getLocation().getY() < playerInArea.get(0).getLocation().getY()) {
				// Sud
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Sud
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Sud-Ouest
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Ouest
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Nord-Ouest
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Nord
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Nord-Est
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Est
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Sud-Est
				}
			} else if (p.getLocation().getY() == playerInArea.get(0).getLocation().getY() && p.getLocation().getX() > playerInArea.get(0).getLocation().getX()) {
				// Ouest
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Est
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Sud-Est
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Sud
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Sud-Ouest
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Ouest
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Nord-Ouest
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Nord
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Nord-Est
				}
			} else if (p.getLocation().getY() == playerInArea.get(0).getLocation().getY() && p.getLocation().getX() < playerInArea.get(0).getLocation().getX()) {
				// Est 
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Ouest
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Nord-Ouest
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Nord
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Nord-Est
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Est
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Sur-Est
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Sud
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Sud-Ouest
				}
			} else if (p.getLocation().getX() > playerInArea.get(0).getLocation().getX() && p.getLocation().getY() > playerInArea.get(0).getLocation().getY()) {
				// Nord-Est
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Nord-Ouest
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Nord
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Nord-Est
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Est
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Sud-Est
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Sud
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Sud-Ouest
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Ouest
				}
			} else if (p.getLocation().getX() > playerInArea.get(0).getLocation().getX() && p.getLocation().getY() < playerInArea.get(0).getLocation().getY()) {
				// Nord-Ouest
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Nord
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Nord-Est
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Est
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Sud-Est
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Sud
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Sud-Ouest
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Ouest
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Nord-Ouest
				}
			} else if (p.getLocation().getX() < playerInArea.get(0).getLocation().getX() && p.getLocation().getY() > playerInArea.get(0).getLocation().getY()) {
				// Sud-Est
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Sud
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Sud-Ouest
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Ouest
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Nord-Ouest
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Nord
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Nord-Est
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Est
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Sud-Est
				}
			} else if (p.getLocation().getX() < playerInArea.get(0).getLocation().getX() && p.getLocation().getY() < playerInArea.get(0).getLocation().getY()) {
				// Sud-Ouest
				if((p.getLocation().getPitch() >= 158 && p.getLocation().getPitch() <= 180) || 
						(p.getLocation().getPitch() <= -158 && p.getLocation().getPitch() >= -179.9d)){
					//Est
				} else if(p.getLocation().getPitch() > -157.9d && p.getLocation().getPitch() <= 113) {
					//Sud-Est
				} else if(p.getLocation().getPitch() > -112.9d && p.getLocation().getPitch() <= 68) {
					//Sud
				} else if(p.getLocation().getPitch() > -67.9d && p.getLocation().getPitch() <= 22.9d) {
					//Sud-Ouest
				} else if((p.getLocation().getPitch() >= -23 && p.getLocation().getPitch() <= 0) || 
						(p.getLocation().getPitch() <= 23 && p.getLocation().getPitch() >= -0.1d)){
					//Ouest
				} else if (p.getLocation().getPitch() > 23.1d && p.getLocation().getPitch() < 68) {
					//Nord-Ouest
				} else if (p.getLocation().getPitch() > 68.1d && p.getLocation().getPitch() < 113) {
					//Nord
				} else if (p.getLocation().getPitch() > 113.1d && p.getLocation().getPitch() < 157.9d) {
					//Nord-Est
				}
			}
		}
	}
}