package eu.fireblade.fireffa;


import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import eu.fireblade.fireffa.cmd.GUI;
import eu.fireblade.fireffa.util.Tp;
import fr.glowstoner.api.bukkit.title.GlowstoneTitle;
import net.md_5.bungee.api.ChatColor;

public class Events implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		
		e.setJoinMessage("§6[§eFireFFA§6] §e"+p.getName()+"§f à rejoint le FireFFA !");
		
		Tp.tpSpawn(p);
		
		GlowstoneTitle gt = new GlowstoneTitle(p, "§6Bienvenue sur le FFA !", "§l"+p.getName(), 20, 50, 20);
		gt.send();
	}
	
	@EventHandler
	public void onRain(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		final Player p = e.getPlayer();
		
		e.setQuitMessage("§6[§eFireFFA§6] §e"+p.getName()+"§f à quitté le FireFFA !");
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		final Player p = (Player) e.getWhoClicked();
		final Inventory inv = e.getClickedInventory();
		final ItemStack item = e.getCurrentItem();
		
		if(inv.getType().equals(InventoryType.PLAYER)){
			if(e.getSlotType().equals(SlotType.ARMOR)){
				e.setCancelled(true);
			}
		}
		
		if(inv.getName().equals("§9§lKits")){
			if(item.equals(GUI.genPerspective(Material.STAINED_GLASS, "§f§lKits Membre/FFA", (byte) 0))){
				e.setCancelled(true);
				
				p.closeInventory();
				
				GUI.ffaMenu(p);
			}else if(item.equals(GUI.genPerspectiveEnch(Material.STAINED_GLASS, "§e§lKits Fire",Enchantment.PROTECTION_ENVIRONMENTAL, 1, (byte) 4))){
				e.setCancelled(true);
				
				p.closeInventory();
				
				GUI.fireMenu(p);
			}else{
				e.setCancelled(true);
			}
		}else if(inv.getName().equals("§9§lKits Membre/FFA")){
			e.setCancelled(true);
			
			if(item.equals(GUI.genPerspective(Material.STAINED_GLASS, "§f§lMenu Principal", (byte) 0))){
				p.closeInventory();
				
				GUI.mainMenu(p);
			}
		}else if(inv.getName().equals("§9§lKits Fire")){
			e.setCancelled(true);
			
			if(item.equals(GUI.genPerspective(Material.STAINED_GLASS, "§f§lMenu Principal", (byte) 0))){
				p.closeInventory();
				
				GUI.mainMenu(p);
			}
		}
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player d = e.getEntity();
		Player p = d.getKiller();
		
		if (d.getType().equals(EntityType.PLAYER) && p.getType().equals(EntityType.PLAYER)) {
			if(d != p){
				p.setHealth(p.getHealth() + 5);
			}
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		Entity p = e.getEntity();
		if (p.getType().equals(EntityType.PLAYER) && Var.piaf.contains(p)) {
			if(e.getCause().equals(DamageCause.FALL)) {
				e.setCancelled(true);
		}
	}
}
	
	@EventHandler
	public void onInteract (PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		if(a.equals(Action.RIGHT_CLICK_AIR) && e.getMaterial().equals(Material.IRON_AXE) && eu.fireblade.fireffa.Var.démolisseur.contains(p)){
			if(p.getInventory().containsAtLeast(eu.fireblade.fireffa.items.Kits.ItemGen(Material.FIREBALL, ChatColor.DARK_RED+"Boule de feu", null, 1), 1)) {
				p.launchProjectile(Fireball.class);
				p.playSound(p.getLocation(), Sound.FIRE_IGNITE, 30, 30);
				p.getInventory().removeItem(eu.fireblade.fireffa.items.Kits.ItemGen(Material.FIREBALL, ChatColor.DARK_RED+"Boule de feu", null, 1));
			} else {
			p.playSound(p.getLocation(), Sound.ITEM_BREAK, 30, 30);
			p.sendMessage(ChatColor.GOLD+"[FireFFA] "+ChatColor.RED+"Vous n'avez plus de boule de feu.");
			}
		}
	}		
}

