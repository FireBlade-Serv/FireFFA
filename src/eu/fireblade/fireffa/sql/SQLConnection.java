package eu.fireblade.fireffa.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;

public class SQLConnection {
	
	private static Connection connection;
	
	public static void connection() {
		try {
			Bukkit.getLogger().info("Tentative de connection SQL "
					+ "avec 'host' -> '"+Var.host+"', 'db' -> '"+Var.db+"', 'user' -> '"+Var.user+"', 'password' -> '"+Var.password+"'.");
			connection = DriverManager.getConnection(Var.SqlUrlBase + Var.host + "/" + Var.db, Var.user, Var.password);
			Bukkit.getLogger().info("Connection réussie !");
			Bukkit.getConsoleSender().sendMessage("§aConnection SQL !");
		} catch (SQLException e) {
			Bukkit.getLogger().info("Connection fail ! Erreur -> "+e.getMessage());
		}
	}

	public static void disconnect() {
		if(isConnected()) {
			Bukkit.getConsoleSender().sendMessage("§aDéconnection SQL !");
			
			connection = null;
		}
	}
	
	public static void autoConnection() {
		Var.sqltask = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				Bukkit.getConsoleSender().sendMessage("§aPrecessus de Refresh SQL !");
				
				Bukkit.getConsoleSender().sendMessage("§aTentative de déconnection SQL !");
				disconnect();
				
				Bukkit.getConsoleSender().sendMessage("§aTentative de connection SQL !");
				connection();
			}
			
		}, 36000L, 72000L);
	}
	
	public static boolean isConnected() {
		return connection != null;
	}
	
	public static void createAccount(Player p){
		if(!hasAccount(p)){
			
			try {
				PreparedStatement q = connection.prepareStatement("INSERT INTO FireFFA(name, kills) VALUES (?, ?)");
				q.setString(1, p.getName().toString());
				q.setInt(2, 0);
				
				q.execute();
				q.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static boolean hasAccount(Player p){
		try {
			PreparedStatement q = connection.prepareStatement("SELECT name FROM FireFFA WHERE name = ?");
			q.setString(1, p.getName().toString());
			
			ResultSet r = q.executeQuery();
			
			boolean has = r.next();
			
			q.close();
			
			return has;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static int getKills(Player p){
		try {
			PreparedStatement q = connection.prepareStatement("SELECT kills FROM FireFFA WHERE name = ?");
			q.setString(1, p.getName().toString());
			
			ResultSet rs = q.executeQuery();
			
			int kills = 0;
			
			while(rs.next()){
				kills = rs.getInt("kills");
			}
			
			q.close();
			
			return kills;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static void setKills(Player p, int kills) {
		try {
			PreparedStatement rs = connection.prepareStatement("UPDATE FireFFA SET kills = ? WHERE name = ?");
			
			rs.setInt(1, kills);
			rs.setString(2, p.getName().toString());
			
			rs.executeUpdate();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
