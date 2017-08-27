package eu.fireblade.fireffa.util;

import org.bukkit.entity.Player;

import eu.fireblade.fireffa.Var;
import fr.glowstoner.api.bukkit.scoreboard.GlowstoneScoreboardAPI;

public class Scoreboard {
	
	public static void displayScoreboard(Player p){
		GlowstoneScoreboardAPI gs = new GlowstoneScoreboardAPI(p, "§6§l-=FireFFA=-");
		
		gs.setLine("§8  ", 1);
		gs.setLine("§7§lGrade :", 2);
		gs.setLine("§7 Serveur §8§l>> §c"+null, 3);
		gs.setLine("§7 FFA §8§l>> §c"+null, 4);
		gs.setLine("§6  ", 5);
		gs.setLine("§7§lKills :", 6);
		gs.setLine(" §8§l>> §c"+null, 7);
		gs.setLine("§4    ", 8);
		gs.setLine("§7§lKills Restants :", 9);
		gs.setLine("§8§l >>§c "+null, 10);
		gs.setLine("§1   ", 11);
		gs.setLine("§7§lKillStreak :", 12);
		gs.setLine("§8§l >> §5§l"+Var.killStreak.get(p), 13);
		gs.setLine("§a   ", 14);
		gs.setLine("§eplay.fireblade-serv.eu", 15);
		
		gs.sendPacket();
	}

}
