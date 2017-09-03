package eu.fireblade.fireffa.ability;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.Main;
import eu.fireblade.fireffa.Var;
import eu.fireblade.fireffa.items.Kits;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;

public class Enderman implements Listener {
	
	public static ArrayList<Player> cooldown = new ArrayList<Player>();
	
	private static ArrayList<Player> nod = new ArrayList<Player>();

	@EventHandler
	public void OnClick (PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		final ItemStack item = e.getItem();
		
		if((a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) && item.equals(Kits.ItemGen1(Material.FLINT, Enchantment.DAMAGE_ALL, 3,
				"§7Main de l'enderman", Kits.LoreCreator("§9Clique droit - vous tp aléatoirement", "§930 secondes de récupération"), 1)) && Var.enderman.contains(p)){
			
			if(cooldown.contains(p)) {
				p.sendMessage(ChatColor.GOLD+"§6[§eFireFFA§6] "+ChatColor.RED+"Vous êtes en cooldown pour cette attaque !");
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
				
				return;
			
			}else {
				Random r = new Random();
				int x = -127 + r.nextInt(254);
				int z = -127 + r.nextInt(254);
				
				Location l = new Location(p.getWorld(),x,1,z);
				Location newL = new Location(p.getWorld(), x, ((CraftWorld)p.getWorld()).getHighestBlockYAt(l), z);
				
				cooldown.add(p);
				p.playSound(l, Sound.ENDERMAN_TELEPORT, 30, 30);
				p.teleport(newL);
				noDamage(p);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

					@Override
					public void run() { 
					if(Var.enderman.contains(p)){
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
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e){
		final Entity entity = e.getEntity();
		
		if(entity instanceof Player){
			Player p = (Player) entity;
			
			if(Var.enderman.contains(p) && nod.contains(p)){
				if(e.getCause().equals(DamageCause.FALL)){
					e.setCancelled(true);
				}
			}
		}
	}

	private void noDamage(Player p) {
		nod.add(p);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				nod.remove(p);
			}
			
		}, 100L);
	}

}
