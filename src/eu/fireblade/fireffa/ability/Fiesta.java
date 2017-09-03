package eu.fireblade.fireffa.ability;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.events.PlayerRightClickInteractEvent;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.md_5.bungee.api.ChatColor;

public class Fiesta implements Listener {
	
	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	private static ArrayList<Player> playeronarea = new ArrayList<Player>();
	
	private static ArrayList<Location> loc = new ArrayList<Location>();
	
	@EventHandler
	public void OnClick(PlayerRightClickInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack i = e.getItem();
		final World w = e.getWorld();
		
		if (Var.fiesta.contains(p) && i.equals(Kits.ItemGen2(Material.ARROW, Enchantment.DAMAGE_ALL, 2, Enchantment.KNOCKBACK, 3, "§9Cotillon", 
				Kits.LoreCreator("§9Clique Droit - tp les joueurs sur 10 blocs", "§940 secodnes de récupération"), 1))) {
			
			if(cooldown.contains(p)){
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
					
				return;
			}else {
				for (Entity onarea : p.getNearbyEntities(10, 10, 10)) {
					if(onarea.getType().equals(EntityType.PLAYER)) {
						Player ponarea = (Player) onarea;
						playeronarea.add(ponarea);
					}
				} 
				if(playeronarea.size() != 0) {
					playeronarea.add(p);
				
					for (Player inList : playeronarea) {
						loc.add(inList.getLocation());
					}
					int a = 0;
					int b = 1;
					for ( int pn = 0 ; pn < loc.size() ; pn++) {
						if( b < loc.size()) {					
							playeronarea.get(a).teleport(loc.get(b));
							a++;
							b++;
							playeronarea.get(a).playSound(playeronarea.get(a).getLocation().add(0, 1, 0), Sound.FIREWORK_LAUNCH, 30, 30);
							w.playEffect(playeronarea.get(a).getLocation(), Effect.HAPPY_VILLAGER, 0);
							GlowstoneTitle gt = new GlowstoneTitle(playeronarea.get(a), "", ChatColor.LIGHT_PURPLE+"C'est la fête!", 20, 30, 20);
							gt.send();
						}else {
							b = 0;
							playeronarea.get(a).teleport(loc.get(b));
							playeronarea.get(b).playSound(playeronarea.get(b).getLocation(), Sound.FIREWORK_LAUNCH, 30, 30);
							w.playEffect(playeronarea.get(b).getEyeLocation().add(0, 1, 0), Effect.HAPPY_VILLAGER, 0);
							GlowstoneTitle gt = new GlowstoneTitle(playeronarea.get(b), "", ChatColor.LIGHT_PURPLE+"C'est la fête!", 20, 30, 20);
							gt.send();
						}
					}
					loc.clear();
					playeronarea.clear();
					a = 0;
					b = 1;
				
					cooldown.add(p);
				
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

						@Override
						public void run() {
							if(Var.fiesta.contains(p)){
								GlowstoneTitle gt = new GlowstoneTitle(p, "", "§9Vous pouvez utiliser votre Cotillon !", 20, 30, 20);
								gt.send();
							
								p.playSound(p.getLocation(), Sound.ORB_PICKUP, 30, 30);
							}
						
							if(cooldown.contains(p)) {
								cooldown.remove(p);
							}
						}
					
					}, 800L);			
				}else {
					p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Il n'y a personne dans la zone !");
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
						
					return;
				}
			}
		}
	}
}
