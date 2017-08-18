package eu.fireblade.fireffa.ability;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class VoleurÂmes implements Listener {
	
	private static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	private static HashMap<Player, Double> soul = new HashMap<Player, Double>();
	
	@EventHandler
	public void onPlayerClick(PlayerInteractAtPlayerEvent e){
		final Player p = e.getPlayer();
		final Player target = e.getTarget();
		final ItemStack item = e.getItemInHand();
		final World w = e.getWorld();
		
		if(Var.voleurdame.contains(p)){
			if(item.equals(Kits.ItemGen(Material.STONE_SWORD, 
					ChatColor.BLACK+"Épée du voleur d'âme",Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Vole 1,5 coeurs",
							ChatColor.BLUE+"45 secondes de récupération"), 1))){
				
				if(cooldown.contains(p)){
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
					return;
				}else{
					damage(target);
					
					cooldown.add(p);
					
					p.setLevel(p.getLevel() + 1);
					
					if(soul.containsKey(p)){
						soul.replace(p, soul.get(p) + 3.0d);
					}else{
						soul.put(p, 3.0d);
					}
					
					p.playSound(p.getLocation(), Sound.CAT_MEOW, 30, 30);
					
					for(int i = 1; i <= 15; i++){
						w.playEffect(target.getEyeLocation(), Effect.HEART, 1);
					}
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

						@Override
						public void run() {
							if(Var.voleurdame.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre attaque est prête !", 20, 30, 20);
								gt.send();
									
								p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
								
							}
							
							cooldown.remove(p);
						}
						
					}, 900L);
				}
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		final ItemStack item = e.getItem();
		
		if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)){
			if(item.equals(Kits.ItemGen(Material.REDSTONE, ChatColor.BLACK+"Puit de sang",
					Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Utilise les âmes accumulées pour se régénerer",
							ChatColor.BLUE+"Consomme le puit de sang (Expérience)"), 1))){
				if(!Var.voleurdame.contains(p)){
					return;
				}
				
				if(!soul.containsKey(p)){
					soul.put(p, 0.0d);
				}
				
				if(soul.get(p) >= 3.0d){
					p.sendMessage("§6[§eFireFFA§6] §fLes âmes que vous avez capturées entrent dans votre corps !");
					
					p.playSound(p.getLocation(), Sound.VILLAGER_YES, 30, 30);
					
					if(p.getHealth() + 3.0d >= p.getMaxHealth()){
						p.setLevel(p.getLevel() - 1);
						
						p.setHealth(p.getMaxHealth());
						
						soul.replace(p, soul.get(p) - 3.0d);
					}else{
						p.setHealth(p.getHealth() + soul.get(p));
						
						p.setLevel(p.getLevel() - 1);
						
						soul.replace(p, soul.get(p) - 3.0d);
					}
				}else{
					p.sendMessage("§6[§eFireFFA§6] §fVous ne possedez aucune âme!");
					
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				}
			}
		}
	}
	
	private static void damage(Player p){
		if(p.getHealth() <= 3){
			p.setHealth(0);
		}else{
			if(!p.getGameMode().equals(GameMode.CREATIVE)){
				p.setHealth(p.getHealth() - 3);
				
				p.sendMessage("§6[§eFireFFA§6] §fVotre âme vous a été volée !");
				
				p.playSound(p.getLocation(), Sound.GHAST_SCREAM, 30, 30);
			}
		}
	}

}