package eu.fireblade.fireffa.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import com.nametagedit.plugin.NametagEdit;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.enums.GlobalRank;
import eu.fireblade.fireffa.enums.Rank;
import eu.fireblade.fireffa.sql.SQLConnectionFFA;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldBorder;
import net.minecraft.server.v1_8_R3.WorldBorder;
import ru.tehkode.permissions.bukkit.PermissionsEx;

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
		int kills = SQLConnectionFFA.getKills(p);
		
		Methods.refreshTabRank(p);
		
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
						.withColor(Color.NAVY)
						.build());
				
				fm.setPower(1);
				f.setFireworkMeta(fm);
				
				Bukkit.broadcastMessage("§6[§eFireFFA§6] §aBravo à §l"+p.getName()+"§a ! Il a désormait le grade §1§lExecuteur §a!");
				
				IChatBaseComponent chat = ChatSerializer.a("{\"text\": \" §aVous avez désormais le grade §1§lExecuteur §a! \"}");
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(chat, (byte) 2));
				p.playSound(p.getEyeLocation(), Sound.LEVEL_UP, 30, 30);
			}
		}else if(kills >= 1200 && kills < 1700) {
			//Sanguinaire
			
			if(kills == 1200) {
				Firework f = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
				
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffect(FireworkEffect.builder()
						
						.flicker(false)
						.trail(false)
						.with(Type.STAR)
						.withColor(Color.RED)
						.build());
				
				fm.setPower(1);
				f.setFireworkMeta(fm);
				
				Bukkit.broadcastMessage("§6[§eFireFFA§6] §aBravo à §l"+p.getName()+"§a ! Il a désormait le grade §c§lSanguinaire §a!");
				
				IChatBaseComponent chat = ChatSerializer.a("{\"text\": \" §aVous avez désormais le grade §c§lSanguinaire §a! \"}");
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(chat, (byte) 2));
				p.playSound(p.getEyeLocation(), Sound.LEVEL_UP, 30, 30);
			}
		}else if(kills >= 1700 && kills < 2300) {
			//Massacreur
			
			if(kills == 1700) {
				Firework f = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
				
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffect(FireworkEffect.builder()
						
						.flicker(false)
						.trail(false)
						.with(Type.STAR)
						.withColor(Color.ORANGE)
						.build());
				
				fm.setPower(1);
				f.setFireworkMeta(fm);
				
				Bukkit.broadcastMessage("§6[§eFireFFA§6] §aBravo à §l"+p.getName()+"§a ! Il a désormait le grade §6§lMassacreur §a!");
				
				IChatBaseComponent chat = ChatSerializer.a("{\"text\": \" §aVous avez désormais le grade §6§lMassacreur §a! \"}");
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(chat, (byte) 2));
				p.playSound(p.getEyeLocation(), Sound.LEVEL_UP, 30, 30);
			}
		}else if(kills >= 2300 && kills < 3000) {
			//Déchiqueteur
			
			if(kills == 2300) {
				Firework f = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
				
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffect(FireworkEffect.builder()
						
						.flicker(false)
						.trail(false)
						.with(Type.STAR)
						.withColor(Color.SILVER)
						.build());
				
				fm.setPower(1);
				f.setFireworkMeta(fm);
				
				Bukkit.broadcastMessage("§6[§eFireFFA§6] §aBravo à §l"+p.getName()+"§a ! Il a désormait le grade §7§lDéchiqueteur §a!");
				
				IChatBaseComponent chat = ChatSerializer.a("{\"text\": \" §aVous avez désormais le grade §7§lDéchiqueteur §a! \"}");
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(chat, (byte) 2));
				p.playSound(p.getEyeLocation(), Sound.LEVEL_UP, 30, 30);
			}
		}else if(kills >= 3000) {
			//DeathGod
			
			if(kills == 3000) {
				Firework f = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
				
				FireworkMeta fm = f.getFireworkMeta();
				fm.addEffect(FireworkEffect.builder()
						
						.flicker(false)
						.trail(false)
						.with(Type.STAR)
						.withColor(Color.BLACK)
						.build());
				
				fm.setPower(1);
				f.setFireworkMeta(fm);
				
				Bukkit.broadcastMessage("§6[§eFireFFA§6] §aBravo à §l"+p.getName()+"§a ! Il a désormait le grade §0§lDeathGod §a!");
				
				IChatBaseComponent chat = ChatSerializer.a("{\"text\": \" §aVous avez désormais le grade §0§lDeathGod §a! \"}");
				((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(chat, (byte) 2));
				p.playSound(p.getEyeLocation(), Sound.LEVEL_UP, 30, 30);
			}
		}
	}
	
	public static Rank getRank(Player p) {
		int kills = SQLConnectionFFA.getKills(p);
		
		if(kills < 50) {
			//Vagabond
			
			return Rank.VAGABOND;
		}else if(kills >= 50 && kills < 150) {
			//Inquisiteur
			
			return Rank.INQUISITEUR;
		}else if(kills >= 150 && kills < 300) {
			//Meurtrier
			
			return Rank.MEURTRIER;
		}else if(kills >= 300 && kills < 500) {
			//Mercenaire
			
			return Rank.MERCENAIRE;
		}else if(kills >= 500 && kills < 800) {
			//Bourreau
			
			return Rank.BOURREAU;
		}else if(kills >= 800 && kills < 1200) {
			//Executeur
			
			return Rank.EXECUTEUR;
		}else if(kills >= 1200 && kills < 1700) {
			//Sanguinaire
			
			return Rank.SANGUINAIRE;
		}else if(kills >= 1700 && kills < 2300) {
			//Massacreur
			
			return Rank.MASSACREUR;
		}else if(kills >= 2300 && kills < 3000) {
			//Déchiqueteur
			
			return Rank.DÉCHIQUETEUR;
		}else if(kills >= 3000) {
			//DeathGod
		
			return Rank.DEATHGOD;
		}else {
			return null;
		}
	}
	
	public static String getRemainingKills(Player p) {
		int kills = SQLConnectionFFA.getKills(p);
		
		if(kills < 50) {
			//Vagabond
			
			int re = 50 - kills;
			
			return ""+re;
		}else if(kills >= 50 && kills < 150) {
			//Inquisiteur
			
			int re = 150 - kills;
			
			return ""+re;
		}else if(kills >= 150 && kills < 300) {
			//Meurtrier
			
			int re = 300 - kills;
			
			return ""+re;
		}else if(kills >= 300 && kills < 500) {
			//Mercenaire
			
			int re = 500 - kills;
			
			return ""+re;
		}else if(kills >= 500 && kills < 800) {
			//Bourreau
			
			int re = 800 - kills;
			
			return ""+re;
		}else if(kills >= 800 && kills < 1200) {
			//Executeur
			
			int re = 1200 - kills;
			
			return ""+re;
		}else if(kills >= 1200 && kills < 1700) {
			//Sanguinaire
			
			int re = 1700 - kills;
			
			return ""+re;
		}else if(kills >= 1700 && kills < 2300) {
			//Massacreur
			
			int re = 2300 - kills;
			
			return ""+re;
		}else if(kills >= 2300 && kills < 3000) {
			//Déchiqueteur
			
			int re = 3000 - kills;
			
			return ""+re;
		}else if(kills >= 3000) {
			//DeathGod
		
			return "§cÀ venir :)";
		}else {
			return null;
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
	
	public static void refreshTabRank(Player p) {
		int kills = SQLConnectionFFA.getKills(p);
		
		if(getRank(p).equals(Rank.VAGABOND)) {
			NametagEdit.getApi().setPrefix(p, "§b[Vagabond] ");
		}else if(getRank(p).equals(Rank.INQUISITEUR)) {
			NametagEdit.getApi().setPrefix(p, "§e[Inquisiteur] ");
		}else if(getRank(p).equals(Rank.MEURTRIER)) {
			NametagEdit.getApi().setPrefix(p, "§5[Meurtrier] ");
		}else if(getRank(p).equals(Rank.MERCENAIRE)) {
			NametagEdit.getApi().setPrefix(p, "§a[Mercenaire] ");
		}else if(getRank(p).equals(Rank.BOURREAU)) {
			NametagEdit.getApi().setPrefix(p, "§1[Bourreau] ");
		}else if(getRank(p).equals(Rank.EXECUTEUR)) {
			NametagEdit.getApi().setPrefix(p, "§2[Executeur] ");
		}else if(getRank(p).equals(Rank.SANGUINAIRE)) {
			NametagEdit.getApi().setPrefix(p, "§c[Sanguinaire] ");
		}else if(getRank(p).equals(Rank.MASSACREUR)) {
			NametagEdit.getApi().setPrefix(p, "§6[Massacreur] ");
		}else if(getRank(p).equals(Rank.DÉCHIQUETEUR)) {
			NametagEdit.getApi().setPrefix(p, "§7[Déchiqueteur] ");
		}else if(getRank(p).equals(Rank.DEATHGOD)) {
			NametagEdit.getApi().setPrefix(p, "§0[DeathGod] ");
		}
		
		NametagEdit.getApi().setSuffix(p, " §["+kills+"]");
	}
	
	public static void chatFormat(Player p, String msg, String global, AsyncPlayerChatEvent e) {
		if(Methods.getRank(p).equals(Rank.VAGABOND)) e.setFormat(global+" §b[Vagabond] "+ChatColor.RESET+p.getName()+ChatColor.YELLOW+" >> "+ChatColor.RESET+msg);
		if(Methods.getRank(p).equals(Rank.INQUISITEUR)) e.setFormat(global+" §e[Inquisiteur] "+ChatColor.RESET+p.getName()+ChatColor.YELLOW+" >> "+ChatColor.RESET+msg);
		if(Methods.getRank(p).equals(Rank.MEURTRIER)) e.setFormat(global+" §5[Meurtrier] "+ChatColor.RESET+p.getName()+ChatColor.YELLOW+" >> "+ChatColor.RESET+msg);
		if(Methods.getRank(p).equals(Rank.MERCENAIRE)) e.setFormat(global+" §a[Mercenaire] "+ChatColor.RESET+p.getName()+ChatColor.YELLOW+" >> "+ChatColor.RESET+msg);
		if(Methods.getRank(p).equals(Rank.BOURREAU)) e.setFormat(global+" §9[Bourreau] "+ChatColor.RESET+p.getName()+ChatColor.YELLOW+" >> "+ChatColor.RESET+msg);
		if(Methods.getRank(p).equals(Rank.EXECUTEUR)) e.setFormat(global+" §2[Executeur] "+ChatColor.RESET+p.getName()+ChatColor.YELLOW+" >> "+ChatColor.RESET+msg);
		if(Methods.getRank(p).equals(Rank.SANGUINAIRE)) e.setFormat(global+" §c[Sanguinaire] "+ChatColor.RESET+p.getName()+ChatColor.YELLOW+" >> "+ChatColor.RESET+msg);
		if(Methods.getRank(p).equals(Rank.MASSACREUR)) e.setFormat(global+" §6[Massacreur] "+ChatColor.RESET+p.getName()+ChatColor.YELLOW+" >> "+ChatColor.RESET+msg);
		if(Methods.getRank(p).equals(Rank.DÉCHIQUETEUR)) e.setFormat(global+" §7[Déchiqueteur] "+ChatColor.RESET+p.getName()+ChatColor.YELLOW+" >> "+ChatColor.RESET+msg);
		if(Methods.getRank(p).equals(Rank.DEATHGOD)) e.setFormat(global+" §0[DeathGod] "+ChatColor.RESET+p.getName()+ChatColor.YELLOW+" >> "+ChatColor.RESET+msg);
	}
	
	public static GlobalRank getGlobalRank(Player p) {
		if(PermissionsEx.getUser(p).inGroup("Membre")) {
			return GlobalRank.MEMBRE;
		}else if(PermissionsEx.getUser(p).inGroup("Fire")) {
			return GlobalRank.FIRE;
		}else if(PermissionsEx.getUser(p).inGroup("Ultra")) {
			return GlobalRank.ULTRA;
		}else if(PermissionsEx.getUser(p).inGroup("Ultimate")) {
			return GlobalRank.ULTIMATE;
		}else if(PermissionsEx.getUser(p).inGroup("Youtuber")) {
			return GlobalRank.YOUTUBER;
		}else if(PermissionsEx.getUser(p).inGroup("RespCom")) {
			return GlobalRank.RESPCOM;
		}else if(PermissionsEx.getUser(p).inGroup("Dev")) {
			return GlobalRank.DEV;
		}else if(PermissionsEx.getUser(p).inGroup("Builder")) {
			return GlobalRank.BUILDER;
		}else if(PermissionsEx.getUser(p).inGroup("Guide")) {
			return GlobalRank.GUIDE;
		}else if(PermissionsEx.getUser(p).inGroup("Assistant")) {
			return GlobalRank.ASSISTANT;
		}else if(PermissionsEx.getUser(p).inGroup("Modérateur")) {
			return GlobalRank.MODÉRATEUR;
		}else if(PermissionsEx.getUser(p).inGroup("Admin")) {
			return GlobalRank.ADMIN;
		}else if(PermissionsEx.getUser(p).inGroup("Owner")) {
			return GlobalRank.PADRE;
		}else if(PermissionsEx.getUser(p).inGroup("manager1")) {
			return GlobalRank.MANAGER_STAFF;
		}else if(PermissionsEx.getUser(p).inGroup("manager2")) {
			return GlobalRank.MANAGER_IG;
		}else {
			return GlobalRank.BUG;
		}
	}
	
	public static String getStringRank(Player p){
		if(PermissionsEx.getUser(p).inGroup("Builder")){
			return "§6§lBuilder";
		}else if(PermissionsEx.getUser(p).inGroup("Fire")){
			return "§e§lFire";
		}else if(PermissionsEx.getUser(p).inGroup("Ultra")){
			return "§a§lUltra";
		}else if(PermissionsEx.getUser(p).inGroup("Ultimate")){
			return "§5§lUltimate";
		}else if(PermissionsEx.getUser(p).inGroup("Youtuber")){
			return "§2§lYoutuber";
		}else if(PermissionsEx.getUser(p).inGroup("Guide")){
			return "§2§lGuide";
		}else if(PermissionsEx.getUser(p).inGroup("Assistant")){
			return "§6§lAssistant";
		}else if(PermissionsEx.getUser(p).inGroup("Modérateur")){
			return "§3§lModérateur";
		}else if(PermissionsEx.getUser(p).inGroup("manager1")){
			return "§c§lStaff Manager";
		}else if(PermissionsEx.getUser(p).inGroup("manager2")){
			return "§c§lManager IG";
		}else if(PermissionsEx.getUser(p).inGroup("Dev")){
			return "§9§lDev";
		}else if(PermissionsEx.getUser(p).inGroup("Admin")){
			return "§4§lAdmin";
		}else if(PermissionsEx.getUser(p).inGroup("Owner")){
			return "§4§lOwner";
		}else if(PermissionsEx.getUser(p).inGroup("RespCom")){
			return "§6§lResp. Com.";
		}else if(PermissionsEx.getUser(p).inGroup("Membre")){
			return "§7Membre";
		}else {
			return "§cBUG !";
		}
	}
}