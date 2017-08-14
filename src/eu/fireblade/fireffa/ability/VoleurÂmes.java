package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import eu.fireblade.fireffa.util.PlayerInteractAtPlayerEvent;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Voleur�mes implements Listener {
	
	private static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerClick(PlayerInteractAtPlayerEvent e){
		final Player p = e.getPlayer();
		final Player target = e.getTarget();
		final ItemStack item = e.getItemInHand();
		final World w = e.getWorld();
		
		if(Var.voleurdame.contains(p)){
			if(item.equals(Kits.ItemGen(Material.STONE_SWORD, 
					ChatColor.BLACK+"�p�e du voleur d'�me",Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Vole 1,5 coeurs",
							ChatColor.BLUE+"45 secondes de r�cup�ration"), 1))){
				
				if(cooldown.contains(p)){
					p.sendMessage(ChatColor.GOLD+"[�eFireFFA�6] "+ChatColor.RED+"Vous �tes en cooldown pour cette attaque !");
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
					return;
				}else{
					damage(target);
					
					p.setLevel(p.getLevel() + 1);
					
					p.playSound(p.getLocation(), Sound.CAT_MEOW, 30, 30);
					
					for(int i = 1; i <= 15; i++){
						w.playEffect(target.getLocation(), Effect.HEART, 1);
					}
					
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

						@Override
						public void run() {
							if(Var.voleurdame.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(p, "", "�9Votre attaque est pr�te !", 20, 30, 20);
								gt.send();
									
								p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
								
							}
							
							cooldown.remove(p);
						}
						
					}, 900L);
				}
			}else if(item.equals(Kits.ItemGen(Material.REDSTONE, ChatColor.BLACK+"Puit de sang",
					Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Utilise les �mes accumul�es pour se r�g�nerer",
							ChatColor.BLUE+"Consomme le puit de sang (Exp�rience)"), 1))){
				
				if(p.getLevel() != 0){
					p.sendMessage("[�eFireFFA�6] �fLes �mes que vous avez captur�es entre dans votre corps !");
					
					p.playSound(p.getLocation(), Sound.WITHER_DEATH, 30, 30);
					
					if(p.getLevel() * 1.5d >= p.getMaxHealth()){
						p.setLevel(0);
						
						p.setHealth(p.getMaxHealth());
					}else{
						p.setHealth(p.getLevel() * 1.5d);
						
						p.setLevel(0);
					}
				}
			}
		}
	}
	
	private static void damage(Player p){
		if(p.getHealth() <= 3){
			p.setHealth(0);
		}else{
			p.setHealth(p.getHealth() - 3);
			
			p.sendMessage("[�eFireFFA�6] �fVotre �me vous a �t� vol�e !");
			
			p.playSound(p.getLocation(), Sound.GHAST_SCREAM, 30, 30);
		}
	}

}
