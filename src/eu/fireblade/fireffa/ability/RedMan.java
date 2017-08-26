package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class RedMan implements Listener {

	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void OnRightClick(PlayerRightClickInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack i = e.getItem();
		World w = e.getWorld();
		
		if(Var.redman.contains(p) && i.equals(Kits.ItemGen1(Material.STICK, Enchantment.DAMAGE_ALL, 2, "§9Boum Boum", 
				Kits.LoreCreator("§9Cliqque Droit - Lance des TNT", "§9Consomme une recharge"), 1))) {
			if(p.getInventory().containsAtLeast(Kits.ItemGen(Material.TNT, "§9Recharge", null, 1), 1)) {
				p.getInventory().removeItem(Kits.ItemGen(Material.TNT, "§9Recharge", null, 1));
				
				Entity primed = w.spawn(p.getLocation(), TNTPrimed.class);
				
				TNTPrimed tnt = (TNTPrimed) primed;
				
				tnt.setFuseTicks(20);
				tnt.setCustomName("§4TNT !!!");
				tnt.setCustomNameVisible(true);
				tnt.setYield(2.5f);
				
				primed.setVelocity(p.getLocation().getDirection().multiply(2));
			}else {
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous n'avez plus de recharge !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				
				return;
			}
		} else if (Var.redman.contains(p) && i.equals(Kits.ItemGen(Material.REDSTONE, "§9Poudre de Regen", 
				Kits.LoreCreator("§9Regen 2 coeurs", "§9 20 secondes de récupérations"), 1))) {
			if(cooldown.contains(p)) {
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				
				return;
			} else {
				cooldown.add(p);
				heal(p);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable(){

					@Override
					public void run() {
						if(Var.redman.contains(p)){
							GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre attaque est prête !", 20, 30, 20);
							gt.send();
								
							p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
							
						}
						
						if(cooldown.contains(p)) {
							cooldown.remove(p);
						}
					}
					
				}, 400L);
			}
		}
	}	
	
	private static void heal(Player p){
		if(p.getHealth() >= 16){
			p.setHealth(20);
		}else{
			if(!p.getGameMode().equals(GameMode.CREATIVE)){
				p.setHealth(p.getHealth() + 4);
				
				p.sendMessage("§6[§eFireFFA§6] §fVous vous êtes régéne!");
				
				p.playSound(p.getLocation(), Sound.LAVA_POP, 30, 30);
			}
		}
	}
}
