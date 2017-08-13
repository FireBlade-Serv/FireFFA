package eu.fireblade.fireffa.util;

import org.bukkit.entity.Player;

import fr.glowstoner.api.bukkit.scoreboard.GlowstoneScoreboardAPI;

public class Scoreboard {
	
	public static void displayScoreboard(Player p){
		GlowstoneScoreboardAPI gs = new GlowstoneScoreboardAPI(p, "§6§l==FireFFA==");
		
		gs.setLine("§8", 1);
		gs.setLine("§7§lGrade :", 2);
		gs.setLine("§7 Serveur §8§l>>", 3);
		gs.setLine("§7 FFA §8§l>>", 4);
		gs.setLine("§8", 5);
		gs.setLine("§7§lKill :", 6);
		gs.setLine("§8§l >>", 7);
		gs.setLine("§7", 8);
		gs.setLine("§7§lKill Restant :", 9);
		gs.setLine("§8§l >>", 10);
		gs.setLine("§7", 11);
		gs.setLine("§7§lKillStreak :", 12);
		gs.setLine("§8§l >>", 13);
		gs.setLine("§8", 14);
		gs.setLine("§eplay.fireblade-serv.eu", 15);
		
		gs.sendPacket();
	}

}
