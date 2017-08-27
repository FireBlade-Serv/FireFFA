package eu.fireblade.fireffa.ability;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerInteractAtPlayerEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class RobinDesBois implements Listener {

	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onInteract(PlayerInteractAtPlayerEvent e){
		final Player p = e.getPlayer();
		final Player t = e.getTarget();
		final ItemStack i = e.getItemInHand();
		
		if(Var.robindesbois.contains(p) && i.equals(Kits.ItemGen1(Material.WOOD_SWORD, Enchantment.DAMAGE_ALL, 1, "§9épée des bois", 
				Kits.LoreCreator("§9clique droit - vole un item aléatoire au joueur", "§930 secondes de récupération"), 1))){
			if(cooldown.contains(p)) {
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				
				return;
			}else {
					ItemStack[] targetItem = t.getInventory().getContents();
					ItemStack[] targetArmor = t.getInventory().getArmorContents();
					ArrayList<ItemStack> targetAll = new ArrayList<ItemStack>();
					for(ItemStack inList : targetItem) {
						if(inList != null) {
							targetAll.add(inList);
						}
					}
					for(ItemStack inList : targetArmor) {
						if(inList != null) {
							targetAll.add(inList);
						}
					}
					Random r = new Random();
					int item = r.nextInt(targetAll.size());
					if(item > targetAll.size() - 1) item--;
					p.getInventory().addItem(targetAll.get(item));
					p.getInventory().remove(targetAll.get(item));
					cooldown.add(p);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

					@Override
					public void run() {
						if(Var.robindesbois.contains(p)){
							GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Votre attaque est prête !", 20, 30, 20);
							gt.send();
							
							p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
						}
						
						if(cooldown.contains(p)) {
							cooldown.remove(p);
						}			
					}									
				}, 600L);
			}
		}
	}
}
