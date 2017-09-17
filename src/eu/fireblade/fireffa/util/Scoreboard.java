package eu.fireblade.fireffa.util;

import org.bukkit.entity.Player;

import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.sql.SQLConnectionFFA;
import fr.glowstoner.api.bukkit.scoreboard.GlowstoneScoreboardAPI;

public class Scoreboard {
	
	public static void displayScoreboard(Player p){
		GlowstoneScoreboardAPI gs = new GlowstoneScoreboardAPI(p, "§6§l-=FireFFA=-");
		
		gs.setLine("§8  ", 1);
		gs.setLine("§7§lGrade :", 2);
		gs.setLine("§7 Serveur §8§l>> §c"+null, 3);
		gs.setLine("§7 FFA §8§l>> "+refreshRank(p), 4);
		gs.setLine("§6  ", 5);
		gs.setLine("§7§lKills :", 6);
		gs.setLine(" §8§l>> "+genKills(p), 7);
		gs.setLine("§4    ", 8);
		gs.setLine("§7§lKills Restants :", 9);
		gs.setLine("§8§l >>§c "+null, 10);
		gs.setLine("§1   ", 11);
		gs.setLine("§7§lKillStreak :", 12);
		gs.setLine("§8§l >> "+genKillStreak(p), 13);
		gs.setLine("§a   ", 14);
		gs.setLine("§eplay.fireblade-serv.eu", 15);
		
		gs.sendPacket();
	}

	private static String genKillStreak(Player p) {
		if(Var.killStreak.get(p) == 0) {
			return "§cAucun KillStreak";
		}else {
			return "§e"+Var.killStreak.get(p);
		}
	}
	
	private static String genKills(Player p) {
		if(SQLConnectionFFA.getKills(p) == 0) {
			return "§cAucun Kill";
		}else {
			return "§e"+SQLConnectionFFA.getKills(p);
		}
	}
	
	private static String refreshRank(Player p) {
		int kills = SQLConnectionFFA.getKills(p);
		
		if(kills < 50) {
			//Vagabond
			
			return "§b§lVagabond";
		}else if(kills >= 50 && kills < 150) {
			//Inquisiteur
			
			return "§e§lInquisiteur";
		}else if(kills >= 150 && kills < 300) {
			//Meurtrier
			
			return "§5§lMeurtrier";
		}else if(kills >= 300 && kills < 500) {
			//Mercenaire
			
			return "§a§lMercenaire";
		}else if(kills >= 500 && kills < 800) {
			//Bourreau
			
			return "§9§lBourrreau";
		}else if(kills >= 800 && kills < 1200) {
			//Executeur
			
			return "§1§lExecuteur";
		}else if(kills >= 1200 && kills < 1700) {
			//Sanguinaire
			
			return "§c§lSanguinaire";
		}else if(kills >= 1700 && kills < 2300) {
			//Massacreur
			
			return "§6§lMassacreur";
		}else if(kills >= 2300 && kills < 3000) {
			//Déchiqueteur
			
			return "§7Déchiqueteur";
		}else if(kills >= 3000) {
			//DeathGod
		
			return "§0§lDeathGod";
		}else {
			return "§4§lBUG !";
		}
	}
}
