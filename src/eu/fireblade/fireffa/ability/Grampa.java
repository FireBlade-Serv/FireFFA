package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Grampa implements Listener {
	
	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	private static ItemStack getItem(){
		ItemStack charcoal = new ItemStack(Material.COAL, 1, (byte) 0);
		ItemMeta charcoalM = charcoal.getItemMeta();
		charcoalM.setDisplayName(ChatColor.DARK_GRAY+"Pruneau");
		charcoalM.setLore(Kits.LoreCreator(ChatColor.BLUE+"Clique droit - Régéne 2 coeurs", ChatColor.BLUE+"Récupération 1 minute 30"));
		charcoal.setItemMeta(charcoalM);
		
		return charcoal;
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		final ItemStack item = e.getItem();
		
		if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)){
			if(Var.grampa.contains(p)){
				if(item.equals(getItem())){
					if(cooldown.contains(p)){
						p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
						p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
						
						return;
					}else{
						giveHealth(p);
						
						cooldown.add(p);
						
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

							@Override
							public void run() {
								if(Var.grampa.contains(p)){
									GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Vous pouvez vous heal !", 20, 30, 20);
									gt.send();
									
									p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
								}
								
								if(cooldown.contains(p)) {
									cooldown.remove(p);
								}
							}
							
						}, 1800L);
					}
				}
			}
		}
	}
	
	private static void giveHealth(Player p){
		if(p.getHealth() >= 16){
			p.setHealth(p.getMaxHealth());
			
			p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 30, 30);
		}else{
			p.setHealth(p.getHealth() + 4);
			
			p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 30, 30);
		}
	}

}
